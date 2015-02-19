package br.com.waiso.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;

import br.com.waiso.entidades.enums.Perfil;

@Entity
@Table(name="tbl_pessoa")
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = -3536629699833055554L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pessoa", unique=true)
	private Long id;
	
	@Column(name="email", unique=true)
	private String email;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="celular")
	private String celular;

	@Enumerated
	@Column(name="perfil")
	private Perfil perfil;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE, mappedBy="id")
	@Fetch(org.hibernate.annotations.FetchMode.SELECT)
	private Collection<Endereco> enderecos = new ArrayList<Endereco>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE, mappedBy="id")
	@Fetch(org.hibernate.annotations.FetchMode.SELECT)
	private Collection<Produto> produtos = new ArrayList<Produto>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@IndexColumn(name = "fk_pessoa_pedido")
	@JoinTable(name="tbl_pessoa_pedido", joinColumns={@JoinColumn(name="id_pessoa")}, inverseJoinColumns={@JoinColumn(name="id_pedido")})
	private Collection<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Collection<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Collection<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Collection<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}

	public Collection<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Collection<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
