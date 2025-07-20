# Start from a Java image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the jar file (make sure it exists in backend/target/)
COPY backend/target/*.jar app.jar

# Expose the correct port
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]