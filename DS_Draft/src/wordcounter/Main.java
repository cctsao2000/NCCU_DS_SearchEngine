package wordcounter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import googleCrawler.Demo;
import keyword.Keyword;
import keyword.KeywordList;

public class Main {
	public static void main(String[] args) throws IOException {
		LinkedList<String> results= Demo.buildList();
		String keyword = "政治大學";
		for (String result:results) {
			WordCounter counter = new WordCounter(result);
			System.out.print(result+" ");
			System.out.print(counter.countKeyword(keyword));
			System.out.println();
		}
	}
}