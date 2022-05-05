package com.example.simplecruddto.person.service;

import com.example.simplecruddto.person.dto.PersonDto;
import com.example.simplecruddto.person.entity.Person;

import java.util.List;

public interface PersonService {
    List<PersonDto> getAll();
    PersonDto getById(Long id);
    PersonDto update(PersonDto person);
    PersonDto save(PersonDto person);
    void delete(Long id);
}
