#!/usr/bin/env bash

set -e

#docker-compose -f docker-compose.yaml -f docker-compose.security.yaml pull --parallel
docker-compose -f docker-compose.yaml -f docker-compose.security.yaml run --rm glue bash /app/run_glue.sh http://api blackbox /output/api.txt