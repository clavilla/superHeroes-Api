package com.superhero.w2wchallenge.exception;

public class BadRequestException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }

}
