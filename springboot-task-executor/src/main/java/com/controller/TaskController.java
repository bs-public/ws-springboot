package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.TaskHandlerService;

@RestController
public class TaskController {

  private final TaskHandlerService taskHandlerService;

  public TaskController(TaskHandlerService taskHandlerService) {
    this.taskHandlerService = taskHandlerService;
  }

  @GetMapping("/task")
  public String executeTask() {
    return taskHandlerService.executeAsynchronously();
  }

}
