package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class TaskExecutorConfig {

  @Autowired
  private TaskExecutorProperties taskExecutorProperties;

  @Bean
  public TaskExecutor ThreadPoolTaskExecutor() {
    ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();

    taskExecutor.setCorePoolSize(taskExecutorProperties.getCorePoolSize());
    taskExecutor.setMaxPoolSize(taskExecutorProperties.getMaxPoolSize());
    taskExecutor.setQueueCapacity(taskExecutorProperties.getQueueCapacity());
    taskExecutor.setKeepAliveSeconds(taskExecutorProperties.getKeepAlive());
    taskExecutor.setThreadNamePrefix(taskExecutorProperties.getThreadNamePrefix());

    return taskExecutor;
  }

}
