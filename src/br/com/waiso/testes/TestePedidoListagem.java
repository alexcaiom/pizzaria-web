package br.com.waiso.testes;

import java.util.List;

import org.junit.Test;

import br.com.waiso.bo.PedidoBO;
import br.com.waiso.dao.Classe;
import br.com.waiso.entidades.Pedido;

public class TestePedidoListagem extends Classe {

	@Test
	public void test() {
//		fail("Not yet implemented");
		listar();
	}

	private void listar() {
		PedidoBO pedidoBO = new PedidoBO();
		List<Pedido> pedidos = pedidoBO.listar();
		if (existe(pedidos)) {
			for (Pedido pedido : pedidos) {
				System.out.println(pedido.getDescricao());
			}
		}
	}

}
