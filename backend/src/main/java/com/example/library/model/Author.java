package com.example.library.model;

import antlr.collections.List;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String lastName;

    private String listOfBook;

    public Author() {
    }

    public Author(Integer id, String lastName, String listOfBook) {
        this.id = id;
        this.lastName = lastName;
        this.listOfBook = listOfBook;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getListOfBook() {
        return listOfBook;
    }

    public void setListOfBook(String listOfBook) {
        this.listOfBook = listOfBook;
    }
}
