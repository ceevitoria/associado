package com.cee.associado.entity;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoOcorrencia {
    
	CO("{tipoOcorrencia.CO}"), // Contribuicao
	CN("{tipoOcorrencia.CN}"); // Cancelamento

    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private TipoOcorrencia(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
