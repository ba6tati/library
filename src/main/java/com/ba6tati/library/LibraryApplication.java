package com.ba6tati.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
		// http://localhost:8080/swagger-ui.html
	}
	// TODO: add
	/*
		@ManyToOne
		@JoinColumn(name = "author_id", nullable = false)

		and use

		Author author = authorRepository.findById(authorId)
    		.orElseThrow(() -> new RuntimeException("Author not found"));

		book.setAuthorId(author);
	 */
}
