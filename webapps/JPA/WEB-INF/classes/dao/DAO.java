package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO implements AutoCloseable {
	 public  EntityManager em ;
	DAO(){
		EntityManagerFactory factory = EntityProvider.getInstance().getEntityManagerFactory();
		em = factory.createEntityManager();	

	}
	@Override
	public void close() throws Exception {
		System.out.println("Close again");
		if(em.isOpen())	em.close();
		
	}

}
