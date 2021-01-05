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
		int pivot = rightbound;
		int i = leftbound;
		int j = rightbound-1;
		while (i!=j) {
			if(get(i).getScore() > get(pivot).getScore() && get(j).getScore() <= get(pivot).getScore()) {
				swap(i,j);
				i++;
				j--;
			}
			else if (get(i).getScore() > get(pivot).getScore() && get(j).getScore() >= get(pivot).getScore()) {
				j--;
			}
			else if (get(i).getScore() < get(pivot).getScore() && get(j).getScore() <= get(pivot).getScore()) {
				i++;
			}
			else {
				i++;
				j--;
			}
		}
		swap(i,pivot);
		pivot = i;
		quickSort(leftbound,pivot-1);
		quickSort(pivot+1,rightbound);
	}
	
	private void swap(int aIndex, int bIndex){
		SearchResult temp = get(aIndex);
		set(aIndex, get(bIndex));
		set(bIndex, temp);
	}
	
	public void output(){
		
		for(int k=0; k<size();k++){	
			System.out.println(get(k).getUrl()+" "+get(k).getScore());	
		}
	}
	
}
