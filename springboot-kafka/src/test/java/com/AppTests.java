package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AppTests {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void sendMessage() {
    String message = "Hello Kafka";
    ResponseEntity<Integer> responseEntity = this.restTemplate
        .postForEntity("http://localhost:" + port + "/send", message, Integer.class);
    HttpStatus statusCode = responseEntity.getStatusCode();
    assertEquals(HttpStatus.OK, statusCode);
  }

}
