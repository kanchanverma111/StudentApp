package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import models.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	
}
