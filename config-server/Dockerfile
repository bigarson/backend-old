FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /temp
COPY . .
RUN mvn clean install


FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /temp/target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]