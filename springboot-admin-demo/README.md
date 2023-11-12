## Spring Boot Admin (SBA)
SBA is used for managing and monitoring Spring Boot applications. It provides a web interface to interact with Spring Boot Actuator endpoints.


### Key features of Spring Boot Admin
- **Dashboard Overview**: Spring Boot Admin provides a user-friendly dashboard to visualize the status and key metrics of all registered applications.
- **Health Status**: It displays the health status of each application, including details like disk space, database connectivity, and custom health indicators.
- **Metrics Visualization**: The tool allows you to view various metrics such as memory usage, garbage collection, web request metrics, and more.
- **Environment Management**: You can view and manage the configuration properties of your applications.
- **Log Levels Management**: It enables you to view and modify log levels in your applications at runtime.


### How the process works?
- The Spring Boot Client exposes metrics endpoints, such as /actuator/metrics. These endpoints expose data about the application's health and performance.
- The SBA Server periodically checks for registered clients. When it finds a new client, it starts fetching metrics from that client.
- The SBA Server fetches metrics from the client by making HTTP GET requests to the client's metrics endpoints.
- The SBA Server aggregates the metrics from all of its registered clients and displays them in a user-friendly interface.


### Brief description about each Actuator endpoint:
 - **auditevents**: Provides information about audit events that have occurred in the application.
 - **beans**: Provides information about all of the beans that are managed by the application context.
 - **caches**: Provides information about all of the caches that are used by the application.
 - **conditions**: Provides information about all of the conditional beans that are defined in the application.
 - **configprops**: Provides information about all of the configuration properties that are defined in the application.
 - **env**: Provides information about the environment in which the application is running.
 - **flyway**: Provides information about the Flyway database migration tool.
 - **health**: Provides information about the health of the application.
 - **httptrace**: Provides information about HTTP requests that are being processed by the application.
 - **info**: Provides information about the application, such as its name, version, and build information.
 - **integrationgraph**: Provides information about the Spring Integration integration flows that are defined in the application.
 - **loggers**: Provides information about the loggers that are used by the application.
 - **logfile**: Provides access to the application's log file.
 - **liquibase**: Provides information about the Liquibase database changelog tool.
 - **metrics**: Provides information about the metrics that are collected by the application.
 - **prometheus**: Provides information about the Prometheus metrics that are exposed by the application.
 - **mappings**: Provides information about the request mappings that are defined for the application's controllers.
 - **quartz**: Provides information about the Quartz scheduler that is used by the application.
 - **scheduledtasks**: Provides information about the scheduled tasks that are defined for the application.
 - **sessions**: Provides information about the sessions that are active in the application.
 - **shutdown**: Provides a way to shut down the application.
 - **startup**: Provides information about the application's startup process.
 - **threaddump**: Provides a thread dump of the application.
