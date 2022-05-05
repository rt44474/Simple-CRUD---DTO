package com.example.simplecruddto.product.entity;

import com.example.simplecruddto.categories.entity.Categories;
import com.example.simplecruddto.person.entity.Person;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    private String name;

    @Column(name="person_id")
    @NonNull
    private Long person_id;

    @ManyToOne(targetEntity = Person.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private Person person;

    @OneToMany(mappedBy = "product")
    private List<Categories> categoriesList;
}
