package com.cee.associado.model;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.cee.associado.entity.Associado;
import com.cee.associado.entity.AssociadoEntity;
import com.cee.associado.entity.Ocorrencia;
import com.cee.associado.entity.OcorrenciaEntity;
import com.cee.associado.entity.StatusAssociado;
import com.cee.associado.entity.TipoContribuicao;
import com.cee.associado.entity.TipoOcorrencia;
import com.cee.associado.entity.apoio.RegistroContribuicao;
import com.cee.associado.entity.config.ContribuicaoConfig;
import com.cee.associado.entity.config.ContribuicaoConfigEntity;
import com.cee.associado.entity.config.RetornoRegistro;
import com.cee.associado.entity.config.TipoMensagemSucessoConfig;
import com.cee.associado.persistence.jpa.associado.AssociadoDAO;
import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.PlcException;
import com.powerlogic.jcompany.domain.type.PlcYesNo;

public class ContribuicaoRepository {
	
	@Inject
	private AssociadoDAO jpa;

	@Inject
	protected transient Logger log;

	private ContribuicaoConfig config;
	private List<String> alertas = new ArrayList<String>();
	private List<String> mensagens = new ArrayList<String>();
	
	private PlcBaseContextVO context;
	
	/** 
	 * Registra a contribuição de um ou mais associado
	 * @param entityList
	 * @throws PlcException
	 */
	public RetornoRegistro registrarContribuicao(PlcBaseContextVO context, List entityList) throws PlcException {
		this.context = context;
		Date dataContribuicao = new Date();
		double valor = 0.0;

		mensagens.clear();
		alertas.clear();
		
		try {
			carregaConfiguracao(context);
			valor = registraContribuicao(entityList, dataContribuicao);
		} catch (PlcException plcE) {
			throw plcE;
		} catch (Exception e) {
			throw new PlcException("ContribuicaoRepository", "registrarContribuicao", e, log, e.getMessage());
		}
		
		return new RetornoRegistro(BigDecimal.valueOf(valor), config, alertas, mensagens);
	}

	/**
	 * @param context
	 */
	private void carregaConfiguracao(PlcBaseContextVO context) throws PlcException {
		List listaConfig = (List)jpa.findAll(context, ContribuicaoConfigEntity.class, null);
		
		if (listaConfig == null || listaConfig.size() != 1) {
			throw new PlcException("{erro.RegistroContribuicao.configuracao.inexistente}");
		}
		
		config = (ContribuicaoConfig)listaConfig.get(0);
	}

	/**
	 * Configura como as mensagens serão apresentadas para o usuário
	 * @param listaObs
	 * @param valor
	 * @param quantidade
	 */
	private void configuraMensagens(List<String> listaObs, double valor, int quantidade) {
		if (valor == 0.0 || quantidade == 0) {
			alertas.add(String.format("Nenhuma contribuição registrada!"));
		} else {
			
			if (config.getExibirMensagemSucesso().equals(PlcYesNo.S) ) {
				
				if (config.getTipoMensagemSucesso() .equals(TipoMensagemSucessoConfig.B) ) {
					mensagens.add("Registro realizado com sucesso!");
				} else if (config.getTipoMensagemSucesso() .equals(TipoMensagemSucessoConfig.V) ){
					mensagens.add(String.format("Registro de %02d contribuicoes no valor total de R$ %,.02f realizado com sucesso!", new Object[]{quantidade, valor}));
				} else if (config.getTipoMensagemSucesso() .equals(TipoMensagemSucessoConfig.D) ){
					mensagens.add(String.format("Registro de %02d contribuicoes no valor total de R$ %,.02f realizado com sucesso!", new Object[]{quantidade, valor}));
					mensagens.addAll(listaObs);
				}
			}
		}
		
	}

