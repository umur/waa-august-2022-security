package com.miu.Lab3.dto;

import com.miu.Lab3.entity.User;
import lombok.Data;

@Data
public class ReviewDto {
    private int id;
    private String commit;
    private User user;
}
