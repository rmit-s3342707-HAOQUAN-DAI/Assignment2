import java.io.IOException;
import java.util.ArrayList;




public class Official extends Athlete{
	
	public static ArrayList<String[]> official = new ArrayList<String[]>();//official list

	public Official(String AthleteID, String AthleteName, String AthleteState, int AthleteAge) {
		super(AthleteID, AthleteName, AthleteState, AthleteAge);
		// TODO Auto-generated constructor stub
	}
	
	
	 public static void readOfficialdata() throws IOException {
		 
	 }
	 
	 
	 public static ArrayList<String[]> getOfficial() throws IOException {
	        official.clear();
	        readOfficialdata();
	        return official;
	    }

	 public static void setOfficial(ArrayList<String[]> official) {
	        Official.official = official;
	    }

}
