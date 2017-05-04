import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


public class Ozlympic extends Application {
	
	
	
	
	 private Button start = new Button("Start Game"); //create the start button
	 private Button btnRestart =new Button("Restart"); //create the restart button

	@Override //Override the start method in the Application class
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		 Scene scene = new Scene(getFirstPage(), 500, 300);
	        primaryStage.setTitle("Ozlympic Game"); // Set the stage title
	        primaryStage.setScene(scene); // Place the scene in the stage
	        primaryStage.setResizable(false);
	        primaryStage.show(); // Display the stage
	}

	private Parent getFirstPage() {
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
        titleInfo.getChildren().addAll(gameTitle, welcomeAndAsk);

        ChoiceBox cb = new ChoiceBox((FXCollections.observableArrayList("Swimming", "Cycling", "Running")));
        cb.setTooltip(new Tooltip("Select a Game"));
        cb.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> Type = ((String)newValue).toLowerCase());

        start.setAlignment(Pos.TOP_CENTER);
        start.setMinWidth(100);

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
                Label warningMessage = new Label("Please select one game!");
                warningMessage.setAlignment(Pos.CENTER);
                Scene ss = new Scene(warningMessage, 250, 100);
                s1.setTitle("WARNING");
                s1.setScene(ss);
                s1.setResizable(false);
                s1.show();
            }
        });

        //BorderPane created,put the hBox into the boarderPane
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.getChildren().addAll(titleInfo, cb ,start);
        return vbox;
	}

	private void getPredictStage() {
		// TODO Auto-generated method stub
		
	}

}
