package com.example.simplecruddto.person.controller;

import com.example.simplecruddto.person.dto.PersonDto;
import com.example.simplecruddto.person.entity.Person;
import com.example.simplecruddto.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/person"})
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAll(){
        return ResponseEntity.ok(personService
                .getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(personService
        .getById(id));
    }

    @PostMapping
    public ResponseEntity<PersonDto> save(@RequestBody PersonDto person){
        return ResponseEntity.ok(personService
        .save(person));
    }

    @PutMapping("{id}")
    public  ResponseEntity<PersonDto> update(@RequestBody PersonDto person, @PathVariable Long id){
        person.setId(id);
        return ResponseEntity.ok(personService
        .update(person));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        personService.delete(id);
        return ResponseEntity.ok("OK");
    }

}
