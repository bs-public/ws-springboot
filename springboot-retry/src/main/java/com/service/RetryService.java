package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetrySynchronizationManager;
import org.springframework.stereotype.Service;

@Service
public class RetryService {

  private static final Logger logger = LoggerFactory.getLogger(RetryService.class);

  @Retryable(retryFor = {RuntimeException.class}, maxAttempts = 3, backoff = @Backoff(delay = 2000))
  public void retryService() {
    logger.info("Retry Number: " + RetrySynchronizationManager.getContext().getRetryCount());
    logger.info("throw RuntimeException in method retryService()");
    throw new RuntimeException();
  }

  @Recover
  public void recover(RuntimeException e) {
    logger.info("Executing recovery now");
  }

}
