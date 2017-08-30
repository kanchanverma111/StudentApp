package repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
