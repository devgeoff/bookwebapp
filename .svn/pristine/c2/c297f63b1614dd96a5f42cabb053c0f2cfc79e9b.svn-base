package com.booksellingapp.dao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.booksellingapp.model.UserRole;


public class UserRoleDAOImpl implements UserRoleDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(UserRole userRole) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(userRole);
		tx.commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getUserRoles() {
		Session session = this.sessionFactory.openSession();
		List<UserRole> userRoleList = session.createQuery("from UserRole")
				.list();
		session.close();
		return userRoleList;
	}

	@Override
	public UserRole findUserRoleById(int userRoleId) {
		List<UserRole> userRoles = new ArrayList<UserRole>();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = " from UserRole where userRoleId= :userRoleId";
		userRoles = session.createQuery(hql)
				.setInteger("userRoleId", userRoleId).list();
		;
		// session.close();
		tx.commit();
		if (userRoles.size() > 0) {
			return userRoles.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void deleteUserRole(int userRoleId) {
		Session session = this.sessionFactory.openSession();
		String hql = "delete from UserRole where userRoleId= :userRoleId";
		session.createQuery(hql).setInteger("userRoleId", userRoleId)
				.executeUpdate();
		session.close();

	}

}
