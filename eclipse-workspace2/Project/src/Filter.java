import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Filter extends WordCounter{
	private String urlStr;
    private String content;
    
    public Filter(String urlStr){
    	super(urlStr);
    }
    
    private String fetchContent() throws IOException{
		URL url = new URL(this.urlStr);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
	
		String retVal = "";
	
		String line = null;
		while ((line = br.readLine()) != null)
		{
		    retVal = retVal + line + "\n";
		}
	
		return retVal;
    }
    
    public void remove(String keyword) throws IOException{
    	if (content == null){
		    content = fetchContent();
		}
    	
    	content = content.toUpperCase();
		keyword = keyword.toUpperCase();
		
//    	for(int i=0;i<webpagelist.size();i++) {
//    		if(content.contains(keyword)==false) {
//    			webpagelist.remove(i);
//        	}
//    	}
    	
    }
}
