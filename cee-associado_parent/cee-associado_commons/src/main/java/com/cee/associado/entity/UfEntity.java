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
@Table(name = "UF")
@SequenceGenerator(name = "SE_UF", sequenceName = "SE_UF")
@Access(AccessType.FIELD)
@NamedQueries({
		@NamedQuery(name = "UfEntity.querySel", query = "select id as id, nome as nome, sigla as sigla from UfEntity order by nome asc"),
		@NamedQuery(name = "UfEntity.queryMan", query = "from UfEntity"),
		@NamedQuery(name = "UfEntity.querySelLookup", query = "select id as id, nome as nome from UfEntity where id = ? order by id asc") })
public class UfEntity extends Uf {

	private static final long serialVersionUID = 1L;

	/*
	 * Construtor padrao
	 */
	public UfEntity() {
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
