FROM eclipse-temurin:17-jdk-focal
LABEL authors="hannah"

WORKDIR /app
COPY target/EventService-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "EventService-0.0.1-SNAPSHOT.jar"]