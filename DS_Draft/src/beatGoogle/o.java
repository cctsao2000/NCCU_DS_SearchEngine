package beatGoogle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;


public class o {
	/////////////////////////////////////
	public static String decodeValue(String value) {
        try {
            return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
	


	public static void main(String []args) throws IOException {
		
		Document doc = Jsoup.connect("http://linux.vbird.org/linux_server/0110network_basic.php#prepare_dns").get();

		Elements links = doc.select("a[href]"); // a with href
		for(Element i:links) {
			System.out.println(i.attr("href"));
			System.out.println(i.text());}
		}

		
		
	}

