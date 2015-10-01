package com.booksellingapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.booksellingapp.model.User;


public class UserDAOImpl implements UserDAO {

   
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(User user) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(user);
        tx.commit();
        session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		Session session = this.sessionFactory.openSession();
        List<User> userList = session.createQuery("from User").list();
        session.close();
        return userList;
	}

//	@Override
//	public User findByUserName(String username) {
//		List<User> users = new ArrayList<User>();
//		Session session = this.sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		users = sessionFactory.getCurrentSession()
//			.createQuery("from User where username=?")
//			.setParameter(0, username)
//			.list();
//		 tx.commit();
//		if (users.size() > 0) {
//			return users.get(0);
//		} else {
//			return null;
//		}		
//	}
	
	@Override
	public User findByUserName(String username) {
		List<User> users = new ArrayList<User>();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = " from User where username= :username"; 
		users = session.createQuery(hql).setString("username", username).list();;
//        session.close();
		 tx.commit();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}		
	}
	
	@Override
	public void deleteUser(String username) {
		Session session = this.sessionFactory.openSession();
		String hql = "delete from User where username= :username"; 
		session.createQuery(hql).setString("username", username).executeUpdate();
        session.close();
		
	}

}
