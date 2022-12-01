package br.com.siac.pesistence.dao;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.siac.pesistence.model.User;

@Named
@SessionScoped
public class UserDAO extends DAOImpl<User> {
	private static final long serialVersionUID = 1L;

	public UserDAO() {
		super(User.class);
	}

}
