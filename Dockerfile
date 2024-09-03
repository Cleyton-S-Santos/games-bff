FROM maven:3.9.8-amazoncorretto-21 AS build
WORKDIR /app
COPY . .
ENV PORT=8080

RUN mvn clean package -DskipTests

FROM openjdk:21-bullseye
WORKDIR /app

EXPOSE 8082
COPY --from=build /app/target/bff-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
