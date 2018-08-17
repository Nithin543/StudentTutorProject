package com.learnforlife.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "courseOffering")
public class CourseOffering {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "courseOfferingId")
	private int courseOfferingId;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.DETACH,
			  CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="tutor_id")
	private Tutor tutor;
	
	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name="student_name")
	private String studentName;
	
	public CourseOffering() {
		
	}
	
	public int getCourseOfferingId() {
		return courseOfferingId;
	}

	public void setCourseOfferingId(int courseOfferingId) {
		this.courseOfferingId = courseOfferingId;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
}
