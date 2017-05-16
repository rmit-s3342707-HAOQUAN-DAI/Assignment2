import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map.Entry;


	public class ShowResults {
//		private static final int COLUMN_NUM = 3;
//		static ArrayList<String>  resultList = new ArrayList<String>(); //ArrayList used to store all results
		
		
		public static String getAllResults() throws IOException {
			BufferedReader input = new BufferedReader(new FileReader("gameResults.txt"));
			String line = null;
			try {
				//BufferedReader input = new BufferedReader(new FileReader("output.txt"));
				line = new String();
				line = input.readLine();

				while (line != null) {
					
					line = input.readLine();
				}
				input.close();

			} catch (IOException e) {
				System.err.println("File Reading Error!");
				System.exit(0);
			}
//			List<String> lines = new ArrayList<String>();
//			String line;
//			try{
//				BufferedReader br = new BufferedReader(new FileReader("gameResults.txt"));
//				while((line = br.readLine())!=null){
//					lines.add(line);
//				}
//				br.close();
//			}catch (IOException e){
//				e.printStackTrace();
//			}
//			
//			return lines;
//			
//		}
			return line;

			/*
	        BufferedReader br = new BufferedReader(new FileReader("gameResults.txt"));
	        String line = "";
	        // Read a single line from the file until there are no more lines to read
	        String currCol=null;
	        while ((line = br.readLine()) != null) {
	            StringTokenizer st = new StringTokenizer(line, ","); // using , to despite the content
	            currCol = new String(); // Each currCol has 5 fields
	            //System.out.println(line);
	            
	            int i = 0;
	            while (st.hasMoreTokens()) {
	            	
	            	currCol+=line; //st.nextToken().toString()
	            	//System.out.println(currCol);
	            }
//	            for (int i = 0; i < COLUMN_NUM; i++) { // For each token in the line that we've read:
//	                //First to determine whether the data to be read, to prevent overflow
//	                if (st.hasMoreTokens()) {
//	                    currCol[i] = st.nextToken();
//	                }
//	            }
	            //resultList.add(currCol);
	            //System.out.println(resultList);
	        }
	        br.close();
			return currCol;
	    }
	    */
//	    public static ArrayList<String> getResultList() throws IOException {
//	    	resultList.clear();
//	    	getAllResults();
//			return resultList;	    	
//	    }
		}
	  
}
