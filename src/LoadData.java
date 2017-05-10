import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadData {
	
	
	public static final int COLUMN_NUM = 5;//the column of the csv file 
	static ArrayList<String[]> lineList = new ArrayList<String[]>();// ArrayList used to store the row of csv file
	
	
	public static void getTXTData() throws IOException {   //read the exact csv file data and return ArrayList
		
		BufferedReader br = new BufferedReader(new FileReader("participants.txt"));
        String line = "";
        
        
		
		
	}
	
	
	
	
	
}
