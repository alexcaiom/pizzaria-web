package br.com.waiso.dao.finder;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.waiso.dao.Finder;
import br.com.waiso.entidades.Pessoa;

public class FinderPessoa extends Finder<Pessoa> {

	public FinderPessoa() {
		super(Pessoa.class);
	}

	public Pessoa pesquisarPessoaPorNomeEIdentificacao(String nome, Long identificacao) {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Pessoa> c = cb.createQuery(Pessoa.class);
		Root<Pessoa> pessoa = c.from(Pessoa.class);
		c.select(pessoa);
		List<Predicate> filtros = new ArrayList<Predicate>();
		
		if (existe(nome)) {
			ParameterExpression<String> p = cb.parameter(String.class, "nome");
			filtros.add(cb.equal(pessoa.<String>get("nome"), p));
		}
		
		if (existe(identificacao)) {
			ParameterExpression<Long> p = cb.parameter(Long.class, "identificacao");
			filtros.add(cb.equal(pessoa.<Long>get("identificacao"), p));
		}
		
		if (filtros.isEmpty()) {
			throw new RuntimeException("sem filtros");
		} else if (filtros.size() == 1) {
			c.where(filtros.get(0));
		} else {
			c.where(cb.and(filtros.toArray(new Predicate[0])));
		}
		
		TypedQuery<Pessoa> q = getEm().createQuery(c);
		
		if (existe(nome)) {
			q.setParameter("nome", nome);
		}

		if (existe(identificacao)) {
			q.setParameter("identificacao", identificacao);
		}
		return q.getSingleResult();
	}

	
	
}
