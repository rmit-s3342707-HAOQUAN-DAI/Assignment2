import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.hsqldb.Table;

import Game.Games;

/*
 * Ozympic Class
 *
 * This class is the entrance of whole program
 * 
 * HAOQUAN
 */
public class Ozlympic extends Application {

    private static final EventHandler<ActionEvent> ActionEvent = null;
	Engine gameEngine = new Engine();
    private String predict_id = null; // the predition winner's id
    public static String Type = null; //record the type of game selected in toggle group
    private ArrayList<Map.Entry<String, String>> storeDecreasedScoreList = new ArrayList<>();// a Arraylist to store the ID and score
    //private ArrayList<String[]> storeAllResultList = new ArrayList<>();
    //private ArrayList<String[]> storeAllResultList;   
    
    //private final TableView<GameRecord> scoreTable = new TableView<>();
    private final ObservableList<GameRecord> data = FXCollections.observableArrayList();
    private final ObservableList<ResultTable> allResults = FXCollections.observableArrayList();

    private Button start = new Button("Start Game"); //create the start button
    private Button btnRestart =new Button("Restart"); //create the restart button
    private Button showResult = new Button("Show Result");//create the result button
    private Button showPoints = new Button("Show Points");//create the points button
    private Button exit = new Button("Exit");//create the points button
    
    public Ozlympic() throws IOException {

    }

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws IOException {
        Scene scene = new Scene(getFirstPage(), 500, 350);
        primaryStage.setTitle("Ozlympic Game"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.setResizable(false);
        primaryStage.show(); // Display the stage
    }

    protected VBox getFirstPage() throws IOException {
        // Hold two buttons in an HBox
        VBox titleInfo = new VBox();
        titleInfo.setSpacing(30);
        titleInfo.setAlignment(Pos.TOP_CENTER);
        titleInfo.setPadding(new Insets(20));

        //create the title of the game
        Text gameTitle = new Text(20, 20, "Welcome to the Ozlympic Game!");
        gameTitle.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 25));

        // create the text to welcome the player and ask the selection
        Text welcomeAndAsk = new Text(60, 60, "Please choose a game to play!");
        
        //Text author = new Text("s3342707");
        
