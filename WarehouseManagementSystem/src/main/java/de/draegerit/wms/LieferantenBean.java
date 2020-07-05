package de.draegerit.wms;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import de.draegerit.wms.db.Lieferant;
import de.draegerit.wms.db.dao.LieferantDAO;

@ManagedBean(name="lieferantenBean")
@SessionScoped
public class LieferantenBean {
	
	private Lieferant createLieferant;
	
	private List<Lieferant> lieferanten;

	@PostConstruct
	public void init() {
		createLieferant = new Lieferant();
		loadLieferanten();
	}
	
	private void loadLieferanten() {
		lieferanten = new LieferantDAO().findAll();		
	}
	
	public String addLieferant() {
		new LieferantDAO().save(createLieferant);
		loadLieferanten();
		return "success";
	}
	
	
	public Lieferant getCreateLieferant() {
		return createLieferant;
	}

	public void setCreateLieferant(Lieferant createLieferant) {
		this.createLieferant = createLieferant;
	}

	public List<Lieferant> getLieferanten() {
		return lieferanten;
	}

	public void setLieferanten(List<Lieferant> lieferanten) {
		this.lieferanten = lieferanten;
	}

}
