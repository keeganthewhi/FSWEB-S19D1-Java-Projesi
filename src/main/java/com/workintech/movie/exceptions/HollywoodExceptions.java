package com.workintech.movie.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class HollywoodExceptions {
    @ExceptionHandler
    ResponseEntity<HollywoodErrorResponse> handleExceptions(MovieException exception){
        HollywoodErrorResponse response = new HollywoodErrorResponse(exception.getStatus().value(),
                exception.getMessage(),System.currentTimeMillis());
        log.error(exception.getMessage());
        return new ResponseEntity<>(response,exception.getStatus());
    }
    @ExceptionHandler
    ResponseEntity<HollywoodErrorResponse> handleExceptions(Exception exception){
        HollywoodErrorResponse response = new HollywoodErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),System.currentTimeMillis());
        log.error(exception.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

}
