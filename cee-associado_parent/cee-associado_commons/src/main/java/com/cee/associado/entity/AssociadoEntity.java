package com.cee.associado.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;

/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name = "ASSOCIADO")
@SequenceGenerator(name = "SE_ASSOCIADO", sequenceName = "SE_ASSOCIADO")
@Access(AccessType.FIELD)
@NamedQueries({
	@NamedQuery(name = "AssociadoEntity.queryMan", query = "from AssociadoEntity"),
	@NamedQuery(name = "AssociadoEntity.queryEdita", query="select obj from AssociadoEntity obj where obj.id = ?"),
	@NamedQuery(name = "AssociadoEntity.naoDeveExistirPessoa", query = "select count(obj) from AssociadoEntity obj where obj.pessoa = :pessoa"),
	@NamedQuery(name = "AssociadoEntity.obterAssociadoPorIdPessoa", query = "from AssociadoEntity where pessoa.id = :idPessoa"),
	@NamedQuery(name = "AssociadoEntity.querySel", query = "select obj.id as id, obj.data as data, obj.valor as valor, obj.status as status, obj.tipo as tipo, obj1.id as pessoa_id, obj1.nome as pessoa_nome from AssociadoEntity obj left outer join obj.pessoa as obj1 order by obj1.nome asc"),
	@NamedQuery(name = "AssociadoEntity.querySelLookup", query = "select obj.id as id, obj1.id as pessoa_id, obj1.nome as pessoa_nome from AssociadoEntity obj inner join obj.pessoa obj1 where obj.id = ? order by obj1.nome asc") })
public class AssociadoEntity extends Associado {
	private static final long serialVersionUID = 7785416002588051892L;

	/*
	 * Construtor padrao
	 */
	public AssociadoEntity() {
	}

	@Override
	public String toString() {
		
		if (getPessoa() != null) {
			return getPessoa().toString();
		}
		
		return "";
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
