package com.workintech.movie.mapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieActorsResponse {
    private int id;
    private String name;
    private String directorName;
    private int rating;
    private LocalDate releaseDate;
    private List<ActorResponse> actorResponses;
}
