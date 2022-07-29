package edu.miu.demo.spring.data.lab3.dtos;


import lombok.Data;

import java.time.LocalDate;
@Data
public class ActivityLogDto {
    private LocalDate date;
    private String operation;
    private long duration;
}