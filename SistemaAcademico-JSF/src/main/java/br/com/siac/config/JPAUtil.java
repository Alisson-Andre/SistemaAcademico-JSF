package br.com.siac.config;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaAcademico");
	
	@Produces
	@RequestScoped
	public EntityManager criarEntityManager() {
		return emf.createEntityManager();
	}
	
	public void fecharEntityManager(@Disposes EntityManager em) {
		if (em != null && em.isOpen()) {
			em.close();
		}
	}
}
