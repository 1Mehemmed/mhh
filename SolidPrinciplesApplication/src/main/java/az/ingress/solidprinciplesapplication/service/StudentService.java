package az.ingress.solidprinciplesapplication.service;

import az.ingress.solidprinciplesapplication.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    //Query methods
    @PostConstruct
    public void listByQueryMethods(){
        studentRepository.findByFirstName("Babek")
                .stream()
                .forEach(System.out::println);
        studentRepository.findByFirstNameAndLastName("Babek","Mammmadov")
                .stream()
                .forEach(System.out::println);
    }
}
