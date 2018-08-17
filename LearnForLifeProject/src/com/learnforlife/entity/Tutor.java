package com.learnforlife.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tutor")
public class Tutor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tutorId")
	private int tutorId;

	@Column(name = "tutorName")
	private String tutorName;

	@Column(name = "tutorEmail")
	private String tutorEmail;

	@Column(name = "tutorGender")
	private String tutorGender;

	@OneToMany(mappedBy = "tutor", cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private List<CourseOffering> courseOffering;

	public Tutor() {

	}

	public Tutor(String tutorName, String tutorEmail, String tutorGender) {
		super();
		this.tutorName = tutorName;
		this.tutorEmail = tutorEmail;
		this.tutorGender = tutorGender;
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public String getTutorEmail() {
		return tutorEmail;
	}

	public void setTutorEmail(String tutorEmail) {
		this.tutorEmail = tutorEmail;
	}

	public String getTutorGender() {
		return tutorGender;
	}

	public void setTutorGender(String tutorGender) {
		this.tutorGender = tutorGender;
	}

	public List<CourseOffering> getCourseOffering() {
		return courseOffering;
	}

	public void setCourseOffering(List<CourseOffering> courseOffering) {
		this.courseOffering = courseOffering;
	}
}
