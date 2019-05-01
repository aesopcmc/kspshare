#!/bin/sh
#构建Dockerfile文件，运行新编译项目脚本

jarName = "ksp-web-prod"

echo "FROM java:8-alpine
COPY ${jarName}.jar /usr/local/app/
WORKDIR /usr/local/app/
CMD java -jar web/target/${jarName}.jar --spring.profiles.active=prod" > Dockerfile

cat Dockerfile

docker build -t aesopcmc/ksp-prod:1.1111 .