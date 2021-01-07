
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	
	public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";
	private  SRList List=new SRList();
	
	public static String decodeValue(String value) {
	    try {
	        return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
	    } catch (UnsupportedEncodingException ex) {
	        throw new RuntimeException(ex.getCause());
	    }
	}
	
	
	public static SRList buildList(String pk) throws IOException{
		Crawler demo=new Crawler();
		String searchTerm = pk;
		int num=100;
		
		String searchURL = GOOGLE_SEARCH_URL + "?q="+searchTerm+"&num="+num+"&sourceid=chrome&ie=UTF-8";
		System.out.println(searchURL);
		//without proper User-Agent, we will get 403 errorzz
		Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
		Elements url = doc.select("div").select(".kCrYT");
		for (Element link : url) {
			try{
				String citeUrl = link.select("a").get(0).attr("href");
				String title = link.select("a").get(0).select(".vvjwJb").text();
				String decodeURL = citeUrl.split("q=")[1];
				SearchResult res = new SearchResult(decodeValue(decodeURL),title);
				demo.List.add(res);

			} catch (IndexOutOfBoundsException e) {
				
			}
		}
		return demo.List;
	}
//	public static void main(String[] args) throws IOException {
//		for (SearchResult SR:buildList("%26%2321338%3B%26%2323458%3B%26%2320358%3B")){
//			System.out.println(SR.getName()+SR.getUrl());
//		}
//	}
	 
}


