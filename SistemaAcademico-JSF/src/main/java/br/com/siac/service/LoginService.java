package br.com.siac.service;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import javax.xml.bind.DatatypeConverter;

import br.com.siac.pesistence.dao.UserDAO;
import br.com.siac.pesistence.model.User;

public class LoginService implements Serializable {
	private static final long serialVersionUID = 1L;

	private UserDAO userDAO;

	public User verificarCredenciais(String nomeUsuario, String senha) {
		String senhaHash = generateMD5Hash(senha).toUpperCase(Locale.ROOT);
		System.out.println(senhaHash);
		return userDAO.findByUserHQLQuery("searchUser", nomeUsuario, senhaHash);
	}

	private String generateMD5Hash(String senha) {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MDS");
			messageDigest.update(senha.getBytes(StandardCharsets.UTF_8));
			byte[] digest = messageDigest.digest();

			return DatatypeConverter.printHexBinary(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}
