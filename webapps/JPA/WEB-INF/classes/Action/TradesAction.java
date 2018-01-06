package Action;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import dao.StockDAO;
import dao.TradeDAO;
import model.Stock;
import model.Trade;
import model.TradePK;
import util.ChartImage;
import util.FormatUtil;

public class TradesAction {

	private List<Stock> stocks;	
	private List<Trade> trades;	
	 private EntityManager em ;
	 
	 private String chart;
	private String learn;
	private String notes;
	private String type;
	private String code;
	private String date;
	private String image;
	private List<String> allImage; 
	private boolean week;
	 
	public String setResearch(){
		//have to determine whether this is new code or old one.
		// if old one go straight to chatwork
		//if new one then go and chartResearch , let user select new chart
		//Determine this by whether it got chart image....
		
		try(TradeDAO d = new TradeDAO()){
		    
			System.out.println("setResearch  :"+code);  
			System.out.println("setResearch  :"+date);  
			System.out.println("setResearch  :"+type);  
	        Trade tr= new Trade(new TradePK( code ,FormatUtil.convertStringToDate(date),type) );
	        tr = d.findByCodeAndDateAndType(tr);
	        image = tr.getChart();
	      //  System.out.println("image---:"+image);
	        if(image == null ){
	        	 System.out.println(" NULL image---:");
	        	allImage = ChartImage.chartImage(  FormatUtil.getPureCode ( code));
	        	return "success";
	        }
	        
	        
	        
		} catch (Exception e) {
			System.out.println("setResearch :"+e);  
		}
		  System.out.println("No :");
		
    	return "no";
	}
	
	// load first page , get data 
	public String notes(){
		setStockList();
		return "success";
	} 

	public String setChartImage(){
		//System.out.println("image---:"+image);
		System.out.println("updateTrade  :"+code);  
		System.out.println("updateTrade  :"+type);  
		return "success";
	} 
	
	public String updateTrade(){
		try(TradeDAO d = new TradeDAO()){
		    
			System.out.println("updateTrade  :"+code);  
			System.out.println("updateTrade  :"+type);  
			System.out.println("updateTrade  :"+notes);  
	        
			 Trade tr= new Trade(new TradePK( code ,new Date(),type) );
	       tr.setChart(image);
			tr.setNotes(notes); 
	        //System.out.println("image---:"+image);

	        d.update(tr);
	        
	        
	        
	        
	        
	        
		} catch (Exception e) {
			System.out.println("setResearch :"+e);  
		}
    	return "success";
	    
	} 
	
	
	public String findTrades(){
		try(TradeDAO d = new TradeDAO()){
		    
			System.out.println("updateTrade  :"+code);  
			System.out.println("updateTrade  :"+type);  
			System.out.println("updateTrade  :"+notes);  
			System.out.println("updateTrade  :isWeek "+week);  
			
			
			// list by code
			// list by week
			//list code,type,date
			
			if(week){
				System.out.println("week  :");  
				trades = d.findByCurrentWeek();
				allImage =new  ArrayList<>();
				trades.forEach(( Trade t)->{
					if(!t.getChart().isEmpty())
						allImage.add(t.getChart()  ) ;
					
					
				});
				
				  
				
				
			}else if(type.equals("-1")    ){// get by code
				System.out.println("type  :");  
				Trade tr= new Trade(new TradePK( code ,new Date(),null) );
				trades= d.findByCode( tr);
				allImage =new  ArrayList<>();
				trades.forEach(( Trade t)->{     
					allImage.add(t.getChart()  ) ;
				});
				
				
				 
			}else{//find individual object
				System.out.println("indiv  :");  
				 Trade tr= new Trade(new TradePK( code ,FormatUtil.convertStringToDate(date),type) );
			      tr = d.findByCodeAndDateAndType(tr);
			      trades =new  ArrayList<>();
			     
			      allImage =new  ArrayList<>();
			      
			      if(tr != null){
			    	  trades.add(tr);
			    	  allImage.add(tr.getChart()  );
			      }
				
				
			}
	        
		} catch (Exception e) {
			System.out.println("Err findTrades :"+e);  
		}
		System.out.println("findTrades :"+trades);  
		System.out.println("indiv  :");  
    	return "success";
	    
	} 
	
	
	
	private void setStockList(){
		try (StockDAO s = new StockDAO()) {
			stocks = s.findAllCode();
		} catch (Exception e) {
			System.out.println("Error getAllStock:"+e);
		}
	}

	
	
	public String findTrade(){
		setStockList();
		return "success";
	} 

	public List<Stock> getStocks() {
		return stocks;
	}




	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}




	public List<Trade> getTrades() {
		return trades;
	}




	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}




	public EntityManager getEm() {
		return em;
	}




	public void setEm(EntityManager em) {
		this.em = em;
	}




	public String getChart() {
		return chart;
	}




	public void setChart(String chart) {
		this.chart = chart;
	}




	public String getLearn() {
		return learn;
	}




	public void setLearn(String learn) {
		this.learn = learn;
	}




	public String getNotes() {
		return notes;
	}




	public void setNotes(String notes) {
		this.notes = notes;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public String getCode() {
		return code;
	}




	public void setCode(String code) {
		this.code = code;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getImage() {
		return image;
	}
	public List<String> getAllImage() {
		return allImage;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isWeek() {
		return week;
	}

	public void setWeek(boolean week) {
		this.week = week;
	}


			
			 
			




 
}
