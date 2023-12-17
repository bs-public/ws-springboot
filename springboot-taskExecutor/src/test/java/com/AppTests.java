package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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
@TestMethodOrder(OrderAnnotation.class)
class AppTests {

  private static final Logger log = LoggerFactory.getLogger(AppTests.class);

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  @Order(1)
  public void testExecuteTask() {
    ResponseEntity<String> responseEntity =
        restTemplate.getForEntity("http://localhost:" + port + "/task", String.class);

    HttpStatus statusCode = responseEntity.getStatusCode();
    String response = responseEntity.getBody();
    log.info("Status: {}", response);
    assertEquals(HttpStatus.OK, statusCode);
    assertNotNull(response);
  }


  @Test
  @Order(2)
  public void testExecuteTasks() throws InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(7);
    AtomicInteger successfulRequests = new AtomicInteger(0);

    for (int i = 0; i < 7; i++) {
      service.submit(() -> {
        ResponseEntity<String> responseEntity =
            restTemplate.getForEntity("http://localhost:" + port + "/task", String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK && responseEntity.getBody() != null) {
          successfulRequests.incrementAndGet();
          String response = responseEntity.getBody();
          log.info("Status: {}", response);
        }
      });
    }

    service.shutdown();
    service.awaitTermination(1, TimeUnit.MINUTES);

    assertEquals(7, successfulRequests.get());
  }



  @Test
  @Order(2)
  public void testExecuteTaskRejection() throws InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(7);
    AtomicInteger successfulRequests = new AtomicInteger(0);
    AtomicInteger taskRejected = new AtomicInteger(0);

    for (int i = 0; i < 10; i++) {
      service.submit(() -> {
        ResponseEntity<String> responseEntity =
            restTemplate.getForEntity("http://localhost:" + port + "/task", String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK && responseEntity.getBody() != null) {
          successfulRequests.incrementAndGet();
          String response = responseEntity.getBody();
          log.info("Status: {}", response);
          if ("Rejected".equalsIgnoreCase(response)) {
            taskRejected.incrementAndGet();
          }
        }
      });
    }

    service.shutdown();
    service.awaitTermination(1, TimeUnit.MINUTES);

    assertEquals(10, successfulRequests.get());
    assertNotEquals(0, taskRejected.get());
  }

}
