package azingress.service;

import azingress.dto.CarRequestDto;
import azingress.dto.CarResponseDto;
import azingress.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService implements CarServiceimpl {
    private final ModelMapper modelMapper;
    private final CarRepository carRepository;

    public void createCar(CarRequestDto carRequestDto){
        Car car = ModelMapper.map(carRequestDto,Car.class);
        carRepository.save(car);
    }
    @Override
    public CarResponseDto getCarById(Long id){
        Car car =carRepository.findById(id).orElseThrow(()-> new RuntimeException());
        return modelMapper.map(car, CarResponseDto.class);
    }

}
