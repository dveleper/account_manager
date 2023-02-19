FROM openjdk:17-jdk-alpine
COPY "./target/account-1.0.jar" "app.jar"
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]