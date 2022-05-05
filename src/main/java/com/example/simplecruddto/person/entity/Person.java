package com.example.simplecruddto.person.entity;

import com.example.simplecruddto.product.entity.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "person")
    private List<Product> productList;
}
