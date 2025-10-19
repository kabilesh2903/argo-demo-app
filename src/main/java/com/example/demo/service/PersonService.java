package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonService {
  private final PersonRepository repo;
  public PersonService(PersonRepository repo) { this.repo = repo; }
  public List<Person> list() { return repo.findAll(); }
  public Person save(Person p) { return repo.save(p); }
}

