import java.io.File;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.io.FileWriter;

import java.util.HashSet;

import java.util.Iterator;

import java.util.Scanner;

import java.util.Set;

public class DuplicateRemover {
	  private Set<String> uniqueWords;
	  

public void remove(String dataFile) {
	  
		 String word;
	     uniqueWords = new HashSet<String>();
	  
	  
	  Scanner file = null;
	try {
		file = new Scanner(new File(dataFile));
	} 
	
	catch (FileNotFoundException exc) {
		exc.printStackTrace();
		System.out.println("It looks like there was an error");
		System.exit(0);
	}
	  while(file.hasNext())
	       {
	        word=file.next();
	           uniqueWords.add(word);
	       }
	       file.close();
	      
	      
	   }
	  
public void Write(String outputFile)  {
	File file;
	FileWriter writer;

	writer = null;
	file = new File(outputFile);
	
	
	if(file.exists()) {
	try {
		writer=new FileWriter(file,true);
	} catch (IOException e) {
		e.printStackTrace();
	}
	Iterator<String> itrator=uniqueWords.iterator();

	while(itrator.hasNext()) {
	   String str=(String)itrator.next();
	   try {
		   
		   writer.write(str);
		} 
	   
	   catch (IOException e) {
		e.printStackTrace();
	  }     
	
	
	}
	
	try {
		writer.close();
	} 
	catch (IOException e) {
		e.printStackTrace();
	
	}
	
	
	System.out.println("Data was dritten to the file");
	  
	}
	else
	{
	try {
		file.createNewFile();
	} catch (IOException exc) {
		exc.printStackTrace();
	}
	try {
		writer=new FileWriter(file);
	} catch (IOException exc) {
		exc.printStackTrace();
	}
	Iterator<String> itrator=uniqueWords.iterator();

	while(itrator.hasNext())
	{
	   String str=(String)itrator.next();
	   try {
		writer.write(str+"\n");
	} catch (IOException exc) {
		exc.printStackTrace();
	}     
	}
	try {
		writer.close();
	} catch (IOException exc) {
		exc.printStackTrace();
	}
	
	
	System.out.println("Data was dritten to the file");
	
	
	}

	  
	   
	   }



}
