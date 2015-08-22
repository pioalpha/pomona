package com.github.common.service.query;

public abstract class ParametrosPesquisa {
	private Integer numeroResultadosPorPagina;
	private int numeroDaPagina;

	public ParametrosPesquisa() {
		super();
		
		this.numeroResultadosPorPagina = null;
		this.numeroDaPagina = 1;
	}

	public ParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina) {
		super();
		
		this.numeroResultadosPorPagina = numeroResultadosPorPagina;
		this.numeroDaPagina = numeroDaPagina;
	}
	
	public Integer getNumeroResultadosPorPagina() {
		return numeroResultadosPorPagina;
	}

	public int getNumeroDaPagina() {
		return numeroDaPagina;
	}
}
