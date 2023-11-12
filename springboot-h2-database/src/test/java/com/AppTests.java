package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

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

import com.dao.Person;


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
  public void testAddPersons() {
    Person person = new Person();
    person.setName("Test");
    person.setAge(25);
    person.setEmailId("test@xyz.com");

    ResponseEntity<Integer> responseEntity = this.restTemplate
        .postForEntity("http://localhost:" + port + "/persons", person, Integer.class);
    HttpStatus statusCode = responseEntity.getStatusCode();
    Integer id = responseEntity.getBody();
    log.info("id: {}", id);
    assertEquals(HttpStatus.OK, statusCode);
    assertNotNull(id);
  }

  
  @Test
  @Order(2) 
  public void testAllPersons() {
    ResponseEntity<Person[]> responseEntity =
        restTemplate.getForEntity("http://localhost:" + port + "/persons", Person[].class);
    Person[] persons = responseEntity.getBody();
    List<Person> personList = Arrays.asList(persons);
    log.info("persons: {}", personList);
    HttpStatus statusCode = responseEntity.getStatusCode();
    assertEquals(HttpStatus.OK, statusCode);
    assertNotNull(personList);
  }


}
