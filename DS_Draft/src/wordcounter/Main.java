package wordcounter;

import java.io.IOException;
import java.util.LinkedList;
import googleCrawler.Demo;
import keyword.Keyword;
import keyword.KeywordList;

public class Main {
	public static void main(String[] args) throws IOException {
		KeywordList kl1 = new KeywordList();
		Keyword k1 = new Keyword("博客來",5.0);
		Keyword k2 = new Keyword("書局",2.0);
		Double score = 0.0;
		Double totalScore = 0.0;
		kl1.add(k1);
		kl1.add(k2);
		LinkedList<String> results= Demo.buildList();
		for (String result:results) {
			for (Keyword key:kl1.getLst()) {
		    	String keyword = key.name;
		    	WordCounter counter = new WordCounter(result);
		    	counter.getContent();
				score = counter.countKeyword(keyword) * key.weight;
				totalScore += score;
			}
			System.out.print(result+" ");
			System.out.print(totalScore);
			System.out.println();
		}
	}
}