package de.draegerit.wms.db.dao;

import java.util.List;

import org.hibernate.Query;

import de.draegerit.wms.db.Halle;

public class HalleDAO extends EntityDAO<Halle> {

	public List<Halle> findAll() {
		Query query = session.createQuery("from Halle halle where 1 = 1");
		return query.list();
	}

	public void delete(long id) {
		session.beginTransaction();
		Query query = session.createQuery("from Halle halle where halle.id = :id");
		query.setParameter("id", id);
		Object result = query.uniqueResult();
		if (result instanceof Halle) {
			Halle halle = (Halle) result;
			session.delete(halle);
		}
		session.getTransaction().commit();
		session.close();
	}
}
