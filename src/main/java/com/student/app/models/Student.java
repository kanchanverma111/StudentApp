package com.student.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="student")
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long studentID;
	private String studentName;
	private String studentAddress;
	
		
	@ManyToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Course> courses = new ArrayList<>();


	public Student() {
		super();
	}
	public Student(Long studentId, String studentName, String studentAddress) {
		super();
		this.studentID = studentId;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
	}
	public Long getStudentId() {
		return studentID;
	}
	public void setStudentId(Long studentId) {
		this.studentID = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentID == null) ? 0 : studentID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentID == null) {
			if (other.studentID != null)
				return false;
		} else if (!studentID.equals(other.studentID))
			return false;
		return true;
	}
	
	
}


