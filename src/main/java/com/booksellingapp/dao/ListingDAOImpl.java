package com.booksellingapp.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.booksellingapp.model.Listing;


public class ListingDAOImpl implements ListingDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Listing listing) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(listing);
        tx.commit();
        session.close();
        System.out.println("done saving listing");
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Listing> getListings() {
		Session session = this.sessionFactory.openSession();
        List<Listing> listingList = session.createQuery("from Listing").list();
        session.close();
        return listingList;
	}

//	@Override
//	public Listing findListingById(int listingId) {
//		List<Listing> listings = new ArrayList<Listing>();
//		Session session = this.sessionFactory.openSession(); 
//		listings = sessionFactory.getCurrentSession()
//			.createQuery("from Listing where listingId=?")
//			.setParameter(0, listingId)
//			.list();
// 
//		if (listings.size() > 0) {
//			return listings.get(0);
//		} else {
//			return null;
//		}
// 
//	}
	
	@Override
	public Listing findListingById(int id) {
		List<Listing> listings = new ArrayList<Listing>();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = " from Listing where id= :id"; 
		listings = session.createQuery(hql).setInteger("id", id).list();;
//        session.close();
		 tx.commit();
		 if (listings.size() > 0) {
				return listings.get(0);
			} else {
				return null;
			} 	
	}
	
	@Override
	public void deleteListing(int id) {
		Session session = this.sessionFactory.openSession();
		String hql = "delete from Listing where id= :id"; 
		session.createQuery(hql).setInteger("id", id).executeUpdate();
        session.close();
		
	}

}
