#!/usr/bin/env bash

DOCKER_IMAGE=markhobson/maven-chrome:latest

docker pull $DOCKER_IMAGE

if [[ $1 == "mobile" ]]; then
  docker run -it -e DOCKER=true \
  -v "$PWD":/usr/src \
  -w /usr/src \
  $DOCKER_IMAGE mvn test -DrunOnMobile=true
else
  docker run -it -e DOCKER=true \
  -v "$PWD":/usr/src \
  -w /usr/src \
  $DOCKER_IMAGE mvn test
fi
