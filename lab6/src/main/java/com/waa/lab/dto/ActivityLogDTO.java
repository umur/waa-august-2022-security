package com.waa.lab.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class ActivityLogDTO {
    private int id;
    private String operation;
    private Long duration;
    private Date date;
}
