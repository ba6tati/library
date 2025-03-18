package com.ba6tati.library.book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ba6tati.library.author.Author;

public interface BookRepository extends JpaRepository<Book, UUID> {
    Optional<Book> findById(UUID id);
    
    // List<Book> findBookByAuthor(String author)
    List<Book> findByTitleContaining(String title);

    List<Book> findByAuthor(Author author);
}
