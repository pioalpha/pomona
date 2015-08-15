package com.github.pomona.domain.model;

import com.github.common.domain.model.AbstractId;

public class TipoMedidaId extends AbstractId {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9007766264852321159L;

	public TipoMedidaId() {
		super();
	}

	public TipoMedidaId(String umId) {
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
