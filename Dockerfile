# Microsoft OpenJDK 21 runtime
FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu

WORKDIR /app

# Copy the fat jar
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
