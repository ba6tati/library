package com.ba6tati.library.book;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book API", description = "Book endpoints")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    @Operation(summary = "Creates a book", description = "Returns the book created")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    public ResponseEntity<Book> createBook(@RequestBody BookDTO bookDTO) {
        Book book = bookService.createBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Gets a book", description = "Returns the book by id")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @ApiResponse(responseCode = "404", description = "Book with id not found")
    public ResponseEntity<Book> getBookById(@PathVariable UUID id) {
        ResponseEntity<Book> book = bookService.getBookById(id);
        return book;
    }
}
