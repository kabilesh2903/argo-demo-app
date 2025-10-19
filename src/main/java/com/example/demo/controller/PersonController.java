package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin(origins = "*")
public class PersonController {
  private final PersonService service;
  public PersonController(PersonService service) { this.service = service; }

  @GetMapping
  public List<Person> list() { return service.list(); }

  @PostMapping
  public ResponseEntity<Person> create(@RequestBody Person p) {
    return ResponseEntity.ok(service.save(p));
  }

  @GetMapping("/health")
  public ResponseEntity<String> health() {
    return ResponseEntity.ok("OK");
  }
}

