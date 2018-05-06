#!/bin/bash

# Abort script on error
set -e
set -x

function run_tests()
{
  dotnet test
}

PROXY_URL=$http_proxy

if [ -z "$PROXY_URL" ]
then
  echo PROXY_URL is not set, not running security checks
  run_tests
else
  
  ZAP_URL=$(echo $PROXY_URL | sed -e 's/https\?:\/\///')
  ./wait-for-it.sh $ZAP_URL -t 300
  echo "ZAP is ready"

  curl -s --fail $PROXY_URL/JSON/core/action/newSession
  curl -s --fail $PROXY_URL/JSON/pscan/action/enableAllScanners
  curl -s --fail $PROXY_URL/JSON/core/action/clearExcludedFromProxy

  # Add the rules you wish to ignore on this line, after the ids query param.
  # curl -s --fail $PROXY_URL/JSON/pscan/action/disableScanners/?ids=

  # Add the URLs you wish to ignore on this line, after the regex query param - regex supported.
  # curl -s --fail $PROXY_URL/JSON/core/action/excludeFromProxy/?regex=

  run_tests

  echo "waiting for ZAP to finish scanning"

  while [ "$(curl --fail $PROXY_URL/JSON/pscan/view/recordsToScan 2> /dev/null | jq '.recordsToScan')" != '"0"' ]; do sleep 1; done

  if [ "$(curl --fail $PROXY_URL/JSON/core/view/urls/?zapapiformat=JSON\&formMethod=GET\&baseurl= 2> /dev/null | jq '.urls | length')" == 0 ]; 
  then 
    echo "No URL was accessed by ZAP"
    exit -55
  fi

  curl -s --fail $PROXY_URL/JSON/core/action/saveSession/?name=blackbox\&overwrite=true > /dev/null

  echo "ZAP scan completed"
fi
