package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.stereotype.Service;
import com.constants.TaskStatus;

@Service
public class TaskHandlerService {

  private static final Logger LOGGER = LoggerFactory.getLogger(TaskHandlerService.class);

  @Autowired
  private TaskExecutor taskExecutor;

  public String executeAsynchronously() {
    try {
      taskExecutor.execute(new Runnable() {
        @Override
        public void run() {
          sneakySleep(1000);
          LOGGER.info("Thread: {}", Thread.currentThread().getName());
          LOGGER.info("Task Completed");
        }

        private void sneakySleep(long millis) {
          try {
            Thread.sleep(millis);
          } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
          }
        }

      });
    } catch (TaskRejectedException e) {
      return TaskStatus.REJECTED.name();
    }
    return TaskStatus.ACCEPTED.name();
  }

}
