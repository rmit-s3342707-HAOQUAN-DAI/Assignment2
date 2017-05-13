package Participants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
 * loadData Class
 *
 * This class is used to read data from csv data file
 *
 * Author:
 */

public class LoadData {

    public static final int COLUMN_NUM = 5;//the column of the csv file
    static ArrayList<String[]> lineList = new ArrayList<String[]>();// ArrayList used to store the row of csv file
    static ArrayList<String[]> resultList = new ArrayList<String[]>(); //ArrayList used to store all results

    //read the exact csv file data and return ArrayList
    public static void getTXTData() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("participants.txt"));
        String line = "";
        // Read a single line from the file until there are no more lines to read
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, ","); // using , to despite the content
            String[] currCol = new String[COLUMN_NUM]; // Each currCol has 5 fields, so we need room for the 4 tokens.
            int i = 0;
            while (st.hasMoreTokens()) {
            	currCol[i++] = st.nextToken();
            }
//            for (int i = 0; i < COLUMN_NUM; i++) { // For each token in the line that we've read:
//                //First to determine whether the data to be read, to prevent overflow
//                if (st.hasMoreTokens()) {
//                    currCol[i] = st.nextToken();
//                }
//            }
            lineList.add(currCol);
        }
        br.close();
    }

    /**
     * getter and setter of ArrayList lineList
     * @return lineList
     * @throws IOException
     */
    public static ArrayList<String[]> getLineList() throws IOException { //clear linelist for new game
        lineList.clear();
        getTXTData();
        return lineList;
    }

    public static void setLineList(ArrayList<String[]> lineList) {
        LoadData.lineList = lineList;
    }
    
    public static void getAllResults() throws IOException{
    	 BufferedReader br2 = new BufferedReader(new FileReader("gameResults.txt"));
         String result = "";
         // Read a single line from the file until there are no more lines to read
         while ((result = br2.readLine()) != null) {
             StringTokenizer st2 = new StringTokenizer(result, ","); // using , to despite the content
             String[] resultCol = new String[COLUMN_NUM]; // Each currCol has 5 fields, so we need room for the 4 tokens.
             int i = 0;
             while (st2.hasMoreTokens()) {
             	resultCol[i++] = st2.nextToken();
             }

             resultList.add(resultCol);
         }
         br2.close();
    	
    }
    
    public static ArrayList<String[]> getResultList() throws IOException {
    	getAllResults();
		return resultList;
    	
    }
    
    

    /*
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
    
    */
}

