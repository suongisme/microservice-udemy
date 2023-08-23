FROM openjdk:17-slim
WORKDIR app
COPY ./target/*.jar app.jar
EXPOSE 9803:9803
CMD ["java", "-jar", "app.jar"]