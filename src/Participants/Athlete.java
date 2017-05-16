package Participants;

import java.util.HashMap;

public class Athlete extends Participant{

    private String score; // the score of every athlete
    private Integer point; //the point of every athlete
    private static HashMap<String,Integer> AthletePointHashMap = new HashMap<>();

    /**
     * Constructor
     *
     * @param participantID
     * @param participantName
     * @param participantState
     * @param participantAge
     */
    public Athlete(String participantID, String participantType, String participantName, String participantState, int participantAge) {
        super(participantID, participantType, participantName, participantState, participantAge);
    }

    /**
     * Constructor
     * @param participantID
     * @param participantName
     * @param participantState
     * @param participantAge
     * @param score
     */
    public Athlete(String participantID, String participantType, String participantName, String participantState, int participantAge, String score) {
        super(participantID, participantType, participantName, participantState, participantAge);
        this.score = score;
    }

    /**
     * Constructor
     * @param participantID
     * @param participantName
     * @param participantState
     * @param participantAge
     * @param point
     */
    public Athlete(String participantID, String participantType, String participantName, String participantState, int participantAge, Integer point) {
        super(participantID, participantType, participantName, participantState, participantAge);
        this.point = point;
    }


    /**
     * getters and setters
     * @return
     */
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public static HashMap<String, Integer> getAthletePointHashMap() {
        return AthletePointHashMap;
    }

//    public void setAthletePointHashMap(HashMap<String, Integer> athletePointHashMap) {
//        AthletePointHashMap = athletePointHashMap;
//    }
}