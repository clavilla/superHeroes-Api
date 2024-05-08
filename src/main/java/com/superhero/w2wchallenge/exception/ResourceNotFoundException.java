package com.superhero.w2wchallenge.exception;

public class ResourceNotFoundException extends RuntimeException{

            private static final long serialVersionUID = 1L;

            public ResourceNotFoundException(String message) {
                super(message);
            }
}
