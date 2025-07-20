# Stage 1: Build the Spring Boot app using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY backend/pom.xml .
COPY backend/src ./src
RUN mvn clean install -DskipTests

# Stage 2: Create minimal runtime image
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# ✅ COPY built JAR from previous stage, not local machine
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]