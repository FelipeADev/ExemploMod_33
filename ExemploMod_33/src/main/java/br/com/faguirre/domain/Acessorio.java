/**
 * 
 */
package br.com.faguirre.domain;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.ManyToMany;

/**
 * 
 */
@Entity
@Table(name = "tb_acessorio")
public class Acessorio {
	
	@Id
	@GeneratedValue(Strategy=GenerationType.SEQUENCE, generator="carro_seq")
	@SequenceGenerator(name="carro_seq", sequenceName="sq_carro", initiaValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "nome", lenght = 50, nullable = false, unique = true)
	private String nome;
	
	@Column(name = "codigo", length = 10, nullable = false, unique = true)
	private String codigo;
	
	@ManyToMany(mappedBy = "acessorios")
	private List<Carro> carros;

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

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	
	

}
