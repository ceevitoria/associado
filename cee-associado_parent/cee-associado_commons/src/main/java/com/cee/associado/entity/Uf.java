package com.cee.associado.entity;

import org.apache.myfaces.extensions.validator.crossval.annotation.RequiredIf;
import javax.validation.constraints.NotNull;
import org.apache.myfaces.extensions.validator.crossval.annotation.RequiredIfType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import com.powerlogic.jcompany.config.domain.PlcReference;
import com.powerlogic.jcompany.domain.validation.PlcValGroupEntityList;
import javax.persistence.GeneratedValue;
import java.util.List;
import com.powerlogic.jcompany.domain.validation.PlcValDuplicity;
import javax.validation.Valid;
import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import org.hibernate.annotations.ForeignKey;

@MappedSuperclass
public abstract class Uf extends AppBaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_UF")
	private Long id;

	@NotNull(groups = PlcValGroupEntityList.class)
	@RequiredIf(valueOf = "id", is = RequiredIfType.not_empty)
	@Size(max = 60)
	@PlcReference(testDuplicity = true)
	private String nome;

	@NotNull(groups = PlcValGroupEntityList.class)
	@RequiredIf(valueOf = "nome", is = RequiredIfType.not_empty)
	@Size(max = 2)
	private String sigla;

	@OneToMany (targetEntity = com.cee.associado.entity.CidadeEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="uf")
	@ForeignKey(name="FK_CIDADE_UF")
	@PlcValDuplicity(property="nome")
	@PlcValMultiplicity(referenceProperty="nome",  message="{jcompany.aplicacao.mestredetalhe.multiplicidade.CidadeEntity}")
	@Valid
	private List<Cidade> cidade;

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Cidade> getCidade() {
		return cidade;
	}

	public void setCidade(List<Cidade> cidade) {
		this.cidade=cidade;
	}

}
