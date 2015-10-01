package com.booksellingapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.booksellingapp.model.Image;


public class ImageDAOImpl implements ImageDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save (Image image) {
	//
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(image);
		tx.commit();
		session.close();
	//

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Image> getImages() {
		Session session = this.sessionFactory.openSession();
	List<Image> imageList = session.createQuery("from Image").list();
	session.close();
	return imageList;
	}

//	@Override
//	public user findByImageId(String imageId) {
//		List<Image> images = new ArrayList<Image>();
//		Session session = this.sessionFactory.openSession();
//		//
//		images = sessionFactory.getCurrentSession()
//			.createQuery("from Image where imageId=?")
//			.setParameter(0, imageId)
//			.list();
//		//
//		if (images.size() > 0) {
//			return images.get(0);
//		} else {
//			return null;
//		}
//	}

	@Override
	public Image findImageByImageId(String imageId) {
		List<Image> images = new ArrayList<Image>();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = " from Image where imageId= :imageId";
		images = session.createQuery(hql).setString("imageId", imageId).list();;
		//	session.close();
		tx.commit();
		if (images.size() > 0) {
			return images.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void deleteImage(String imageId) {
		Session session = this.sessionFactory.openSession();
		String hql = "delete from Image where imageId= imageId";
		session.createQuery(hql).setString("imageId", imageId).executeUpdate();
		session.close();

	}

	
}
