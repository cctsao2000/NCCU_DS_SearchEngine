
public class SearchResult {
	
	private String url;
	private double score;
	private String name;
	
	public SearchResult(String url,String name,double score) {
		this.url = url;
		this.name = name;
		this.score = score;
	}
	
	public SearchResult(String url,String name) {
		this.url = url;
		this.name = name;
	}
	
	public double getScore() {
		return score;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getName() {
		return name;
	}
}
