FROM openjdk:8-jdk-alpine

EXPOSE 8081

ADD target/authorizationService-0.0.1-SNAPSHOT.jar authorization.jar

CMD ["java", "-jar", "authorization.jar"]