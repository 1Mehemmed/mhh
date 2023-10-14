package az.ingress.solidprinciplesapplication;

import az.ingress.solidprinciplesapplication.SOLID.openclosedprinciple.DriverLicenseDto;
import az.ingress.solidprinciplesapplication.SOLID.openclosedprinciple.DriverLicenseValidator; // Добавьте этот импорт
import az.ingress.solidprinciplesapplication.domain.Student;
import az.ingress.solidprinciplesapplication.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class SolidPrinciplesApplication implements CommandLineRunner {
    private final StudentRepository studentRepository;

    public static void main(String[] args) {SpringApplication.run(SolidPrinciplesApplication.class, args);}

    @Override
    public void run(String... args) throws Exception {
        Student student = Student.builder()
                .age(20)
                .firstName("Babek")
                .lastName("Mammadov")
                .studentNumber("AA12321")
                .build();
        studentRepository.save(student);

    }
}
