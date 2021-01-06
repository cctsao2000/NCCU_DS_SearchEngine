import java.util.ArrayList;

public class SRList extends ArrayList<SearchResult>{
	//quick sort
	public void sort(){
		quickSort(0, size()-1);
	}
	
	private void quickSort(int leftbound, int rightbound){
		if (leftbound >= rightbound) {
			return;
		}
		int i = leftbound;
		int j = rightbound;
		double pivot = get(leftbound).getScore();
		
		while (i!=j) {
			while(get(j).getScore() > pivot && i < j) {
				j -= 1;
			}
			while(get(i).getScore() <= pivot && i < j) {
				i += 1;
			}
			if (i < j) {
				swap(i,j);
			}
		}
		swap(leftbound,i);
		quickSort(leftbound,i-1);
		quickSort(i+1,rightbound);
	}
	
	private void swap(int aIndex, int bIndex){
		SearchResult temp = get(aIndex);
		set(aIndex, get(bIndex));
		set(bIndex, temp);
	}
	
	public String output(){
		String outRes = "";
		for(int k=size()-1; k>-1;k--){	
			outRes += String.format("<label style=\"font-size:12px;padding-left:55px;max-width:600px;overflow:hidden;\">%s</label><br>%n<a href='%s' target=\"_blank\" class=\"link\">%s</a> %.0f<br><br><br>",get(k).getUrl().split("&sa")[0],get(k).getUrl().split("&sa")[0],get(k).getName(),get(k).getScore());	
		}
		return outRes;
	}
	
}
