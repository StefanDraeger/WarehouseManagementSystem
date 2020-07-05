package de.draegerit.wms.db.dao;

import java.util.List;

import org.hibernate.Query;

import de.draegerit.wms.db.Lieferant;

public class LieferantDAO extends EntityDAO<Lieferant>{

	public List<Lieferant> findAll() {
		Query query = session.createQuery("from Lieferant lieferant where 1 = 1");
		return query.list();
	}
}
