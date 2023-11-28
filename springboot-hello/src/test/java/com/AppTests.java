package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AppTests {

  private static final Logger log = LoggerFactory.getLogger(AppTests.class);

  public static final String MSG = "Hello World";

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;


  @Test
  public void testGetMessage() {
    ResponseEntity<String> responseEntity =
        restTemplate.getForEntity("http://localhost:" + port + "/greetings", String.class);
    HttpStatus statusCode = responseEntity.getStatusCode();
    assertEquals(HttpStatus.OK, statusCode);
    String resp = responseEntity.getBody();
    log.info("Response: {}", resp);
    assertNotNull(resp);
    assertEquals(resp, MSG);
  }

}
