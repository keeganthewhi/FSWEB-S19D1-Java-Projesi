package com.workintech.movie.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class MovieException extends RuntimeException{

    private HttpStatus status;

    public MovieException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
