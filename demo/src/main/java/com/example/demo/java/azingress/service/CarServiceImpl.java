package com.example.demo.java.azingress.service;

import azingress.dto.CarRequestDto;
import azingress.dto.CarResponseDto;
import java.util.List;

public interface CarServiceImpl {
     void createCar(CarRequestDto carRequestDto);
    CarResponseDto getCarById(Long id);
    List<CarResponseDto> findAll();
    void update(Long id,CarRequestDto carRequestDto);
    void delete(Long id);
}

