package com.workintech.movie.controller;

import com.workintech.movie.entity.Actor;
import com.workintech.movie.entity.Movie;
import com.workintech.movie.mapping.ActorResponse;
import com.workintech.movie.mapping.MovieActorRequest;
import com.workintech.movie.mapping.MovieActorsResponse;
import com.workintech.movie.mapping.MovieResponse;
import com.workintech.movie.service.ActorService;
import com.workintech.movie.service.MovieService;
import com.workintech.movie.util.HollywoodUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {
    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/")
    public List<ActorResponse> findAll(){
        List<ActorResponse> actorResponses = new ArrayList<>();
        for (Actor actor:actorService.findAll()){
            actorResponses.add(HollywoodUtility.convertActorResponse(actor););
        }
        return actorResponses;
    }

    @GetMapping("/{id}")
    public ActorResponse findById(@PathVariable int id){
        Actor actor = actorService.findById(id);
        return HollywoodUtility.convertActorResponse(actor);
    }
    @PostMapping("/")
    public ActorResponse save(@RequestBody MovieActorRequest movieActorRequest){
        Movie movie = movieActorRequest.getMovie();
        Actor actor = movieActorRequest.getActor();
        actor.addMovie(movie);
        actorService.save(actor);

        return HollywoodUtility.convertActorResponse(actor);
    }

    @PutMapping("/{id}")
    public ActorResponse update(@RequestBody Actor actor, @PathVariable int id){
        Actor foundedActor = actorService.findById(id);
        actor.setMovies(foundedActor.getMovies());
        actor.setId(id);
        actorService.save(actor);
        return HollywoodUtility.convertActorResponse(actor);
    }

    @DeleteMapping("/{id}")
    public ActorResponse delete(@PathVariable int id){
        Actor actor = actorService.findById(id);
        actorService.delete(actor);
        return HollywoodUtility.convertActorResponse(actor);
    }

}
