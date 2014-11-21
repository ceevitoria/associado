package com.cee.associado.controller.jsf.registrarContribuicao;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.cee.associado.commons.AppConstants;
import com.cee.associado.controller.jsf.AppMB;
import com.cee.associado.entity.apoio.RegistroContribuicao;
import com.cee.associado.entity.config.ContribuicaoConfig;
import com.cee.associado.entity.config.RetornoRegistro;
import com.cee.associado.facade.IAppFacade;
import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.PlcConstants;
import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.config.collaboration.PlcConfigTabular;
import com.powerlogic.jcompany.controller.jsf.PlcEntityList;
import com.powerlogic.jcompany.controller.jsf.action.util.PlcConversationControl;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.controller.jsf.util.PlcCreateContextUtil;
import com.powerlogic.jcompany.controller.util.PlcIocControllerFacadeUtil;
import com.powerlogic.jcompany.domain.type.PlcYesNo;
import com.powerlogic.jcompany.domain.validation.PlcMessage;
	
@PlcConfigAggregation(entity = com.cee.associado.entity.apoio.RegistroContribuicao.class)

@PlcConfigForm(
	formPattern=FormPattern.Tab,
	tabular = @PlcConfigTabular(numNew = 4), 
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/registrocontribuicao")
)

/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("registrarcontribuicao")	
@PlcHandleException
public class RegistrarContribuicaoMB extends AppMB  {

	@Inject @QPlcDefault 
	protected PlcCreateContextUtil contextMontaUtil;

	@Inject @Named(PlcConstants.PlcJsfConstantes.PLC_CONTROLE_CONVERSACAO)
	protected PlcConversationControl plcControleConversacao;	

	@Inject @QPlcDefault 
	protected PlcIocControllerFacadeUtil iocControleFacadeUtil;

	private static final long serialVersionUID = 1L;

	private BigDecimal valorTotalGeral;

	@Produces @Named("valorTotalGeral")
	public BigDecimal getValorTotalGeral() {
		return valorTotalGeral;
	}

	public void setValorTotalGeral(BigDecimal valorTotalGeral) {
		this.valorTotalGeral = valorTotalGeral;
	}

	/**
	 * Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("contribuicaoLista") 
	public PlcEntityList createEntityListPlc() {
		criaNovaLista();
		return this.entityListPlc;
	}	

	public String search()  {
		novosItens();

		return baseSearchMB.getDefaultNavigationFlow(); 
	}

	private void novosItens() {
		List itens = new ArrayList<Object>();
		
		RegistroContribuicao rc = null;
		
		for (int i=0; i<4; i++) {
			rc = new RegistroContribuicao();
			itens.add(rc);
		}
		
		this.entityListPlc.setItensPlc(itens);
	}

	private void criaNovaLista() {
		if (this.entityListPlc==null) {
			this.entityListPlc = new PlcEntityList();
			this.newObjectList();
		}
	}
	
	public void handleButtonsAccordingFormPattern() {
		contextUtil.getRequest().setAttribute(PlcConstants.ACAO.EXIBE_BT_GRAVAR, PlcConstants.NAO_EXIBIR);
		contextUtil.getRequest().setAttribute(PlcConstants.ACAO.EXIBE_BT_EXCLUIR, PlcConstants.NAO_EXIBIR);
		contextUtil.getRequest().setAttribute(PlcConstants.ACAO.EXIBE_BT_INCLUIR, PlcConstants.EXIBIR);
		
		contextUtil.getRequest().setAttribute(AppConstants.ACAO.EXIBE_BT_LIMPAR, PlcConstants.EXIBIR);
		contextUtil.getRequest().setAttribute(AppConstants.ACAO.EXIBE_BT_NOVO, PlcConstants.EXIBIR);
		contextUtil.getRequest().setAttribute(AppConstants.ACAO.EXIBE_BT_REGISTRAR_CONTRIBUICAO, PlcConstants.EXIBIR);
	}
	
	public String limparContribuicaoAnterior()  {
		List itens = entityListPlc.getItensPlc();

		limpaItens(itens);
		this.setValorTotalGeral(null);
		
		return baseEditMB.getDefaultNavigationFlow(); 
	}

	/**
	 * 
	 */
	private void limpaItens(List itens) {

		for (Object o : itens) {
			RegistroContribuicao rc = (RegistroContribuicao)o;
			rc.setId(null);
			rc.setPessoa(null);
			rc.setData(null);
			rc.setValor(null);
			rc.setDescricao(null);
			rc.setIndExcPlc(null);
		}
		
		if (itens.size() > 4) {
			
			for(int i = itens.size()-1; i > 3; i--) {
				itens.remove(i);
			}
		}
	}

	private void limpaItensSemPessoa(List itens) {

		for (Object o : itens) {
			RegistroContribuicao rc = (RegistroContribuicao)o;
			
			if (rc.getPessoa() == null || rc.getPessoa().getNome() == null || "".compareTo(rc.getPessoa().getNome().trim()) == 0) {
				rc.setId(null);
				rc.setData(null);
				rc.setValor(null);
				rc.setDescricao(null);
				rc.setIndExcPlc(null);
			}
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String registrarContribuicao()  {
		PlcBaseContextVO context = contextMontaUtil.createContextParam(plcControleConversacao);
		
		List itens = entityListPlc.getItensPlc();

		RetornoRegistro ret = iocControleFacadeUtil.getFacade(IAppFacade.class).registrarContribuicao(context, itens);
		
		this.setValorTotalGeral(ret.getValor());
		
		if (ret.getAlertas().size() > 0) {
			
			for (String alerta : ret.getAlertas()) {
				msgUtil.msg(alerta, PlcMessage.Cor.msgAmareloPlc.name());
			}
		}
		
		if (ret.getMensagens().size() > 0) {
			
			for (String mensagem : ret.getMensagens()) {
				msgUtil.msg(mensagem, PlcMessage.Cor.msgAzulPlc.name());
			}
		}
		
		ContribuicaoConfig config = (ContribuicaoConfig)ret.getConfig();
		
		if (config.getAutoLimparTelaParaNovaContribuicao().equals(PlcYesNo.S)) {
			limpaItens(itens);
			this.setValorTotalGeral(null);
		}
		
		
		return baseEditMB.getDefaultNavigationFlow(); 
	}
	
}
