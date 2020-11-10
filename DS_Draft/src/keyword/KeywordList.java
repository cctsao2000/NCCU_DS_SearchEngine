package keyword;

public class KeywordList extends LinkedList<Keyword>{
	private LinkedList<Keyword> lst;
	
	public KeywordList(){
		this.lst = new LinkedList<Keyword>();
    }
	
	public void add(Keyword keyword){
		//7. add keyword to proper index base on its count
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
	
	public void outputCount(int c){
		LinkedList<Keyword> results = new LinkedList<>();
		for(int i=0;i<lst.size();i++){
		    Keyword k = lst.get(i);
		    if(k.count == c){
		    	results.add(k);
		    }
		}
		if(results.isEmpty() == true){
		    System.out.println("NotFound");
		}else{
		    printKeywordList(results);
		}
    }
	
	public void outputHas(String pattern){
		LinkedList<Keyword> results = new LinkedList<>();
		for(int i=0;i<lst.size();i++){
		    Keyword k = lst.get(i);
		    if(k.name.contains(pattern)){
		    	results.add(k);
		    }
		}
		if(results.isEmpty() == true){
		    System.out.println("NotFound");
		}else{
		    printKeywordList(results);
		}
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
	
	public void outputFirstN(int n){
		if(n>lst.size()){
		    System.out.println("InvalidOperation");
		    return;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
		    Keyword k = lst.get(i);
		    if(i>0){
		    	sb.append(" ");
		    }
		    sb.append(k.toString());   
		}
		System.out.println(sb.toString());
    }
	
	public void outputScore(){
		float results = 0;
		for(int i=0;i<lst.size();i++){
		    Keyword k = lst.get(i);
		    results += k.weight * k.count;
		}
		
		System.out.println(results);
	}
	
	public void deleteIndex(int n){
		if(n>=lst.size()){
		    System.out.println("InvalidOperation");
		    return;
		}
		lst.remove(n);
		System.out.println("Done");	
	}
	
	public void deleteCount(int cnt){
		// 8. remove nodes that the count is equal to cnt
		for(int i=0;i<lst.size();i++){
		    Keyword k = lst.get(i);
		    if(k.count == cnt){
		    	lst.remove(i);
		    	i--;
		    }
		}
		System.out.println("Done");
    }
	
	public void deleteHas(String name){
		// 9. remove nodes that the name contains input name
		for(int i=0;i<lst.size();i++){
		    Keyword k = lst.get(i);
		    if(k.name.contains(name)){
		    	lst.remove(i);
		    	i--;
		    }
		}
		System.out.println("Done");
    }
	
	public void deleteName(String name){
		// 10. remove nodes that the name is equal to input name
		for(int i=0;i<lst.size();i++){
		    Keyword k = lst.get(i);
		    if(k.name.equals(name)){
		    	lst.remove(i);
		    	i--;
		    }
		}
		System.out.println("Done");
    }
	
	public void deleteFirstN(int n){
		//11. remove first n nodes
		if(n>=lst.size()){
		    System.out.println("InvalidOperation");
		    return;
		}
		while(n>0){
			lst.remove(n-1);
			n--;
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