	/**
	 * @param relacaoContribuicao
	 * @return
	 */
	private List<String> montaObservacao(List relacaoContribuicao) {
		List<String> listaObs = new ArrayList<String>();

		for (Object o : relacaoContribuicao) {
			RegistroContribuicao cl = (RegistroContribuicao)o;

			if (cl.getPessoa() != null && cl.getPessoa().getId() != null) {
				StringBuilder obs = new StringBuilder();
				obs.append("Pessoa: '");
				obs.append(cl.getPessoa().getNome());
				obs.append("' - Data: '");
				obs.append(DateFormat.getInstance().format(cl.getData()));
				obs.append("' - Valor: '");
				obs.append(String.format("R$ %,.02f", cl.getValor()));
				obs.append("' - De: '");
				obs.append(DateFormat.getInstance().format(cl.getPagoDe()));
				obs.append("' - Até: '");
				obs.append(DateFormat.getInstance().format(cl.getPagoDe()));
				obs.append("' - Forma Pagto: '");
				obs.append(cl.getFormaPagto().getNome());
				obs.append("'");

				listaObs.add(obs.toString());
			}
		}
		
		return listaObs;
	}

	/**
	 * Registra as contribuicoes para os itens da relação
	 * @param relacaoContribuicao Relação das contribuicoes a serem registradas
	 * @param dataContribuicao Data da contribuição, só será utilizada se a data informada pelo usuário não tiver sido informada.
	 * @return valorGeral A soma de todas as contribuições 
	 */
	private double registraContribuicao(@SuppressWarnings("rawtypes") List relacaoContribuicao, Date dataContribuicao) throws PlcException {
		double valorGeral = 0.0;
		int quantidade = 0;
		Associado associado = null;
		
		for (Object o : relacaoContribuicao) {
			RegistroContribuicao rc = (RegistroContribuicao)o;
			
			// Evita os itens em branco
			if (rc.getPessoa() != null && rc.getPessoa().getId() != null) {
				double valor = rc.getValor().doubleValue();
				
				List assocList = jpa.findByFields(context, AssociadoEntity.class, "obterAssociadoPorIdPessoa", new String[] {"idPessoa"}, new Object[] {rc.getPessoa().getId()});
				
				// Verifica se deve Cadastrar um novo associado
				if (assocList == null || assocList.size() == 0) {
					associado = new AssociadoEntity();
					associado.setPessoa(rc.getPessoa());
					associado.setData(dataContribuicao);
					associado.setValor(rc.getValor());
					associado.setTipo(TipoContribuicao.ME);
					associado.setStatus(StatusAssociado.A);
					associado.setSitHistoricoPlc("A");
					Long id = jpa.insert(context, associado);
					associado.setId(id);
					jpa.sendFlush(context);
				} else  {
					associado = (Associado)assocList.get(0);
				}
				
				// Utiliza a data atual caso não tenha sido informada
				rc.setData(rc.getData() != null ? rc.getData() : dataContribuicao);
				
				Ocorrencia ocorrencia = new OcorrenciaEntity();
				
				ocorrencia.setAssociado(associado);
				ocorrencia.setTipo(TipoOcorrencia.CO);
				ocorrencia.setData(rc.getData());
				ocorrencia.setValor(rc.getValor());
				ocorrencia.setPagoDe(rc.getPagoDe());
				ocorrencia.setPagoAte(rc.getPagoAte());
				ocorrencia.setFormaPagto(rc.getFormaPagto());
				ocorrencia.setDescricao(rc.getDescricao());
				
				ocorrencia.setDataUltAlteracao(dataContribuicao);
				ocorrencia.setUsuarioUltAlteracao(context.getUserProfile().getLogin());
				
				jpa.insert(context, ocorrencia);
				
				valorGeral += valor;
				quantidade++;
			}
		}

		valorGeral = Math.round(valorGeral * 100.00) / 100.00;
		
		List<String> listaObs = montaObservacao(relacaoContribuicao);
		configuraMensagens(listaObs, valorGeral, quantidade);			
		
		return valorGeral;
	}
	
}
