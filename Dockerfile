FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .


FROM openjdk:17-jdk-slim
VOLUME gradle-cache:/home/gradle/.gradle
VOLUME /tmp
USER gradle
RUN gradle bootJar
RUN mv /home/gradle/project/build/libs/*.jar /home/gradle/project/app.jar
EXPOSE 8080
