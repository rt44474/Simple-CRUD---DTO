package com.example.simplecruddto.person.service.personImplementation;

import com.example.simplecruddto.person.dto.PersonDto;
import com.example.simplecruddto.person.entity.Person;
import com.example.simplecruddto.person.mappers.PersonMappers;
import com.example.simplecruddto.person.repository.PersonRepository;
import com.example.simplecruddto.person.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonServiceImplementation implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    protected PersonMappers personMappers;

    @Override
    public List<PersonDto> getAll() {
        return personRepository.findAll()
                .stream()
                .map(this.personMappers::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDto getById(Long id) {
        Optional<Person> personOptional = this.personRepository.findById(id);
        return this.personMappers.toDto(
                personOptional.get()
        );
    }



    @Override
    public PersonDto update(PersonDto person) {
        Optional<Person> currentPersonOptional = this.personRepository.findById(person.getId());

        Person currentPerson = currentPersonOptional.get();

        currentPerson.setFirstName(person.getFirstName());
        currentPerson.setLastName(person.getLastName());
        return this.personMappers.toDto(
                this.personRepository.save(currentPerson)
        );
    }

    @Override
    public PersonDto save(PersonDto person) {
        Person newPerson = this.personMappers.fromDto(person);
        return this.personMappers.toDto(
                this.personRepository.save(newPerson)
        );
    }

    @Override
    public void delete(Long id) {
        this.personRepository.deleteById(id);
    }
}
