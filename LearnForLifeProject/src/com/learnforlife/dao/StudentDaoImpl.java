package com.learnforlife.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learnforlife.entity.Student;

@Repository("StudentDao")
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.save(student);
	}

}
