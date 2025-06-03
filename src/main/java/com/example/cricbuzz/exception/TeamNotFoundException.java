package com.example.cricbuzz.exception;

public class TeamNotFoundException  extends  RuntimeException{

    public TeamNotFoundException(String messsage){
        super(messsage);
    }
}
