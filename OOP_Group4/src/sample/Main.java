package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

import java.io.File;

public class Main extends Application {

    public static Stage window;
    public static BorderPane mainScreen = new BorderPane(); //Layout designer for main menu
    public static Scene mainScene = new Scene(mainScreen, 950,500);
    ImageView splashBG = new ImageView(new Image("https://i.imgur.com/WnV4OFT.jpg"));
    //Scene to play game.
    public static BorderPane layout2 = new BorderPane();
    public static Scene playGame = new Scene(layout2,950,500);
    public static String musicFileName = "bestMusic.mp3";
    public static Media sound = new Media(new File(musicFileName).toURI().toString());
    public static MediaPlayer mediaPlayer = new MediaPlayer(sound);
    public int battleControlID = 0;
    public TextArea output = new TextArea();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); //Use FXml for formatting\
        window = primaryStage;
        window.setTitle("OOP Project 4 Game.");
        Button createBtn  = new Button("Create New Character.");
        Button exitBtn = new Button("Exit Game.");
        exitBtn.setOnAction(e -> closeProgram());
        //*************************************************************************
        //Using HBox for bottom of screen buttons
        HBox bottomBtns = new HBox(10);
        bottomBtns.getChildren().addAll(createBtn,exitBtn);
        bottomBtns.setPadding(new Insets(10,10,10,10));
        bottomBtns.setAlignment(Pos.BASELINE_CENTER);
        //Set up button functionality.
        createBtn.setOnAction(e -> {
            CreateNewChar.display();
        });
        //*************************************************************************

        mainScreen.setCenter(splashBG);
        mainScreen.setBottom(bottomBtns);
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);
        primaryStage.show();

        ////////////Start of playing the game//////////////////////
        int updatedID = battleControlID;
            if(battleControlID == 0){
                output.setText("Your adventure is just beginning...\n" +
                        "Click on \"Next Battle!\" in order to start your adventure!\n");
            }
            Button exitGame = new Button("Exit Game");
            exitGame.setOnAction(e -> {
                output.setText("Exiting now...");
                window.close();
            });
            Button newBattle = new Button("Next Battle!");
            newBattle.setOnAction(e -> {
                printLn("Searching for next battle...");
                battleControlID++;
                NextBattle(battleControlID);
            });
            Button attackBtn = new Button("Attack now!");
            attackBtn.setOnAction(e -> {
                //character.attack();
                printLn("Attacked!");
            });
            Button defendBtn = new Button("Defend now!");
            defendBtn.setOnAction(e -> {
                //character.defend();
                printLn("Defended!");
            });
            if(battleControlID == 1){
                printLn("You have reached your next battle!");
            }
            if(battleControlID == 2){
                printLn("You have reached the third window!");
            }
            //Layout Setup.
            HBox bottomBar = new HBox(20);
            bottomBar.setPadding(new Insets(15));
            bottomBar.setAlignment(Pos.BOTTOM_CENTER);
            bottomBar.getChildren().setAll(attackBtn,defendBtn,newBattle,exitGame);
            layout2.setCenter(output);
            layout2.setBottom(bottomBar);
            layout2.setPadding(new Insets(15));
    }

    private void NextBattle(int updatedBattleID){
        //Function that handles the story line.
        if(updatedBattleID == 1){
            printLn("Second Battle.");
        }
        if(updatedBattleID == 2){
            printLn("Third Battle");
        }
    }

    private void printLn(String line){
        output.appendText(line+"\n");
    }

    private void closeProgram() {
        window.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
