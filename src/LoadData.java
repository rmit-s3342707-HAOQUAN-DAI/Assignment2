import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LoadData {
	
	
	public static final int COLUMN_NUM = 5;//the column of the csv file 
	static ArrayList<String[]> lineList = new ArrayList<String[]>();// ArrayList used to store the row of csv file
	
	
	public static void getTXTData() throws IOException {   //read the exact csv file data and return ArrayList
		
		BufferedReader br = new BufferedReader(new FileReader("Athlete.txt"));
        String line = "";
        // Read a single line from the file until there are no more lines to read
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, ","); // using , to despite the content
            String[] currCol = new String[COLUMN_NUM]; // Each currCol has 5 fields, so we need room for the 4 tokens.
            for (int i = 0; i < COLUMN_NUM; i++) { // For each token in the line that we've read:
                //First to determine whether the data to be read, to prevent overflow
                if (st.hasMoreTokens()) {
                    currCol[i] = st.nextToken();
                }
            }
            lineList.add(currCol);
        }
        br.close();
        
		
		
	}


	public static ArrayList<String[]> getLineList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
