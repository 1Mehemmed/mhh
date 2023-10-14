package ingress.organizationtaskmanagment.service;

import azingress.organizationtaskmanagment.dto.RequestDto;
import azingress.organizationtaskmanagment.dto.ResponseDto;
import java.util.List;

public interface ServiceImpl {
    void createUser(RequestDto requestDto);
    ResponseDto getUserById(Long id);
    List<ResponseDto> findAll();
    void update(Long id,RequestDto requestDto);
    void delete(Long id);
}