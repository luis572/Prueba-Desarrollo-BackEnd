FROM openjdk:8-jdk-slim
COPY "./target/Prueba-Desarrollo-BackEnd-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]