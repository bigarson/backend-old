FROM maven:3.9-eclipse-temurin-22 AS builder
WORKDIR /temp
COPY . .
WORKDIR ./config-server
RUN mvn clean install

FROM eclipse-temurin:22-jre-alpine
WORKDIR /app
COPY --from=builder /temp/config-server/target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]