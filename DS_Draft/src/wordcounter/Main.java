package wordcounter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		KeywordList kl1 = new KeywordList();
		Keyword k1 = new Keyword("nccu",5.0);
		Keyword k2 = new Keyword("學生",2.0);
		kl1.add(k1);
		kl1.add(k2);
		KeywordList filter = new KeywordList();
		Keyword f1 = new Keyword("netflix",0.0);
		Keyword f2 = new Keyword("youtube",0.0);
		Keyword f3 = new Keyword("movie",0.0);
		Keyword f4 = new Keyword("TV",0.0);
		filter.add(f1);
		filter.add(f2);
		filter.add(f3);
		filter.add(f4);
		Double score = 0.0;
		Double totalScore = 0.0;
		LinkedList<String> results= Demo.buildList();
		for (String result:results) {
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
				    	counter.getContent();
				    	if(counter.countKeyword(filt) != 0) {
				    		totalScore *= 0;
				    		break;
				    	}
					}
				}
			}
			catch(FileNotFoundException e){
				System.out.println(result+" error");
				continue;
			}
			catch(IOException e) {
				System.out.println(result+" error");
				continue;
			}
			if(totalScore == 0) {
				continue;
			}
			System.out.print(result+" ");
			System.out.print(totalScore);
			System.out.println();
			totalScore = 0.0;
		}
	}
}