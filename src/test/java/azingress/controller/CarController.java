package azingress.controller;

import azingress.dto.CarResponseDto;
import azingress.service.CarServiceimpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/car")
@RequiredArgsConstructor
public class CarController {
    private final CarServiceimpl carService;

    @PostMapping
    public void create(RequestBody CarRequestDto){
        carServiceimpl.createCar(carRequestDto);
    }
@GetMapping("/{id}")
    public CarResponseDto getCarById(@PathVariable Long id){
        return carServiceimpl.getCarById(id);

}
}
