FROM openjdk:8-jdk-alpine
EXPOSE 8081
ADD /target/nprdb-service-0.0.1-SNAPSHOT.jar nprdb-service.jar
ENTRYPOINT ["java", "-jar", "nprdb-service.jar"]