package azingress.service;

import azingress.dto.CarRequestDto;
import azingress.dto.CarResponseDto;
import azingress.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService implements CarServiceimpl {
    private final ModelMapper modelMapper;
    private final CarRepository carRepository;
    @Override
public List<CarResponseDto> findAll(){
    return carRepository
            .findAll()
            .stream()
            .map(car -> modelMapper.map(car, CarResponseDtoDto.class))
            .collect(Collectors.toList())
}
    public void createCar(CarRequestDto carRequestDto){
        Car car = ModelMapper.map(carRequestDto,Car.class);
        carRepository.save(car);
    }
    @Override
    public CarResponseDto getCarById(Long id){
        Car car =carRepository.findById(id).orElseThrow(()-> new RuntimeException());
        return modelMapper.map(car, CarResponseDto.class);
    }
public void update(Long id,CarRequestDto carRequestDto){
        Car car =carRepository.findById(id).get();
        car.setCarColor(carRequestDto,getCarColor());
        car.setYear(carRequestDto,getCarYear());
        car.setEngine(carRequestDto,getCarEngine());
        car.setMaker(carRequestDto,getCarMaker());
        car.setModel(carRequestDto,getCarModel());
        carRepository.save(car);

}
public void delete(Long id){
        carRepository.deleteById(id);
}
}
