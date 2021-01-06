
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Demo {
	
	public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";
	private  LinkedList<String>List=new LinkedList();
	
	public static String decodeValue(String value) {
	    try {
	        return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
	    } catch (UnsupportedEncodingException ex) {
	        throw new RuntimeException(ex.getCause());
	    }
	}
	
	
	public static LinkedList<String>buildList(String pk) throws IOException{
		Demo demo=new Demo();
		String searchTerm = pk;
		int num=30;
		
		String searchURL = GOOGLE_SEARCH_URL + "?q="+searchTerm+"&num="+num;
		//without proper User-Agent, we will get 403 errorzz
		Document doc = Jsoup.connect(searchURL).userAgent("Chrome/7.0.517.44").get();
		Elements elements = doc.select("a[href]");
		int count = 0;
		
		for (Element link : elements) {
			String absurl = link.attr("abs:href");
			
			if(absurl.contains("https://www.google.com/url?q=https://")) {
				count++;
				
				//去頭去尾
				String[] g1=absurl.split("\\?q=");
				String s=g1[1];
				String encodedValue = s;
				String[] s1=s.split("&sa=U");
				String encodedValue1=s1[0];
				
				String decodedValue = decodeValue(encodedValue1);
				demo.List.add(decodedValue);
				String text=link.text();
			}
		}
		return demo.List;
	}
	
	public static void main(String[] args) throws IOException {
		//Taking search term input from console	
		LinkedList<String> results= Demo.buildList("nccu");
		System.out.println(results.size());
		for(String result:results) {
			System.out.println(result);
		}    
	}
	 
}


