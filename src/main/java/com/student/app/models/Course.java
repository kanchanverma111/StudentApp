package com.student.app.models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="course")

public class Course  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long courseID;
	private String courseName;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinTable(name = "studentcourse", joinColumns = @JoinColumn(name = "courseID", referencedColumnName = "courseID"),
			inverseJoinColumns = @JoinColumn(name = "studentID", referencedColumnName = "studentID"))
	
	@JsonIgnore
	private List<Student> student = new ArrayList();

	@Version
	private Integer versionId;
	
	public Course() {
		super();
	}

	public Course(Long courseId, String courseName, Integer versionId) {
		super();
		this.courseID = courseId;
		this.courseName = courseName;
		this.versionId = versionId;
	}

	public Long getCourseId() {
		return courseID;
	}

	public void setCourseId(Long courseId) {
		this.courseID = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getVersionId() {
		return versionId;
	}

	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}

}