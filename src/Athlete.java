import java.util.HashMap;

public class Athlete {

	  	private String score; // the score of every athlete
	    private Integer point; //the point of every athlete


	    /**
	     * Constructor
	     *
	     * @param AthleteID
	     * @param AthleteName
	     * @param AthleteState
	     * @param AthleteAge
	     */
	    public Athlete(String AthleteID, String AthleteName, String AthleteState, int AthleteAge) {
	        super(AthleteID, AthleteName, AthleteState, AthleteAge);
	    }

	    /**
	     * Constructor
	     * @param AthleteID
	     * @param AthleteName
	     * @param AthleteState
	     * @param AthleteAge
	     * @param score
	     */
	    public Athlete(String AthleteID, String AthleteName, String AthleteState, int AthleteAge, String score) {
	        super(AthleteID, AthleteName, AthleteState, AthleteAge);
	        this.score = score;
	    }

	    /**
	     * Constructor
	     * @param AthleteID
	     * @param AthleteName
	     * @param AthleteState
	     * @param AthleteAge
	     * @param point
	     */
	    public Athlete(String AthleteID, String AthleteName, String AthleteState, int AthleteAge, Integer point) {
	        super(AthleteID, AthleteName, AthleteState, AthleteAge);
	        this.point = point;
	    }

}
