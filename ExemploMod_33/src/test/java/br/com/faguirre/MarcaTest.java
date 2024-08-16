package br.com.faguirre;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import java.time.Instant;

import br.com.faguirre.dao.CarroDao;
import br.com.faguirre.dao.ICarroDao;
import br.com.faguirre.dao.IMarcaDao;
import br.com.faguirre.dao.MarcaDao;
import br.com.faguirre.domain.Acessorio;
import br.com.faguirre.domain.Carro;
import br.com.faguirre.domain.Marca;

public class MarcaTest {
	
	private IMarcaDao marcaDao;
	
	private ICarroDao carroDao;
	
	public MarcaTest() {
		marcaDao = new MarcaDao();
		carroDao = new CarroDao();
	}
	
	@Test
	public void cadastrar() {
		Marca marca = criarMarca("A1");
		Carro car = criarCarro("A2");
		
		
		Marca marc = new Marca();
		
		marc.setNome("test");
		marc.setCodigo("A1");
		marc.setCarro(car);
		
		marcaDao.cadastrar(marc);
		
		assertNotNull(marc);
		assertNotNull(marc.getId());
	}
	
	private Acessorio criarAcessorio (String Codigo) {
		Acessorio aces = new Acessorio();
		aces.setCodigo(Codigo);
		
		return aces;
	}
	
	private Carro criarCarro (String codigo) {
		Acessorio aces = criarAcessorio("A1");
		Acessorio aces2 = criarAcessorio("A2"); 
		
		Carro carro = new Carro();
		
		carro.setCodigo(codigo);
		carro.setNome("XT");
		
		carro.add(aces);
		carro.add(aces2);
		
		return carroDao.cadastrar(carro);
	}
	
	private Marca criarMarca (String Codigo) {
		Marca marc = new Marca();
		
		marc.setCodigo(Codigo);
		marc.setNome("TX");
		
		return marcaDao.cadastrar(marc);
	}
	

}
