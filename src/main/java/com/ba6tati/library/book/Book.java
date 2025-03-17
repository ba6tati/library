package com.ba6tati.library.book;

import java.sql.Date;
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

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
    private Date releaseDate;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}
