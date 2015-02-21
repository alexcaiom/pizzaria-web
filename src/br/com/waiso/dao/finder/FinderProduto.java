package br.com.waiso.dao.finder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Parameter;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.waiso.dao.Finder;
import br.com.waiso.entidades.Pessoa;
import br.com.waiso.entidades.Produto;

public class FinderProduto extends Finder<Produto> {

	public FinderProduto() {
		super(Produto.class);
	}
	
	public Produto pesquisarPorNome(String nome, Pessoa pessoa) {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Produto> c = cb.createQuery(Produto.class);
		Root<Produto> produto = c.from(Produto.class);
		Root<Pessoa> fromPessoa = c.from(Pessoa.class);
		
//		Join<Produto, Pessoa> produtoPessoa = produto.join(Produto_.cliente);
		c.select(produto);
		List<Predicate> filtros = new ArrayList<Predicate>();
		
		if (existe(nome)) {
			ParameterExpression<String> p = cb.parameter(String.class, "nome");
			filtros.add(cb.equal(produto.<String>get("nome"), p));
		}

		if (existe(pessoa) && existe(pessoa.getId())) {
			Predicate p = cb.equal(produto.get("pessoa").get("id"), fromPessoa.get("id"));
			filtros.add(p);
		}
		
		if (filtros.isEmpty()) {
			throw new RuntimeException("sem filtros");
		} else if (filtros.size() == 1) {
			c.where(filtros.get(0));
		} else {
			c.where(cb.and(filtros.toArray(new Predicate[0])));
		}
		
		TypedQuery<Produto> q = getEm().createQuery(c);
		
		if (existe(nome)) {
			q.setParameter("nome", nome);
		}

		if (existe(pessoa) && existe(pessoa.getId())) {
			Set<Parameter<?>> parameters = q.getParameters();
			for (Parameter<?> parameter : parameters) {
				System.out.println(parameter.getName());
			}
			q.setParameter("pessoa", pessoa.getId());
		}

		return q.getSingleResult();
	}

}
