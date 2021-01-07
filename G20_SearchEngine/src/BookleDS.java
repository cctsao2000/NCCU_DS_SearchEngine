import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookleDS")
public class BookleDS extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public BookleDS() {
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
		Double score = 0.0;
		Double totalScore = 0.0;
		SRList results= Crawler.buildList(primary+" book"+" -film");
		SRList searchResults = new SRList();
		int resultCount = 0;
		for (SearchResult result:results) {
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
				    	WordCounter counter = new WordCounter(result.getUrl());
				    	counter.getContent();
						score = (counter.countKeyword(keyword)/counter.getContent().length()) * key.weight;
						totalScore += score;
					}
				}
				if(totalScore <= 0) {
					continue;
				}
				resultCount += 1;
				SearchResult res = new SearchResult(result.getUrl(),result.getName(),totalScore);
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
		out.println("div {margin-top: 10px;margin-bottom: 10px;margin-right: 20px;}");
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
				+ "<input type='image' value=\"\" src=\"02.jpg\" onClick=\"document.formname.submit();\" style=\"width:40px;height:40px;\"/>\n"
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
				+ "<select name=\"type\">\n"
				+ "    <option value=\"N/A\">N/A</option>\n"
				+ "    <option value=\"Document(.pdf)\">Document(.pdf)</option>\n"
				+ "    <option value=\"Slides(.pptx)\">Slides(.pptx)</option>\n"
				+ "    <option value=\"Picture(.png)\">Picture(.png)</option>\n"
				+ "    <option value=\"Picture(.jpg)\">Picture(.jpg)</option>\n"
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
		String typeK = request.getParameter("type");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Bookle</title>");
		out.println("<link rel='shortcut icon' href='favicon.ico' />");
		out.println("<style type='text/css'>");
		out.println("div {margin-top: 10px;margin-bottom: 10px;margin-right: 20px;}");
		out.println("p.one{border-style: solid;border-width: 5px;border-radius:25px;border-color: #FDC2B7;padding-left: 20px;padding-top: 7px;}");
		out.println("label.long{height:7px;width:120px;display: inline-block;border-style: solid;border-radius:12px;border: transparent 10px solid;outline:none;background-color:#DDDDDD;padding-left: 5px;padding-right: 5px;padding-bottom: 10px;}");
		out.println("label.short{height:7px;width:100px;display: inline-block;border-style: solid;border-radius:12px;border: transparent 10px solid;outline:none;background-color:#DDDDDD;padding-left: 5px;padding-right: 5px;padding-bottom: 10px;}");
		out.println("a.link{text-decoration:none;color:#fb6648;font-size:22px;margin-left:55px}");
		out.println("a:hover {\n"
				+ "text-decoration:underline;");
		out.println("</style>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<table style=\"margin-left:50px;\">\n"
				+ "<thead>\n"
				+ "</thead>\n"
				+ "<tbody>\n"
				+ "<tr>\n"
				+ "<td rowspan=\"2\">\n"
				+ "<img src=\"03.png\" width=120>\n"
				+ "</td>\n"
				+ "<td style=\"padding:30px;\">\n"
				+ "<p for=\"primeKey\" class=\"one\" style=\" font-size:17px;outline:none;background-color:white;width:800px;height:35px;\">"+priK+"</p>\n"
				+ "<label for=\"advKey\" class=\"long\" style=\" font-size:14px;outline:none;margin-right:10px\">"+keyone+"&emsp;&emsp;&emsp;"+weione+"</label>\n"
				+ "<label for=\"advKey\" class=\"long\" style=\" font-size:14px;outline:none;margin-right:10px\">"+keytwo+"&emsp;&emsp;&emsp;"+weitwo+"</label>\n"
				+ "<label for=\"advKey\" class=\"long\" style=\" font-size:14px;outline:none;margin-right:10px\">"+keythr+"&emsp;&emsp;&emsp;"+weithr+"</label>\n"
				+ "<label for=\"typeKey\" class=\"short\" style=\" font-size:14px;outline:none;margin-right:10px\">"+typeK+"</label>\n"
				+ "</td>\n"
				+ "</tr>\n");
		out.println("</tbody>\n"+"</table>");
		out.println(search(priK,keyone,weione,keytwo,weitwo,keythr,weithr));
		out.println("</body>");
		out.println("</html>");
		
		out.flush();
		out.close();
	}
}
