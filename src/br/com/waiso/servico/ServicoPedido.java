package br.com.waiso.servico;

import java.util.List;

import br.com.waiso.bo.PedidoBO;
import br.com.waiso.entidades.Pedido;

public class ServicoPedido {
	
	public Object incluir(Pedido pedido) {
		PedidoBO pedidoBO = new PedidoBO();
		return pedidoBO.inserirPedido(pedido);
	}

	public List<Pedido> getTodosOsPedidos(){
		PedidoBO bo = new PedidoBO();
		return bo.listar();
	}

	public Pedido getUltimoPedidoDoCliente(String imei) {
		PedidoBO pedidoBO = new PedidoBO();
		Pedido pedido = pedidoBO.pesquisarUltimoPedidoDoCliente(imei);
		return pedido;
	}
	
}
