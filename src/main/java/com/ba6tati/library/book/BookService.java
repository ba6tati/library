package com.ba6tati.library.book;

import java.net.URI;
import java.util.UUID;

import org.modelmapper.ModelMapper;
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

    private final ModelMapper modelMapper;

    public BookService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Book createBook(BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);

        if (bookDTO.getAuthorId() != null) {
            Author author = authorRepository.findById(bookDTO.getAuthorId()).orElse(null);
            book.setAuthor(author);
        }

        return bookRepository.save(book);
    }

    public Book getBookById(UUID id) {
        Book book = bookRepository.findById(id).orElse(null);

        return book;
    }
}
