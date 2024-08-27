FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /usr/src/app
COPY . .
RUN mvn clean package

FROM openjdk:17-jre-slim
COPY --from=build /usr/src/app/target/scoreboard.war /usr/local/lib/scoreboard.war
ENTRYPOINT ["java","-jar","/usr/local/lib/scoreboard.war"]
