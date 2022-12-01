package br.com.siac.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.siac.pesistence.model.Estudante;
import br.com.siac.pesistence.model.enums.Situacao;
import br.com.siac.service.EstudanteService;

@Named
@ViewScoped
public class RelatorioEstudantesBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EstudanteService estudanteService;

	private List<Estudante> estudantes;

	@PostConstruct
	public void init() {
		this.estudantes = estudanteService.todosEstudantes();
	}

	public void realizarRelatorio() {
		estudantes.forEach(estudante -> {
			BigDecimal media;
			media = calcularMedia(estudante);
			estudante.setMedia(media);

			Situacao situacao;
			situacao = calcularSituacao(estudante);
			estudante.setSituacao(situacao);
		});
	}

	private BigDecimal calcularMedia(Estudante estudante) {
		BigDecimal nota1 = estudante.getNota1();
		BigDecimal nota2 = estudante.getNota2();
		BigDecimal nota3 = estudante.getNota3();
		BigDecimal nota4 = estudante.getNota4();
		BigDecimal notaFinal = estudante.getNotaFinal();
		BigDecimal media = null;

		if (nota1 != null && nota2 != null && nota3 != null && nota4 != null) {
			media = (nota1.add(nota2).add(nota3).add(nota4).divide(new BigDecimal(4), MathContext.DECIMAL32));

			if (notaFinal != null) {
				media = (media.multiply(new BigDecimal(60)).add(notaFinal.multiply(new BigDecimal(40)))
						.divide(new BigDecimal(100), MathContext.DECIMAL32));
			}
		}
		return media;
	}

	private Situacao calcularSituacao(Estudante estudante) {
		BigDecimal media = this.calcularMedia(estudante);
		BigDecimal notaFinal = estudante.getNotaFinal();
		Integer faltas = estudante.getFaltas();

		if (faltas != null) {
			if (faltas >= 25) {
				return Situacao.RF;
			}
			if (media != null) {
				if (media.compareTo(new BigDecimal(0)) > 0) {
					if (notaFinal != null) {
						if (media.compareTo(new BigDecimal(50)) == 0 || media.compareTo(new BigDecimal(50)) == 1) {
							return Situacao.AP;
						} else {
							return Situacao.RP;
						}
					} else {
						if (media.compareTo(new BigDecimal(40)) == -1) {
							return Situacao.RP;
						}
						if (media.compareTo(new BigDecimal(70)) == -1) {
							return Situacao.FN;
						}
						if (media.compareTo(new BigDecimal(70)) == 0 || media.compareTo(new BigDecimal(70)) == 1) {
							return Situacao.AP;
						}
					}
				}
			}
		}
		return Situacao.MT;
	}

	public List<Estudante> getEstudantes() {
		return estudantes;
	}

}
