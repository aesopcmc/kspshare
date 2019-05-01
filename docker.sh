#!/bin/sh
#构建Dockerfile文件，运行新编译项目脚本

jarName="ksp-web-prod"

echo "FROM java:8-alpine
COPY web/target/${jarName}.jar /usr/local/app/
WORKDIR /usr/local/app/
CMD java -jar ${jarName}.jar --spring.profiles.active=prod" > Dockerfile

version=$(date +%s%N)
docker build -t aesopcmc/ksp-web-prod:${version} .

docker run -d -p 8082:8080 --name ksp-prod aesopcmc/ksp-web-prod:${version}
#docker stop ksp-web-prod && docker rm ksp-web-prod && docker run -d -p 8082:8080 --name ksp-web-prod aesopcmc/ksp-web-prod:${version}