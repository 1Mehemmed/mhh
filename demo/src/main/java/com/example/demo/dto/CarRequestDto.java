package com.example.demo.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Data
@Getter
@Setter
public class CarRequestDto {
    private String model;
    private String maker;
    private String engine;
    private String carColor;
    private LocalDate year;

}
