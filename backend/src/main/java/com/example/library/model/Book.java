package com.example.library.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author id_author;

    private String genre;

    private Date dateOfPublication;

    public Book() {
    }

    public Book(Integer id, String name, Author id_author, String genre, Date dateOfPublication) {
        this.id = id;
        this.name = name;
        this.id_author = id_author;
        this.genre = genre;
        this.dateOfPublication = dateOfPublication;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getId_author() {
        return id_author;
    }

    public void setId_author(Author id_author) {
        this.id_author = id_author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(Date dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }
}
