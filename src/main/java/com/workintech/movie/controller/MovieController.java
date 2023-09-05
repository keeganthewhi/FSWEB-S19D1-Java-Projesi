package com.workintech.movie.controller;

import com.workintech.movie.entity.Actor;
import com.workintech.movie.entity.Movie;
import com.workintech.movie.mapping.ActorResponse;
import com.workintech.movie.mapping.MovieActorRequest;
import com.workintech.movie.mapping.MovieActorsResponse;
import com.workintech.movie.mapping.MovieResponse;
import com.workintech.movie.service.MovieService;
import com.workintech.movie.util.HollywoodUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public List<MovieResponse> findAll(){
        List<MovieResponse> movieResponses = new ArrayList<>();
        for (Movie movie:movieService.findAll()){
            movieResponses.add(HollywoodUtility.convertMovieResponse(movie));
        }
        return movieResponses;
    }

    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable int id){
        Movie movie = movieService.findById(id);
        return HollywoodUtility.convertMovieResponse(movie);
    }
    @PostMapping("/")
    public MovieActorsResponse save(@RequestBody MovieActorRequest movieActorRequest){
        Movie movie = movieActorRequest.getMovie();
        Actor actor = movieActorRequest.getActor();
        movie.addActor(actor);
        movieService.save(movie);
        return HollywoodUtility.convertMovieActorResponse(movie);
    }

    @PutMapping("/{id}")
    public MovieResponse update(@RequestBody Movie movie, @PathVariable int id){
        Movie foundedMovie = movieService.findById(id);
        movie.setActors(foundedMovie.getActors());
        movie.setId(id);
        movieService.save(movie);
        return HollywoodUtility.convertMovieResponse(movie);
    }

    @DeleteMapping("/{id}")
    public MovieResponse delete(@PathVariable int id){
        Movie movie = movieService.findById(id);
        movieService.delete(movie);
        return HollywoodUtility.convertMovieResponse(movie);
    }

}
