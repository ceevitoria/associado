/* ************************* META-DADOS GLOBAIS DA APLICAÇÃO ******************************
  ********************** Configurações padrão para toda a aplicação *************************
  ************ Obs: configurações corporativas devem estar no nível anterior,****************
  ************              preferencialmente na camada Bridge               ****************
  *******************************************************************************************/

@PlcConfigApplication(
	definition=@PlcConfigApplicationDefinition(name="Controle dos Associados",acronym="Associados",version=1,release=0),
	classesDiscreteDomain={
		com.powerlogic.jcompany.domain.type.PlcYesNo.class,
		com.cee.associado.entity.Sexo.class,
		com.cee.associado.entity.TipoOcorrencia.class,
		com.cee.associado.entity.StatusAssociado.class,
		com.cee.associado.entity.TipoContribuicao.class,
		com.cee.associado.entity.config.TipoMensagemSucessoConfig.class},
	classesLookup={
		com.cee.associado.entity.UfEntity.class,
		com.cee.associado.entity.CidadeEntity.class,
		com.cee.associado.entity.FormaPagto.class}
)

package com.powerlogic.jcompany.config.app;

import com.powerlogic.jcompany.config.application.PlcConfigApplication;
import com.powerlogic.jcompany.config.application.PlcConfigApplicationDefinition;
