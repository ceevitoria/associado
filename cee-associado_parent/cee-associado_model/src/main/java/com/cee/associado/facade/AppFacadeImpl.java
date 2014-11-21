package com.cee.associado.facade;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import com.cee.associado.entity.config.RetornoRegistro;
import com.cee.associado.model.ContribuicaoRepository;
import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.PlcException;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcFacade;
import com.powerlogic.jcompany.facade.PlcFacadeImpl;
import com.powerlogic.jcompany.model.annotation.PlcTransactional;

@QPlcDefault
@SPlcFacade
public class AppFacadeImpl extends PlcFacadeImpl implements IAppFacade {

	@Inject
	private ContribuicaoRepository contribuicaoRepository;
	
	@PlcTransactional(commit=true)
	@TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
	@Override
	public RetornoRegistro registrarContribuicao(PlcBaseContextVO context, List entityList) throws PlcException {
		return contribuicaoRepository.registrarContribuicao(context, entityList);
	}
	
}
