package ingress.organizationtaskmanagment.dto;

import azingress.organizationtaskmanagment.dto.RequestDto;
import azingress.organizationtaskmanagment.dto.ResponseDto;
import azingress.organizationtaskmanagment.entity.User;
import azingress.organizationtaskmanagment.repository.Repository;
import ingress.organizationtaskmanagment.service.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@ingress.organizationtaskmanagment.serviceDto.ServiceDto
@RequiredArgsConstructor
public class ServiceDto implements ServiceImpl {
    private final ModelMapper modelMapper;
    private final Repository repository;
    @Override
    public List<ResponseDto> findAll(){
        return repository
                .findAll()
                .stream()
                .map(car -> modelMapper.map(car, ResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createUser(RequestDto requestDto){
        User user = modelMapper.map(requestDto, User.class);
        repository.save(user);
    }
    @Override
    public ResponseDto getUserById(Long id){
        User user =repository.findById(id).orElseThrow(()-> new RuntimeException());
        return modelMapper.map(user, ResponseDto.class);
    }
    @Override
    public void update(Long id, RequestDto requestDto) {
        User user = repository.findById(id).get();
        user.setUserName(requestDto.getUserName());
        user.setUserSurname(requestDto.getUserSurname());
        user.setUserEmail(requestDto.getUserEmail());
        user.setUserPassword(requestDto.getUserPassword());
        repository.save(user);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}