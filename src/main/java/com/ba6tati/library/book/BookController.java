package com.ba6tati.library.book;

import java.util.List;
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
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Book.class)))
    public ResponseEntity<?> createBook(@RequestBody BookDTO bookDTO) {
        ResponseEntity<?> response = bookService.createBook(bookDTO);
        return response;

        // ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Gets a book", description = "Returns the book by id")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Book.class)))
    @ApiResponse(responseCode = "404", description = "Book with id not found", content = @Content(schema = @Schema(implementation = Void.class)))
    public ResponseEntity<?> getBookById(@PathVariable UUID id) {
        Book book = bookService.getBookById(id);

        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found");
        }

        return ResponseEntity.ok(book);
    }

    @GetMapping()
    @Operation(summary = "Gets all books", description = "Returns list of all books")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Book.class))))
    public ResponseEntity<?> getAllBooks() {
        List<Book> books = bookService.getAllBooks();

        return ResponseEntity.ok(books);
    }

    @GetMapping("/search/title={title}")
    @Operation(summary = "Search book by title", description = "Returns list of all books matching the given title")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Book.class))))
    public ResponseEntity<?> searchBookByTitle(@PathVariable String title) {
        ResponseEntity<?> response = bookService.searchBookByTitle(title);

        return response;
    }

    @GetMapping("/by-author/{authorId}")
    @Operation(summary = "Return all books by author", description = "Returns list of books written by specified author")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Book.class))))
    public ResponseEntity<?> searchBookByTitle(@PathVariable UUID authorId) {
        ResponseEntity<?> response = bookService.getBooksByAuthor(authorId);

        return response;
    }
}
