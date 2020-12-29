package keyword;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		KeywordList kLst = new KeywordList();
		
		while(sc.hasNext()){
		    String cmd = sc.next();
		    switch(cmd){
	        	case "add":
	        	{
	        		String name = sc.next();
	        		int count = sc.nextInt();
	        		float weight = sc.nextFloat();
	        		Keyword k = new Keyword(name, count, weight);
	        		kLst.add(k);
	        		System.out.println("Done");
	        	}
	        		break;
	        	
	        	case "outputIndex":
	        	{
	        		int index = sc.nextInt();
            		kLst.outputIndex(index);
	        	}
	        		break;	
        	    
	        	case "outputName":
        	    {
	        		String name = sc.next();
	        		kLst.outputName(name);
        	    }
        	    	break;
        	    	
        	    case "deleteIndex":
        	    {
        	    	int index = sc.nextInt();
        	    	kLst.deleteIndex(index);       		
        	    }
        	    	break;
	    	    	
        	    case "deleteName":
	    	    {
		    		String name = sc.next();
		    		kLst.deleteName(name);	    		
	    	    }
	    	    	break;		
        	    	
        	    case "deleteAll":
        	    	kLst.deleteAll();       		
        	    	break;
        	    	
        	    
        	    default:
        	    	System.out.println("InvalidOperation2");       	    	      
		    }
		}
		sc.close();
	}

}

