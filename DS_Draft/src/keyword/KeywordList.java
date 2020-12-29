package keyword;

public class KeywordList extends LinkedList<Keyword>{
	private LinkedList<Keyword> lst;
	
	public KeywordList(){
		this.lst = new LinkedList<Keyword>();
    }
	
	public void add(Keyword keyword){
		if (lst.size() == 0){
			lst.add(keyword);
		}
		else if (lst.size() == 1) {
			if (lst.get(0).count > keyword.count) {
				lst.add(1,keyword);
			}
			else {
				lst.add(0,keyword);
			}
		}
		else{
			int index = 0;
			for(int i = 0;i < lst.size();i++)
				if(lst.get(i).count <= keyword.count) {
					lst.add(0,keyword);
					break;
				}
				else if(i+1 == lst.size() && lst.get(i).count > keyword.count ) {
					lst.add(keyword);
					break;
				}
				else if ((lst.get(i).count > keyword.count) && (lst.get(i+1).count <= keyword.count)){
					index = i + 1;
					lst.add(index,keyword);
					break;
				}
				else {
					continue;
				}
		}
		lst.resetIndex();
    }
	
	public void outputIndex(int n){
		if(n>=lst.size()){
		    System.out.println("InvalidOperation");
		    return;
		}
		LinkedList<Keyword> results = new LinkedList<>();
		Keyword k = lst.get(n);		    
		results.add(k);		    		
		
		printKeywordList(results);	
	}
	
	public void outputName(String pattern){
		LinkedList<Keyword> results = new LinkedList<>();
		for(int i=0;i<lst.size();i++){
		    Keyword k = lst.get(i);
		    if(k.name.equals(pattern)){
		    	results.add(k);
		    }
		}
		if(results.isEmpty() == true){
		    System.out.println("NotFound");
		}else{
		    printKeywordList(results);
		}
	}
	
	public void deleteIndex(int n){
		if(n>=lst.size()){
		    System.out.println("InvalidOperation");
		    return;
		}
		lst.remove(n);
		System.out.println("Done");	
	}
	
	public void deleteName(String name){
		for(int i=0;i<lst.size();i++){
		    Keyword k = lst.get(i);
		    if(k.name.equals(name)){
		    	lst.remove(i);
		    	i--;
		    }
		}
		System.out.println("Done");
    }
	
	public void deleteAll(){
		lst = new LinkedList<Keyword>();
		System.out.println("Done");
    }
	
	public void printKeywordList(LinkedList<Keyword> kLst){
		kLst.printList();
    }
}