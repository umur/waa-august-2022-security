package edu.miu.demo.spring.data.lab3.exceptions;

public class OffensiveWordException extends RuntimeException {
    public  OffensiveWordException(String message) {
        super(message);
    }
}
