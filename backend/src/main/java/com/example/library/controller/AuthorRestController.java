package com.example.library.controller;


import com.example.library.model.Author;
import com.example.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/author")
public class AuthorRestController {

    @Autowired
    AuthorService service;

    @GetMapping("/")
    public List<Author> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Author getById(@PathVariable(value = "id") Integer id) {
        return service.getById(id);
    }

    @PostMapping("/")
    public Author create(@RequestBody Author author) {
        return service.create(author);
    }

    @PutMapping("/")
    public Author update(@RequestBody Author author) {
        return service.update(author);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Integer id) {
        service.delete(id);
    }
}
