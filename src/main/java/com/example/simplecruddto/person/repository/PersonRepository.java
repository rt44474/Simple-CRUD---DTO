package com.example.simplecruddto.person.repository;

import com.example.simplecruddto.person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
