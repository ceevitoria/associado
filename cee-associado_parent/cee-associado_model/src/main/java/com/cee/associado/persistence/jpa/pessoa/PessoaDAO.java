package com.cee.associado.persistence.jpa.pessoa;

import com.cee.associado.persistence.jpa.AppJpaDAO;
import com.cee.associado.entity.PessoaEntity;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryParameter;
import com.cee.associado.entity.Uf;
import com.cee.associado.entity.Cidade;

import java.util.List;

import com.powerlogic.jcompany.persistence.jpa.PlcQuery;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryLineAmount;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryOrderBy;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryFirstLine;
import com.powerlogic.jcompany.commons.annotation.PlcAggregationDAOIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcDataAccessObject;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryService;
import com.powerlogic.jcompany.commons.PlcBaseContextVO;
/**
 * Classe de Persistência gerada pelo assistente
 */

@PlcAggregationDAOIoC(PessoaEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class PessoaDAO extends AppJpaDAO  {

	@PlcQuery("querySel")
	public native List<PessoaEntity> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="nome", expression="obj.nome like :nome || '%' ") String nome,
			@PlcQueryParameter(name="cpf", expression="obj.cpf like :cpf || '%' ") String cpf,
			@PlcQueryParameter(name="endereco_logradouro", expression="obj.endereco.logradouro like :endereco_logradouro || '%' ") String endereco_logradouro,
			@PlcQueryParameter(name="endereco_bairro", expression="obj.endereco.bairro like :endereco_bairro || '%' ") String endereco_bairro,
			@PlcQueryParameter(name="endereco_uf", expression="obj1 = :endereco_uf") Uf endereco_uf,
			@PlcQueryParameter(name="endereco_cidade", expression="obj2 = :endereco_cidade") Cidade endereco_cidade
	);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="nome", expression="obj.nome like :nome || '%' ") String nome,
			@PlcQueryParameter(name="cpf", expression="obj.cpf like :cpf || '%' ") String cpf,
			@PlcQueryParameter(name="endereco_logradouro", expression="obj.endereco.logradouro like :endereco_logradouro || '%' ") String endereco_logradouro,
			@PlcQueryParameter(name="endereco_bairro", expression="obj.endereco.bairro like :endereco_bairro || '%' ") String endereco_bairro,
			@PlcQueryParameter(name="endereco_uf", expression="obj1 = :endereco_uf") Uf endereco_uf,
			@PlcQueryParameter(name="endereco_cidade", expression="obj2 = :endereco_cidade") Cidade endereco_cidade
	);
	
}
