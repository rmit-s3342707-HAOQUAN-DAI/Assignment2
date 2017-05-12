import java.io.IOException;
import java.util.ArrayList;

/*
 * Sprinter Class
 *
 * This class is Sprinter which read the Sprinter data from txt
 *
 * Author:
 */

public class Sprinter extends Athlete{

    private static final int COLUMN_NUM = 5;
	public static ArrayList<String[]> sprinter = new ArrayList<String[]>(); //sprinter athlete

    /**
     * Constructor
     *
     * @param participantID
     * @param participantName
     * @param participantState
     * @param participantAge
     */
    public Sprinter(String participantID, String participantName, String participantState, int participantAge) {
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
    public Sprinter(String participantID, String participantName, String participantState, int participantAge, String score) {
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
    public Sprinter(String participantID, String participantName, String participantState, int participantAge, Integer point) {
        super(participantID, participantName, participantState, participantAge, point);
    }

    /**
     * data reader of sprinter athlete
     * @throws IOException
     */
    public static void readSprinterdata() throws IOException {

        ArrayList<String[]> tempSp = LoadData.getLineList();

        for (int i = 0; i < tempSp.size(); i++) {
            if (tempSp.get(i)[1].equals("SPRINTER")) {
                String[] currCol = new String[COLUMN_NUM];
                for (int n = 0; n < COLUMN_NUM; n++) {
                    currCol[n] = tempSp.get(i)[COLUMN_NUM + n - 5];
                }
                sprinter.add(currCol);
            }
        }
    }

    /**
     * getter and setter of ArrayList sprinter
     * @return sprinter
     * @throws IOException
     */
    public static ArrayList<String[]> getSprinter() throws IOException {
        sprinter.clear();
        readSprinterdata();
        return sprinter;
    }

    public static void setSprinter(ArrayList<String[]> sprinter) {
        Sprinter.sprinter = sprinter;
    }
}
