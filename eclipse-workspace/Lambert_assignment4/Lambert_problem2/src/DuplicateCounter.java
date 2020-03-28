import java.io.File;

import java.util.Scanner;

import java.io.PrintWriter;

import java.util.Map;

import java.util.HashMap;

import java.io.FileNotFoundException;



public class DuplicateCounter {
	
	 private Map<String, Integer> wordCounter;
	   
	   public DuplicateCounter(){
	       wordCounter = new HashMap<String,Integer>();
	   }
	   
   
   public void count(String datafile){
      
	   
	   Scanner file = null;
       try {
    	   file = new Scanner(new File(datafile));
       } 
       
       catch (FileNotFoundException exc) {
    	   System.out.println("It looks like there was an error");
   		System.exit(0);
       }
       
       
       while(file.hasNext()) {
           String word = file.next().toLowerCase();
           Integer count = wordCounter.get(word); 
           if(count == null)
               count = 1;
           
           else
               count = count + 1;
           
           
           wordCounter.put(word, count);
       }
       file.close();
   }
   
  
  
  
   public void write(String outpufile){
      
	   try {
           PrintWriter file2 = new PrintWriter(new File(outpufile));
           
           for(String word : wordCounter.keySet()) 
               file2.println(word + " " + wordCounter.get(word));
           
          
           
           file2.close();
           
       } catch (FileNotFoundException exc) {
    	   System.out.println("It looks like there was an error");
      		System.exit(0);
       }
   }
  
}
