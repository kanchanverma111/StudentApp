package com.student.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.app.models.Course;
import com.student.app.models.Student;

public interface CourseRepository extends JpaRepository<Course, Long> {

	public Optional<Student> findByCourseName(String courseName);

	public List<Student> findDistinctByCourseName(String courseName);

	@Query(value = "select * from course where courseName like '%Java'", nativeQuery = true)
	public List<Student> findAllJavaCourseNativeQuery();

}
