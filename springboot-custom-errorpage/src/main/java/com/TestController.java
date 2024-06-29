package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping(value = "/test/{id}")
  public String details(@PathVariable Integer id) {
    if (id == 0) {
      throw new DataNotFoundException();
    }
    return id.toString();
  }

}
