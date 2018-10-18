package de.draegerit.wms.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import de.draegerit.wms.db.User;
import de.draegerit.wms.db.util.HibernateUtil;

public class EntityDAO<T> {
	Session session = HibernateUtil.getSessionFactory().openSession();

	public void save(T o) {
		session.beginTransaction();
		session.save(o);
		session.getTransaction().commit();
		session.close();
	}
}
