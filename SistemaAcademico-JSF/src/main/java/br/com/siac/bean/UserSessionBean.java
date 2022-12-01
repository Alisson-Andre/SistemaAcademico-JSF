package br.com.siac.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.siac.pesistence.model.User;
import br.com.siac.service.LoginService;

@Named
@ViewScoped
public class UserSessionBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private User admin = new User();

	@Inject
	private LoginService loginService;

	public String efetuarLogin() {
		System.out.println(admin.toString());
		User foundUser = loginService.verificarCredenciais(admin.getNomeUsuario(), admin.getSenha());

		System.out.println(foundUser);
		if (foundUser == null) {
			return "";
		}
		return "main?faces-redirect=true";
	}

	public String efetuarLogout() {
		this.admin = new User();
		return "login";
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

}
