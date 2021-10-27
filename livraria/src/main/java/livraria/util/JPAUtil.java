package livraria.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");

	public EntityManager getManager() {
		return factory.createEntityManager();
	}
	
	
	

}
