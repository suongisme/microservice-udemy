FROM openjdk:17-slim
WORKDIR app
COPY ./target/*.jar app.jar
EXPOSE 9801:9801
CMD ["java", "-jar", "app.jar"]