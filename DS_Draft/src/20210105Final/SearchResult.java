
public class SearchResult {
	
	private String url;
	private double score;
	
	public SearchResult(String url,double score) {
		this.url = url;
		this.score = score;
	}
	
	public double getScore() {
		return score;
	}
	
	public String getUrl() {
		return url;
	}
}
