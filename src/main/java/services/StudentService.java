package services;


import java.util.List;

import models.Student;

public interface StudentService {
	
	public Student createStudent(Student student) throws Exception;
	
	public Student updateStudent(Student student) throws Exception;
	
	public List<Student> getAllStudent() throws Exception;
	
	public Student getStudentById(Long studentId) throws Exception;
	
	public void deleteStudent(Long studentId) throws Exception;
	
	public List<Student> getStudentRegForCourse(String courseId) throws Exception;
	
	public List<Student> getStudentRegForMoreTwoCourse() throws Exception;
	
	public List<Student> getStudentLivesInTx(String studentAddress) throws Exception;

	
}
