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
	
	public void output(){
		
		for(int k=size()-1; k>-1;k--){	
			System.out.println(get(k).getUrl()+" "+get(k).getScore());	
		}
	}
	
}
