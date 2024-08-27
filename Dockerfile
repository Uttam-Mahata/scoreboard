# Use Maven 3.8.6 with JDK 21 for building the project
FROM maven:3.8.6-eclipse-temurin-21-alpine as builder

WORKDIR /usr/src/app

COPY . /usr/src/app

# Package the application
RUN mvn package

# Use a lightweight JDK 21 runtime for running the application
FROM eclipse-temurin:21-jre-alpine

# Copy the packaged application from the builder stage
COPY --from=builder /usr/src/app/target/wscoreboard.jar /app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java"]
CMD ["-jar", "/app.jar"]
