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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "course")

public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long courseID;
	private String courseName;

	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "studentcourse", joinColumns = @JoinColumn(name =
	 * "courseID", referencedColumnName = "courseID"), inverseJoinColumns
	 * = @JoinColumn(name = "studentID", referencedColumnName = "studentID"))
	 * //@JsonIgnore
	 */

	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Student.class)
	@JoinTable(name = "StudCourse", joinColumns = {
			@JoinColumn(name = "courseID", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "studentID	", nullable = false) })
	@JsonIgnore
	private List<Student> student = new ArrayList();

	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "book_publisher", joinColumns = @JoinColumn(name =
	 * "book_id", referencedColumnName = "id"), inverseJoinColumns
	 * = @JoinColumn(name = "publisher_id", referencedColumnName = "id")) public
	 * Set<Publisher> getPublishers() { return publishers; }
	 */

	// @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
	// CascadeType.REFRESH})

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

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseID == null) ? 0 : courseID.hashCode());
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
		Course other = (Course) obj;
		if (courseID == null) {
			if (other.courseID != null)
				return false;
		} else if (!courseID.equals(other.courseID))
			return false;

		return true;
	}

}