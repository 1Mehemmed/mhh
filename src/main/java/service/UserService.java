package service;

import dto.Request.UserRequest;
import dto.Response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repostory.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<UserRequest> findAll(){
        return userRepository
                .findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
    }
    public UserResponse findById(Long userId){
        User user = userRepository.findById(userId). orElseThrow(()-> new RuntimeException(
                String.format("user not found by id -%s")
        ));
        return modelMapper.map(user,UserResponse.class);

    }
}
