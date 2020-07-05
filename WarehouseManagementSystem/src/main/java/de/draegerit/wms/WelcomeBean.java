package de.draegerit.wms;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="welcomeBean")
@RequestScoped
public class WelcomeBean {

	@ManagedProperty(value="#{login}")
	private LoginBean loginBean;
	
	
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

}
