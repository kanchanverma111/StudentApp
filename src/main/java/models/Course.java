package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long courseID;
	private String courseName;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinTable(name = "CourseEnrollment", joinColumns = @JoinColumn(name="courseID", referencedColumnName="courseID"),
	inverseJoinColumns = @JoinColumn(name = "studentID", referencedColumnName = "studentID"))
	
	@JsonIgnore
	private List<Student> student = new ArrayList();
	
	@Version
	private Integer versionID;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(Long courseID, String courseName, List<Student> student, Integer versionID) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.student = student;
		this.versionID = versionID;
	}

	public Long getCourseID() {
		return courseID;
	}

	public void setCourseID(Long courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getVersionID() {
		return versionID;
	}

	public void setVersionID(Integer versionID) {
		this.versionID = versionID;
	}
	
	
	
	
	}
	
	


