package dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.eclipse.persistence.internal.jpa.EJBQueryImpl;

import model.Trade;

public class TradeDAO extends DAO {



	
	public List<Trade> findByCode(Trade tr)throws Exception {
		  //TypedQuery<Trade> q = em.createQuery("select t from Trade t  join t.stock s where s.code=:code",Trade.class );
		TypedQuery<Trade> q = em.createQuery("select t from Trade t  where t.id.code=:code",Trade.class );
		  
	//	  System.out.println("code:"+tr.getStock().getCode());
	    //   q.setParameter("code",tr.getStock().getCode()   );
		    q.setParameter("code",tr.getId() .getCode()   );
			
	       System.out.println("SQL " +  q.unwrap(EJBQueryImpl.class).getDatabaseQuery().getSQLString());
	       
	        List<Trade>m =q.getResultList();
	        return m;
  }
	
	public Trade findByCodeAndDateAndType(Trade tr)throws Exception {
		 Trade m  = em.find(Trade.class, tr.getId());
	        System.out.println("SQL " + m );  				
	        
	        if(m == null ){
	      //  	create(tr);
	        	return tr;
	       } 
	        
	        
	        
	        return m;   
}
	

	public List<Trade> findByCurrentWeek()throws Exception {
		
		int week =	 Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) ;
		int year=	 Calendar.getInstance().get(Calendar.YEAR) ;
	
		  TypedQuery<Trade> q = em.createQuery("SELECT t FROM Trade t where extract(WEEK from t.id.date)=:week and extract(YEAR from t.id.date)=:year",Trade.class );
		 
	        q.setParameter("week", week);
	        q.setParameter("year", year);
	        List<Trade>m =q.getResultList();
	        return m;
	}  
	   
	   
	
	public void create(Trade tr)throws Exception {
		  
		em.getTransaction().begin();
		//tr.setDate(new Date());
		em.persist(tr);
		em.getTransaction().commit();;
}
	public void update(Trade tr)throws Exception {
		 System.out.println("Start update " );  	
		em.getTransaction().begin();
	
		
		
	//	tr.setDate(new Date());
		em.merge(tr);
		em.getTransaction().commit();
		 System.out.println("Done update " );  	
	}
		
	
}
