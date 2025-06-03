package com.example.cricbuzz.exception;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(String message){
        super(message);
    }
}
