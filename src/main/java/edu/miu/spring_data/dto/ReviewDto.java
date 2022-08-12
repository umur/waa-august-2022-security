package edu.miu.spring_data.dto;

import edu.miu.spring_data.entity.User;
import lombok.Data;

@Data
public class ReviewDto {

    private int id;
    private String comment ;
    private User user ;
}
