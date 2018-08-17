package com.learnforlife.dao;

import java.util.List;

import com.learnforlife.entity.CourseOffering;


public interface CourseOfferingDao {
	public List<CourseOffering> getCoursesOfName(String courseName);
	public void appendCourse(String courseName, int userId, CourseOffering courseOffering);
	public Long getCountOfProfessors(String courseName);
	public List<CourseOffering> selectTutors(String courseName);
	public void assignStudentToTutors(String studentName, String[] tutorsOfACourse);
	public List<CourseOffering> getCoursesOfStudent(String studentName);
	public List<CourseOffering> getCoursesOfTutor(String tutorName);
}
