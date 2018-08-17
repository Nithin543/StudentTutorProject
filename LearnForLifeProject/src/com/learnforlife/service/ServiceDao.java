package com.learnforlife.service;

import java.util.List;

import com.learnforlife.entity.Course;
import com.learnforlife.entity.CourseOffering;
import com.learnforlife.entity.User;
import com.learnforlife.general.Login;
import com.learnforlife.general.Registration;

public interface ServiceDao {
	public void add(Registration registration);
	public User validateUser(Login login);
	public List<Course> getAllCourses();
	public List<CourseOffering> getCoursesOfName(String courseName);
	public void appendCourse(String courseName, int userId, CourseOffering courseOffering);
	public Long getCountOfProfessors(String courseName);
	public List<CourseOffering> selectTutors(String courseName);
	public void assignStudentToTutors(String studentName, String[] tutorsOfACourse);
	public List<CourseOffering> getCoursesOfStudent(String studentName);
	public List<CourseOffering> getCoursesOfTutor(String tutorName);
}
