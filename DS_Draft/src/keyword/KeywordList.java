package keyword;

import java.util.ArrayList;

public class KeywordList{
	private ArrayList<Keyword> lst;
	
	public KeywordList(){
		this.lst = new ArrayList<Keyword>();
    }
	
	public ArrayList<Keyword> getLst() {
		return lst;	
	}
	
	public boolean add(Keyword keyword){
		lst.add(keyword);
		return true;
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
		lst = new ArrayList<Keyword>();
		System.out.println("Done");
    }
}