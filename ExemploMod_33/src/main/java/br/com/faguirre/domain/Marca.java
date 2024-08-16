package br.com.faguirre.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;

/**
 * 
 */
@Entity
@Table(name = "tb_marca")
public class Marca {
	
	@Id
	@GeneratedValue(Strategy=GenerationType.SEQUENCE, generator="marca_seq")
	@SequenceGenerator(name="marca_seq", sequenceName="sq_marca", initiaValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "nome", lenght = 50, nullable = false, unique = true)
	private String nome;
	
	@Column(name = "codigo", length = 10, nullable = false, unique = true)
	private String codigo;
	
	@OneToOne
	@JoinColumn(name = "id_carro_fk", 
		foreignKey = @ForeignKey(name = "fk_carro_marca"), 
		referencedColumnName = "id", nullable = false
	)	
	private Carro carro;
	
	@ManyToOne
	@JoinColumn(name = "id_acessorio_fk", 
		foreignKey = @ForeignKey(name = "fk_acessorio_marca"), 
		referencedColumnName = "id", nullable = false
	)
	private Acessorio acessorio;
	
	@Entity
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	
}
