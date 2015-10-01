package com.booksellingapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.booksellingapp.model.Listing;
import com.booksellingapp.model.User;
import com.booksellingapp.model.UserTransaction;

public class TransactionDAOImpl implements TransactionDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<UserTransaction> getTransactions() {
		Session session = this.sessionFactory.openSession();
        List<UserTransaction> userTransactionList = session.createQuery("from UserTransaction").list();
        session.close();
        return userTransactionList;
	}
	
	@Override
	public void saveTransaction(UserTransaction transaction) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(transaction);
        tx.commit();
        session.close();
        System.out.println("done saving transaction");

	}

	@Override
	public UserTransaction getTransactionById(int id) {
		List<UserTransaction> userTransactionList= new ArrayList<UserTransaction>();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = " from UserTransaction where id= :id"; 
		userTransactionList = session.createQuery(hql).setInteger("id", id).list();;
//        session.close();
		 tx.commit();
		 if (userTransactionList.size() > 0) {
				return userTransactionList.get(0);
			} else {
				return new UserTransaction();
			} 	
	}

	

	@Override
	public List<UserTransaction> getTransactionsBySeller(String seller) {
		List<UserTransaction> userTransactionList= new ArrayList<UserTransaction>();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = " from UserTransaction where seller= :seller"; 
		userTransactionList = session.createQuery(hql).setString("seller", seller).list();        
		 tx.commit();
//		 session.close();
		if (userTransactionList.size() > 0) {
			return userTransactionList;
		} else {
			return userTransactionList;
		}		
	}

	@Override
	public List<UserTransaction> getTransactionsByBuyer(String buyer) {
		List<UserTransaction> userTransactionList= new ArrayList<UserTransaction>();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = " from UserTransaction where buyer= :buyer"; 
		userTransactionList = session.createQuery(hql).setString("buyer", buyer).list();        
		 tx.commit();
//		 session.close();
		if (userTransactionList.size() > 0) {
			return userTransactionList;
		} else {
			return userTransactionList;
		}		
	}

}
