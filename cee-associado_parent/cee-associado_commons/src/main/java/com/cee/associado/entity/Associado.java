package com.cee.associado.entity;

import java.math.BigDecimal;
import java.util.Date;

public abstract class Associado extends AppBaseEntity {
//	private Pessoa pessoa;
	private Date data;
	private BigDecimal valor;
	private StatusAssociado status;
	private TipoContribuicao tipo;
}

