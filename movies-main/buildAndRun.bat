@echo off
call mvn clean package
call docker build -t movieGroup/cinema .
call docker rm -f cinema
call docker run -d -p 9080:9080 -p 9443:9443 --name cinema movieGroup/cinema