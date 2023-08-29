package azingress.service;

import azingress.dto.CarRequestDto;
import azingress.dto.CarResponseDto;
import org.springframework.stereotype.Service;
import java.until.list;
import java.util.List;

public interface CarServiceimpl {
    void createCar(CarRequestDto carRequestDto);
    CarResponseDto getCarById(Long id);
    List<CarResponseDto> findAll();
    void update(Long id,CarRequestDto carRequestDto);
    void delete(Long id);
}

