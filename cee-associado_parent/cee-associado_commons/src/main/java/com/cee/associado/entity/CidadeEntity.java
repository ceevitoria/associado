package com.cee.associado.entity;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Access;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.AccessType;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name = "CIDADE")
@SequenceGenerator(name = "SE_CIDADE", sequenceName = "SE_CIDADE")
@Access(AccessType.FIELD)
@NamedQueries({ @NamedQuery(name = "CidadeEntity.querySelLookup", query = "select id as id, nome as nome from CidadeEntity where id = ? order by id asc") })
public class CidadeEntity extends Cidade {

	private static final long serialVersionUID = 1L;

	/*
	 * Construtor padrao
	 */
	public CidadeEntity() {
	}

	@Override
	public String toString() {
		return getNome();
	}

	@Transient
	private String indExcPlc = "N";

	public void setIndExcPlc(String indExcPlc) {
		this.indExcPlc = indExcPlc;
	}

	public String getIndExcPlc() {
		return indExcPlc;
	}

}
