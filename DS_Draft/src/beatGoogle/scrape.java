package beatGoogle;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class scrape {

	public static void main(String[] args) throws IOException{
	    String url  = "https://www.google.com/search?q=ucc&oq=ucc&aqs=chrome.0.69i59l2j0i433j0l5.1247j0j15&sourceid=chrome&ie=UTF-8";
	    //get first link
	    String link = Jsoup.connect(url).get().getElementsByClass("f1").get(0).attr("href");
	    //an int just to count up links
	    int i = 1;
	    System.out.println("pagination-link_"+ i + "\t" + link);
	    //parse next page using link
	    //check if the div on next page has more than one link in it
	    while(Jsoup.connect(link).get().getElementsByClass("f1").size() >1){
	        link = Jsoup.connect(link).get().select("div.pagination a").get(i).attr("href");
	        System.out.println("pagination-link_"+ (++i) +"\t" + link);
	    }
	} 
}
