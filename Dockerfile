FROM maven:3.8.5-openjdk-11 AS build
COPY . .
RUN mvn clean install

FROM openjdk:11-jdk-slim-sid
ADD /target/scoreboard.jar scoreboard.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","scoreboard.jar"]