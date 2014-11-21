package com.cee.associado.facade;

import java.util.List;

import com.cee.associado.entity.config.RetornoRegistro;
import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.PlcException;
import com.powerlogic.jcompany.commons.facade.IPlcFacade;

public interface IAppFacade extends IPlcFacade {
	
	/**
	 * Registra a contribuicao de um ou mais associado
	 * @param context Contexto da aplicacao
	 * @param entityList Relacao das contribuicões sendo registradas
	 * @return RetornoRegistro Retorna com informacoes sobre o registro da contribuicao (@see RetornoRegistro)
	 */
	public RetornoRegistro registrarContribuicao(PlcBaseContextVO context, List entityList) throws PlcException;

}
