package de.draegerit.wms;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.draegerit.wms.db.User;
import de.draegerit.wms.db.dao.UserDAO;

@Named
@SessionScoped
public class LoginBean {

	private String username;

	private String passwort;

	private boolean loginSuccessfull;

	@Inject
	private FirmaBean firmaBean;
	
	public String doLogin() {
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findByUsername(getUsername());
		if (user != null && passwort.equalsIgnoreCase(user.getPasswort())) {
			setLoginSuccessfull(true);
			firmaBean.setContentPage(EContentage.HALLETBL.getPage());
			return "success";
		}
		setLoginSuccessfull(false);
		return "fail";
	}

	public String doLogout() {
		setUsername("");
		setPasswort("");
		setLoginSuccessfull(false);
		return "success";

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public boolean isLoginSuccessfull() {
		return loginSuccessfull;
	}

	public void setLoginSuccessfull(boolean loginSuccessfull) {
		this.loginSuccessfull = loginSuccessfull;
	}
}
