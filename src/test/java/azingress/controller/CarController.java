package azingress.controller;

import azingress.dto.CarRequestDto;
import azingress.dto.CarResponseDto;
import azingress.service.CarServiceimpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/car")
@RequiredArgsConstructor
public class CarController {
    private final CarServiceimpl carService;
@GetMapping
public List<CarResponseDto> findAll{
    return CarServiceimpl.funfAll();
    }
    @PostMapping
    public void create(RequestBody CarRequestDto){
        carServiceimpl.createCar(carRequestDto);
    }
@GetMapping("/{id}")
    public CarResponseDto getCarById(@PathVariable Long id){
        return carServiceimpl.getCarById(id);

}
@PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CarRequestDto){
    carServiceimpl.update(id,carRequestDto);
}
@DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
    carServiceimpl.delete(id)
}
}
