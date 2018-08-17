package com.learnforlife.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnforlife.dao.CourseDao;
import com.learnforlife.dao.CourseOfferingDao;
import com.learnforlife.dao.StudentDao;
import com.learnforlife.dao.TutorDao;
import com.learnforlife.dao.UserDao;
import com.learnforlife.entity.Course;
import com.learnforlife.entity.CourseOffering;
import com.learnforlife.entity.Student;
import com.learnforlife.entity.Tutor;
import com.learnforlife.entity.User;
import com.learnforlife.general.Login;
import com.learnforlife.general.Registration;

@Service
public class ServiceDaoImpl implements ServiceDao {

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private TutorDao tutorDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private CourseOfferingDao courseOfferingDao;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void add(Registration registration) {
		System.out.println(registration.getRole());
		if (registration.getRole().equalsIgnoreCase("STUDENT")) {

			Student student = new Student(registration.getUsername(), registration.getEmail(),
					registration.getGender());

			studentDao.addStudent(student);
		} else if (registration.getRole().equalsIgnoreCase("TUTOR")) {
			Tutor tutor = new Tutor(registration.getUsername(), registration.getEmail(), registration.getGender());

			tutorDao.addTutor(tutor);
		}
		User user = new User(registration.getUsername(), registration.getPassword(), registration.getRole());

		userDao.addUser(user);

	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public User validateUser(Login login) {

		@SuppressWarnings("unchecked")
		List<User> listOfUsers = sessionFactory.getCurrentSession().createCriteria(User.class).list();
		for (User user : listOfUsers) {
			if (user.getPassword().equals(login.getPassword()) && 
				user.getUsername().equals(login.getUsername())) {
				if (user.getRole().equals("STUDENT"))
					return user;
				else if (user.getRole().equals("TUTOR"))
					return user;
			}
		}
		return null;
	}

	@Override
	@Transactional
	public List<Course> getAllCourses() {
		List<Course> listOfCourses = courseDao.getAllCourses();
		return listOfCourses;
	}

	@Override
	@Transactional
	public List<CourseOffering> getCoursesOfName(String courseName) {
		List<CourseOffering> listOfCourseOfferings = courseOfferingDao.getCoursesOfName(courseName);
		return listOfCourseOfferings;
	}

	@Override
	@Transactional
	public void appendCourse(String courseName, int userId, CourseOffering courseOffering) {
		courseOfferingDao.appendCourse(courseName, userId, courseOffering);
	}

	@Override
	@Transactional
	public Long getCountOfProfessors(String courseName) {
		return courseOfferingDao.getCountOfProfessors(courseName);
	}

	@Override
	@Transactional
	public List<CourseOffering> selectTutors(String courseName) {
		return courseOfferingDao.selectTutors(courseName);
	}

	@Override
	@Transactional
	public void assignStudentToTutors(String studentName, String[] tutorsOfACourse) {
		courseOfferingDao.assignStudentToTutors(studentName,tutorsOfACourse);
	}

	@Override
	@Transactional
	public List<CourseOffering> getCoursesOfStudent(String studentName) {
		return courseOfferingDao.getCoursesOfStudent(studentName);
	}

	@Override
	@Transactional
	public List<CourseOffering> getCoursesOfTutor(String tutorName) {
		return courseOfferingDao.getCoursesOfTutor(tutorName);
	}

}
