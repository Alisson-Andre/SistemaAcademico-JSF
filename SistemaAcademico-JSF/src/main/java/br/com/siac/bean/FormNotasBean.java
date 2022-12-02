package br.com.siac.bean;

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
import static br.com.siac.utils.FacesUtils.addSuccessMessage;

@Named
@ViewScoped
public class FormNotasBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EstudanteService estudanteService;

	public String atualizarBoletim(Estudante estudante) {
		estudanteService.alterar(estudante);
//		addSuccessMessage("sucessoAtualizarBoletin");

		return "notas?faces-redirect=true";
	}

	public Boolean travaCampoFinal(Estudante estudante) {
		if (estudante.getNota1() != null && estudante.getNota2() != null && estudante.getNota3() != null
				&& estudante.getNota4() != null) {
			if (estudante.getFaltas() != null) {
				if (estudante.getFaltas() > 25) {
					return true;
				}
			}
			return !((estudante.getNota1().doubleValue() +
					estudante.getNota2().doubleValue() +
					estudante.getNota3().doubleValue() +
					estudante.getNota4().doubleValue())/4 >=4);
		}
		return true;
	}
}
