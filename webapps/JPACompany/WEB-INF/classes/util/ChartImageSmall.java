package util;



import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
/**
 * import ASX news from ASX website
 * @author rowan
 *
 */
public class ChartImageSmall {

	public static String preurl="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A";	
	public static String year5="&x=53&y=18&time=12&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=3&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=10&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=2&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11";
	public static String year3="&x=15&y=11&time=10&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=15&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=2&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11";
	public static String year1="&x=43&y=17&time=8&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=1&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=100&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=2&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11";
	public static String yearhalf="&x=54&y=9&time=7&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=1&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=20&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=2&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11";
	public static String year10="&x=34&y=8&time=13&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=3&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=10&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=2&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11";
	public static String year2="&x=70&y=15&time=9&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=1&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=15&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=2&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11";
	
	 
	  static ArrayList<BufferedImage> bimage;
	
	public static String chartImage( String code )throws Exception{
		System.out.println("chartImage");
		System.out.println("chartImage code "+code);
	
	String href = "<a href=\"Research/getCharts?code="+code+".AX" ;
	String mode = "&mode=";
	
	
	String[] link ={year10,year5,year3,year1,yearhalf,year2};
				// mode0, 
	//String[] link ={year10};
	//String[] link ={sixMonth,year,week,month};
	//String[] link ={sixMonth};
	ArrayList<String> ls = new ArrayList<String>(Arrays.asList(link) );
	
	bimage= new  ArrayList<>();
	
	//ArrayList<String> image = new ArrayList<String> ();
	String image;
	int x=0;
	for(String urls : ls){
		String url =preurl+code+urls;
		String imagetag=getImageTag( url );
		bimage.add(ImageIO.read( new URL(imagetag)) );
		String imagedata = getImage(imagetag);
		//image.add("<img alt=\"Embedded Image\" "+ getImage(imagetag)+"'> ");
//		image.add(href+mode+x+"&image="+ imagedata+"\">"+   "<img alt=\"Embedded Image\" "+ imagedata+"'> </a>");
		//image.add(href+mode+x+"\">"+   "<img alt=\"Embedded Image\" src=\""+ imagedata+"\"> </a>");
		x++;
	}
	System.out.println("OK");
	totalw = 579+5+579+579+5;
	totalh = 444+5+444;
	
	
//	BufferedImage a1= joinBufferedImage(bimage.get(0),bimage.get(1)  );
//	BufferedImage a2= joinBufferedImage(a1,bimage.get(2)  );
//	BufferedImage a3= joinBufferedImage2(a2,bimage.get(3)  );
//	BufferedImage a4= joinBufferedImage3(a3,bimage.get(4)  );
	//BufferedImage a5= joinBufferedImage2(a4,bimage.get(5)  );
	BufferedImage a4 = DrawAll() ;
	
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	  //   ImageIO.write(a5, "png", baos);
	  ImageIO.write(a4, "png", baos);
	     String imagedat=  "data:image/png;base64,"+ Base64.encode(baos.toByteArray());
	   //  image="<img alt=\"Embedded Image\" src=\""+ imagedat+"\"> ";
	     image =imagedat;
	return image;
//	Document doc = Jsoup.connect(url).get();

	  
	
	}	
	static int totalw=0;
	static int totalh=0;
	static int offset=5;
	static int w=579;
	static int h=444;
	
	
	//width = 579
	//height = 444
	public static BufferedImage DrawAll() {

        //do some calculate first
        int offset  = 5;
   	 
      
        //create a new buffer and draw two image into the new image
        BufferedImage newImage = new BufferedImage(totalw,totalh, BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D g2 = newImage.createGraphics();
        Color oldColor = g2.getColor();
        //fill background
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, totalw, totalh);
        //draw image
        g2.setColor(oldColor);
        g2.drawImage(bimage.get(0), null, 0, 0);
        g2.drawImage(bimage.get(1), null, w+offset, 0);
        g2.drawImage(bimage.get(2), null,w+offset+ w+offset, 0);
        
        g2.drawImage(bimage.get(3), null,0, h+offset);
        g2.drawImage(bimage.get(4), null,w+offset, h+offset);
        
        
        g2.drawImage(bimage.get(5), null,w+offset+ w+offset, h+offset);
        
        g2.dispose();
        return newImage;
    }
	
	
	public static BufferedImage joinBufferedImage(BufferedImage img1,BufferedImage img2) {

        //do some calculate first
        int offset  = 5;
   	 System.out.println("widtj:"+img1.getWidth());
	 System.out.println("height "+img1.getHeight());
        int wid = img1.getWidth()+img2.getWidth()+offset;
        int height = Math.max(img1.getHeight(),img2.getHeight())+offset;
        //create a new buffer and draw two image into the new image
        BufferedImage newImage = new BufferedImage(wid,height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        Color oldColor = g2.getColor();
        //fill background
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, wid, height);
        //draw image
        g2.setColor(oldColor);
        g2.drawImage(img1, null, 0, 0);
        g2.drawImage(img2, null, img1.getWidth()+offset, 0);
        g2.dispose();
        return newImage;
    }
	
