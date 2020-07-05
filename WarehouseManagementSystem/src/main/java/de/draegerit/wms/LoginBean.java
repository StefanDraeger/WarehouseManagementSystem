package de.draegerit.wms;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import de.draegerit.wms.db.User;
import de.draegerit.wms.db.dao.UserDAO;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {

	private static final String FAIL = "fail";

	private static final String SUCCESS = "success";

	private static final String EMPTY = "";

	private String username;

	private String passwort;

	private boolean loginSuccessfull;
	
	public String doLogin() {
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findByUsername(getUsername());
		if (user != null && passwort.equalsIgnoreCase(user.getPasswort())) {
			setLoginSuccessfull(true);			
			return SUCCESS;
		}
		setLoginSuccessfull(false);
		return FAIL;
	}

	public String doLogout() {
		setUsername(EMPTY);
		setPasswort(EMPTY);
		setLoginSuccessfull(false);
		 FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return SUCCESS;

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
