#!/bin/bash

docker run \
  -v $(pwd)/chrome-linux:/opt/chrome \
  -v $(pwd)/tests:/opt/tests \
  -w /opt/tests \
  ikudinov/docker-selenide-gitlab-ci \
  mvn test -Dtest=* -Dclienthost=https://google.com -Dbinpath=/opt/chrome/chrome -Dheadless=1
