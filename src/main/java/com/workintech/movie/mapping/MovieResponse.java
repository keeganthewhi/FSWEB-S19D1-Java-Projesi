package com.workintech.movie.mapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {
    private int id;
    private String name;
    private String directorName;
    private int rating;
    private LocalDate releaseDate;
}
