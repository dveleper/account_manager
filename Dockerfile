FROM adoptopenjdk/openjdk11:alpine-jre
COPY "./target/account-0.0.1.jar" "app.jar"
EXPOSE 8082
ENTRYPOINT ["java","-jar","app.jar"]