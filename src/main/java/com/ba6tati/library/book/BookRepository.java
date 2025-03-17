package com.ba6tati.library.book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, UUID> {
    Optional<Book> findBookById(UUID id);
    
    // List<Book> findBookByAuthor(String author)
    List<Book> findBookByTitleContaining(String title);
    
}
