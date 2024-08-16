package br.com.faguirre.dao;

import br.com.faguirre.domain.Acessorio;

public class AcessorioDao implements IAcessorioDAO{

	@Override
	public Acessorio cadastrar(Acessorio acessorio) {

		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(acessorio);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		
		return acessorio;
	}

}
