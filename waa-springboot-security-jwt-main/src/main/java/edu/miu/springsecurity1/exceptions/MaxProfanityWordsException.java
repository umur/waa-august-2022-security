package edu.miu.springsecurity1.exceptions;

public class MaxProfanityWordsException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public MaxProfanityWordsException(String message){
        super(message);
    }
}
