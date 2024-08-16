package br.com.faguirre;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.Instant;

import org.junit.Test;

import br.com.faguirre.dao.CarroDao;
import br.com.faguirre.dao.ICarroDao;
import br.com.faguirre.domain.Carro;

public class CarroTest {
	
	private ICarroDao carroDao;
	
	public CarroTest() {
		carroDao = new CarroDao();
	}
	
	@Test
	public void CarroTest() {
		
		Carro car = new Carro();
		car.setCodigo("A");
		car.setValor(321);
		car.setAnoCarro(Instant.now());
		car.setNome("XT");
		
		carroDao.cadastrar(car);
		
		asssertNotNull(car);
		assestNotNull(car.getId());
	}

}
