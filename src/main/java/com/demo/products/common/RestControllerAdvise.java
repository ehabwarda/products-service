package com.demo.products.common;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import javax.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerAdvise {

    private static final Logger LOG = LoggerFactory.getLogger(RestControllerAdvise.class);

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleNotFoundException(EntityNotFoundException ex) {
        return errorResponse(new ErrorDetails(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception ex) {
        return errorResponse(new ErrorDetails(INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
    }

    private ResponseEntity<ErrorDetails> errorResponse(ErrorDetails error) {
        LOG.error(error.getMessage());
        return ResponseEntity
                .status(error.getCode())
                .contentType(APPLICATION_JSON)
                .body(error);
    }
}
