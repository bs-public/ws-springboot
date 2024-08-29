package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.RetryService;

@RestController
public class RetryController {

  private final RetryService retryService;

  public RetryController(RetryService retryService) {
    this.retryService = retryService;
  }

  @GetMapping("/retry")
  public ResponseEntity<String> retry() {
    retryService.retryService();
    return new ResponseEntity<String>("Ok", HttpStatus.OK);
  }

}
