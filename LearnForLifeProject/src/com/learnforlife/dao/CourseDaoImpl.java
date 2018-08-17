package com.learnforlife.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learnforlife.entity.Course;

@Repository
public class CourseDaoImpl implements CourseDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("deprecation")
	@Override
	public List<Course> getAllCourses() {
		@SuppressWarnings("unchecked")
		List<Course> listOfCourses = sessionFactory
										.getCurrentSession()
											.createCriteria(Course.class)
												.list();
		return listOfCourses;
	}

}
