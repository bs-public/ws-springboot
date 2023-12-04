FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/springboot-docker.jar
ADD target/springboot-docker.jar springboot-docker.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springboot-docker.jar"]
