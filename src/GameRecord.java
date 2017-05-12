import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringPropertyBase;

/**
 * Author: HAOQUAN DAI
 */
public class GameRecord {

    private  SimpleStringProperty athleteID;
    private  SimpleStringProperty athleteScore;
    private  SimpleStringProperty points;
   // private  SimpleStringProperty type;
    //private  SimpleStringProperty Name;
    //private  SimpleStringProperty state;
    //private  SimpleStringProperty age;
	

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
    
    /*
    public String getAthleteName() {
        return Name.get();
    }
     
    public SimpleStringProperty athleteNameProperty() {
        return Name;
    }
    
    public void setAthleteName(String athleteName) {
        this.Name.set(athleteName);
    }
    
    public String getAthleteAge() {
        return age.get();
    }

    public SimpleStringProperty athleteAgeProperty() {
        return age;
    }

    public void setAthleteAge(String athleteAge) {
        this.age.set(athleteAge);
    }
    
    public String getAthleteType() {
        return type.get();
    }
     
    public SimpleStringProperty athleteTypeProperty() {
        return type;
    }
    
    public void setAthleteType(String athleteType) {
        this.type.set(athleteType);
    }
    
    public String getAthleteState() {
        return state.get();
    }
     
    public SimpleStringProperty athleteStateProperty() {
        return state;
    }
    
    public void setAthleteState(String athleteState) {
        this.state.set(athleteState);
    }
    */
    
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