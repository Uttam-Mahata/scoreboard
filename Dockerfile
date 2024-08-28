FROM openjdk:21-slim


# Expose the Spring Boot port (default 8080)
EXPOSE 8080


ADD target/scoreboard.jar scoreboard.jar





#
## Copy the JAR file from the context
#COPY target/*.jar app.jar




# Start the application using java -jar
ENTRYPOINT ["java", "-jar", "scoreboard.jar"]