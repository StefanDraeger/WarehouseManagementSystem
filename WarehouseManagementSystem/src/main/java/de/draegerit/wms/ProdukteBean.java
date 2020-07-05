package de.draegerit.wms;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import de.draegerit.wms.db.Produkt;
import de.draegerit.wms.db.dao.ProduktDAO;

@ManagedBean(name="produkteBean")
@SessionScoped
public class ProdukteBean {
	
	private List<Produkt> produkte;
	
	private Produkt createProdukt;
	
	@PostConstruct
	public void init() {
		createProdukt = new Produkt();
		loadProdukte();
	}
	
	private void loadProdukte() {
		produkte = new ProduktDAO().findAll();		
	}
	
	public String addProdukt() {
		System.out.println(createProdukt);
		new ProduktDAO().save(createProdukt);
		loadProdukte();
		return "success";
	}

	public List<Produkt> getProdukte() {
		return produkte;
	}

	public void setProdukte(List<Produkt> produkte) {
		this.produkte = produkte;
	}

	public Produkt getCreateProdukt() {
		return createProdukt;
	}

	public void setCreateProdukt(Produkt createProdukt) {
		this.createProdukt = createProdukt;
	}
}