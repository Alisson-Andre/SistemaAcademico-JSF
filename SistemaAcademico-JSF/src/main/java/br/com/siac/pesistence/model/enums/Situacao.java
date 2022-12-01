package br.com.siac.pesistence.model.enums;

public enum Situacao {

	MT("Matriculado"), AP("Aprovado"), RP("Reprovado"), FN("Na final"), RF("Reprovado por falta");

	private String descricao;

	Situacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
