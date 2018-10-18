package de.draegerit.wms.db.dao;

import java.util.List;

import org.hibernate.Query;

import de.draegerit.wms.db.User;

public class UserDAO extends EntityDAO<User> {

	public User findByUsername(String username) {
		session.beginTransaction();
		Query query = session.createQuery("from User user where user.username = :username");
		query.setParameter("username", username);
		List results = query.list();
		session.getTransaction().commit();
		session.close();
		if (!results.isEmpty()) {
			return (User) results.get(0);
		}
		return null;
	}

	public Integer getId() {
		String hql = "select max(user.id) from User user";
		Query query = session.createQuery(hql);
		List<Integer> results = query.list();
		Integer userId = 1;
		if (results.get(0) != null) {
			userId = results.get(0) + 1;
		}
		return userId;
	}
}
