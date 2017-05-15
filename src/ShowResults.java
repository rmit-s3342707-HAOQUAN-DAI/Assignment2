import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import javafx.beans.property.SimpleStringProperty;

	public class ShowResults {
		private static final int COLUMN_NUM = 3;
		static ArrayList<String[]>  resultList = new ArrayList<String[]>(); //ArrayList used to store all results
		
		public static void getAllResults() throws IOException{
	    	 BufferedReader br2 = new BufferedReader(new FileReader("gameResults.txt"));
	         String result = "";
	         // Read a single line from the file until there are no more lines to read
	         while ((result = br2.readLine()) != null) {
	             StringTokenizer st2 = new StringTokenizer(result, ","); // using , to despite the content
	             String[] resultCol = new String[COLUMN_NUM]; // Each currCol has 3 fields
	             int i = 0;
	             while (st2.hasMoreTokens()) {
	             	resultCol[i++] = st2.nextToken();
	             }

	             resultList.add(resultCol);
	         }
	         br2.close();
	    	
	    }
	    
	    public static ArrayList<String[]> getResultList() throws IOException {
	    	resultList.clear();
	    	getAllResults();
			return resultList;	    	
	    }
	    
	  
}
