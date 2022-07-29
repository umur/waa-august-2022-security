package edu.miu.demo.spring.data.lab3.exceptions;

public class AOPIsAwesomeHeaderException extends Exception {
    public AOPIsAwesomeHeaderException(String header_required) {
        super(header_required);
    }
}