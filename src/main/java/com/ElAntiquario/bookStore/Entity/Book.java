package com.ElAntiquario.bookStore.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="name")
    String name;
    @Column(name="author")
    String author;
    @Column(name="price")
    Long price;

    public Book(Long id, String name, String author, Long price) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book() {super();
    }
}