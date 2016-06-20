package com.cee.associado.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.myfaces.extensions.validator.crossval.annotation.RequiredIf;
import org.apache.myfaces.extensions.validator.crossval.annotation.RequiredIfType;
import org.hibernate.annotations.ForeignKey;

import com.powerlogic.jcompany.config.domain.PlcReference;
import com.powerlogic.jcompany.domain.validation.PlcValGroupEntityList;

@MappedSuperclass
public abstract class Ocorrencia extends AppBaseEntity {
	private static final long serialVersionUID = 4265986405681849284L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_OCORRENCIA_ASSOCIADO")
	private Long id;

	@ManyToOne(targetEntity = AssociadoEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_OCORRENCIA_ASSOCIADO")
	@NotNull
	private Associado associado;

	@Enumerated(EnumType.STRING)
	@NotNull(groups = PlcValGroupEntityList.class)
	@RequiredIf(valueOf = "id", is = RequiredIfType.not_empty)
	@Column(length = 2)
	private TipoOcorrencia tipo;

	@NotNull(groups = PlcValGroupEntityList.class)
	@RequiredIf(valueOf = "tipo", is = RequiredIfType.not_empty)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Digits(integer = 8, fraction = 2)
	private BigDecimal valor;
	
	@NotNull(groups = PlcValGroupEntityList.class)
	@RequiredIf(valueOf = "tipo", is = RequiredIfType.not_empty)
	@Temporal(TemporalType.DATE)
	private Date pagoDe;
	
	@NotNull(groups = PlcValGroupEntityList.class)
	@RequiredIf(valueOf = "tipo", is = RequiredIfType.not_empty)
	@Temporal(TemporalType.DATE)
	private Date pagoAte;

	@ManyToOne(targetEntity = FormaPagto.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_ASSOCIADO_FORMAPAGTO")
	@NotNull(groups = PlcValGroupEntityList.class)
	@RequiredIf(valueOf = "id", is = RequiredIfType.not_empty)
	@PlcReference(testDuplicity = true)
	private FormaPagto formaPagto;
	
	@Size(max = 200)
	@Column(length=200)
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoOcorrencia getTipo() {
		return tipo;
	}

	public void setTipo(TipoOcorrencia tipo) {
		this.tipo = tipo;
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

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

}
