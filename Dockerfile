# Use official OpenJDK 17 runtime as base image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the built JAR file from the backend's target directory into the container
COPY backend/target/*.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]