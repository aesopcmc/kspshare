#!/bin/sh
#构建Dockerfile文件，运行新编译项目脚本

jarName="ksp-web-prod"

echo "FROM openjdk:8-jdk-alpine
COPY web/target/${jarName}.jar /usr/local/app/
WORKDIR /usr/local/app/
CMD java -jar ${jarName}.jar --spring.profiles.active=prod" > Dockerfile

version=$(date +%s%N)
docker build -t aesopcmc/ksp-web-prod:${version} .

#docker run -d --network kspnet --name ${jarName} aesopcmc/${jarName}:${version}
docker stop ${jarName} && docker rm ${jarName} && docker run -d --network kspnet --name ${jarName} aesopcmc/${jarName}:${version}