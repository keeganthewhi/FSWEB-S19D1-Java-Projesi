package com.workintech.movie.util;

import com.workintech.movie.entity.Actor;
import com.workintech.movie.entity.Movie;
import com.workintech.movie.mapping.ActorResponse;
import com.workintech.movie.mapping.MovieActorsResponse;
import com.workintech.movie.mapping.MovieResponse;

import java.util.ArrayList;
import java.util.List;

public class HollywoodUtility {
    public static MovieResponse convertMovieResponse(Movie movie){
        return new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                movie.getRating(), movie.getReleaseDate());
    }

    public static MovieActorsResponse convertMovieActorResponse(Movie movie){
        List<ActorResponse> actorResponses = new ArrayList<>();
        for (Actor a: movie.getActors()){
            actorResponses.add(new ActorResponse(a.getId(), a.getFirstName(),
                    a.getLastName(),a.getGender().name(),a.getBirthDate()));
        }
        return new MovieActorsResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                movie.getRating(), movie.getReleaseDate(), actorResponses);
    }

    public static ActorResponse convertActorResponse(Actor actor){
        return new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(),
                actor.getGender().name(), actor.getBirthDate());
    }
}
