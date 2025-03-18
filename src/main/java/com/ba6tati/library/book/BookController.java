package com.ba6tati.library.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/book")
@Tag(name = "Book API", description = "Book endpoints")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping()
    @Operation(summary = "Creates a book", description = "Returns the book created")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    public ResponseEntity<Book> createBook(@RequestBody BookDTO bookDTO) {
        Book book = bookService.createBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }
}
