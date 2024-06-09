FROM openjdk:oraclelinux8
LABEL authors="doducmanh"
WORKDIR /app
ARG FILE_JAR=target/*.jar
COPY ${FILE_JAR} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#RUN ./mvnw dependency:go-offline
#COPY src ./src
#CMD ["./mvnw", "spring-boot:run"]

