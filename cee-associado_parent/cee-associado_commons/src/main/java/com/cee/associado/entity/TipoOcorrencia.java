package com.cee.associado.entity;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoOcorrencia {
    
	CD("{tipoOcorrencia.CD}"),
	CO("{tipoOcorrencia.CO}"),
	CN("{tipoOcorrencia.CN}");

	
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
