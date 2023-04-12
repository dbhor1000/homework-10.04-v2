package org.example;

public class BadEmailException extends RuntimeException {
    public BadEmailException(String message){
        super(message);
    }
}


