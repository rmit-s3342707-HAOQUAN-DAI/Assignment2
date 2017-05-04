

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


public class Cyclist {

	 public static ArrayList<String[]> cyclist = new ArrayList<String[]>(); //cyclist arraylist

    /**
     * Constructor
     *
     * @param AthleteID
     * @param AthleteName
     * @param AthleteState
     * @param AthleteAge
     */
    public Cyclist(String AthleteID, String AthleteName, String AthleteState, int AthleteAge) {
        super(AthleteID, AthleteName, AthleteState, AthleteAge);
    }

    /**
     * Constructor
     *
     * @param AthleteID
     * @param AthleteName
     * @param AthleteState
     * @param AthleteAge
     * @param score
     */
    public Cyclist(String AthleteID, String AthleteName, String AthleteState, int AthleteAge, String score) {
        super(AthleteID, AthleteName, AthleteState, AthleteAge, score);
    }

    /**
     * Constructor
     *
     * @param AthleteID
     * @param AthleteName
     * @param AthleteState
     * @param AthleteAge
     * @param point
     */
    public Cyclist(String AthleteID, String AthleteName, String AthleteState, int AthleteAge, Integer point) {
        super(AthleteID, AthleteName, AthleteState, AthleteAge, point);
    }



    /**
     * getter and setter of ArrayList Cyclist
     * @return cyclist
     * @throws IOException
     */
    public static ArrayList<String[]> getCyclist() throws IOException {
        cyclist.clear();
        readCyclistData();
        return cyclist;
    }

    private static void readCyclistData() {
		// TODO Auto-generated method stub
		
	}

	public static void setCyclist(ArrayList<String[]> cyclist) {
        Cyclist.cyclist = cyclist;
    }
}
