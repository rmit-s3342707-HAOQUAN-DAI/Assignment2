package Participants;
/*
 * abstarct class Participant
 *
 * This method is used to define participant
 *
 * Author:
 */

public abstract class Participant {

    private String participantID;
    private String participantName;
    private String participantState;
    private String participantType;
    private int participantAge;

    /**
     * Constructor
     * @param participantID
     * @param participantName
     * @param participantState
     * @param participantAge
     */
    public Participant(String participantID, String participantType, String participantName, String participantState, int participantAge) {
        this.participantID = participantID;
        this.participantName = participantName;
        this.participantState = participantState;
        this.participantAge = participantAge;
        this.participantType = participantType;
    }

    //ArrayList<Participant> participants = new ArrayList<Participant>();

    /**
     * Getters and Setters
     */
    public String getParticipantID() {
        return participantID;
    }

    public void setParticipantID(String participantID) {
        this.participantID = participantID;
    }
    
    public String getParticipantType() {
        return participantType;
    }

    public void setParticipantType(String participantType) {
        this.participantType = participantType;
    }


    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }


    public String getParticipantState() {
        return participantState;
    }

    public void setParticipantState(String participantState) {
        this.participantState = participantState;
    }

    public int getParticipantAge() {
        return participantAge;
    }

    public void setParticipantAge(int participantAge) {
        this.participantAge = participantAge;
    }
}