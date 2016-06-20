package com.cee.associado.entity.apoio;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cee.associado.entity.FormaPagto;
import com.cee.associado.entity.Pessoa;

@Access(AccessType.FIELD)
public class RegistroContribuicao {

	@Id
	private Long id;

	private Pessoa pessoa;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@NotNull
	@Digits(integer = 10, fraction = 2)
	private BigDecimal valor;

	@Temporal(TemporalType.DATE)
	private Date pagoDe;
	
	@Temporal(TemporalType.DATE)
	private Date pagoAte;
	
	private FormaPagto formaPagto;
	
	@Size(max = 200)
	private String descricao;

	
	@Transient
	private String indExcPlc = "N";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getPagoDe() {
		return pagoDe;
	}

	public void setPagoDe(Date pagoDe) {
		this.pagoDe = pagoDe;
	}

	public Date getPagoAte() {
		return pagoAte;
	}

	public void setPagoAte(Date pagoAte) {
		this.pagoAte = pagoAte;
	}

	public FormaPagto getFormaPagto() {
		return formaPagto;
	}

	public void setFormaPagto(FormaPagto formaPagto) {
		this.formaPagto = formaPagto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setIndExcPlc(String indExcPlc) {
		this.indExcPlc = indExcPlc;
	}

	public String getIndExcPlc() {
		return indExcPlc;
	}
	
}
