package de.draegerit.wms.db.dao;

import java.util.List;

import org.hibernate.Query;

import de.draegerit.wms.db.Halle;

public class HalleDAO extends EntityDAO<Halle>{

	public List<Halle> findAll(){
		Query query = session.createQuery("from Halle halle where 1 = 1");
		return query.list();
	}
}
