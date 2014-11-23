package com.cee.associado.entity;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoContribuicao {
    
	QZ("{tipoContribuicao.QZ}"),  // Quinzenal
	ME("{tipoContribuicao.ME}"),  // Mensal
	BM("{tipoContribuicao.BM}"),  // Bimensal
	TM("{tipoContribuicao.TM}"),  // Trimestral
	SM("{tipoContribuicao.SM}"),  // Semenstral
	AN("{tipoContribuicao.AN}"),  // Anual
	BA("{tipoContribuicao.BA}"),  // Bianunal
	TA("{tipoContribuicao.TA}"),  // Trienal
	EV("{tipoContribuicao.EV}");  // Eventual

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
