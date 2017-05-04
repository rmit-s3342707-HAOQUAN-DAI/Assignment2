import java.io.IOException;
import java.util.ArrayList;

public abstract class Games {

	
	   public abstract void readDataFromAthlete() throws IOException; // abstract method to read total
	    // potential attending athletes

	    public static ArrayList<String[]> attendAthlete = new ArrayList<String[]>(); //attend athlete in every game
	    //stored current athlete attend games

	    public static final int COLUMN_NUM = 5; // column number if csv file


	    /**
	     * select random number athlete
	     *
	     * @param ad
	     * @return ArrayList attendAthlete
	     */
	    public void selectRandomAthlete(ArrayList<String[]> ad) {
	        ArrayList<Integer> judgeRepeatedList = new ArrayList<Integer>(); //a list used to judge if this row number is repeated
	        //judgeRepeatedList.clear();
	        int num = (int) (Math.random() * 4 + 4); //the number of athletes will attend the game
	        if (num < 4) {
	        } else {
	            for (int i = 0; i < num; i++) {
	                int rowNumber = (int) (Math.random() * (ad.size() - 1)); //select a random row in ArrayList passed in
	                if (judgeRepeatedList.contains(rowNumber)){
	                    i--;
	                }else{
	                    judgeRepeatedList.add(rowNumber);
	                }
	            }
	        }

	   
	    }

	    /**
	     * getter and setter of ArrayList attendAthlete
	     *
	     * @return attendAthlete
	     */
	    public static ArrayList<String[]> getAttendAthlete() {
	        return attendAthlete;
	    }

		public String[] scores() {
			// TODO Auto-generated method stub
			return null;
		}
}
