package de.draegerit.wms;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "viewBean")
@SessionScoped
public class ViewBean {

	private String contentPage = "logout";

	private String homelink;

	@PostConstruct
	private void afterLoadBean() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.getApplicationContextPath();
		homelink = externalContext.getApplicationContextPath();
	}

	public boolean isBenutzerverwaltung() {
		return contentPage.equalsIgnoreCase(EContentage.BENUTZERVERWALTUNG.getPage());
	}
	
	public boolean isHallenverwaltung() {
		return contentPage.equalsIgnoreCase(EContentage.HALLETBL.getPage());
	}

	public String benutzerverwaltung() {
		setContentPage("benutzerverwaltung");
		return "success";
	}
	
	public String halleverwaltung() {
		setContentPage("halleTbl");
		return "success";
	}	
	
	public String loadProdukte() {
		setContentPage("produkte");
		return "success";
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
