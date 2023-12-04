### Springboot app with Thymeleaf, MySQL, Flyway, Docker
Run the MySQL container using the docker compose file.

On startup, spring will execute flyway from db/migration location.

### Commands 
Execute the commands from devops folder.

To run the container 
	
	docker compose up -d

To stop the container
	
	docker compose down
