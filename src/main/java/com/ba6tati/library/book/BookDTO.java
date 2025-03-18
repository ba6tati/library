package com.ba6tati.library.book;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    private String title;
    private String description;
    private int releaseYear;
    private UUID authorId;
}
