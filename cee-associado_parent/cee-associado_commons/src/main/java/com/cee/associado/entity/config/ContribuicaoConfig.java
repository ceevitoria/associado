package com.cee.associado.entity.config;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import com.powerlogic.jcompany.domain.type.PlcYesNo;

@MappedSuperclass
public abstract class ContribuicaoConfig extends Config {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_CONTRIBUICAO_CONFIG")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(length = 1)
	private PlcYesNo autoLimparTelaParaNovaContribuicao = PlcYesNo.S;

	@Enumerated(EnumType.STRING)
	@Column(length = 1)
	private PlcYesNo exibirMensagemSucesso = PlcYesNo.S;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(length = 1)
	private TipoMensagemSucessoConfig tipoMensagemSucesso = TipoMensagemSucessoConfig.V;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PlcYesNo getAutoLimparTelaParaNovaContribuicao() {
		return autoLimparTelaParaNovaContribuicao;
	}

	public void setAutoLimparTelaParaNovaContribuicao(
			PlcYesNo autoLimparTelaParaNovaContribuicao) {
		this.autoLimparTelaParaNovaContribuicao = autoLimparTelaParaNovaContribuicao;
	}

	public PlcYesNo getExibirMensagemSucesso() {
		return exibirMensagemSucesso;
	}

	public void setExibirMensagemSucesso(
			PlcYesNo exibirMensagemSucesso) {
		this.exibirMensagemSucesso = exibirMensagemSucesso;
	}

	public TipoMensagemSucessoConfig getTipoMensagemSucesso() {
		return tipoMensagemSucesso;
	}

	public void setTipoMensagemSucesso(
			TipoMensagemSucessoConfig tipoMensagemSucesso) {
		this.tipoMensagemSucesso = tipoMensagemSucesso;
	}

}
