package models;

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

@Entity
@Table(name="Student")
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentID;
	private String studentName;
	private String studentAddress;
	
	
	@Version
	private Integer versionID;
	
	@ManyToMany(mappedBy = "Student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Course> courses = new ArrayList();
	
	private Student()
	{
		super();
	}
	
	
	public Student(long studentID, String studentName, String studentAddress, Integer versionID, List<Course> courses) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.versionID = versionID;
		this.courses = courses;
	}


	public long getStudentID() {
		return studentID;
	}


	public void setStudentID(long studentID) {
		this.studentID = studentID;
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


	public Integer getVersionID() {
		return versionID;
	}


	public void setVersionID(Integer versionID) {
		this.versionID = versionID;
	}
	
}

