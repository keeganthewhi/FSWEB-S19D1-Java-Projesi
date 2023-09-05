package com.workintech.movie.service;

import com.workintech.movie.dao.MovieDao;
import com.workintech.movie.entity.Movie;
import com.workintech.movie.exceptions.MovieException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{
    private MovieDao movieDao;

    @Autowired
    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> findAll() {
        return movieDao.findAll();
    }

    @Override
    public Movie findById(int id) {
        Optional<Movie> founded = movieDao.findById(id);
        if (founded.isPresent()){
            return founded.get();
        }
        throw new MovieException("Id not found: "+id, HttpStatus.BAD_REQUEST);
    }

    @Override
    public Movie save(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    public void delete(Movie movie) {
        movieDao.delete(movie);
    }
}
