package com.example.simplecruddto.categories.entity;

import com.example.simplecruddto.product.entity.Product;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Categories implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    private String name;

    @Column(name="product_id")
    @NonNull
    private Long product_id;

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;
}
