import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringPropertyBase;

/**
 * Author: HAOQUAN DAI
 */
public class GameRecord {

    private  SimpleStringProperty athleteID;
    private  SimpleStringProperty athleteScore;
    private  SimpleStringProperty points;
    
	
    /*
    public GameRecord(String aID, String aType, String aName, String atAge, String aState, String aScore, String poi) {
        this.athleteID = new SimpleStringProperty(aID);
        this.athleteScore = new SimpleStringProperty(aScore);
        this.points = new SimpleStringProperty(poi);
        this.type = new SimpleStringProperty(aType);
        this.Name = new SimpleStringProperty(aName);
        this.state = new SimpleStringProperty(aState);
        this.age = new SimpleStringProperty(atAge);
    }
    */
    
    public GameRecord(String aID, String aScore, String poi) {
    	this.athleteID = new SimpleStringProperty(aID);
    	this.athleteScore = new SimpleStringProperty(aScore);
    	this.points = new SimpleStringProperty(poi);
	}
	
	

	public String getAthleteID() {
        return athleteID.get();
    }

    public SimpleStringProperty athleteIDProperty() {
        return athleteID;
    }

    public void setAthleteID(String athleteID) {
        this.athleteID.set(athleteID);
    }
    
    
    public String getAthleteScore() {
        return athleteScore.get();
    }
    
    public SimpleStringProperty athleteScoreProperty() {
        return athleteScore;
    }

    public void setAthleteScore(String athleteScore) {
        this.athleteScore.set(athleteScore);
    }

    public String getPoints() {
        return points.get();
    }

    public SimpleStringProperty pointsProperty() {
        return points;
    }

    public void setPoints(String points) {
        this.points.set(points);
    }
}