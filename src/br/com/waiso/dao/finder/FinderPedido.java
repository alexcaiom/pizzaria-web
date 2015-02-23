package br.com.waiso.dao.finder;

import java.util.List;

import javax.persistence.Query;

import br.com.waiso.dao.Finder;
import br.com.waiso.entidades.Pedido;
import br.com.waiso.entidades.enums.StatusPedido;

public class FinderPedido extends Finder<Pedido> {

	public FinderPedido() {
		super(Pedido.class);
	}

	public List<Pedido> listar() {
		return super.listar();
	}

	public Pedido pesquisarUltimoPedidoDoCliente(String imei) {
		String pesquisa = "select p "
							+" from    Pedido p "
							+" where   p.imei = :imei "
							+" and     p.status = :status "
							+" and     p.data = "
							+""
							+" (select max(p.data) "
							+" from    Pedido p "
							+" where   p.imei = :imei " 
							+" and     p.status = :status) ";
		StatusPedido status = StatusPedido.SALVO;
		Query query = getEm().createQuery(pesquisa);
		
		query.setParameter("imei", imei);
		query.setParameter("status", status);
		
		/*
		
			CriteriaBuilder cb = getEm().getCriteriaBuilder();
			CriteriaQuery<Pedido> c = cb.createQuery(Pedido.class);
			Root<Pedido> pedido = c.from(Pedido.class);
			c.select(pedido);
			List<Predicate> filtros = new ArrayList<Predicate>();
			
			if (existe(imei)) {
				ParameterExpression<String> parametroImei = cb.parameter(String.class, "imei");
				filtros.add(cb.equal(pedido.<String>get("imei"), parametroImei));
			}
			
			c.select(cb.max(pedido.get("data")));
			
			if (filtros.isEmpty()) {
				throw new RuntimeException("sem filtros");
			} else if (filtros.size() == 1) {
				c.where(filtros.get(0));
			} else {
				c.where(cb.and(filtros.toArray(new Predicate[0])));
			}
			
			TypedQuery<Pedido> q = getEm().createQuery(c);
			
			if (existe(imei)) {
				q.setParameter("imei", imei);
			}*/

			return (Pedido) query.getSingleResult();
	}

}
