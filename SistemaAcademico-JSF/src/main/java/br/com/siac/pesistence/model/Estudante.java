package br.com.siac.pesistence.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import br.com.siac.pesistence.model.enums.Situacao;

@Entity
public class Estudante extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "nome", nullable = false, length = 120)
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nasc", nullable = false)
	private Date dataNascimento;

	@Column(name = "faltas", length = 5)
	private Integer faltas;

	@Column(name = "nota1", length = 5)
	private BigDecimal nota1;

	@Column(name = "nota2", length = 5)
	private BigDecimal nota2;

	@Column(name = "nota3", length = 5)
	private BigDecimal nota3;

	@Column(name = "nota4", length = 5)
	private BigDecimal nota4;

	@Column(name = "nota_final", length = 5)
	private BigDecimal notaFinal;

	@Transient
	private BigDecimal media;

	@Transient
	private Situacao situacao;

	public Estudante() {
	}

	public Estudante(@NotEmpty String nome, Date dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getFaltas() {
		return faltas;
	}

	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
	}

	public BigDecimal getNota1() {
		return nota1;
	}

	public void setNota1(BigDecimal nota1) {
		this.nota1 = nota1;
	}

	public BigDecimal getNota2() {
		return nota2;
	}

	public void setNota2(BigDecimal nota2) {
		this.nota2 = nota2;
	}

	public BigDecimal getNota3() {
		return nota3;
	}

	public void setNota3(BigDecimal nota3) {
		this.nota3 = nota3;
	}

	public BigDecimal getNota4() {
		return nota4;
	}

	public void setNota4(BigDecimal nota4) {
		this.nota4 = nota4;
	}

	public BigDecimal getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(BigDecimal notaFinal) {
		this.notaFinal = notaFinal;
	}

	public BigDecimal getMedia() {
		return media;
	}

	public void setMedia(BigDecimal media) {
		this.media = media;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

}
