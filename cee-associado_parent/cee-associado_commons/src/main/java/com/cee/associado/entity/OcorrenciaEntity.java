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
@Table(name = "OCORRENCIA_ASSOCIADO")
@SequenceGenerator(name = "SE_OCORRENCIA_ASSOCIADO", sequenceName = "SE_OCORRENCIA_ASSOCIADO")
@Access(AccessType.FIELD)
@NamedQueries({ 
	@NamedQuery(name = "OcorrenciaEntity.querySel", query = "select obj.id as id, obj.tipo as tipo, obj.data as data, obj.valor as valor, obj.pagoDe as pagoDe, obj.pagoAte as pagoAte, obj3.id as formaPagto_id, obj3.nome as formaPagto_nome, obj.descricao as descricao, obj.versao as versao, obj1.id as associado_id, obj1.versao as associado_versao, obj2.id as associado_pessoa_id, obj2.nome as associado_pessoa_nome, obj2.versao as associado_pessoa_versao from OcorrenciaEntity obj inner join obj.associado obj1 inner join obj1.pessoa obj2 left outer join obj.formaPagto obj3 order by obj.pagoDe asc"),
	@NamedQuery(name = "OcorrenciaEntity.querySelLookup", query = "select obj.id as id, obj.data as data, obj.tipo as tipo, obj.descricao as descricao, obj1.id as associado_id, obj1.status as associado_status, obj2.id as associado_pessoa_id, obj2.nome as associado_pessoa_nome from OcorrenciaEntity obj inner join obj.associado obj1 inner join obj1.pessoa obj2 where obj.id = ? order by obj.pagoDe asc") })
public class OcorrenciaEntity extends Ocorrencia {
	private static final long serialVersionUID = 9098755376722320583L;

	/*
	 * Construtor padrao
	 */
	public OcorrenciaEntity() {
	}

	@Override
	public String toString() {
		return getTipo().toString() + "-" + getPagoDe()+ "-" + getPagoAte();
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
