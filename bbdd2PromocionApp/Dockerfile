# syntax=docker/dockerfile:experimental
FROM openjdk:11-slim-buster as build

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src

RUN --mount=type=cache,target=/root/.m2,rw ./mvnw -B package

FROM openjdk:11-jre-slim-buster

COPY --from=build target/bbdd2PromocionApp-0.0.1.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "bbdd2PromocionApp-0.0.1.jar"]