
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import access.DataAccess;
import access.StockAccess;
import util.FormatUtil;


public class DataDAO extends DAO{
	
	

	
	public DataDAO( Connection mycon ){
		con=mycon;
		
	}
	 		
	
	
	public ArrayList <DataAccess>   getStockbyYear(String code, String year )throws Exception{
		ArrayList <DataAccess> arr = new ArrayList<DataAccess>();
		String mysql="SELECT * FROM fortune.data where code=? and Year(Date)=?; ";

		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, code);
		ps.setString(2, year);
		System.out.println("RSI for a 1" );
		ResultSet rs = ps.executeQuery();
		System.out.println("RSI for a 2" );
		
		
		
		
		while(rs.next()){
			
			 arr.add( new  DataAccess(rs.getDouble("open"), rs.getDouble("high"), rs.getDouble("low"), rs.getDouble("close"), rs.getString("closeVol") , rs.getDouble("volume"), rs.getDouble("changes"),
						rs.getDouble("changePercent"), rs.getString("previousClose") , rs.getDouble("avg3mth"), rs.getDouble("fifty"),rs.getDouble("fiftychg") ,
						rs.getDouble("twohundred"), rs.getDouble("twohundredchg"), rs.getString("code"), rs.getDate("date")));
		
		
		}
		System.out.println("RSI for a 3" );

