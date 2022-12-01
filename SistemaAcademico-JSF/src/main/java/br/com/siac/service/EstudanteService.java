package br.com.siac.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.siac.annotations.Transactional;
import br.com.siac.pesistence.dao.EstudanteDAO;
import br.com.siac.pesistence.model.Estudante;

public class EstudanteService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EstudanteDAO estudanteDAO;
	
	@Transactional
	public void cadastrar(Estudante estudante) {
		estudanteDAO.save(estudante);
	}
	
	@Transactional
	public void excluir(Estudante estudante) {
		estudanteDAO.remove(estudante);
	}
	
	@Transactional
	public void alterar(Estudante estudante) {
		estudanteDAO.update(estudante);
	}
	
	public List<Estudante> todosEstudantes() {
		return estudanteDAO.listAll();
	}
}
