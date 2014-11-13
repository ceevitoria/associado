package com.cee.associado.entity;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoContribuicao {
    
	QZ("{tipoContribuicao.QZ}"),
	ME("{tipoContribuicao.ME}"),
	BM("{tipoContribuicao.BM}"),
	TM("{tipoContribuicao.TM}"),
	SM("{tipoContribuicao.SM}"),
	AN("{tipoContribuicao.AN}"),
	BA("{tipoContribuicao.BA}"),
	TA("{tipoContribuicao.TA}");

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private TipoContribuicao(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
