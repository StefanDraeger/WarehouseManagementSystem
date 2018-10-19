package de.draegerit.wms;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
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

	private String contentPage = "logout";

	private String homelink;

	@PostConstruct
	private void afterLoadBean() {
		hallen = new HalleDAO().findAll();
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.getApplicationContextPath();
		homelink = externalContext.getApplicationContextPath();
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
		setContentPage(EContentage.HALLETBL.getPage());
	}

	public void deleteHalle() {
		new HalleDAO().delete(selectedHalle.getId());
		updateHalleTable();
	}

	public void updateHalleTable() {
		hallen = new HalleDAO().findAll();
	}

	public void addUser() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String username = params.get("form:benutzername");
		String passwort1 = params.get("form:passwort1");
		String passwort2 = params.get("form:passwort2");
		if (!StringUtils.isBlank(username) && !StringUtils.isBlank(passwort1) && !StringUtils.isBlank(passwort2)
				&& passwort1.equals(passwort2)) {
			User user = new User();
			user.setUsername(username);
			user.setPasswort(passwort1);
			new UserDAO().save(user);
		}
	}
	
	public void loadBenutzer() {
		System.out.println("HalloWelt!");
		setContentPage("benutzerverwaltung");
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

	public String getHomelink() {
		return homelink;
	}

	public void setHomelink(String homelink) {
		this.homelink = homelink;
	}

}
