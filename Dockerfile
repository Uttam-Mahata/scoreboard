# Use Maven 3.8.6 with OpenJDK 11 for building the project
FROM maven:3.8.6-openjdk-11 as build

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the Maven project files to the container
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Use a lightweight OpenJDK 11 runtime for running the application
FROM openjdk:11-jdk-slim

# Copy the packaged JAR file from the builder stage to the runtime stage
COPY --from=build /usr/src/app/target/wscoreboard.jar /app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
