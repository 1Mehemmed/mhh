package com.example.demo.java.azingress.controller;

import azingress.dto.CarRequestDto;
import azingress.dto.CarResponseDto;
import azingress.service.CarServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/api/car")
@RequiredArgsConstructor
public class CarController {
    private final CarServiceImpl carServiceImpl;

    public CarController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping
    public List<CarResponseDto> findAll() {
        return carServiceImpl.findAll();
    }

    @PostMapping
    public void create(@RequestBody CarRequestDto carRequestDto){
    carServiceImpl.createCar(carRequestDto);
    }
@GetMapping("/{id}")
    public CarResponseDto getCarById(@PathVariable Long id){
        return carServiceImpl.getCarById(id);

}
@PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CarRequestDto carRequestDto){
    carServiceImpl.update(id,carRequestDto);
}
@DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
    carServiceImpl.delete(id);
}
}
