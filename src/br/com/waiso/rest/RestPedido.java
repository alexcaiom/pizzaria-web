package br.com.waiso.rest;

import java.util.GregorianCalendar;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.waiso.entidades.Pedido;
import br.com.waiso.entidades.enums.StatusPedido;
import br.com.waiso.entidades.enums.TipoPedido;
import br.com.waiso.servico.ServicoPedido;
@Path("pedido/")
public class RestPedido {
	
//	@Path("pedido/cadastrar/{descricao}/{tipo}/{data}/{latitude}/{numero}/{complemento}/{nome}/{identificacao}/{telefone}/{celular}/{imei}")
	@Path("cadastrar/{descricao}/{tipo}/{latitude}/{longitude}/{numero}/{imei}")
//	@Path("cadastrar")
//	@POST
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object cadastrar(@PathParam("descricao") String descricao,
							@PathParam("tipo") String tipo,
//							@PathParam("data") String data,
							@PathParam("latitude") Double latitude,
							@PathParam("longitude") Double longitude,
							@PathParam("numero") Integer numero,
							/*@PathParam("complemento") String complemento,*/
//							@PathParam("nome") String nome,
							/*@PathParam("identificacao") Long identificacao,*/
//							@PathParam("telefone") String telefone,
//							@PathParam("celular") String celular,
							@PathParam("imei") String imei){
		Pedido pedido = new Pedido();
		pedido.setDescricao(descricao);
		pedido.setTipoPedido(TipoPedido.ENTREGAR);
		pedido.setData(GregorianCalendar.getInstance());
		pedido.setLatitude(latitude);
		pedido.setLongitude(longitude);
		pedido.setNumero(numero);
		pedido.setStatus(StatusPedido.SALVO);
//		pedido.setComplemento(complemento);
//		pedido.setNome(nome);
//		pedido.setIdentificacao(identificacao);
//		pedido.setTelefone(telefone);
//		pedido.setCelular(celular);
		pedido.setImei(imei);
		
		return new ServicoPedido().incluir(pedido);
	}

//	@Path("pedido/lista")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Object getTodosOsPedidos(){
//		return new ServicoPedido().getTodosOsPedidos();
//	}
	
	@Path("pesquisarUltimoDoCliente/{imei}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Pedido getUltimoPedidoDoCliente(@PathParam("imei") String imei){
		return new ServicoPedido().getUltimoPedidoDoCliente(imei);
	}
	
}
