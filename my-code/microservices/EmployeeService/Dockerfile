FROM openjdk:17-slim
WORKDIR app
EXPOSE 9804:9804
COPY ./target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]