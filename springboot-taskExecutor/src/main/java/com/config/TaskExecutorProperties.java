package com.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "app.taskexecutor")
@Data
public class TaskExecutorProperties {

  private int corePoolSize;
  private int maxPoolSize;
  private int queueCapacity;
  private int keepAlive;
  private String threadNamePrefix;

}
