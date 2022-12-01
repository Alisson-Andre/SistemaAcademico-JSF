package br.com.siac.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.siac.pesistence.model.Estudante;
import br.com.siac.service.EstudanteService;

@Named
@ViewScoped
public class ListagemEstudantesBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EstudanteService estudanteService;
	
	private List<Estudante> estudantes;
	
	@PostConstruct
	public void init() {
		this.estudantes = estudanteService.todosEstudantes();
	}
	
	public void excluirAluno(Estudante estudante) {
		estudanteService.excluir(estudante);
		this.estudantes = estudanteService.todosEstudantes();
	}
	
	public String carregarAluno(Estudante estudante) {
		this.putFlash("estudante", estudante);
		return "form-estudante?faces-redirect=true";
	}

	private void putFlash(String nome, Object valor) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put(nome, valor);
	}
	
	public List<Estudante> getEstudantes() {
		return estudantes;
	}
	
}
