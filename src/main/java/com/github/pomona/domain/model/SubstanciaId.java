package com.github.pomona.domain.model;

import com.github.common.domain.model.AbstractId;

public class SubstanciaId extends AbstractId {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6979786615543695737L;

	public SubstanciaId() {
		super();
	}

	public SubstanciaId(String umId) {
		super(umId);
	}

	@Override
	protected int hashValorImpar() {
		// TODO Auto-generated method stub
		return 57853;
	}

	@Override
	protected int hashValorPrimo() {
		// TODO Auto-generated method stub
		return 31;
	}
}
