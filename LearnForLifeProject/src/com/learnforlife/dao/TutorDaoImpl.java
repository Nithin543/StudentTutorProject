package com.learnforlife.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learnforlife.entity.Tutor;

@Repository
public class TutorDaoImpl implements TutorDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addTutor(Tutor tutor) {
		Session session = sessionFactory.getCurrentSession();
		session.save(tutor);
	}

}
