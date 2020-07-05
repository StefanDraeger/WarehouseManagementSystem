package de.draegerit.wms;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;

import de.draegerit.wms.db.User;
import de.draegerit.wms.db.dao.HalleDAO;
import de.draegerit.wms.db.dao.UserDAO;

@ManagedBean(name = "benutzerverwaltungBean")
@SessionScoped
public class BenutzerverwaltungBean {

	private List<User> users;

	private User selectedUser;

	@PostConstruct
	private void afterLoadBean() {
		aktualisieren();
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

	public void deleteUser() {
		new UserDAO().delete(selectedUser.getId());
	}

	public String aktualisieren() {
		users = new UserDAO().findAll();
		return "success";
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}
}
