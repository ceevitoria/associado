package com.cee.associado.entity.config;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoMensagemSucessoConfig {
    
	B("{tipoMensagemSucessoConfig.B}"), // Básico
	V("{tipoMensagemSucessoConfig.V}"), // Contendo Valor
	D("{tipoMensagemSucessoConfig.D}"); // Detalhada

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private TipoMensagemSucessoConfig(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
