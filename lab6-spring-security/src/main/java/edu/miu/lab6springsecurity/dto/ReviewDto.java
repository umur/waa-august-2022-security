package edu.miu.lab6springsecurity.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private int id;
    private String comment;
    private int numberOfStars;
}
