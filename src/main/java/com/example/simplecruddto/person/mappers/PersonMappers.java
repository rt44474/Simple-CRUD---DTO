package com.example.simplecruddto.person.mappers;


import com.example.simplecruddto.person.dto.PersonDto;
import com.example.simplecruddto.person.entity.Person;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMappers {
    PersonDto toDto(Person person);
    Person fromDto(PersonDto personDto);
}
