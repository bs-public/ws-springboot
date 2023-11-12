package com.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.Person;
import com.service.PersonService;

@RestController
public class PersonController {

  private final PersonService personService;
  
  public PersonController(PersonService personService) {
	  this.personService = personService;
  }

  @GetMapping("/persons")
  private List<Person> getAllPersons() {
    return personService.getAllPersons();
  }

  @GetMapping("/persons/{id}")
  private Person getPerson(@PathVariable("id") int id) {
    return personService.getPersonById(id);
  }

  @PostMapping("/persons")
  private Integer savePerson(@RequestBody Person person) {
    personService.saveOrUpdate(person);
    return person.getId();
  }

  @DeleteMapping("/persons/{id}")
  private void deletePerson(@PathVariable("id") int id) {
    personService.delete(id);
  }


}
