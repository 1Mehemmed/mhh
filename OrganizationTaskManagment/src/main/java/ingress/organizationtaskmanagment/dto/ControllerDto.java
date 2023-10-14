package ingress.organizationtaskmanagment.dto;

import ingress.organizationtaskmanagment.dto.RequestDto;
import ingress.organizationtaskmanagment.dto.ResponseDto;
import ingress.organizationtaskmanagment.service.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/api/car")
@RequiredArgsConstructor
public class ControllerDto {
    private final ServiceImpl serviceImpl;

    public ControllerDto(ServiceImpl serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    @GetMapping
    public List<ResponseDto> findAll() {
        return serviceImpl.findAll();
    }

    @PostMapping
    public void create(@RequestBody RequestDto requestDto){
        serviceImpl.createUser(requestDto);
    }
    @GetMapping("/{id}")
    public ResponseDto getCarById(@PathVariable Long id){
        return ServiceImpl.getUserBy(id)

    }
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody RequestDto RequestDto){
        ServiceImpl.update(id,requestDto;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        serviceImpl.delete(id);
    }
}
