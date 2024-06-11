FROM maven:3.8.4-openjdk-17-slim AS build
COPY mvnw .
RUN chmod +x ./mvnw
COPY pom.xml ./
COPY .mvn .mvn
COPY src src
RUN mvn clean install -DskipTests


# Stage 2: Run stage
FROM openjdk:17-jdk-slim
# Set working directory
WORKDIR project-service
# Copy the JAR file from the build stage
COPY --from=build target/*.jar /app/project-service.jar
# Set the entrypoint command for running the application
ENTRYPOINT ["java", "-jar", "/app/project-service.jar"]