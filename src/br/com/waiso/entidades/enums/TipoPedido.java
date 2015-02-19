package br.com.waiso.entidades.enums;

public enum TipoPedido {
	
	LEVAR(1), ENTREGAR(2);
	
	private final Integer pedido;
	
	private TipoPedido(Integer pedido) {
		this.pedido = pedido;
	}

	public Integer getPedido() {
		return pedido;
	}

}
