#!/bin/bash

cd tests && mvn test -Dtest=* -Dclienthost=https://google.com
