package beatGoogle;

import java.io.File;
import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class tryjsooup {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/**Document a=Jsoup.parse(new File("C:/Users/ASUS/htnl/try813.html"),"utf-8");
System.out.println(a.html());
Elements links = (Elements) a.select("a.fl");  
for (Element link : links) 
{
     System.out.println("link : " + link.attr("href"));  
     System.out.println("text : " + link.text());  
}*/
		
		Document b=Jsoup.connect("https://www.google.com/search?q=java&sxsrf=ALeKk01iF8r0Ywj2IQDOk"
				+ "YMbRLmXq04cBA:1607356471886&ei=N1DOX_nHNdHFmAW63IjABg&start=20&sa"
				+ "=N&ved=2ahUKEwi5v6K8nbztAhXRIqYKHTouAmgQ8tMDegQIDBA-&biw=782&bih=706").get();
		
		Elements b1=b.select("a.fl");
		for(Element bb:b1) {
			System.out.println(bb.attr("href"));
		}
	}

}
