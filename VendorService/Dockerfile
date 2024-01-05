FROM eclipse-temurin:17-jdk-focal
LABEL authors="hannah"

WORKDIR /app
COPY target/VendorService-0.0.1-SNAPSHOT.jar /app
EXPOSE 8082
CMD ["java", "-jar", "VendorService-0.0.1-SNAPSHOT.jar"]