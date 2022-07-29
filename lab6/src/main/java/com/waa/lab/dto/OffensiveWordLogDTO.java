package com.waa.lab.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class OffensiveWordLogDTO {
    private int id;
    private String word;
    private UserDTO user;
    private ZonedDateTime time;
}
