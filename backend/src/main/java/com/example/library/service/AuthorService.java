package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    IAuthorRepository repository;

    public List<Author> getAll(){
        return repository.findAll();
    }

    public Author getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found id author"));
    }

    public Author create(Author author){
        return repository.save(author);
    }

    public Author update(Author author){
        Author newAuthor = getById(author.getId());
        newAuthor.setId(author.getId());
        newAuthor.setLastName(author.getLastName());
        newAuthor.setName(author.getName());
        newAuthor.setListOfBook(author.getListOfBook());
        repository.save(newAuthor);
        return newAuthor;
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}
