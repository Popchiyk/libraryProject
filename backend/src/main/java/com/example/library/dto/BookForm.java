package com.example.library.dto;

import com.example.library.model.Author;

import java.util.Date;

public class BookForm {
    private String name;

    private Author id_author;

    private String genre;

    private Date dateOfPublication;

    public BookForm() {
    }

    public BookForm(String name, Author id_author, String genre, Date dateOfPublication) {
        this.name = name;
        this.id_author = id_author;
        this.genre = genre;
        this.dateOfPublication = dateOfPublication;
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

