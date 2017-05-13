import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;
import java.util.Map.Entry;

import Game.Cycling;
import Game.Games;
import Game.Running;
import Game.Swimming;
import Participants.Official;

/*
 * Engine Class
 *
 * This class is the main class activities done
 *
 * Author:HAOQUAN DAI
 */

public class Engine {

    private String type = null; //the type of the game selected
    private String referee = null; // the string stored the current referee
    private Timestamp timestamp;//timestamp to get the current system date
    private String[] s = new String[100];//a String store the game ID
    private int runTimes=0;// a integer to store the game run times
    private String GameID =null; // store the game id of game
    private String athleteName; //store athlete names

    public static HashMap<String, String> scoreMap = new HashMap<String, String>();//hashmap used to store the score and athlete data

    public ArrayList<Entry<String, String>> storeDecreasedScoreList = new ArrayList<>(); // an ArrayList to store the top 3 athlete

    private File storedData = new File("GameResults.txt"); // create a new file
    //the operator of the file
    private BufferedWriter out = new BufferedWriter(new FileWriter(storedData, true)); //true added 13/05

    public Engine() throws IOException {
        if (!storedData.exists()) {
            storedData.createNewFile();
        }// if the fire not exists,create new one
    }

    /**
     * get athlete score with different types
     *
     * @return scoreMap
     */
    public HashMap getAthleteScore() {

        String[] score = new String[Games.getAttendAthlete().size()];
        switch (type) {
            case "swimming":
                Swimming s = new Swimming();
                score = s.scores();
                break;
            case "cycling":
                Cycling c = new Cycling();
                score = c.scores();
                break;
            case "running":
                Running r = new Running();
                score = r.scores();
                break;
        }

        for (int i = 0; i < Games.getAttendAthlete().size(); i++) {

            scoreMap.put(Games.getAttendAthlete().get(i)[0], score[i]);

        }
        return scoreMap;
    }

    /**
     * startGame method which is responsible for game running and score calculate
     * sort the score of athlete
     * judge the prediction of user
     * allocate the score
     *
     * @return list
     * @throws IOException
     */
    public void startGame() throws IOException {
        runTimes++;
        storeDecreasedScoreList.clear();
        getAthleteScore().clear();
        getAthleteScore();
        ArrayList<Entry<String, String>> list = new ArrayList<>(scoreMap.entrySet());
        //use collection to sort
        Collections.sort(list, Comparator.comparing(Entry::getValue));

        //sort the list and get the decrease sort
        for (Entry<String, String> mapping : list) {

            System.out.println(mapping.getKey() + ":    " + mapping.getValue());
        }
        this.storeDecreasedScoreList = list;
        //judgePredictWinner();
    }

    /**
     * Print out the details of each game preparation
     *
     * @throws IOException
     */
    public void printDetails() throws IOException {

        timestamp = new Timestamp(System.currentTimeMillis());  //the run time of this game
        getRandomOfficial();

    }

    /**
     * print out the results of this game
     *
     * @throws IOException
     */
    public void generateGameID() throws IOException {
        for (int i = 0; i < 100; i++) {
            s[i] = String.format("%02d", i);
        }

        if (type.equals("swimming")) {
            GameID="S"+s[runTimes];
            out.write("S"+s[runTimes]+", ");
        } else if (type.equals("running")) {
            GameID="R"+s[runTimes];
            out.write("R"+s[runTimes]+", ");
        } else if (type.equals("cycling")) {
            GameID="C"+s[runTimes];
            out.write("C"+s[runTimes]+", ");
        }

    }

    /**
     * This method gather the game results of each game
     *
     * @return a LinkedHashMap (stored game data in order)
     * @throws IOException
     */
    public void saveResults() throws IOException {
        printDetails();
        generateGameID();
        out.write(referee + ", " + timestamp + "\r\n");
        //storeDecreasedScoreList.clear();

        // HashMap mapping athleteID,score and points of every athlete
        LinkedHashMap<Entry<String, String>, Integer> orderedScoreMap = new LinkedHashMap<>();
        orderedScoreMap.clear();

        //input the AthleteID,AthleteScore and AthletePoints into a linked ID
        // in which could printout in order
        orderedScoreMap.put(storeDecreasedScoreList.get(0), 5);
        orderedScoreMap.put(storeDecreasedScoreList.get(1), 2);
        orderedScoreMap.put(storeDecreasedScoreList.get(2), 1);
        int i = 3;
        while (i < Games.getAttendAthlete().size()) {
            orderedScoreMap.put(storeDecreasedScoreList.get(i), 0);
            i++;
        }
        //print out all the data in order
        for (Entry<Entry<String, String>, Integer> entryAll : orderedScoreMap.entrySet()) {
            String key = String.valueOf(entryAll.getKey());
            String s[] = key.split("=");
            int value = entryAll.getValue();
            out.write(s[0] + ", " + s[1] + ", " + value + "\r\n");
        }
        //storeDecreasedScoreList.clear();
        out.write("\r\n");
        out.flush(); // put into the file
    }

    /**
     * Show the athlete attending each game
     */
    public void loadAthleteInfo() throws IOException {
        switch (type) {
            case "swimming":
                Games.getAttendAthlete().clear();
                Swimming s = new Swimming();
                s.readDataFromAthlete();
                break;
            case "cycling":
                Games.getAttendAthlete().clear();
                Cycling c = new Cycling();
                c.readDataFromAthlete();
                break;
            case "running":
                Games.getAttendAthlete().clear();
                Running r = new Running();
                r.readDataFromAthlete();
                break;
        }
    }

    /**
     * get a random official to each game
     *
     * @throws IOException
     */
    public void getRandomOfficial() throws IOException {
        int i = (int) (Math.random() * Official.getOfficial().size());
        referee = new String(Official.getOfficial().get(i)[0]);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getGameID() {
        return GameID;
    }

    public void setGameID(String gameID) {
        GameID = gameID;
    }

    public ArrayList<Entry<String, String>> getStoreDecreasedScoreList() {
        return storeDecreasedScoreList;
    }

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}