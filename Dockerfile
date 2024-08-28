FROM eclipse-temurin:21-jdk-jammy as deps

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .

# This step is optional but helps with caching dependencies
RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY src /app/src

# Package the application
RUN mvn clean package -DskipTests

# Use the official OpenJDK image to run the application
FROM eclipse-temurin:21-jre-jammy AS final

# Set the working directory in the container
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /target/scoreboard.jar /app/scoreboard.jar

# Expose the port the application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/scoreboard.jar"]
