package br.com.siac.pesistence.dao;

import br.com.siac.pesistence.model.Estudante;

public class EstudanteDAO extends DAOImpl<Estudante> {
	private static final long serialVersionUID = 1L;

	public EstudanteDAO() {
		super(Estudante.class);
	}

}
