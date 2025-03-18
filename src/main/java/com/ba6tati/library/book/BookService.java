package com.ba6tati.library.book;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ba6tati.library.author.Author;
import com.ba6tati.library.author.AuthorRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Book createBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setDescription(bookDTO.getDescription());
        book.setReleaseYear(bookDTO.getReleaseYear());

        Author author = authorRepository.findById(bookDTO.getAuthorId()).orElse(null);

        if (author != null) {
            book.setAuthor(author);
        }

        return bookRepository.save(book);
    }

    public Book getBookById(UUID id) {
        Book book = bookRepository.findById(id).orElse(null);

        return book;
    }
}
