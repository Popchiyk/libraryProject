package com.example.library.service;


import com.example.library.model.Book;
import com.example.library.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    IBookRepository repository;

    public List<Book> getAll(){
        return repository.findAll();
    }

    public Book create(Book book){
        return repository.save(book);
    }

    public Book getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Book id not found"));
    }

    public Book update(Book oldBook){
        Book newBook = getById(oldBook.getId());
        newBook.setId(oldBook.getId());
        newBook.setGenre(oldBook.getGenre());
        newBook.setId_author(oldBook.getId_author());
        newBook.setName(oldBook.getName());
        newBook.setDateOfPublication(oldBook.getDateOfPublication());
        repository.save(newBook);
        return newBook;
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}
