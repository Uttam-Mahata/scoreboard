# Step 1: Use an official OpenJDK runtime as the base image
FROM eclipse-temurin:21-jre

# Step 2: Set the working directory for the application
WORKDIR /app

# Step 3: Copy the JAR file from your local machine to the container
COPY target/scoreboard.jar /app/scoreboard.jar

# Step 4: Expose the application port (optional, default for Spring Boot is 8080)
EXPOSE 8080

# Step 5: Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "/app/scoreboard.jar"]
