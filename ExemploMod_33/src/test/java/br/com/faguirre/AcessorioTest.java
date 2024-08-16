/**
 * 
 */
package br.com.faguirre;

import java.time.Instant;

import br.com.faguirre.dao.AcessorioDao;
import br.com.faguirre.dao.CarroDao;
import br.com.faguirre.dao.IAcessorioDAO;
import br.com.faguirre.domain.Acessorio;
import br.com.faguirre.domain.Carro;

/**
 * 
 */
public class AcessorioTest {
	
	private IAcessorioDAO acessorioDao;
	
	public AcessorioTest() {
		acessorioDao = new AcessorioDao();
	}
	
	public void acessorioTest() {
		
		Acessorio acessorio = new Acessorio();
		acessorio.setNome("XT");
		acessorio.setCodigo("A1");
		
		acessorioDao.cadastrar(acessorio);
		
		asssertNotNull(acessorio);
		assestNotNull(acessorio.getId());
	}

}
