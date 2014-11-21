/* Jaguar-jCompany Developer Suite. Powerlogic 2010-2014. Please read licensing information or contact Powerlogic 
 * for more information or contribute with this project: suporte@powerlogic.com.br - www.powerlogic.com.br        */ 
package com.cee.associado.commons;

import com.powerlogic.jcompany.commons.PlcConstants;

/**
 * Implementar aqui constantes específicas da Aplicação
 * 
 */
public interface AppConstants extends PlcConstants {
    
    interface ACAO {
    	String EXIBE_BT_ABRIR_CUSTOMIZADO = "exibeBtnAbrirCustomizado";
    	String EXIBE_BT_LIMPAR = "exibeBtnLimpar";
    	String EXIBE_BT_NOVO = "exibeBtnNovo";
    	String EXIBE_BT_REGISTRAR_CONTRIBUICAO = "exibeBtnRegistrarContribuicao";
    }

    String URL_BT_ABRIR_CUSTOMIZADO = "urlBtnAbrirCustomizado";
    
}
