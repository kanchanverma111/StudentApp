package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import models.Student;
import repositories.StudentRepository;

@Service
public class StudentServiceImpl {

	@Autowired
	private StudentRepository studentRepository;

	public Student createStudent(Student student) throws Exception {

		return studentRepository.save(student);
	}

	public Student updateStudent(Student student) throws Exception {

		return studentRepository.save(student);
	}

	public List<Student> getAllStudent() throws Exception {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	public Student getStudentById(Long studentId) throws Exception {
		// TODO Auto-generated method stub
		return studentRepository.findOne(studentId);
	}

	public void deleteStudent(Long studentId) throws Exception {
		// TODO Auto-generated method stub

		studentRepository.delete(studentId);
	}

	
	//List of students registered for course with courseId
	public List<Student> getStudentRegForCourse(String courseId) throws Exception {

		return studentRepository.findAllStudentRegCourse(courseId);
	}
	

	//List of students registered for more than 2 courses
	public List<Student> getStudentRegForMoreTwoCourse() throws Exception {

		return studentRepository.findAllStudentRegMoreTwoCourse();
	}

	//List of students who live in Texas
	public List<Student> getStudentLivesInTx(String studentAddress) throws Exception {

		return studentRepository.findAllTxStudentNativeQuery();
	}

	public List<Student> getStudentLeavesTx(String studentAddress) {
		// TODO Auto-generated method stub
		return null;
	}

}
