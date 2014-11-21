package com.cee.associado.entity.config;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import com.powerlogic.jcompany.domain.type.PlcYesNo;
import javax.persistence.Access;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.AccessType;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;
import javax.persistence.Entity;

/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name = "CONTRIBUICAO_CONFIG")
@SequenceGenerator(name = "SE_CONTRIBUICAO_CONFIG", sequenceName = "SE_CONTRIBUICAO_CONFIG")
@Access(AccessType.FIELD)
@NamedQueries({ @NamedQuery(name = "ContribuicaoConfigEntity.querySelLookup", query = "select id as id, exibirMensagemSucesso as exibirMensagemSucesso from ContribuicaoConfigEntity where id = ? order by id asc") })
public class ContribuicaoConfigEntity extends ContribuicaoConfig {

	private static final long serialVersionUID = 1L;

	/*
	 * Construtor padrao
	 */
	public ContribuicaoConfigEntity() {
	}

	@Override
	public String toString() {
		return getExibirMensagemSucesso().toString();
	}

}
