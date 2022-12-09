### CREACION DEL JAR ###
FROM maven:3-jdk-11-slim AS builder

WORKDIR /app
COPY ./pom.xml .
RUN mvn -e -B dependency:go-offline
COPY ./src ./src
RUN mvn -e -B -Dmaven.test.skip=true package

### FASE FINAL DE LA IMAGEN ###
FROM openjdk:11-jdk-slim
LABEL maintainer="luferlira@gmail.com"
WORKDIR /workspace

ENV KAFKA_BOOSTRAP_SERVER=localhost:9093

COPY --from=builder /app/target/app*.jar app.jar

# No abre ningun puerto, solo informativo
EXPOSE 8080
ENTRYPOINT exec java -jar /workspace/app.jar