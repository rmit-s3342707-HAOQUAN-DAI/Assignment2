import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;
import java.util.Map.Entry;


/*
 * Engine Class
 *
 * This class is the main class activities done
 *
 * Author: HAOQUAN
 */

public class Engine {

    private String type = null; //the type of the game selected
    private String referee = null; // the string stored the current referee
    private Timestamp timestamp;//timestamp to get the current system date
    private String[] s = new String[100];//a String store the game ID
    private int runTimes=0;// a integer to store the game run times
    private String GameID =null; // store the game id of game

    public static HashMap<String, String> scoreMap = new HashMap<String, String>();//hashmap used to store the score and athlete data


    private File storedData = new File("GameResults.txt"); // create a new file
   
    public void startGame() throws IOException {
       
    }




    /**
     * Show the athlete attending each game
     */
    public void loadAthleteInfo() throws IOException {
        switch (type) {
	        case "cycling":
	            Games.getAttendAthlete().clear();
	            Cycling c = new Cycling();
	            c.readDataFromAthlete();
	            break;    
	            

        }
    }

 
}
