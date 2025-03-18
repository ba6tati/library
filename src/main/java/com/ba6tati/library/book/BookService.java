package com.ba6tati.library.book;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ba6tati.library.author.Author;
import com.ba6tati.library.author.AuthorRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    private final ModelMapper modelMapper;

    public BookService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ResponseEntity<?> createBook(BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        UUID authorId = bookDTO.getAuthorId();

        if (authorId != null) {
            Author author = authorRepository.findById(authorId).orElse(null);

            if (author == null) {
                return ResponseEntity.badRequest().body("Author with id " + authorId + " doesn't exist");
            }
        }
        bookRepository.save(book);

        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    public Book getBookById(UUID id) {
        Book book = bookRepository.findById(id).orElse(null);

        return book;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public ResponseEntity<?> searchBookByTitle(String title) {
        List<Book> books = bookRepository.findByTitleContaining(title);
        
        return ResponseEntity.ok(books);
    }
}
