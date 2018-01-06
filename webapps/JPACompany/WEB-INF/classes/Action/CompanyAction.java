package Action;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import factory.DAOFactoryStock;
import factory.SingleEntityManagerFactory;
import model.Company;
import model.CompanyPK;


public class CompanyAction  {

//	private CompanyPK companyPK = new CompanyPK() ;
	//private Company company=new Company();
	
	public ArrayList codes ;
	public List<String> year =Arrays.asList(new String[]{"2017","2016","2015","2014"} );
	//public String mycode;
	//public String myyear;
	
	//public double  sales;
	//public double ebit;
	//public double dividend;
	//public double npat;
	//public double equity;
	//public double asset;
	//public double debt;
	//public double cf;
	//public double cash;
	//public double category;
	
	//public String desc;
	
	public Company company= new Company();
	public CompanyPK companypk= new CompanyPK();


	public CompanyAction(){   
		System.out.println("ChartAction new :");  
	}
	
	public String saveAction(){
		
		
		System.out.println("GET saveAction  :");  
	//	System.out.println("GET saveAction mycode :"+mycode);  
	//	System.out.println("GET saveAction  myyear :"+myyear);  
	//	Company tr= new Company();
	//	tr.setId(new CompanyPK( mycode,myyear));
	      //  tr = d.findByCodeAndDateAndType(tr);
		System.out.println("GET saveAction 2 :"  +companypk.getCode()+":"+companypk.getYear());  
		System.out.println("GET saveAction 3 :"  +company.getSales()+":"+company.getEbit() );  
		
		try{
		System.out.println("GET saveAction 3 :");  
		 EntityManagerFactory emf  = SingleEntityManagerFactory.getInstance().getEntityManagerFactory();
		 System.out.println("GET saveAction 4 :");  
		 EntityManager em = emf.createEntityManager();
		 
		 System.out.println("GET saveAction 5 :");  
		 company.setId(companypk);
		 //em.merge(company);
		 em.persist(company);
		 System.out.println("GET saveAction 6 :");  
		 //System.out.println("GET saveAction  PK :"+companyPK);
		//System.out.println("GET saveAction  company :"+company);
		
		  
	//	em.merge(arg0)
        
// em.persist(arg0);
  //      TypedQuery<Mynote> q = em.createQuery("select m from Mynote m",Mynote.class );
        
    //    List<Mynote>m =q.getResultList();
  //      m.forEach( (Mynote z)->{
    //    	        	  System.out.println("Note: "+z.getNotes());
      //  }   );
        
          
      //  em.close();
		
        
        
        
		} catch (Exception e) {
			System.out.println("ERROR :"+e);  
		}

	 System.out.println("GET saveAction 6 :");  
		 
		
		return "success";
		
	}
	public String displayAction(){
		System.out.println(" displayAction  :");  
	try{
	    
		getAllStocks();
        
		} catch (Exception e) {
			System.out.println("ERROR :"+e);  
		}
	System.out.println(" displayAction done :");  
		return "success";
	}
	
	
	private void getAllStocks(){
		System.out.println("STRART getAllStocks:");
		try (DAOFactoryStock dao = new DAOFactoryStock()) {
			codes = dao.getAllList();
			System.out.println("STRART getAllStocks:" + codes.size());
		} catch (Exception e) {
			System.out.println("ChartAction chart :" + e);

		}
	}

			
	public Object getModel(){
		return null;
	}



  
}
