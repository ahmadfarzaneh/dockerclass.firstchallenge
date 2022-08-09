FROM openjdk:11
ADD target/dockerclass.firstchallenge-0.0.1.jar dockerclass.firstchallenge-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","dockerclass.firstchallenge-0.0.1.jar","--port=8080"]