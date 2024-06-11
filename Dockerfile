FROM maven:3.8.4-openjdk-17-slim AS build
COPY pom.xml ./
COPY .mvn .mvn
COPY src src
RUN mvn clean install -DskipTests
# the base image
FROM openjdk:17-jdk-slim
COPY --from=build target/*.jar application.jar
CMD apt-get update -y
ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/application.jar"]