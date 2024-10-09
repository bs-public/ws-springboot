package com;

import org.springframework.stereotype.Service;

@Service
public final class TestService {

  public TestService() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
