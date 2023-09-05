package com.workintech.movie.service;

import com.workintech.movie.dao.ActorDao;
import com.workintech.movie.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService{
    private ActorDao actorDao;

    @Autowired
    public ActorServiceImpl(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    @Override
    public List<Actor> findAll() {
        return actorDao.findAll();
    }

    @Override
    public Actor findById(int id) {
        Optional<Actor> founded = actorDao.findById(id);
        if (founded.isPresent()){
            return founded.get();
        }
        return null;
    }

    @Override
    public Actor save(Actor actor) {
        return actorDao.save(actor);
    }

    @Override
    public void delete(Actor actor) {
        actorDao.delete(actor);
    }
}
