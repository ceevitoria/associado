package com.cee.associado.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.myfaces.extensions.validator.crossval.annotation.RequiredIf;
import org.apache.myfaces.extensions.validator.crossval.annotation.RequiredIfType;

import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;
import com.powerlogic.jcompany.config.domain.PlcReference;
import com.powerlogic.jcompany.domain.validation.PlcValGroupEntityList;

@SPlcEntity
@Entity
@Table(name = "FORMA_PAGTO")
@SequenceGenerator(name = "SE_FORMA_PAGTO", sequenceName = "SE_FORMA_PAGTO")
@Access(AccessType.FIELD)
@NamedQueries({
	@NamedQuery(name="FormaPagto.queryMan", query="from FormaPagto"), 
	@NamedQuery(name="FormaPagto.querySel", query="select id as id, nome as nome from FormaPagto order by id asc"), 
	@NamedQuery(name="FormaPagto.querySelLookup", query="select id as id, nome as nome from FormaPagto where id = ? order by id asc") })
public class FormaPagto extends AppBaseEntity {
	private static final long serialVersionUID = -2812997345365138380L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_FORMA_PAGTO")
	private Long id;

	@NotNull(groups = PlcValGroupEntityList.class)
	@RequiredIf(valueOf = "id", is = RequiredIfType.not_empty)
	@Size(max = 80)
	@PlcReference(testDuplicity = true)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/*
	 * Construtor padrao
	 */
	public FormaPagto() {
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
