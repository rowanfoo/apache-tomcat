package factory;


import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingleEntityManagerFactory {

    private static final String DB_PU = "JPACompany";

    public static final boolean DEBUG = true;

    private static final SingleEntityManagerFactory singleton = new SingleEntityManagerFactory();

    private EntityManagerFactory emf;

private SingleEntityManagerFactory() {}

public static SingleEntityManagerFactory getInstance() {
    return singleton;
}


public EntityManagerFactory getEntityManagerFactory() {
    if(emf == null) {
        emf =  Persistence.createEntityManagerFactory(DB_PU);
        
     
        
    }
    if(DEBUG) {
        System.out.println("factory created on: " + new Date());
    }
    return emf;
}

public void closeEmf() {
    if(emf.isOpen() || emf != null) {
        emf.close();
    }
    emf = null;
    if(DEBUG) {
        System.out.println("EMF closed at: " + new Date());
    }
}

}//end class