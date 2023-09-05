package com.workintech.movie.service;

import com.workintech.movie.entity.Actor;
import com.workintech.movie.entity.Movie;

import java.util.List;

public interface ActorService {
    List<Actor> findAll();
    Actor findById(int id);
    Actor save(Actor actor);
    void delete(Actor actor);
}
