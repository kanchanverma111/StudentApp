package services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
		
		return studentRepository.findAll();
	}

	
	public Student getStudentById(Long studentId) throws Exception {

		return studentRepository.findOne(studentId);
	}

	
	public void deleteStudent(Long studentId) throws Exception {
		
		
		studentRepository.delete(studentId);

	}

}
