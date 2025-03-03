package com.example.StudentsToCourses.ErrorHandler;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String msg){
        super(msg);
    }
}
