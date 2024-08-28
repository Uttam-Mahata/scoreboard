FROM openjdk:21-slim



WORKDIR /app

# Copy the JAR file from the context
COPY target/*.jar app.jar



# Expose the Spring Boot port (default 8080)
EXPOSE 8080

# Start the application using java -jar
ENTRYPOINT ["java", "-jar", "/app.jar"]