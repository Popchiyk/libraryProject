package com.example.library.controller;


import com.example.library.model.Author;
import com.example.library.service.AuthorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/author")
public class AuthorRestController {

    @Autowired
    AuthorService service;

    @ApiOperation(value = "Get all authors", notes = "View all authors")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Champion"),
            @ApiResponse(code = 403, message = "Access is closed"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping("/")
    public List<Author> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "Get all authors", notes = "View all authors")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Champion"),
            @ApiResponse(code = 403, message = "Access is closed"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping("/{id}")
    public Author getById(@PathVariable(value = "id") Integer id) {
        return service.getById(id);
    }

    @ApiOperation(value = "Get all authors", notes = "View all authors")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Champion"),
            @ApiResponse(code = 403, message = "Access is closed"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @PostMapping("/")
    public Author create(@RequestBody Author author) {
        return service.create(author);
    }

    @ApiOperation(value = "Get all authors", notes = "View all authors")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Champion"),
            @ApiResponse(code = 403, message = "Access is closed"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @PutMapping("/")
    public Author update(@RequestBody Author author) {
        return service.update(author);
    }

    @ApiOperation(value = "Get all authors", notes = "View all authors")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Champion"),
            @ApiResponse(code = 403, message = "Access is closed"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Integer id) {
        service.delete(id);
    }
}
