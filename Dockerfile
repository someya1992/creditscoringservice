# Use OpenJDK 8 as base image
FROM openjdk:8-jdk-alpine

# Install curl
RUN apk --no-cache add curl

# Set the working directory
WORKDIR /app

# Copy the built jar file into the container
COPY target/creditscoringservice-0.0.1-SNAPSHOT.jar creditscoringservice-0.0.1-SNAPSHOT.jar

# Expose the application port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "creditscoringservice-0.0.1-SNAPSHOT.jar"]
