package com.student.app.services;

import java.util.List;

import com.student.app.models.Course;

public interface CourseService {

	public Course createCourse(Course course) throws Exception;
	
	public Course updateCourse(Course course) throws Exception;
	
	public List<Course> getAllCourse() throws Exception;
	
	public Course getCourseById(Long courseId) throws Exception;
	
	public void deleteCourse(Long courseId) throws Exception;
	
}
