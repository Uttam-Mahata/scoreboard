# Use Maven 3.8.6 with OpenJDK 21 for building the project
FROM maven:3.8.6-openjdk-21-slim as builder

WORKDIR /usr/target

COPY . /usr/target

# Package the application
RUN mvn package

# Use a lightweight OpenJDK 21 runtime for running the application
FROM openjdk:21-jre-slim

# Copy the packaged application from the builder stage
COPY --from=builder /usr/target/wscoreboard.jar /app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java"]
CMD ["-jar", "/app.jar"]
