import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Bookle")
public class Bookle extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public Bookle() {
	        super();
	}
	public static String search(String primary,String key1,Double wei1,String key2,Double wei2,String key3,Double wei3) throws IOException {
		KeywordList kl1 = new KeywordList();
		Keyword k1 = new Keyword(key1,wei1);
		Keyword k2 = new Keyword(key2,wei2);
		Keyword k3 = new Keyword(key3,wei3);
		kl1.add(k1);
		kl1.add(k2);
		kl1.add(k3);
		KeywordList filter = new KeywordList();
		Double score = 0.0;
		Double totalScore = 0.0;
		LinkedList<String> results= Demo.buildList(primary);
		SRList searchResults = new SRList();
		int resultCount = 0;
		for (String result:results) {
			if (resultCount >= 10) {
				break;
			}
			try {
				for (Keyword key:kl1.getLst()) {
					if (key.weight == 0) {
						continue;
					}
					else {
						String keyword = key.name;
				    	WordCounter counter = new WordCounter(result);
				    	counter.getContent();
						score = counter.countKeyword(keyword) * key.weight;
						totalScore += score;
					}
				}
				if (totalScore != 0) {
					for (Keyword fil:filter.getLst()) {
				    	String filt = fil.name;
				    	WordCounter counter = new WordCounter(result);
				    	if(counter.getContent().indexOf(filt) != -1) {
				    		totalScore *= -1;
				    		break;
				    	}
					}
				}
				if(totalScore <= 0) {
					continue;
				}
				resultCount += 1;
				SearchResult res = new SearchResult(result,totalScore);
				searchResults.add(res);
				totalScore = 0.0;
			}
			catch(NullPointerException e){
				continue;
			}
			catch(FileNotFoundException e){
				continue;
			}
			catch(IOException e) {
				continue;
			}
		}
		searchResults.sort();
		return searchResults.output();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestUri = request.getRequestURI();
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Bookle</title>");
		out.println("<link rel='shortcut icon' href='favicon.ico' />");
		out.println("<style type='text/css'>");
		out.println("div {margin-top: 20px;margin-bottom: 20px;margin-right: 20px;}");
		out.println("</style>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<div class='form'>");
		out.println("<form action='" + requestUri + "' method='post'>");
		out.println("<br><br><br><br>");
		out.println("<table style='margin-left:80px;'>");
		out.println("<thead></thead>");
		out.println("<tbody>\n"
				+ "<tr>\n"
				+ "<td rowspan=\"10\">\n"
				+ "<img src=\"01.png\" width=500>\n"
				+ "</td>\n"
				+ "<td colspan=\"2\">\n"
				+ "<input type='text' name='prime' placeholder = 'Search' required style=\" font-size:18px;border-radius:10px;border: transparent 10px solid;outline:none;background-color:#FDC2B7;width:500px;height:30px;\"/>\n"
				+ "</td>\n"
				+ "<td style=\"padding:20px;\">\n"
				+ "<input type='image' value=\"\" src=\"2.jpg\" onClick=\"document.formname.submit();\" style=\"width:40px;height:40px;\"/>\n"
				+ "</td>\n"
				+ "</tr>\n"
				+ "<tr>\n"
				+ "<td>\n"
				+ "<label for=\"Advanced Keyword\" style=\"font-size:20px;\">Advanced Keyword</label>\n"
				+ "<div ><input type=\"text\" name=\"keyword1\" placeholder = 'Keyword' style=\"font-size:16px;border-radius:10px;border: transparent 10px solid;outline:none;background-color:#DDDDDD\n"
				+ ";width:60%;height:23px;\">&ensp;&ensp;<input type=\"text\" name=\"weight1\" placeholder = 'Weight' oninput = \"value=value.replace(/[^\\d.]/g,'')\" style=\"font-size:16px;border-radius:10px;border: transparent 10px solid;outline:none;background-color:#DDDDDD\n"
				+ ";width:15%;height:23px;\"></div>\n"
				+ "<div ><input type=\"text\" name=\"keyword2\" placeholder = 'Keyword' style=\"font-size:16px;border-radius:10px;border: transparent 10px solid;outline:none;background-color:#DDDDDD\n"
				+ ";width:60%;height:23px;\">&ensp;&ensp;<input type=\"text\" name=\"weight2\" placeholder = 'Weight' oninput = \"value=value.replace(/[^\\d.]/g,'')\" style=\"font-size:16px;border-radius:10px;border: transparent 10px solid;outline:none;background-color:#DDDDDD\n"
				+ ";width:15%;height:23px;\"></div>\n"
				+ "<div ><input type=\"text\" name=\"keyword3\" placeholder = 'Keyword' style=\"font-size:16px;border-radius:10px;border: transparent 10px solid;outline:none;background-color:#DDDDDD\n"
				+ ";width:60%;height:23px;\">&ensp;&ensp;<input type=\"text\" name=\"weight3\" placeholder = 'Weight' oninput = \"value=value.replace(/[^\\d.]/g,'')\" style=\"font-size:16px;border-radius:10px;border: transparent 10px solid;outline:none;background-color:#DDDDDD\n"
				+ ";width:15%;height:23px;\"></div>  \n"
				+ "</td>\n"
				+ "</tr>\n"
				+ "<tr>\n"
				+ "<td>\n"
				+ "<label for=\"Type Keyword\" style=\"font-size:20px;\">Type Keyword</label>\n"
				+ "</td>\n"
				+ "</tr>\n"
				+ "<tr>\n"
				+ "<td>\n"
				+ "<select>\n"
				+ "    <option>N/A</option>\n"
				+ "    <option>Document(.pdf)</option>\n"
				+ "    <option>Slides(.pptx)</option>\n"
				+ "    <option>Picture(.png)</option>\n"
				+ "    <option>Picture(.jpg)</option>\n"
				+ "</select>\n"
				+ "</td>\n"
				+ "</tr>\n"
				+ "</tbody>\n"
				+ "</table>\n"
				+ "</form></div>\n"
				+ "</body>\n"
				+ "</html>");
		
		out.flush();
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String priK  = request.getParameter("prime");
		String keyone  = request.getParameter("keyword1");
		Double weione = Double.parseDouble(request.getParameter("weight1"));
		String keytwo  = request.getParameter("keyword2");
		Double weitwo = Double.parseDouble(request.getParameter("weight2"));
		String keythr  = request.getParameter("keyword3");
		Double weithr = Double.parseDouble(request.getParameter("weight3"));
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Bookle</title>");
		out.println("<link rel='shortcut icon' href='favicon.ico' />");
		out.println("<style type='text/css'>");
		out.println("div {margin-top: 20px;margin-bottom: 20px;margin-right: 20px;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		
		out.println(search(priK,keyone,weione,keytwo,weitwo,keythr,weithr));
		
		out.println("</body>");
		out.println("</html>");
		
		out.flush();
		out.close();
	}
}
