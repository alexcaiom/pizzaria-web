package br.com.waiso.bo;

import java.util.List;

import br.com.waiso.dao.PedidoDAO;
import br.com.waiso.dao.finder.FinderPedido;
import br.com.waiso.entidades.Pedido;

public class PedidoBO {
	
	private PedidoDAO pedidoDAO = new PedidoDAO();
	private FinderPedido pedidoFinder = new FinderPedido();
	
	public Pedido inserirPedido(Pedido pedido) {
		return getPedidoDAO().inserir(pedido);
	}
	
	public void atualizarPedido(Pedido pedido) {
		getPedidoDAO().atualizar(pedido);
	}
	
	public Pedido pesquisarUltimoPedidoDoCliente(String imei) {
		return getPedidoFinder().pesquisarUltimoPedidoDoCliente(imei);
	}
	
	public List<Pedido> listar() {
		return getPedidoFinder().listar();
	}
	
	public PedidoDAO getPedidoDAO() {
		return pedidoDAO;
	}

	public void setPedidoDAO(PedidoDAO pedidoDAO) {
		this.pedidoDAO = pedidoDAO;
	}

	public FinderPedido getPedidoFinder() {
		return pedidoFinder;
	}

	public void setPedidoFinder(FinderPedido pedidoFinder) {
		this.pedidoFinder = pedidoFinder;
	}

}