		 ps.close();	
		 System.out.println("RSI for a "+arr.size() );
	return arr;
	
	
	}
	
	public DataAccess   get3monthHigh(String code)throws Exception{
		String mysql="SELECT min(close)as maxprice  FROM fortune.data where  code=? and month(date)= (MONTH(CURRENT_DATE())-3)  and year(date)=year(CURRENT_DATE())";

		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, code);
		//System.out.println("get3monthHigh for a 1" );
		ResultSet rs = ps.executeQuery();
		//System.out.println("get3monthHigh for a 2" );
		
		DataAccess dt = new  DataAccess();
		
		while(rs.next()){
			dt.setCode(code);
			dt.setClose(rs.getDouble("maxprice"));
		}
		//System.out.println("get3monthHigh for a 3" );

		 ps.close();	
		 return dt;
	}


		
	
	
	
	public ArrayList <DataAccess>   getStock(String code)throws Exception{
		 System.out.println("DataAccess getStock  start: ");
		ArrayList <DataAccess> arr = new ArrayList<DataAccess>();
		String mysql="SELECT * FROM fortune.data where code=?";
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, code);
		//System.out.println("DataAccess getStock: "+ps);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			/*
			System.out.println("DataAccess getStock date: "+ rs.getDate("date") );
			System.out.println("DataAccess getStock1 : "+rs.getDouble("open"));
			System.out.println("DataAccess getStock2:1 "+rs.getDouble("high"));
			System.out.println("DataAccess getStock3: "+rs.getDouble("low"));
			System.out.println("DataAccess getStock4: "+rs.getDouble("close"));
			System.out.println("DataAccess getStock5: "+rs.getDouble("volume"));
			System.out.println("DataAccess getStock6: "+rs.getDouble("changes"));
			System.out.println("DataAccess getStock7: "+rs.getDouble("changePercent"));
			System.out.println("DataAccess getStock8: "+rs.getDouble("avg3mth"));
			System.out.println("DataAccess getStock9: "+rs.getDouble("fifty"));
			System.out.println("DataAccess getStock10: "+rs.getDouble("fiftychg"));
			System.out.println("DataAccess getStock11: "+rs.getDouble("twohundred"));
			System.out.println("DataAccess getStock12: "+rs.getDouble("twohundredchg"));
	    	 	
	    	  
			System.out.println("DataAccess getStock 11 : "+ rs.getString("closeVol"));
			System.out.println("DataAccess getStock 12 : "+ rs.getString("previousClose"));
			System.out.println("DataAccess getStock 13 : "+ rs.getString("code"));
		//	System.out.println("DataAccess getStock 14 : "+ rs.getString("closeVol"));
		//	System.out.println("DataAccess getStock 15 : "+ rs.getString("closeVol"));
			*/
			 arr.add( new  DataAccess(rs.getDouble("open"), rs.getDouble("high"), rs.getDouble("low"), rs.getDouble("close"), rs.getString("closeVol") , rs.getDouble("volume"), rs.getDouble("changes"),
						rs.getDouble("changePercent"), rs.getString("previousClose") , rs.getDouble("avg3mth"), rs.getDouble("fifty"),rs.getDouble("fiftychg") ,
						rs.getDouble("twohundred"), rs.getDouble("twohundredchg"), rs.getString("code"), rs.getDate("date"),rs.getDouble("relativestrenght"),rs.getDouble("rsi"),rs.getDouble("rsivol")  ));
    	
			// System.out.println("DataAccess getStock OK !!!!!!!!!!!!: ");
		
			 
		}
		
		 System.out.println("DataAccess getStock OK !!!!!!!!!!!! DONE : ");
		 ps.close();	
	return arr;
	
	
	}
	
	
	
	

			/**
			 * Get latest data record.
			 * @param code
			 * @return
			 * @throws Exception
			 */
		public DataAccess   getLastData(String code)throws Exception{
				 System.out.println("DataAccess getLastData  start: ");
				
				String mysql="SELECT * FROM fortune.data where code=? order by date desc limit 1";
				
				PreparedStatement ps = con.prepareStatement(mysql);
				ps.setString(1, code);
				ResultSet rs = ps.executeQuery();
				DataAccess dt=null;
				while(rs.next()){
			
						dt = new  DataAccess(rs.getDouble("open"), rs.getDouble("high"), rs.getDouble("low"), rs.getDouble("close"), rs.getString("closeVol") , rs.getDouble("volume"), rs.getDouble("changes"),
								rs.getDouble("changePercent"), rs.getString("previousClose") , rs.getDouble("avg3mth"), rs.getDouble("fifty"),rs.getDouble("fiftychg") ,
								rs.getDouble("twohundred"), rs.getDouble("twohundredchg"), rs.getString("code"), rs.getDate("date"),rs.getDouble("relativestrenght"),rs.getDouble("rsi"),rs.getDouble("rsivol")  );
						dt.setTwenty(rs.getDouble("twenty") );	
						dt.setTwentychg(rs.getDouble("twentychg") );
						dt.setFourhundred(rs.getDouble("fourhundred") );
						dt.setFourhundredchg(rs.getDouble("fourhundredchg"));
						dt.setFourty(rs.getDouble("fourty"));
						dt.setFourtychg(rs.getDouble("fourtychg"));
						dt.setFourhundred(rs.getDouble("fourhundred"));
						dt.setFourhundredchg(rs.getDouble("fourhundredchg"));

						dt.setOnehundredfifty(rs.getDouble("onehundredfifty"));
						dt.setOnehundredfiftychg(rs.getDouble("onehundredfiftychg"));

				}
				
				 System.out.println("DataAccess getLastData OK !!!!!!!!!!!! DONE : ");
				 ps.close();	
			return dt;
			
			
			}
			
		public DataAccess   getDataDate(String code,String date)throws Exception{
			 System.out.println("DataAccess getDataDate  start: ");
			
			 System.out.println("DataAccess getDataDate  date : "+date);
			 
			String mysql="SELECT * FROM fortune.data where code=? and date=?";
			
			PreparedStatement ps = con.prepareStatement(mysql);
			ps.setString(1, code);
			ps.setString(2, date);
			// System.out.println("DataAccess getDataDate  start sql : "+ps);
			ResultSet rs = ps.executeQuery();
			DataAccess dt=null;
			while(rs.next()){
		
					dt = new  DataAccess(rs.getDouble("open"), rs.getDouble("high"), rs.getDouble("low"), rs.getDouble("close"), rs.getString("closeVol") , rs.getDouble("volume"), rs.getDouble("changes"),
							rs.getDouble("changePercent"), rs.getString("previousClose") , rs.getDouble("avg3mth"), rs.getDouble("fifty"),rs.getDouble("fiftychg") ,
							rs.getDouble("twohundred"), rs.getDouble("twohundredchg"), rs.getString("code"), rs.getDate("date"),rs.getDouble("relativestrenght"),rs.getDouble("rsi"),rs.getDouble("rsivol")  );
					dt.setTwenty(rs.getDouble("twenty") );	
					dt.setTwentychg(rs.getDouble("twentychg") );
					dt.setFourhundred(rs.getDouble("fourhundred") );
					dt.setFourhundredchg(rs.getDouble("fourhundredchg"));
					dt.setFourty(rs.getDouble("fourty"));
					dt.setFourtychg(rs.getDouble("fourtychg"));
					dt.setFourhundred(rs.getDouble("fourhundred"));
					dt.setFourhundredchg(rs.getDouble("fourhundredchg"));

					dt.setOnehundredfifty(rs.getDouble("onehundredfifty"));
					dt.setOnehundredfiftychg(rs.getDouble("onehundredfiftychg"));

			}
			
			// System.out.println("DataAccess getDataDate OK !!!!!!!!!!!! DONE : ");
			 ps.close();	
		return dt;
		
		
		}
	
	public HashMap<String,DataAccess>  getDataByCategory(String category,String date)throws Exception{
		HashMap <String,DataAccess> arr = new HashMap<String,DataAccess>();
		String mysql="SELECT * FROM fortune.data join stock on data.code=stock.code where stock.category=? and data.date=? ";
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, category);
		ps.setString(2, date);
		
		System.out.println("DataAccess getStock: "+ps);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			
		
	    	 	
	    	  
	      
		
			 arr.put( rs.getString("code"), new  DataAccess(rs.getDouble("open"), rs.getDouble("high"), rs.getDouble("low"), rs.getDouble("close"), rs.getString("closeVol") , rs.getDouble("volume"), rs.getDouble("changes"),
						rs.getDouble("changePercent"), rs.getString("previousClose") , rs.getDouble("avg3mth"), rs.getDouble("fifty"),rs.getDouble("fiftychg") ,
						rs.getDouble("twohundred"), rs.getDouble("twohundredchg"), rs.getString("code"), rs.getDate("date")));
    	
		
		
		}
		 ps.close();	
	return arr;
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	public StockAccess getStockCode(String code)throws Exception{
		ArrayList <StockAccess> arr = new ArrayList();
		String mysql="select * from stock where code=?";

			 
		System.out.println("111sql:"+mysql);
	
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, code);
		
		ResultSet rs = ps.executeQuery();
		StockAccess stock=null ;
		while(rs.next()){
			
			 stock = new StockAccess (rs.getString("code"),rs.getDate("date"),rs.getString("name"),rs.getString("descp"),rs.getLong("shares") ,rs.getString("marketCap"),rs.getString("category"),
					 rs.getString("top"),rs.getString("notes1"),rs.getString("notes2"),rs.getString("reason"),rs.getString("moat"),rs.getString("fundNotes"),
					 rs.getDouble("buyTrigger"),rs.getString("wishlist"),rs.getString("trend"),rs.getDouble("alertPrice"), rs.getDouble("normandyPrice"),  rs.getString("normandyNotes"), rs.getString("fYdate"),
					 rs.getString("technicalNotes"), rs.getString("montlyNotes"), rs.getString("weeklyNotes"),rs.getString("dailyNotes"), rs.getDouble("stopLoss"),rs.getString("stopLossNotes"),
					 rs.getString("whenBuy"), rs.getDouble("whenBuyPrice"), rs.getString("easyChange"), rs.getDouble("keySupportPrice"),rs.getString("keySupportPriceNotes"), rs.getDouble("defendKeyPrice"),rs.getString("defendKeyNotes")
					 , rs.getString("Nope"), rs.getString("news"),rs.getString("chart")	,rs.getString("stageGrowth"),rs.getString("research"),rs.getString("researchCat"),rs.getString("oneNotes")		);

	    	 	 
	    	  
	      }
		ps.close();	
		
	return stock;
	
	
	}
	
	
	

	public DataAccess   getAllHigh(DataAccess dt  , String code)throws Exception{
	
		LocalDate dte  = LocalDate.now();
		String myyear =  " and year(date)= "+dte.minusMonths(3).getYear()+" " ;
		String myyear1 =  " and year(date)= "+dte.minusMonths(6).getYear()+" " ;
		String myyear2 =  " and year(date)= "+dte.minusMonths(8).getYear()+" " ;
		String myyear3 =  " and year(date)= "+dte.minusMonths(12).getYear()+" " ;
		

		//String mysql = "SELECT min(close)as maxprice  FROM fortune.data where  code=? and month(date)= (MONTH(CURRENT_DATE())-3)  and year(date)=year(CURRENT_DATE()) " +myyear;
		//String mysql1 = " UNION SELECT min(close)as maxprice  FROM fortune.data where  code=? and month(date)= (MONTH(CURRENT_DATE())-6)  and year(date)=year(CURRENT_DATE()) "+myyear1;
		//String mysql2 = " UNION SELECT min(close)as maxprice  FROM fortune.data where  code=? and month(date)= (MONTH(CURRENT_DATE())-8)  and year(date)=year(CURRENT_DATE()) "+myyear2;
	//	String mysql3 = "UNION SELECT min(close)as maxprice  FROM fortune.data where  code=? and month(date)= (MONTH(CURRENT_DATE())-12)  and year(date)=year(CURRENT_DATE()) "+myyear3;
		String mysql = "SELECT max(close)as maxprice  FROM fortune.data where  code=? and date >=? ";
		String mysql1 = " UNION all SELECT max(close)as maxprice  FROM fortune.data where  code=? and date >= ?";
		String mysql2 = " UNION all  SELECT max(close)as maxprice  FROM fortune.data where  code=? and date >=? ";
		String mysql3 = "UNION all  SELECT max(close)as maxprice  FROM fortune.data where  code=? and date >=? ";
		
		
		
		String sql = mysql + mysql1 + mysql2+mysql3;
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, code);
		ps.setString(2, dte.minusMonths(3)+"");
		
		ps.setString(3, code);
		ps.setString(4, dte.minusMonths(6)+"");
		ps.setString(5, code);
		ps.setString(6, dte.minusMonths(8)+"");
		ps.setString(7, code);
		
		ps.setString(8, dte.minusMonths(12)+"");
		
		//System.out.println("getAllHigh for a "+ps );

		
		ResultSet rs = ps.executeQuery();
		
	//	System.out.println("get3monthHigh for a dt "+dt );
		//System.out.println("get3monthHigh for a 2" );
		int count=0;
		
		while(rs.next()){
			
			//dt.setClose(rs.getDouble("maxprice"));
		//	dt.setMonth3High(rs.getDouble("maxprice"));
		//	dt.setMonth6High(rs.getDouble("maxprice"));
		//	dt.setMonth8High(rs.getDouble("maxprice"));
		//	dt.setMonth12High(rs.getDouble("maxprice"));
		
			if(count==0)dt.setMonth3High(rs.getDouble("maxprice"));
			else if(count==1)	dt.setMonth6High(rs.getDouble("maxprice"));
			else if(count==2)	dt.setMonth8High(rs.getDouble("maxprice"));
			else if(count==3)	dt.setMonth12High(rs.getDouble("maxprice"));
									
			count++;
		
		}
	//	System.out.println("get3monthHigh for a 3" );

		 ps.close();	
		 return dt;
	}  

	
	
	

	public DataAccess   get6monthHigh(String code)throws Exception{
		String mysql="SELECT min(close)as maxprice  FROM fortune.data where  code=? and month(date)= (MONTH(CURRENT_DATE())-6)  and year(date)=year(CURRENT_DATE())";

		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, code);
		//System.out.println("get3monthHigh for a 1" );
		ResultSet rs = ps.executeQuery();
		//System.out.println("get3monthHigh for a 2" );
		
		DataAccess dt = new  DataAccess();
		
		while(rs.next()){
			dt.setCode(code);
			dt.setClose(rs.getDouble("maxprice"));
		}
		//System.out.println("get3monthHigh for a 3" );

		 ps.close();	
		 return dt;
	}

	
	public DataAccess   get8monthHigh(String code)throws Exception{
		String mysql="SELECT min(close)as maxprice  FROM fortune.data where  code=? and month(date)= (MONTH(CURRENT_DATE())-8)  and year(date)=year(CURRENT_DATE())";

		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, code);
		//System.out.println("get3monthHigh for a 1" );
		ResultSet rs = ps.executeQuery();
		//System.out.println("get3monthHigh for a 2" );
		
		DataAccess dt = new  DataAccess();
		
		while(rs.next()){
			dt.setCode(code);
			dt.setClose(rs.getDouble("maxprice"));
		}
		//System.out.println("get3monthHigh for a 3" );

		 ps.close();	
		 return dt;
	}
	
	
	public DataAccess   get12monthHigh(String code)throws Exception{
		String mysql="SELECT min(close)as maxprice  FROM fortune.data where  code=? and month(date)= (MONTH(CURRENT_DATE())-12)  and year(date)=year(CURRENT_DATE())";

		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, code);
		//System.out.println("get3monthHigh for a 1" );
		ResultSet rs = ps.executeQuery();
		//System.out.println("get3monthHigh for a 2" );
		
		DataAccess dt = new  DataAccess();
		
		while(rs.next()){
			dt.setCode(code);
			dt.setClose(rs.getDouble("maxprice"));
		}
		//System.out.println("get3monthHigh for a 3" );

		 ps.close();	
		 return dt;
	}
	
	

	
	
	public void updateData50d(DataAccess obj)throws Exception {
		
	//	String mysql="	UPDATE techstr SET Notes=?,OK=? WHERE  code=? and date=? and mode=?";
		
		String mysql="UPDATE data SET fifty=?, fiftychg=?  WHERE code=? and date=?  ";
	
		
		
		
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		
		ps.setDouble(1,obj.getFifty() );
		System.out.println("DataDAO SQL "+obj.getClose()+"::"+obj.getFifty()  );
		
		if(obj.getFifty()>0){
			double close =obj.getClose();
			double fifty = obj.getFifty();
			
			ps.setDouble(2, FormatUtil.formatDouble((close-fifty)/fifty  ,2) );
		}else{
			ps.setDouble(2,0); 
		}
		
		ps.setString(3, obj.getCode());	
		ps.setString(4, obj.changeStringToDate());
	
		
		
		
		
		System.out.println("DataDAO SQL "+ps  );
		ps.executeUpdate();
		
		
		ps.close();	
	}
	

	/**
	 * Done daily , because yahoo dosent provide 20d and 75 moving avg
	 * @param arr
	 * @throws Exception
	 */
	
	public void updateDataNewAverages(ArrayList<DataAccess>arr)throws Exception {
		
	//	String mysql="	UPDATE techstr SET Notes=?,OK=? WHERE  code=? and date=? and mode=?";
		System.out.println("DataDAO updateDataNewAverages" );
		String mysql="UPDATE data SET sevenfive=?, sevenfivechg=?, twenty=?, twentychg=?,fourty=?,fourtychg=?,onehundredfifty=?,onehundredfiftychg=? ,fourhundred=?,fourhundredchg=?  WHERE code=? and date=?  ";
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		
		
		LocalDate date75 = FormatUtil.getWorkDay(LocalDate.now(), 75);
		LocalDate date20 = FormatUtil.getWorkDay(LocalDate.now(), 20);
		LocalDate date40 = FormatUtil.getWorkDay(LocalDate.now(), 40);
		LocalDate date150 = FormatUtil.getWorkDay(LocalDate.now(), 150);
		LocalDate date400 = FormatUtil.getWorkDay(LocalDate.now(), 400);	
		
		
//		String mysql="UPDATE data SET sevenfive=?, sevenfivechg=?, twenty=?, twentychg=?   WHERE code=? and date=?  ";
	

		String mysql1="sELECT Avg(close)as average1   FROM fortune.data where date >= ? and code=? union all  sELECT Avg(close)as average2  FROM fortune.data where date >= ? and code=? "+
				 " union all  sELECT Avg(close)as average3  FROM fortune.data where date >= ? and code=?  union all  sELECT Avg(close)as average4  FROM fortune.data where date >= ? and code=? " +
				 "union all  sELECT Avg(close)as average4  FROM fortune.data where date >= ? and code=? ";
		
		
		
		PreparedStatement ps1 =
		        con.prepareStatement(mysql1);
	
		//System.out.println("DataDAO preSQL updateDataNewAverages:"+ps1 );

		
		for(DataAccess obj:arr){
	
			
			ps1.setString(1,date20.toString()    );	
			ps1.setString(2, obj.getCode() );	
			
			ps1.setString(3, date75.toString());	
			ps1.setString(4, obj.getCode() );	
	
			
			ps1.setString(5, date40.toString());	
			ps1.setString(6, obj.getCode() );	
	
			ps1.setString(7, date150.toString());	
			ps1.setString(8, obj.getCode() );	
	
			ps1.setString(9, date400.toString());	
			ps1.setString(10, obj.getCode() );	
			
			
			double close = obj.getClose();
			//System.out.println("DataDAO updateDataNewAverages: code"+ obj.getCode() );
			ResultSet rs = ps1.executeQuery();
			double twenty=0;
			double seventy=0;
			double fourty=0;
			double oneHundredfifty=0;
			double fourhundred=0;
			int count =0;
			while(rs.next()){
				if(count==0){
					twenty=rs.getDouble("average1");
					
				}else if(count==1){
					seventy=rs.getDouble("average1");
				}else if(count==2){
					fourty=rs.getDouble("average1");
				}else if(count==3){
					oneHundredfifty=rs.getDouble("average1");
				}else if(count==4){
					fourhundred=rs.getDouble("average1");
				}
				
				count++;
		    	 	 
		    	  
		     }
			
			
		
			
			ps.setDouble(1,seventy );
			ps.setDouble(2,FormatUtil.formatDouble((close-seventy)/seventy  ,2) );
			ps.setDouble(3,twenty );
			ps.setDouble(4, FormatUtil.formatDouble((close-twenty)/twenty  ,2) );
			
			ps.setDouble(5,fourty );
			ps.setDouble(6, FormatUtil.formatDouble((close-fourty)/fourty  ,2) );
			ps.setDouble(7,oneHundredfifty );
			ps.setDouble(8, FormatUtil.formatDouble((close-oneHundredfifty)/oneHundredfifty  ,2) );
			
			ps.setDouble(9,fourhundred );
			ps.setDouble(10, FormatUtil.formatDouble((close-fourhundred)/fourhundred  ,2) );
			
			
			
			ps.setString(11  ,obj.getCode()  );	
			ps.setString(12  ,obj.changeStringToDate()) ;	
			
			//System.out.println("DataDAO updateDataNewAverages:"+ps );
			
		ps.addBatch();
			
			
			
		}
		ps1.close();
		 ps.executeBatch();
		ps.close();
		
		
	}

	/**
	 * this is used in updating new data import , not daily operation (IMPORT)
	 * @param arr
	 * @throws Exception
	 */
		
	public void updateDataNewAveragesImport(ArrayList<DataAccess>arr )throws Exception {
	       
	    //    String mysql="    UPDATE techstr SET Notes=?,OK=? WHERE  code=? and date=? and mode=?";
	       
	       

	        System.out.println("DataDAO new data avg" );
	       
	        String mysql="UPDATE data SET sevenfive=?, sevenfivechg=?, twenty=?, twentychg=?   WHERE code=? and date=?  ";
	   
	        PreparedStatement ps =
	                con.prepareStatement(mysql);
	   
	        for(DataAccess obj:arr){
	       
	       
	       
	           
	            ps.setDouble(1,obj.getSevenfive() );
	            ps.setDouble(3,obj.getTwenty());
	           
	          //  System.out.println("DataDAO SQL "+obj.getClose()+"::"+obj.getTwenty()  );
	          //  System.out.println("DataDAO SQL " +obj.getTwenty()  );
	           
	            if(obj.getTwenty()>0){
	                double close =obj.getClose();
	                double twenty = obj.getTwenty();
	               
	                ps.setDouble(4, FormatUtil.formatDouble((close-twenty)/twenty  ,2) );
	            }else{
	                ps.setDouble(4,0);
	            }
	       
	            if(obj.getSevenfive()>0){
	                double close =obj.getClose();
	                double sevenfive = obj.getSevenfive();
	               
	                ps.setDouble(2, FormatUtil.formatDouble((close-sevenfive)/sevenfive  ,2) );
	            }else{
	                ps.setDouble(2,0);
	            }
	           
	           
	           
	           
	            ps.setString(5, obj.getCode());   
	            ps.setString(6, obj.changeStringToDate());
	       
	           
	            ps.addBatch();
	           
	           
	            //System.out.println("DataDAO SQL "+ps  );
	           
	        }
	       
	        ps.executeBatch();
	       
	        ps.close();   
	    }
	
	
	public void updateDataNewAveragesImport400(ArrayList<DataAccess>arr )throws Exception {
	       
        System.out.println("DataDAO new data updateDataNewAveragesImport400" );
	       
	        String mysql="UPDATE data SET fourhundred=?, fourhundredchg=? WHERE code=? and date=?  ";
	   
	        PreparedStatement ps =
	                con.prepareStatement(mysql);
	   
	        for(DataAccess obj:arr){
	       
	       
	       
	           
	            ps.setDouble(1,obj.getFourhundred() );
	           
	          //  System.out.println("DataDAO SQL "+obj.getClose()+"::"+obj.getTwenty()  );
	          //  System.out.println("DataDAO SQL " +obj.getTwenty()  );
	           
	            if(obj.getFourhundred()>0){
	                double close =obj.getClose();
	                double fourhundred = obj.getFourhundred();
	               
	                ps.setDouble(2, FormatUtil.formatDouble((close-fourhundred)/fourhundred  ,2) );
	            }else{
	                ps.setDouble(2,0);
	            }
	       
	           
	           
	           
	            ps.setString(3, obj.getCode());   
	            ps.setString(4, obj.changeStringToDate());
	       
	           
	            ps.addBatch();
	           
	           
	            //System.out.println("DataDAO SQL "+ps  );
	           
	        }
	       
	        ps.executeBatch();
	       
	        ps.close();   
	    }
		
	
	
	public void updateDataNewAveragesImportNew(ArrayList<DataAccess>arr )throws Exception {

		System.out.println("DataDAO new data avg");

		String mysql = "UPDATE data SET fourty=?, fourtychg=?, onehundredfifty=?, onehundredfiftychg=?   WHERE code=? and date=?  ";

		PreparedStatement ps = con.prepareStatement(mysql);

		for (DataAccess obj : arr) {

			ps.setDouble(1, obj.getFourty());
			ps.setDouble(3, obj.getOnehundredfifty());

			// System.out.println("DataDAO SQL
			// "+obj.getClose()+"::"+obj.getTwenty() );
			// System.out.println("DataDAO SQL " +obj.getTwenty() );

			if (obj.getOnehundredfifty() > 0) {
				double close = obj.getClose();
				double onehundredfifty = obj.getOnehundredfifty();

				ps.setDouble(4, FormatUtil.formatDouble((close - onehundredfifty) / onehundredfifty, 2));
			} else {
				ps.setDouble(4, 0);
			}

			if (obj.getFourty() > 0) {
				double close = obj.getClose();
				double fourty = obj.getFourty();

				ps.setDouble(2, FormatUtil.formatDouble((close - fourty) / fourty, 2));
			} else {
				ps.setDouble(2, 0);
			}

			ps.setString(5, obj.getCode());
			ps.setString(6, obj.changeStringToDate());

			ps.addBatch();

			// System.out.println("DataDAO SQL "+ps );

		}

		ps.executeBatch();

		ps.close();
	    }
				
		
		
		
		
			
	
	/**
	 * this is used in updating new data import , not daily operation (IMPORT)
	 * @param arr
	 * @throws Exception
	 */
	
	
	
	public void updateDataAveragesImport(ArrayList<DataAccess>arr )throws Exception {
		
	//	String mysql="	UPDATE techstr SET Notes=?,OK=? WHERE  code=? and date=? and mode=?";
		
		String mysql="UPDATE data SET fifty=?, fiftychg=?, twohundred=?, twohundredchg=? ,Avg3mth=?    WHERE code=? and date=?  ";
	
		PreparedStatement ps =
		        con.prepareStatement(mysql);
	
		for(DataAccess obj:arr){
		
		
		
			
			ps.setDouble(1,obj.getFifty() );
			//System.out.println("DataDAO SQL "+obj.getClose()+"::"+obj.getFifty()  );
			
			if(obj.getFifty()>0){
				double close =obj.getClose();
				double fifty = obj.getFifty();
				
				ps.setDouble(2, FormatUtil.formatDouble((close-fifty)/fifty  ,2) );
			}else{
				ps.setDouble(2,0); 
			}
			ps.setDouble(3,obj.getTwohundred() );
			if(obj.getTwohundred()>0){
				double close =obj.getClose();
				double twohundred = obj.getTwohundred();
				
				ps.setDouble(4, FormatUtil.formatDouble((close-twohundred)/twohundred  ,2) );
			}else{
				ps.setDouble(4,0); 
			}
			
			ps.setDouble(5,obj.getAvg3mth()) ;
			
			
			ps.setString(6, obj.getCode());	
			ps.setString(7, obj.changeStringToDate());
		
			
			ps.addBatch();
			
			
		//	System.out.println("DataDAO SQL "+ps  );
			
		}
		
	
		ps.executeBatch();
		ps.close();	
	}
	
	

	
	
	
	
	
	
	public void updateData200d(DataAccess obj)throws Exception {
		
	//	String mysql="	UPDATE techstr SET Notes=?,OK=? WHERE  code=? and date=? and mode=?";
		
		String mysql="UPDATE data SET twohundred=?, twohundredchg=?  WHERE code=? and date=?  ";
	
		
		
		
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		
		ps.setDouble(1,obj.getFifty() );
		System.out.println("DataDAO SQL "+obj.getClose()+"::"+obj.getTwohundred()   );
		
		if(obj.getTwohundred()>0){
			double close =obj.getClose();
			double twohundred = obj.getTwohundred();
			
			ps.setDouble(2, FormatUtil.formatDouble((close-twohundred)/twohundred  ,2) );
		}else{
			ps.setDouble(2,0); 
		}
		
		ps.setString(3, obj.getCode());	
		ps.setString(4, obj.changeStringToDate());
	
		
		
		
		
		System.out.println("DataDAO SQL "+ps  );
		ps.executeUpdate();
		
		
		ps.close();	
	}
	
	public void updateDataAvgVol(DataAccess obj)throws Exception {
		
	//	String mysql="	UPDATE techstr SET Notes=?,OK=? WHERE  code=? and date=? and mode=?";
		
		String mysql="UPDATE data SET Avg3mth=?  WHERE code=? and date=?  ";
	
		
		
		
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		
		ps.setDouble(1,obj.getAvg3mth()) ;
		
		

		ps.setString(3, obj.getCode());	
		ps.setString(4, obj.changeStringToDate());
	
		
		
		
		
		System.out.println("DataDAO SQL "+ps  );
		ps.executeUpdate();
		
		
		ps.close();	
	}
	
	
	
	
	
	
	

		public void updateStockFundamental(StockAccess obj)throws Exception {
		
		
			
			String mysql="UPDATE stock SET descp=?, category=?, reason=?, moat=?, fundNotes=?, FYdate=?, EasyChange=?,news=? WHERE code=?";
			
		
			
			
			
			PreparedStatement ps =
			        con.prepareStatement(mysql);
			
			ps.setString(1, obj.getDescp() );
			ps.setString(2, obj.getCategory());
			ps.setString(3, obj.getReason() );
			ps.setString(4, obj.getMoat());
			ps.setString(5, obj.getFundNotes() );
			ps.setString(6, obj.getFYdate());
			ps.setString(7, obj.getEasyChange() );
			ps.setString(8, obj.getNews());

			ps.setString(9, obj.getCode());
			
			
			
		
			
			
			
			
			System.out.println("updateStockFundamental SQL "+mysql  );
			ps.executeUpdate();
			
			
			ps.close();	
		}
		
	
	



		public void deleteTodayDate()throws Exception {
		
		
			
			String mysql="delete from data where date=curdate()";
			
		
			
			
			
			PreparedStatement ps =
			        con.prepareStatement(mysql);
			System.out.println("deleteTodayDate SQL "+mysql  );
			ps.executeUpdate();
			
			
			ps.close();	
		}
		
	
	
	
	
	
	
	
}
