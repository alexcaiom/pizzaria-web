package br.com.waiso.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_endereco")
public class Endereco implements Serializable {
	private static final long serialVersionUID = -321500527926377810L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_endereco", unique=true)
	private Long id;
	
	@Column(name="logradouro", nullable=false)
	private String logradouro;
	
	@Column(name="numero", nullable=false)
	private String numero;
	
	@Column(name="complemento", nullable=true)
	private String complemento;
	
	@Column(name="bairro", nullable=false)
	private String bairro;
	
	@Column(name="cidade", nullable=false)
	private String cidade;
	
	@Column(name="uf", nullable=false)
	private String uf;
	
	@Column(name="cep", nullable=false)
	private Integer cep;
	
	@ManyToOne
	@JoinColumn(name="id_pessoa", nullable=false)
	private Pessoa pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep)	{
		this.cep = cep;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}