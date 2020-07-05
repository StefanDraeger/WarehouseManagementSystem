package de.draegerit.wms.db.dao;

import java.util.List;

import org.hibernate.Query;

import de.draegerit.wms.db.Produkt;

public class ProduktDAO extends EntityDAO<Produkt>{

	public List<Produkt> findAll() {
		Query query = session.createQuery("from Produkt produkt where 1 = 1");
		return query.list();
	}

	public List<Produkt> findAllWithWarnings() {
		Query query = session.createQuery("from Produkt produkt where produkt.anzahl < produkt.warnAnzahl and 1 = 1");
		return query.list();
	}
}
