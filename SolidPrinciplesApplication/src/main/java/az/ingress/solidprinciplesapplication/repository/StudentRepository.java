package az.ingress.solidprinciplesapplication.repository;

import az.ingress.solidprinciplesapplication.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFirstName(String Babek);

    List<Student> findByFirstNameAndLastName(String babek, String mammmadov);
}
