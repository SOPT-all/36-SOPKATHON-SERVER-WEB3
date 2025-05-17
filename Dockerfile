FROM openjdk:17-jdk

COPY ./build/libs/sopkathon-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-Duser.timezone=Asia/Seoul", "-jar",  "/app.jar"]