        titleInfo.getChildren().addAll(gameTitle, welcomeAndAsk);
        
 
        ChoiceBox cb = new ChoiceBox((FXCollections.observableArrayList("Swimming", "Cycling", "Running"))); //choose game
        cb.setTooltip(new Tooltip("Select a Game"));
        cb.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> Type = ((String)newValue).toLowerCase());

        start.setAlignment(Pos.TOP_CENTER);
        start.setMinWidth(100);
        
        showResult.setAlignment(Pos.TOP_CENTER);
        showResult.setMinWidth(100);
        
        showPoints.setAlignment(Pos.TOP_CENTER);
        showPoints.setMinWidth(100);
        
        exit.setAlignment(Pos.TOP_CENTER);
        exit.setMinWidth(100);
        // return the type selected
        //group.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
        //    Type = group.getSelectedToggle().getUserData().toString();
        //});

        // Create and register the handler
        start.setOnAction((ActionEvent e) -> {
            if (cb.getValue() != null) {
                try {
                    getPredictStage();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else {
                Stage s1 = new Stage();
                Label warningMessage = new Label("Please select one game to start!");
                warningMessage.setAlignment(Pos.CENTER);
                Scene ss = new Scene(warningMessage, 250, 100);
                s1.setTitle("WARNING");
                s1.setScene(ss);
                s1.setResizable(false);
                s1.show();
            }
        });
        
        
        showResult.setOnAction((ActionEvent s) -> {
            try {
				showAllResultTable();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }); 
        

        showPoints.setOnAction((ActionEvent p) ->{
        	showTotalPointtable();
        });
       
            
        exit.setOnAction(a-> System.exit(0)); //exit app
        

       
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.getChildren().addAll(titleInfo, cb ,start, showResult , showPoints, exit);
        return vbox;
    }
    
    
    
    public void showAllResultTable() throws IOException{

    	Stage s3 = new Stage();
    	s3.setTitle("All Game Result");
    	s3.setResizable(false);
    	
    	//draw the table which is used to show results
       
        //TableView allResultTable = new TableView();

//        allResultTable.setEditable(false);
//        allResultTable.setPadding(new Insets(5));
        TextArea t1 = new TextArea();
       // t1.setFont(Font.font("Courier", 25));
        t1.appendText(ShowResults.getAllResults());
        t1.setPrefSize(300, 600);
        t1.setEditable(false);
        t1.setText(ShowResults.getAllResults());
        
        VBox root = new VBox(t1);
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        
        root.getChildren().add(t1);
        
       
//        Text allGameResult = new Text(20, 20, "All Game Results");
//        allGameResult.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 25));
//        TableView<ResultTable> AllResultTable = new TableView<>();
        
//        for (int i = 0; i < ShowResults.resultList.size(); i++) {
//
//        	allResults.add(new ResultTable("","",""));
//        	allResults.get(i).setAthleteID(ShowResults.resultList.get(i)[0]);
//        	allResults.get(i).setAthleteScore(ShowResults.resultList.get(i)[1]);
//        	allResults.get(i).setPoints(ShowResults.resultList.get(i)[2]);
//        	//System.out.println(ShowResults.resultList);
//        }
		
        
       // AllResultTable.setItems(allResults);
//        allResults.add(new ResultTable("", "",""));
//        int s = allResults.size() - 1;
//        allResults.get(s).getAthleteID();
     
                
        
//        TableColumn athleteIDCol = new TableColumn("Athlete ID");
//        athleteIDCol.setCellValueFactory(
//                new PropertyValueFactory<>("athleteID"));
//        
//        TableColumn athleteSpeedCol = new TableColumn("Time");
//        athleteSpeedCol.setCellValueFactory(
//                new PropertyValueFactory<>("athleteTime"));
//        
//        TableColumn athletePointCol = new TableColumn("Points");
//        athletePointCol.setCellValueFactory(
//                new PropertyValueFactory<>("athletePio"));
//        
//
//        //bind all data
//        allResultTable.setEditable(false);
//        allResultTable.getColumns().addAll(athleteIDCol,athleteSpeedCol, athletePointCol);
//        allResultTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//        allResultTable.setPadding(new Insets(5));
       
        
        Scene s2 = new Scene(root, 600, 380);
        s3.setScene(s2);
        s3.show();
        
    	
    }
    
    protected void showTotalPointtable(){
    	Stage s4 = new Stage();
    	s4.setTitle("Total Athlete Points");
    	s4.setResizable(false);
    	
        VBox vBox2 = new VBox();
        vBox2.setAlignment(Pos.TOP_CENTER);
        vBox2.setSpacing(10);
        vBox2.setPadding(new Insets(10));
        TableView totalPointTable = new TableView();

        totalPointTable.setEditable(false);
        totalPointTable.setPadding(new Insets(5));
  
        
        Text TotalPoints = new Text(20, 20, "Total Athlete Points");
        TotalPoints.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 25));
    	
    	
    	TableColumn athleteIDCol = new TableColumn("Athlete ID");
        athleteIDCol.setCellValueFactory(
                new PropertyValueFactory<>("athleteID"));
        
        TableColumn athletePointCol = new TableColumn("Total Points");
        athletePointCol.setCellValueFactory(
                new PropertyValueFactory<>("athletePio"));
        

        //bind all data
        totalPointTable.setEditable(false);
        totalPointTable.getColumns().addAll(athleteIDCol, athletePointCol);
        totalPointTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        totalPointTable.setPadding(new Insets(5));
        
        vBox2.getChildren().addAll(totalPointTable);
        
        Scene s3 = new Scene(vBox2, 300, 380);
        s4.setScene(s3);
        s4.show();
        
    }
    	
    
    protected void getResultsTable() {
        Stage s2 = new Stage();
        s2.setTitle("Game Results");
        s2.setResizable(false);

        //draw the table which is used to show results
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));

        //a label to show the results
        //create the title of the game
        Text gameResult = new Text(20, 20, "Game Results");
        gameResult.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 25));

        //create the table to store the data
        TableView<GameRecord> scoreTable = new TableView<>();
        scoreTable.setItems(data);

        TableColumn athleteIDCol = new TableColumn("Athlete ID");
        athleteIDCol.setCellValueFactory(
                new PropertyValueFactory<>("athleteID"));
        
        TableColumn athleteTypeCol = new TableColumn("Type");
        athleteTypeCol.setCellValueFactory(
                new PropertyValueFactory<>("athleteType"));
        
        TableColumn athleteAgeCol = new TableColumn("Age");
        athleteAgeCol.setCellValueFactory(
                new PropertyValueFactory<>("athleteAge"));
        
        TableColumn athleteStateCol = new TableColumn(" State");
        athleteStateCol.setCellValueFactory(
                new PropertyValueFactory<>("athleteState"));
        
        
       TableColumn athleteNameCol = new TableColumn("Name");
        athleteNameCol.setCellValueFactory(
                new PropertyValueFactory<>("athleteName"));
       
        
        TableColumn athleteScoreCol = new TableColumn("Score");
        athleteScoreCol.setCellValueFactory(
                new PropertyValueFactory<>("athleteScore"));
        
        TableColumn pointsCol = new TableColumn("Points");
        pointsCol.setCellValueFactory(
                new PropertyValueFactory<>("points"));

        //bind all data
        scoreTable.setEditable(false);
        scoreTable.getColumns().addAll(athleteIDCol,athleteTypeCol, athleteNameCol, athleteAgeCol, athleteStateCol, athleteScoreCol,pointsCol);
        scoreTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        scoreTable.setPadding(new Insets(5));

        btnRestart.setMinWidth(100);

        //add the detail of the game such as referee and play time
       // Text gameIdShowInfo =new Text();
        //Text refereeShowInfo =new Text();
        //Text timeStampShowInfo =new Text();
        

        //gameIdShowInfo.setText(gameEngine.getGameID());
        //refereeShowInfo.setText(gameEngine.getReferee());
        //timeStampShowInfo.setText(gameEngine.getTimestamp().toString());


        Label isPredicted;
        if (predict_id.equals(storeDecreasedScoreList.get(0).getKey()))
        {
            isPredicted = new Label("Congratulation, your prediction is right!");
        }
        else
        {
            isPredicted = new Label("Sorry, maybe next time you could predit the right athletes :)");
        }

        vBox.getChildren().addAll(gameResult, scoreTable,isPredicted,btnRestart);

        btnRestart.setOnAction(event -> s2.close());

        Scene ss = new Scene(vBox, 600, 380);
        s2.setScene(ss);
        s2.show();
        //return s2;
    }


    protected void getPredictStage() throws IOException {
        Stage predict = new Stage();

        VBox titleInfo = new VBox();
        titleInfo.setSpacing(10);
        titleInfo.setAlignment(Pos.TOP_CENTER);
        titleInfo.setPadding(new Insets(10));

        //create the title of the game
        Text predictTitle = new Text(20, 20, "Predict the winner.");
        predictTitle.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));
        titleInfo.getChildren().addAll(predictTitle);

        //Hold three radiobutton in gameselect vBox
        VBox winnerSelect = new VBox();
        winnerSelect.setSpacing(15);
        winnerSelect.setAlignment(Pos.TOP_CENTER);
        winnerSelect.setPadding(new Insets(5));

        //choice box to choose the winner

        gameEngine.setType(Type);
        gameEngine.loadAthleteInfo();
        gameEngine.startGame();
        gameEngine.saveResults();
        
       this.storeDecreasedScoreList= gameEngine.getStoreDecreasedScoreList();

        // add score to each record
        data.add(new GameRecord(storeDecreasedScoreList.get(0).getKey(),
                storeDecreasedScoreList.get(0).getValue(),"5"));
        data.add(new GameRecord(storeDecreasedScoreList.get(1).getKey(),
                storeDecreasedScoreList.get(1).getValue(),"2"));
        data.add(new GameRecord(storeDecreasedScoreList.get(2).getKey(),
                storeDecreasedScoreList.get(2).getValue(),"1"));

        for (int i = 3; i <Games.attendAthlete.size() ; i++) { //add 0 for the rest athletes
            data.add(new GameRecord(storeDecreasedScoreList.get(i).getKey(),
                    storeDecreasedScoreList.get(i).getValue(),"0"));
        }

        ChoiceBox<Object> cb = new ChoiceBox<>();
        for (int i = 0; i < Games.attendAthlete.size(); i++) {
            cb.getItems().addAll(FXCollections.observableArrayList(
                    Games.attendAthlete.get(i)[0] + " " + Games.attendAthlete.get(i)[1] + " "
                            + Games.attendAthlete.get(i)[2] + " " + Games.attendAthlete.get(i)[3] + " "
                            + Games.attendAthlete.get(i)[4]));
        }

        cb.setTooltip(new Tooltip("Select the winner!"));
        winnerSelect.getChildren().addAll(cb);

        //create the start button
        Button btnPredict = new Button("Predict");
        btnPredict.setPadding(new Insets(10));


        //Put in all elements to a VBox
        VBox wholePredictStage = new VBox();
        wholePredictStage.setSpacing(10);
        wholePredictStage.setAlignment(Pos.TOP_CENTER);
        wholePredictStage.getChildren().addAll(titleInfo, winnerSelect, btnPredict);

        // Create and register the handler
        btnPredict.setOnAction((ActionEvent e) -> {
            if (cb.getValue() == null)
            {
                predict_id = "";
            }
            else
            {
                String selection_item = (String)cb.getValue();
                predict_id = selection_item.split(" ")[0];
            }
            predict.close();
            getResultsTable();

        });

        Scene secondWindow = new Scene(wholePredictStage, 400, 180);
        predict.setTitle("Predict the winner!");
        predict.setScene(secondWindow);
        predict.setResizable(false);
        predict.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}