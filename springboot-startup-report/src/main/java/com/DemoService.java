package com;

import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

@Service
public class DemoService {

  @PostConstruct
  void setup() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
