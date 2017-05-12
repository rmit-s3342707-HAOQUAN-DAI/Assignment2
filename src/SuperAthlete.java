import java.io.IOException;
import java.util.ArrayList;


/*
 * superAthlete Class
 *
 * This class is superAthlete which read the superAthlete data from txt
 *
 * Author:
 */

public class superAthlete extends Athlete {

    private static final int COLUMN_NUM = 5;
	public static ArrayList<String[]> superathletes = new ArrayList<String[]>();// super athlete ArrayList

    /**
     * Constructor
     *
     * @param participantID
     * @param participantName
     * @param participantState
     * @param participantAge
     */
    public superAthlete(String participantID, String participantName, String participantState, int participantAge) {
        super(participantID, participantName, participantState, participantAge);
    }

    /**
     * Constructor
     *
     * @param participantID
     * @param participantName
     * @param participantState
     * @param participantAge
     * @param score
     */
    public superAthlete(String participantID, String participantName, String participantState, int participantAge, String score) {
        super(participantID, participantName, participantState, participantAge, score);
    }

    /**
     * Constructor
     *
     * @param participantID
     * @param participantName
     * @param participantState
     * @param participantAge
     * @param point
     */
    public superAthlete(String participantID, String participantName, String participantState, int participantAge, Integer point) {
        super(participantID, participantName, participantState, participantAge, point);
    }

    /**
     * data reader of superAthlete athlete
     * @throws IOException
     */
    public static void readSuperAthleteData() throws IOException {

        ArrayList<String[]> tempSa = LoadData.getLineList();

        for (int i = 0; i < tempSa.size(); i++) {
            if (tempSa.get(i)[1].equals("SUPERATHLETE")) {
                String[] currCol = new String[COLUMN_NUM];
                for (int n = 0; n < COLUMN_NUM; n++) {
                    currCol[n] = tempSa.get(i)[COLUMN_NUM + n - 5];
                }
                superathletes.add(currCol);
            }
        }
    }

    /**
     * getter and setter of ArrayList superAthlete
     * @return superAthlete
     * @throws IOException
     */
    public static ArrayList<String[]> getSuperathletes() throws IOException {
        superathletes.clear();
        readSuperAthleteData();
        return superathletes;
    }

    public static void setSuperathletes(ArrayList<String[]> superathletes) {
        superAthlete.superathletes = superathletes;
    }
}
