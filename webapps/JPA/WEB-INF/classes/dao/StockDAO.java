
package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import model.Stock;

public class StockDAO extends DAO {


	
	public List<Stock> findAllCode()throws Exception {
		  TypedQuery<Stock> q = em.createQuery("select s from Stock s ",Stock.class );
	        List<Stock>m =q.getResultList();
	        return m;
  }
	
	
	
}
