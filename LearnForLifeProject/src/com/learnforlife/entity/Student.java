package com.learnforlife.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "studentId")
	private int studentId;

	@Column(name = "studentName")
	private String studentName;

	@Column(name = "studentEmail")
	private String studentEmail;

	@Column(name = "studentGender")
	private String studentGender;
	
	public Student(String studentName, String studentEmail, String studentGender) {
		super();
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentGender = studentGender;
	}
	public Student() {
		
	}
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}
	
	
}
