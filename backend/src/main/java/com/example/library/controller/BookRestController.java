package com.example.library.controller;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
public class BookRestController {

    @Autowired
    BookService service;

    @GetMapping("/")
    public List<Book> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable(value = "id") Integer id) {
        return service.getById(id);
    }

    @PostMapping("/")
    public Book create(@RequestBody Book book) {
        return service.create(book);
    }

    @PutMapping("/")
    public Book update(@RequestBody Book book) {
        return service.update(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Integer id) {
        service.delete(id);
    }
}
