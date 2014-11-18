package com.cee.associado.entity;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "PESSOA")
@SequenceGenerator(name = "SE_PESSOA", sequenceName = "SE_PESSOA")
@Access(AccessType.FIELD)
@NamedQueries({
		@NamedQuery(name = "PessoaEntity.queryMan", query = "from PessoaEntity where sitHistoricoPlc='A'"),
		@NamedQuery(name = "PessoaEntity.querySel", query = "select obj.id as id, obj.nome as nome, obj.cpf as cpf, obj.endereco.logradouro as endereco_logradouro, obj.endereco.bairro as endereco_bairro, obj1.id as endereco_uf_id , obj1.nome as endereco_uf_nome, obj2.id as endereco_cidade_id , obj2.nome as endereco_cidade_nome from PessoaEntity obj left outer join obj.endereco.uf as obj1 left outer join obj.endereco.cidade as obj2 where obj.sitHistoricoPlc='A' order by obj.nome asc"),
		@NamedQuery(name = "PessoaEntity.naoDeveExistirCpfDuplicado", query = "select count(obj.cpf) from PessoaEntity obj where obj.cpf=:cpf"),
		@NamedQuery(name = "PessoaEntity.querySelLookup", query = "select id as id, nome as nome from PessoaEntity where id = ? order by id asc") })
public class PessoaEntity extends Pessoa {

	private static final long serialVersionUID = 1L;

	/*
	 * Construtor padrao
	 */
	public PessoaEntity() {
	}

	@Override
	public String toString() {
		return getNome();
	}

}
