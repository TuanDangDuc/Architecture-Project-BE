FROM maven:3.9.14-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -Dskiptests 

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /run
COPY --from=build target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
