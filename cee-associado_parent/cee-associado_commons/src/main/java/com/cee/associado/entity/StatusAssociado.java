package com.cee.associado.entity;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum StatusAssociado {
    
	A("{statusAssociado.A}"),
	E("{statusAssociado.E}"),
	C("{statusAssociado.C}");

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private StatusAssociado(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
