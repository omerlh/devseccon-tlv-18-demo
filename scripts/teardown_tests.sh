#!/usr/bin/env bash

set -e

docker-compose -f docker-compose.yaml -f $api_file -f docker-compose.security.yaml down