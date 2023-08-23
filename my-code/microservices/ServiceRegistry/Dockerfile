FROM openjdk:17-slim
WORKDIR app
COPY ./target/*.jar app.jar
EXPOSE 9802:9802
CMD ["java", "-jar", "app.jar"]