### Dockerfile
    FROM openjdk:8-jdk-alpine
	VOLUME /tmp
	ARG JAR_FILE
	# Copy the jar and adding into container
	ADD ${JAR_FILE} springboot-docker.jar
    ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]


**Purpose of adding the following settings**
	
	-Djava.security.egd=file:/dev/./urandom
This setting is used to speed up the startup time of Java applications in certain environments, especially in headless or virtualized environments like Docker containers. 
The reason for this setting relates to how Java generates random numbers. By default, Java uses /dev/random on Linux systems for generating secure random numbers. 
However, /dev/random can block while it gathers sufficient entropy (randomness) from the system, leading to slow startup times for Java applications. 
Changing this to use /dev/urandom (-Djava.security.egd=file:/dev/./urandom) can improve startup times, as /dev/urandom is non-blocking.

### Docker compose file (devops/compose.yml)
	services:
	  app:
	    image: springboot-docker
	    container_name: springboot-docker  
	    ports:
	      - 8080:8080
	    environment:
	      - JAVA_OPTS=-Djava.security.egd=file:/dev/./urandom
	    volumes:
	      - app_vol:/app/tmp
	volumes:
	  app_vol:

### Commands 
Execute the commands from devops folder.

To run the container 
	
	docker compose up -d

To stop the container
	
	docker compose down
