import java.util.Arrays;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class Main implements Comparable{

	public int compareTo(Object o) {
		return 0;
	}	
	
	
	private int binSearch(Comparable[] aList, Comparable key) {
		
		 int startIndex=0;
		    int lastIndex= aList.length -1;
		  while (startIndex<= lastIndex)
		  {
		    int mid= startIndex + (lastIndex-startIndex)/2;
		    int match=  aList[mid].compareTo( key);
		    if (match==0) 
		        return mid;  
		    if (match < 0) 
		        startIndex = mid + 1; 
		    else
		         lastIndex = mid - 1; 
		  }
		  return -1;
	}
	

	public static void main(String[] args) {
		CommandLine cmd = null;
		String type;
		int intKey = 0;
		Integer[] intList = null,OriginalIntList = null;
		String aList[],key,OriginalStringList[];		
		 int result;
		
		Options options = new Options();
		options.addOption(Option.builder("type").desc("List of elements").longOpt("type").numberOfArgs(1).build());
		options.addOption(Option.builder("key").desc("Element to Search").longOpt("key").numberOfArgs(1).build());
		options.addOption(Option.builder("list").desc("List of elements").longOpt("list").numberOfArgs(Option.UNLIMITED_VALUES).build());
		CommandLineParser parser = new DefaultParser();
		try {
			cmd=parser.parse(options,args);
		}
		catch(Exception e) {e.printStackTrace();}
		type=cmd.getOptionValue("type");
		key=cmd.getOptionValue("key");
		aList =cmd.getOptionValues("list");
		OriginalStringList=cmd.getOptionValues("list");
		 Main obj = new Main(); 
		
		if(type.equals("i"))
	    {
		try {
	        intKey = Integer.parseInt(key);
	        intList = new Integer[aList.length];
	        OriginalIntList = new Integer[aList.length];
	        for (int i = 0; i < aList.length; i++)
	        {
	            intList[i] = Integer.parseInt(aList[i]);
	            OriginalIntList[i] = Integer.parseInt(aList[i]);
	        }
	        }
			catch(Exception e) {System.out.println("Please enter integers to sort");}
		
			Arrays.sort(intList);
			     
		         result = obj.binSearch(intList, intKey);
	      
		         int keyindex=0;
		         if (result == -1)
		             System.out.println("The key was not found");   
		         else        
		         {
		             for (int i = 0; i < OriginalIntList.length; i++) {
		               if (OriginalIntList[i] ==intKey ) {              
		                   keyindex = i;
		                   break;
		               }
		             }
		             System.out.println("The Key is found at index "+keyindex);
		   }
	    }
	    else if(type.equals("s"))
	    {
	    		Arrays.sort(aList);
	        result = obj.binSearch(aList,key);
	        int keyindex=0;
	         if (result == -1)
	             System.out.println("The key was not found");   
	         else        
	         {
	             for (int i = 0; i <OriginalStringList .length; i++) {
	               if (OriginalStringList[i].equals(key)) {              
	                   keyindex = i;
	                   break;
	               }
	             }
	             System.out.println("The Key is found at index "+keyindex);
	   }
	        
	    }
	    else {System.out.println("Please enter a valid input");}
		
	}

	
}