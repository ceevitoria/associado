package com.cee.associado.entity;

import java.math.BigDecimal;
import java.util.Date;

public abstract class Ocorrencia extends AppBaseEntity {
	private TipoOcorrencia tipo;
	private Date data;
	private BigDecimal valor;
	private String descricao;
}

