package com.cee.associado.entity.config;

import java.math.BigDecimal;
import java.util.List;

public class RetornoRegistro {

	private BigDecimal valor;
	private Config config;
	private List<String> alertas;
	private List<String> mensagens;

	public RetornoRegistro(BigDecimal valor, Config config, List<String> alertas,
			List<String> mensagens) {
		this.valor = valor;
		this.config = config;
		this.alertas = alertas;
		this.mensagens = mensagens;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public List<String> getAlertas() {
		return alertas;
	}

	public void setAlertas(List<String> alertas) {
		this.alertas = alertas;
	}

	public List<String> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<String> mensagens) {
		this.mensagens = mensagens;
	}

}
