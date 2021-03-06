package com.student.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.app.models.Course;
import com.student.app.models.Student;
import com.student.app.repositories.CourseRepository;

import javassist.NotFoundException;

@Service
public class CourseServiceImpl{
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	public Course createCourse(Course course) throws Exception {
			return courseRepository.save(course);
	}

	
	public Course updateCourse(Course course) throws Exception {
				return courseRepository.save(course);
	}


	public List<Course> getAllCourse() throws Exception {
		
		return courseRepository.findAll();
	}

	
	public Course getCourseById(Long courseId) throws Exception {
		
		return courseRepository.findOne(courseId);
	}

	public void deleteCourse(Long courseId) throws Exception {
		
		Course course = courseRepository.findOne(courseId);
		if(course == null){
			throw new NotFoundException("Course with "+courseId+" not found");
		}

		courseRepository.delete(courseId);
	}

}
