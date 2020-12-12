package beatGoogle;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class domo {public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";
	private  LinkedList<String>List=new LinkedList();
	public static String decodeValue(String value) {
    try {
        return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
    } catch (UnsupportedEncodingException ex) {
        throw new RuntimeException(ex.getCause());
    }
}
	
	
	public static LinkedList<String>buildList() throws IOException{
		domo ag=new domo();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the search term.");
		String searchTerm = scanner.nextLine();
		int num=150;
		scanner.close();
		
		String searchURL = GOOGLE_SEARCH_URL + "?q="+searchTerm+"&num="+num;
		//without proper User-Agent, we will get 403 errorzz
		Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
		Elements elements = doc.select("a[href]");
		int count=0;
		  for (Element link : elements) {
			  String g=link.attr("abs:href");
			  if(g.contains("https://www.google.com/url?q=https://")) {
				 
				
				  count++;
				  String []g1=g.split("\\?q=");
				  String s=g1[1];
				  String encodedValue = s;
				  //if(s.contains("html")) {
					  String [] s1=s.split("&sa=U");
					  String encodedValue1=s1[0];
					  String decodedValue = decodeValue(encodedValue1);
					 ag. List.add(decodedValue);
					  String text=link.text();
					//  System.out.println("\nlink "+ count + ": " +decodedValue ); 
				   //   System.out.println("text : " + text);  
			  }}return ag.List;}
	
			 

	
	public static void main(String[] args) throws IOException {
		//Taking search term input from console
		
LinkedList<String> List1= domo.buildList();
for(String g:List1) {
	System.out.println(g);
}
		        
		       

		      
		  }
		 
	}


