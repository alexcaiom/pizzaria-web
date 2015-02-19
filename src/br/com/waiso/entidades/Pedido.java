package br.com.waiso.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

import br.com.waiso.entidades.enums.TipoPedido;

@Entity
@Table(name="tbl_pedido")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = -6127880940510484616L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pedido", unique=true)
	private Long id;
	
	@Enumerated
	@Column(name="tipo_pedido")
	private TipoPedido tipoPedido;
	
	@Column(name="quantidade")
	private BigInteger quantidade;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="data_pedido")
	private Integer dataPedido;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="id")
	@Fetch(org.hibernate.annotations.FetchMode.SELECT)
	private Collection<Produto> produtos = new ArrayList<Produto>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoPedido getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(TipoPedido tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public BigInteger getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigInteger quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Integer dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Collection<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}
}