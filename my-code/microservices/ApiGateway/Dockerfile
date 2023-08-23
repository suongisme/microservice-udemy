FROM openjdk:17-slim
WORKDIR app
COPY ./target/api-gateway-0.0.1.jar app.jar
COPY ./src/main/resources/application.yml ./config/application.yml
EXPOSE 9800:9800
CMD ["java", "-jar", "app.jar", "-Dspring.config.location=configs/application.ytml"]