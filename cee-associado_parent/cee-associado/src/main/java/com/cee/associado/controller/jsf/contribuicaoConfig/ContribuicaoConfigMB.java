package com.cee.associado.controller.jsf.contribuicaoConfig;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.cee.associado.controller.jsf.AppMB;
import com.cee.associado.entity.config.ContribuicaoConfigEntity;
import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

@PlcConfigAggregation(
	entity= com.cee.associado.entity.config.ContribuicaoConfigEntity.class
)

@PlcConfigForm (
	formPattern=FormPattern.Apl,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/config/contribuicao")
)

/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("contribuicaoconfig")
@PlcHandleException
public class ContribuicaoConfigMB extends AppMB  {

	private static final long serialVersionUID = 1L;
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("contribuicaoconfig")
	public ContribuicaoConfigEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new ContribuicaoConfigEntity();
              this.newEntity();
        }
        
        return (ContribuicaoConfigEntity)this.entityPlc;     	
	}
		
}
