package com.ba6tati.library.book;

import java.util.UUID;

import com.ba6tati.library.author.Author;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) 
    private UUID id;
    private String title;
    private String description;
    private int releaseYear;

    @ManyToOne
	@JoinColumn(name = "author_id", nullable = true)
    private Author author;
}
