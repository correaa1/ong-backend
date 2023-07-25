FROM openjdk:17-jdk-alpine

EXPOSE 8080

WORKDIR /app

COPY ./target/ong-backend.jar /app/ong-backend.jar

ENTRYPOINT ["java", "-jar", "my-app.jar"]
