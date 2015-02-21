package br.com.waiso.testes;

import java.math.BigInteger;

import org.junit.Test;

import br.com.waiso.bo.PedidoBO;
import br.com.waiso.bo.PessoaBO;
import br.com.waiso.bo.ProdutoBO;
import br.com.waiso.dao.Classe;
import br.com.waiso.entidades.Pedido;
import br.com.waiso.entidades.Pessoa;
import br.com.waiso.entidades.Produto;
import br.com.waiso.entidades.enums.TipoPedido;

public class TestePedidoInsercao extends Classe {

	@Test
	public void test() {
//		fail("Not yet implemented");
		inserirPedido();
	}
	
	public static void main(String[] args) {
		new TestePedidoInsercao().inserirPedido();
	}

	private void inserirPedido() {
		Pedido pedido = new Pedido();
		PedidoBO pedidoBO = new PedidoBO();
		
		pedido.setDescricao("Pizza de Mussarela com Peperoni");
		ProdutoBO produtoBO = new ProdutoBO();
		PessoaBO pessoaBO = new PessoaBO();
		
		Pessoa cliente = pessoaBO.pesquisarPessoaPorNomeEIdentificacao("Fabiano", 11111111111l);
		Pessoa pizzaria = pessoaBO.pesquisarPessoaPorNomeEIdentificacao("La Gondola", 11111111000102l);
		Produto produto1 = produtoBO.pesquisarPorNome("Pizza de Peperoni", pizzaria);
		Produto produto2 = produtoBO.pesquisarPorNome("Pizza de Atum", pizzaria);
		Produto produto3 = produtoBO.pesquisarPorNome("Pizza de Mussarela", pizzaria);
		pedido.setQuantidade(new BigInteger("1"));
		pedido.setTipoPedido(TipoPedido.ENTREGAR);
		pedido.setCliente(cliente);
		pedido.setFornecedor(pizzaria);
		
		pedido = pedidoBO.inserirPedido(pedido);
		
		pedido.getItens().add(produto1);
		pedido.getItens().add(produto2);
		pedido.getItens().add(produto3);
		pedidoBO.atualizarPedido(pedido);
	}

}
