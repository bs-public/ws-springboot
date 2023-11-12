package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.Person;
import com.dao.PersonRepository;

@Service
public class PersonService {

  private final PersonRepository personRepository;
  
  public PersonService(PersonRepository personRepository) {
	  this.personRepository = personRepository;
  }

  public List<Person> getAllPersons() {
    List<Person> persons = new ArrayList<Person>();
    personRepository.findAll().forEach(person -> persons.add(person));
    return persons;
  }

  public Person getPersonById(int id) {
    return personRepository.findById(id).get();
  }

  public void saveOrUpdate(Person person) {
    personRepository.save(person);
  }

  public void delete(int id) {
    personRepository.deleteById(id);
  }
  
}
