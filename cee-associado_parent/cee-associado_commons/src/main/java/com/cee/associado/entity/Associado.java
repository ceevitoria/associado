package com.cee.associado.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;

import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;

@MappedSuperclass
public abstract class Associado extends AppBaseEntity {
	private static final long serialVersionUID = -6264809714035679711L;

	@OneToMany(targetEntity = com.cee.associado.entity.OcorrenciaEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "associado")
	@ForeignKey(name = "FK_OCORRENCIA_ASSOCIADO")
	@PlcValMultiplicity(referenceProperty = "tipo", message = "{jcompany.aplicacao.mestredetalhe.multiplicidade.OcorrenciaEntity}")
	@OrderBy(value = "data")
	@Valid
	private List<Ocorrencia> ocorrencia;

	@NotNull
	@Size(max = 1)
	private String sitHistoricoPlc = "A";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_ASSOCIADO")
	private Long id;

	@ManyToOne(targetEntity = PessoaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_ASSOCIADO_PESSOA")
	@NotNull
	private Pessoa pessoa;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@NotNull
	@Digits(integer = 8, fraction = 2)
	private BigDecimal valor;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(length = 1)
	private StatusAssociado status;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(length = 2)
	private TipoContribuicao tipo;

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

	public StatusAssociado getStatus() {
		return status;
	}

	public void setStatus(StatusAssociado status) {
		this.status = status;
	}

	public TipoContribuicao getTipo() {
		return tipo;
	}

	public void setTipo(TipoContribuicao tipo) {
		this.tipo = tipo;
	}

	public String getSitHistoricoPlc() {
		return sitHistoricoPlc;
	}

	public void setSitHistoricoPlc(String sitHistoricoPlc) {
		this.sitHistoricoPlc = sitHistoricoPlc;
	}

	public List<Ocorrencia> getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(List<Ocorrencia> ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

}
