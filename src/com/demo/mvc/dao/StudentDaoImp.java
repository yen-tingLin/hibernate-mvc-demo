package com.demo.mvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.mvc.entity.Student;


@Repository
public class StudentDaoImp implements StudentDao<Student> {

	// inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Student add(Integer id) {

		return null;
	}

	@Override
	public void bulkAdd(String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<Student> retrieveAll() {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		// create query
		Query<Student> query = (Query<Student>) session.createQuery("from Student");
		// execute query and get result list
		List<Student> students = query.getResultList();
		
		return students;
	}

	@Override
	@Transactional
	public Student retrieveById(Integer id) {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		// create query
		Query<Student> query = (Query<Student>) session.createQuery("from Student s where s.id = :id");
		// for test
		query.setParameter("id", id);
		
		Student studentRetrieved = null;
		try {
			// execute query and get result 
			studentRetrieved = query.getSingleResult();	
		
		} catch(Exception e ) {
			e.printStackTrace();
		}
		
		return studentRetrieved;
	}

	@Override
	@Transactional
	public Student retrieveByFirstName(String firstName) {
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		// create query
		Query<Student> query = (Query<Student>) session.createQuery("from Student s where s.firstName = :firstName");
		// execute query and get result
		Student studentRetrieved = query.getSingleResult();
		
		return studentRetrieved;
	}	
	
	@Override
	public Student update(Integer id) {
		return null;
		
	}

	@Override
	public void bulkUpdate(String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
