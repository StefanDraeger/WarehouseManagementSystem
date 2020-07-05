package de.draegerit.wms;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;

import de.draegerit.wms.db.Halle;
import de.draegerit.wms.db.User;
import de.draegerit.wms.db.dao.HalleDAO;
import de.draegerit.wms.db.dao.UserDAO;

@ManagedBean(name = "firmaBean")
@SessionScoped
public class FirmaBean {

	private List<Halle> hallen;

	private Halle selectedHalle;


	@PostConstruct
	private void afterLoadBean() {
		hallen = new HalleDAO().findAll();		
	}

	public void addHalle() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String bezeichnung = params.get("form:bezeichnung");
		String hasStellplatz = params.get("form:hasStellplatz");
		String hasRegal = params.get("form:hasRegal");
		if (bezeichnung != null && !StringUtils.isBlank(bezeichnung)
				&& (hasStellplatz != null && !StringUtils.isBlank(hasStellplatz)
						|| hasRegal != null && !StringUtils.isBlank(hasRegal))) {
			Halle halle = new Halle();
			halle.setBezeichnung(bezeichnung);
			halle.setRegal(hasRegal != null && hasRegal.equalsIgnoreCase("on"));
			halle.setStellplatz(hasStellplatz != null && hasStellplatz.equalsIgnoreCase("on"));
			new HalleDAO().save(halle);
		}
		updateHalleTable();
	}

	public void deleteHalle() {
		new HalleDAO().delete(selectedHalle.getId());
		updateHalleTable();
	}

	public void updateHalleTable() {
		hallen = new HalleDAO().findAll();
	}

	public String loadProdukte() {
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
}
