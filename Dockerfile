FROM maven:3-jdk-8-alpine as builder

WORKDIR /usr/src/target

COPY . /usr/src/target

# Package the application
RUN mvn package

# Use a lightweight JDK  runtime for running the application
FROM openjdk:8-jre-alpine

# Copy the packaged application from the builder stage
COPY --from=builder /usr/src/target/wscoreboard.jar /app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java"]
CMD ["-jar", "/app.jar"]
