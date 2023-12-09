package com;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  private final Producer producer;

  public TestController(Producer producer) {
    this.producer = producer;
  }

  @PostMapping(value = "/send")
  public void sendToKafkaTopic(@RequestBody String message) {
    this.producer.send(message);
  }

}
