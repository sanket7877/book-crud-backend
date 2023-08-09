package com.example.bookcrud.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="authorId")
    private Integer authorId;

    private String id;

    private String name;
}
