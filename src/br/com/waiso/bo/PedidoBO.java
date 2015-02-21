package br.com.waiso.bo;

import br.com.waiso.dao.PedidoDAO;
import br.com.waiso.entidades.Pedido;

public class PedidoBO {
	
	private PedidoDAO pedidoDAO;
	
	public Pedido inserirPedido(Pedido pedido) {
		return getPedidoDAO().inserir(pedido);
	}
	
	public void atualizarPedido(Pedido pedido) {
		getPedidoDAO().atualizar(pedido);
	}
	
	public PedidoDAO getPedidoDAO() {
		return pedidoDAO;
	}

	public void setPedidoDAO(PedidoDAO pedidoDAO) {
		this.pedidoDAO = pedidoDAO;
	}

}
