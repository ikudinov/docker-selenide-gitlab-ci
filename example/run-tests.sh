#!/bin/bash

docker run \
  -v $(pwd)/chrome-linux:/opt/chrome \
  -v $(pwd)/tests:/opt/tests \
  -w /opt/tests \
  selenide-gitlab-ci \
  mvn test -Dtest=*
