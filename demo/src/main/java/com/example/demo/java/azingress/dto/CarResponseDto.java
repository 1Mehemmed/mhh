package com.example.demo.java.azingress.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
@Data
public class CarResponseDto {
    private long id;
    private String model;
    private String maker;
    private String engine;
    private String carColor;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate year;
}
