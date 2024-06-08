FROM --platform=amd64 openjdk:17.0.2-oraclelinux8
LABEL authors="manhdoduc"
ARG JAR_FILE=targer/*.jar
RUN mkdir -p /deployed/springboot
WORKDIR /deployed/springboot
COPY ${JAR_FILE} /deployed/springboot/build-devops.jar
EXPOSE 8099
ENTRYPOINT["java","-jar","/deployed/springboot/build-devops.jar"]