	public static BufferedImage joinBufferedImage2(BufferedImage img1,BufferedImage img2) {

        //do some calculate first
        int offset  = 5;
        int wid = img1.getWidth()+offset;
        //int height = Math.max(img1.getHeight(),img2.getHeight())+offset;
        //create a new buffer and draw two image into the new image
        BufferedImage newImage = new BufferedImage(wid, (img1.getHeight()+img2.getHeight())+offset, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        Color oldColor = g2.getColor();
        //fill background
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, wid, (img1.getHeight()+img2.getHeight())+offset);
        //draw image
        g2.setColor(oldColor);
        g2.drawImage(img1, null, 0, 0);
        g2.drawImage(img2, null, 0,  img1.getHeight()+offset);
        g2.dispose();
        return newImage;
    }     
	
	public static BufferedImage joinBufferedImage3(BufferedImage img1,BufferedImage img2) {

        //do some calculate first
        int offset  = 5;
        int wid = img1.getWidth()+offset;
        //int height = Math.max(img1.getHeight(),img2.getHeight())+offset;
        //create a new buffer and draw two image into the new image
        BufferedImage newImage = new BufferedImage(wid, img1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        Color oldColor = g2.getColor();
        //fill background
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, wid, (img1.getHeight()+img2.getHeight())+offset);
        //draw image
        g2.setColor(oldColor);
        g2.drawImage(img1, null, 0, 0);
        g2.drawImage(img2, null,  (img2.getWidth()*2)+offset, img1.getHeight()+offset);
        g2.dispose();
        return newImage;
    }     
	 
		
	public static String getImageTag(String url )throws Exception{
	//	System.out.println("getImageTag :" +url);
		Document doc = Jsoup.connect(url).get();
		
		Elements img = doc.select("img");

		
		for (Element tb : img) {
			String t = tb.attr("src");
			
			String pattern = ".*nosettings?.*";
			if (Pattern.matches(pattern, t)) {
		//		 System.out.println("CORRECT TABLE"+t);
				 return t;
				
				
			}
				 
				 
				 
			
		}
		//System.out.println("getImageTag  done :" );
		 return "";
	     
		
	}
	/**
	public static String getImage()throws Exception{
		int x=0;
		for(BufferedImage img : arr){
			if(x==1){
				joinImage()
				x=0;
			}
			x++;
		}
	}
	
	*/
	public static String getImage(String url )throws Exception{
		//System.out.println("getImage :" +url);
	     BufferedImage  image = ImageIO.read( new URL(url));
	     ByteArrayOutputStream baos = new ByteArrayOutputStream();
	     ImageIO.write(image, "png", baos);
	     return "data:image/png;base64,"+ Base64.encode(baos.toByteArray());
	     
		
	}
	
	
	
	public void run(){
		String url = "http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=&symb=au%3Ahgg&x=0&y=0&time=7&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=1&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=20&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11";
		System.out.println("RUNB");

		try {
			int count = 0;
			Document doc = Jsoup.connect(url).get();

			Elements img = doc.select("img");

			
			for (Element tb : img) {
				String t = tb.attr("src");
				String pattern = ".*nosettings?.*";
				// boolean matches = Pattern.matches(pattern, t)
			

			//	System.out.println(" TABLE:" + t);
				if (Pattern.matches(pattern, t)) {
					 System.out.println("CORRECT TABLE"+t);

					 
					 BufferedImage  image = null;
					
					 try {
						 System.out.println("image t:"+t);
					     URL urli = new URL(t);
					     image = ImageIO.read(urli);
					     
					     ImageIO.write(image,"jpg",new File("d:\\test.gif"));
					     
					 } catch (IOException e) {
						 System.out.println("error immage. "+e);
					 }
					 
					 
					 
				
			}
			

			
			System.out.println("FINISH ");

		} 
		}catch (Exception e) {
			System.out.println("Error:" + e);

		}
	
	}
	
	
	
	public static void main(String[] args) {

		
		/*		
				   //get current date time with Date()
		Date mydate= new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(mydate);
		int month = cal.get(Calendar.YEAR);	 
		System.out.println("yr"+month);		   
			    
		System.out.println("yr"+(month-1));		    
			*/  
		//new ChartImage().run();
			    
		
		try {
			ChartImageSmall.chartImage("bhp");
		} catch (Exception e) {
			System.out.println("err"+e);		
		}	        	
	
			
			
			  }
		
		
		

	

}
