FROM openjdk:17-slim


COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:17.0.1-jdk-slim

COPY --from=build /target/scoreboard.jar demo.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]