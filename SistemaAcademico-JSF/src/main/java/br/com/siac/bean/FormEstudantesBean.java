package br.com.siac.bean;

import static br.com.siac.utils.FacesUtils.addSuccessMessage;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.siac.pesistence.model.Estudante;
import br.com.siac.service.EstudanteService;

@Named
@ViewScoped
public class FormEstudantesBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EstudanteService estudanteService;

	@Inject
	private Estudante estudante;

	@PostConstruct
	private void init() {
		Estudante estudanteFlash = (Estudante) this.getFlash("estudante");
		if (estudanteFlash != null) {
			this.estudante = estudanteFlash;
		}
	}

	public String cadastrarOuAlterarAluno() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem;
		this.getFlash().setKeepMessages(true);

		try {
			if (this.estudante.getId() == null) {
				estudanteService.cadastrar(estudante);
//				addSuccessMessage("sucessoSalvarEstudante");
				mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Estudante criado com sucesso!", null);
				context.addMessage(null, mensagem);

			} else {
				estudanteService.alterar(estudante);
				addSuccessMessage("sucessoAtualizarEstudante");
			}

		} catch (Exception e) {
			System.out.println("ENTROU NO CATCH");
			e.printStackTrace();
		}
		return "";
	}

	private Object getFlash(String nome) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		return flash.get(nome);
	}

	private Flash getFlash() {
		return FacesContext.getCurrentInstance().getExternalContext().getFlash();
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

}
