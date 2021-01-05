
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		KeywordList kl1 = new KeywordList();
		Keyword k1 = new Keyword(" ",5.0);
		Keyword k2 = new Keyword("的",2.0);
		kl1.add(k1);
		kl1.add(k2);
		KeywordList filter = new KeywordList();
//		Keyword f1 = new Keyword("netflix",0.0);
//		Keyword f2 = new Keyword("youtube",0.0);
//		Keyword f3 = new Keyword("movie",0.0);
//		Keyword f4 = new Keyword("TV",0.0);
//		Keyword f5 = new Keyword("綜藝",0.0);
//		Keyword f6 = new Keyword("電視",0.0);
//		Keyword f7 = new Keyword("電影",0.0);
//		filter.add(f1);
//		filter.add(f2);
//		filter.add(f3);
//		filter.add(f4);
//		filter.add(f5);
//		filter.add(f6);
//		filter.add(f7);
		Double score = 0.0;
		Double totalScore = 0.0;
		LinkedList<String> results= Demo.buildList();
		SRList searchResults = new SRList();
		int resultCount = 0;
		for (String result:results) {
			if (resultCount >= 10) {
				break;
			}
			try {
				for (Keyword key:kl1.getLst()) {
			    	String keyword = key.name;
			    	WordCounter counter = new WordCounter(result);
			    	counter.getContent();
					score = counter.countKeyword(keyword) * key.weight;
					totalScore += score;
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
//				System.out.println(result+" error");
				continue;
			}
			catch(FileNotFoundException e){
//				System.out.println(result+" error");
				continue;
			}
			catch(IOException e) {
//				System.out.println(result+" error");
				continue;
			}
		}
		searchResults.sort();
		searchResults.output();
	}
}