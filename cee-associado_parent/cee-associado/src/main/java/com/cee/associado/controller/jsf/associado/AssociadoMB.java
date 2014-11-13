package com.cee.associado.controller.jsf.associado;

import javax.enterprise.inject.Produces;
import javax.inject.Named;


import com.cee.associado.entity.AssociadoEntity;
import com.cee.associado.controller.jsf.AppMB;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.config.collaboration.FormPattern;

import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm.ExclusionMode;



 
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;

@PlcConfigAggregation(
		entity = com.cee.associado.entity.AssociadoEntity.class
		
	)
	


@PlcConfigForm (
	
	formPattern=FormPattern.Man,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/associado")
	
	
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("associado")
@PlcHandleException
public class AssociadoMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("associado")
	public AssociadoEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new AssociadoEntity();
              this.newEntity();
        }
        return (AssociadoEntity)this.entityPlc;     	
	}
		
}
