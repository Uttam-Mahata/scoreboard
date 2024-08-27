# syntax=docker/dockerfile:1

################################################################################

# Base image to download dependencies
FROM eclipse-temurin:17-jdk-jammy as deps

WORKDIR /build

# Copy the Maven wrapper files
COPY --chmod=0755 mvnw.cmd mvnw.cmd
COPY .mvn/ .mvn/

# Copy the pom.xml to download dependencies
COPY pom.xml .


################################################################################

# Build stage: Compiling the Spring Boot application
FROM deps as build

WORKDIR /build

# Copy source code and resources
COPY src ./src

# Compile the application
RUN ./mvnw.cmd clean install

################################################################################

# Create a minimal image with only the JRE
FROM eclipse-temurin:17-jre-jammy as runtime



WORKDIR /app

# Copy the compiled JAR file from the build stage
COPY --from=build /target/scoreboard.jar app.jar

# Expose the application port
EXPOSE 8080

# Set the entry point for the Docker container
ENTRYPOINT ["java", "-jar", "app.jar"]
