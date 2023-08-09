package com.example.bookcrud.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookReq {

    private String title;
    private String description;
    private Integer categoryId;
    private Integer authorId;
    private LocalDate releaseData;
    private boolean edit;
    private Integer bookId;
}
