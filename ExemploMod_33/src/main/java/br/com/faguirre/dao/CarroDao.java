/**
 * 
 */
package br.com.faguirre.dao;

import br.com.faguirre.domain.Carro;

/**
 * 
 */
public class CarroDao implements ICarroDao {

	@Override
	public Carro cadastrar(Carro car) {

		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(car);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		
		return car;
	}

}
