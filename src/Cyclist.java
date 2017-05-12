import java.io.IOException;
import java.util.ArrayList;

/*
 * Cyclist Class
 *
 * This class is Cyclist which read the cyclist data from txt
 *
 * Author:
 */

public class Cyclist extends Athlete{


    private static final int COLUMN_NUM = 0;
	public static ArrayList<String[]> cyclist = new ArrayList<String[]>(); //cyclist arraylist

    /**
     * Constructor
     *
     * @param participantID
     * @param participantName
     * @param participantState
     * @param participantAge
     */
    public Cyclist(String participantID, String participantName, String participantState, int participantAge) {
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
    public Cyclist(String participantID, String participantName, String participantState, int participantAge, String score) {
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
    public Cyclist(String participantID, String participantName, String participantState, int participantAge, Integer point) {
        super(participantID, participantName, participantState, participantAge, point);
    }


    /**
     * data reader of cyclist athlete
     * @throws IOException
     */
    public static void readCyclistData() throws IOException {

        ArrayList<String[]> tempCy = LoadData.getLineList();

        for (int i = 0; i < tempCy.size(); i++) {
            if (tempCy.get(i)[1].equals("CYCLIST")) {
                String[] currCol = new String[COLUMN_NUM];
                for (int n = 0; n < COLUMN_NUM; n++) {
                    currCol[n] = tempCy.get(i)[COLUMN_NUM + n - 5];
                }
                cyclist.add(currCol);
            }
        }
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

    public static void setCyclist(ArrayList<String[]> cyclist) {
        Cyclist.cyclist = cyclist;
    }
}

