# Maven build işlemini yapın
FROM maven:3.9-eclipse-temurin-22 AS builder
ARG MODULE_NAME
WORKDIR /temp
COPY . .
RUN mvn clean install -pl ${MODULE_NAME} -am

# JRE imajını kullanarak çalıştırılabilir JAR dosyasını oluşturun
FROM eclipse-temurin:22-jre-alpine
WORKDIR /app
COPY --from=builder /temp/${MODULE_NAME}/target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]