package services;

import repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public Course createCourse(Course course) throws Exception
	{
		return courseRepository.save(course);
	}
	
	public Course updateCourse(Course course) throws Exception
	{
		return courseRepository.save(course);
	}
	
	public List<Course> getAllCourse() throws Exception
	{
		return courseRepository.findAll();
	}
	
	public Course getCourseById(Long courseID) throws Exception
	{
		return courseRepository.findOne(courseID);
	}
	
	public void deleteCourse(Long courseID) throws Exception
	{
		courseRepository.delete(courseID);
	}

}
