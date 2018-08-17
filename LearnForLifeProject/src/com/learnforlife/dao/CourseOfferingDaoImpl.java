package com.learnforlife.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learnforlife.entity.CourseOffering;
import com.learnforlife.entity.Tutor;
import com.learnforlife.entity.User;

@Repository
public class CourseOfferingDaoImpl implements CourseOfferingDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<CourseOffering> getCoursesOfName(String courseName) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM CourseOffering CO WHERE CO.courseName = :course_name ";
		@SuppressWarnings("unchecked")
		Query<CourseOffering> query = session.createQuery(hql);
		query.setParameter("course_name", courseName);
		List<CourseOffering> listOfCourseOfferings = query.list();
		return listOfCourseOfferings;
	}

	@Override
	public void appendCourse(String courseName, int userId, CourseOffering courseOffering) {
		Session session = sessionFactory.getCurrentSession();
		courseOffering.setCourseName(courseName);
		User user = session.get(User.class, userId);

		String hql = "FROM Tutor T WHERE T.tutorName = :tutor_name";
		Query query = session.createQuery(hql);
		query.setParameter("tutor_name", user.getUsername());
		Tutor tutor = (Tutor) query.getSingleResult();

		courseOffering.setTutor(tutor);
		session.save(courseOffering);
	}

	@Override
	public Long getCountOfProfessors(String courseName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
		"select count(co.tutor.tutorId) from CourseOffering co group by co.courseName having co.courseName=:course_name");
		query.setParameter("course_name", courseName);
		return (Long) query.uniqueResult();
	}

	@Override
	public List<CourseOffering> selectTutors(String courseName) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<CourseOffering> query = session.createQuery("FROM CourseOffering co WHERE co.courseName = :course_name");
		query.setParameter("course_name", courseName);
		return query.list();
	}

	@Override
	public void assignStudentToTutors(String studentName, String[] tutorsOfACourse) {
		Session session = sessionFactory.getCurrentSession();
		
		for (String tutorName : tutorsOfACourse) {
			
			Query query1 = session.createQuery("FROM Tutor T WHERE T.tutorName = :tName ");
			query1.setParameter("tName", tutorName);
			Tutor tutor = (Tutor) query1.getSingleResult();
			
			String hql = "UPDATE CourseOffering co set co.studentName=:student_name WHERE co.tutor.tutorId = :tutor_id";
			Query query2 = session.createQuery(hql);
			query2.setParameter("student_name", studentName);
			query2.setParameter("tutor_id", tutor.getTutorId());
			query2.executeUpdate();
		}
	}

	@Override
	public List<CourseOffering> getCoursesOfStudent(String studentName) {
			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM CourseOffering co WHERE co.studentName = :student_name";
			Query<CourseOffering> query = session.createQuery(hql);
			query.setParameter("student_name", studentName);
			return query.list();
	}

	@Override
	public List<CourseOffering> getCoursesOfTutor(String tutorName) {
			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM CourseOffering co WHERE co.tutor.tutorName = :tutor_name";
			Query<CourseOffering> query = session.createQuery(hql);
			query.setParameter("tutor_name", tutorName);
			return query.list();
	}

}
