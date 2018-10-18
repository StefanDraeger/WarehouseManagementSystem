package de.draegerit.wms;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import de.draegerit.wms.db.Halle;
import de.draegerit.wms.db.dao.HalleDAO;

@Named
@SessionScoped
public class FirmaBean {

	private List<Halle> hallen;
	
	private Halle selectedHalle;
	
	private String contentPage = "logout";

	@PostConstruct
	private void afterLoadBean() {
		hallen = new HalleDAO().findAll();		
	}
	
	public String addHalle() {
		return "success";
	}

	public List<Halle> getHallen() {
		return hallen;
	}

	public void setHallen(List<Halle> hallen) {
		this.hallen = hallen;
	}

	public Halle getSelectedHalle() {
		return selectedHalle;
	}

	public void setSelectedHalle(Halle selectedHalle) {
		this.selectedHalle = selectedHalle;
	}

	public String getContentPage() {
		return contentPage;
	}

	public void setContentPage(String contentPage) {
		this.contentPage = contentPage;
	}

}
