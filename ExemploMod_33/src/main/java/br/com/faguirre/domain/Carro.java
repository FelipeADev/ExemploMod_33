package br.com.faguirre.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * 
 */
@Entity
@Table(name = "tb_carro")
public class Carro {

	@Id
	@GeneratedValue(Strategy=GenerationType.SEQUENCE, generator="carro_seq")
	@SequenceGenerator(name="carro_seq", sequenceName="sq_carro", initiaValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "codigo", length = 10, nullable = false, unique = true)
	private String codigo;
	
	@Column(name = "valor", lenght = 10, nullable = false)
	private Integer valor;
	
	@Column(name = "ano_carro")
	private Instant anoCarro;
	
	@Column(name = "nome", lenght = 50, nullable = false)
	private String nome;
	
	
	@OneToOne(mappedBy = "carro")
	private Marca marca;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "tb_carro_acessorio", 
        joinColumns = { @JoinColumn(name = "carro") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_acessorio_fk") }
    )
	private List<Acessorio> acessorios;
	
	public Carro() {
		this.acessorios = new ArrayList<Acessorio>();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Instant getAnoCarro() {
		return anoCarro;
	}

	public void setAnoCarro(Instant anoCarro) {
		this.anoCarro = anoCarro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	public List<Acessorio> getAcessorios() {
		return acessorios;
	}


	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
	
	
}
