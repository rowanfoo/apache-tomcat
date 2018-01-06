package dao;

import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityProvider {

    private static final String DB_PU = "JPA";

    public static final boolean DEBUG = true;

    private static final EntityProvider singleton = new EntityProvider();

    private EntityManagerFactory emf;

private EntityProvider() {}

public static EntityProvider getInstance() {
    return singleton;
}


public EntityManagerFactory getEntityManagerFactory() {
    if(emf == null) {
        emf = Persistence.createEntityManagerFactory(DB_PU);
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