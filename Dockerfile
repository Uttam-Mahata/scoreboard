FROM maven:4.0.0-beta-3-openjdk-8 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim

COPY --from=build /target/scoreboard.jar demo.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]