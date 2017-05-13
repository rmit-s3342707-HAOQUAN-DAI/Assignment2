package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fileReader {
    
	public static void getAllResult() throws IOException{
    	
    	BufferedReader b = null; 
    	String results;
    	try {
    		b = new BufferedReader(new FileReader("gameResults.txt"));
    		
    		while((results = b.readLine()) != null){
    			System.out.print(results);
    		}
    	}catch (IOException e)
    	{
    		
    		e.printStackTrace();
    	}
    }
}
