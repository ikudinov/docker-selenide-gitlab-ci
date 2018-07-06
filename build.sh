#!/bin/bash

IMAGE_NAME="docker-selenide-gitlab-ci"

docker kill $(docker ps -q)
docker rmi -f $(docker images --filter "reference=$IMAGE_NAME" -q) $(docker images --filter "dangling=true" -q)
docker build -t $IMAGE_NAME .
