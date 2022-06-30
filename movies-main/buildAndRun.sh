#!/bin/sh
mvn clean package && docker build -t movieGroup/cinema .
docker rm -f cinema || true && docker run -d -p 9080:9080 -p 9443:9443 --name cinema movieGroup/cinema