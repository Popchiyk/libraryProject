package com.example.library.controller;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.service.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("api/v1/book")
public class BookRestController {

    @Autowired
    BookService service;

    @ApiOperation(value = "Get all authors", notes = "View all authors")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Champion"),
            @ApiResponse(code = 403, message = "Access is closed"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping("/")
    public List<Book> getAll() {
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
    public Book getById(@PathVariable(value = "id") Integer id) {
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
    public Book create(@RequestBody Book book) {
        return service.create(book);
    }

    @ApiOperation(value = "Get all authors", notes = "View all authors")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Champion"),
            @ApiResponse(code = 403, message = "Access is closed"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @PutMapping("/")
    public Book update(@RequestBody Book book) {
        return service.update(book);
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
