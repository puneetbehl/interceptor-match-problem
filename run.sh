#!/usr/bin/env bash
./gradlew clean assemble
docker rmi puneetbehl/interceptor-demo:1.0
docker build -t puneetbehl/interceptor-demo:1.0 .
docker rm interceptor-demo
docker run --name interceptor-demo -it --rm -p 8080:8080 puneetbehl/interceptor-demo:1.0