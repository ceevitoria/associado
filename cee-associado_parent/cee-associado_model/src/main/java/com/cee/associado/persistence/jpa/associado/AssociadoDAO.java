package com.cee.associado.persistence.jpa.associado;

import com.cee.associado.persistence.jpa.AppJpaDAO;
import com.cee.associado.entity.AssociadoEntity;
import com.cee.associado.entity.Pessoa;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryParameter;
import com.cee.associado.entity.StatusAssociado;
import com.cee.associado.entity.TipoContribuicao;

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

@PlcAggregationDAOIoC(AssociadoEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class AssociadoDAO extends AppJpaDAO  {

	@PlcQuery("querySel")
	public native List<AssociadoEntity> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="pessoa", expression="obj1 = :pessoa") Pessoa pessoa,
			@PlcQueryParameter(name="status", expression="obj.status = :status") StatusAssociado status,
			@PlcQueryParameter(name="tipo", expression="obj.tipo = :tipo") TipoContribuicao tipo
	);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="pessoa", expression="obj1 = :pessoa") Pessoa pessoa,
			@PlcQueryParameter(name="status", expression="obj.status = :status") StatusAssociado status,
			@PlcQueryParameter(name="tipo", expression="obj.tipo = :tipo") TipoContribuicao tipo
	);
	
}
