package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class CreateNewChar {
    public static void display(){
        Stage windowCreateChar = new Stage();
        windowCreateChar.setResizable(false);
        //
        windowCreateChar.initModality(Modality.APPLICATION_MODAL);
        windowCreateChar.setTitle("Character Creation Screen");
        Label welcomeLabel = new Label("Welcome to character creation...");
        welcomeLabel.setAlignment(Pos.TOP_CENTER);
        welcomeLabel.setTextAlignment(TextAlignment.CENTER);
        Button saveBtn = new Button("Start your adventure now...");
        saveBtn.setOnAction(e -> {
            Main.window.setScene(Main.playGame);
            windowCreateChar.close();
            Main.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            Main.mediaPlayer.play();
        });
        Button exitBtn = new Button("Exit without saving.");
        exitBtn.setOnAction(e -> windowCreateChar.close());

        HBox bottomBtns = new HBox(10);
        bottomBtns.getChildren().setAll(saveBtn, exitBtn);
        bottomBtns.setAlignment(Pos.BOTTOM_CENTER);
        bottomBtns.setPadding(new Insets(10,10,10,10));

        HBox topLabel = new HBox(10);
        topLabel.setFillHeight(true);
        topLabel.getChildren().addAll(welcomeLabel);
        topLabel.setAlignment(Pos.TOP_CENTER);
        topLabel.setPadding(new Insets(10,10,10,10));

        GridPane createCharacter = new GridPane();
        //Column -> Row
        createCharacter.setPadding(new Insets(10,10,10,10));
        createCharacter.setHgap(10);
        createCharacter.setVgap(8);
        Label charNameLabel = new Label("Enter Character Name: ");
        TextField charName = new TextField();
        ComboBox charClass = new ComboBox();
        ComboBox charRelic = new ComboBox();
        Label chooseRelic = new Label("Choose your relic: ");
        Label chooseClass = new Label("Choose your class: ");
        charClass.getItems().addAll("Warrior","Mage","Ranger"); //Zontent
        charRelic.getItems().addAll("Health Stone (+50 Health)","Spiny Gloves (+5 Attack)","Dihn's Bulwark (+5 Defence)");
        GridPane.setConstraints(charNameLabel,0,0,1,1);
        GridPane.setConstraints(charName,1,0,1,1);
        GridPane.setConstraints(chooseClass,0,1,1,1);
        GridPane.setConstraints(charClass,1,1,1,1);
        GridPane.setConstraints(chooseRelic,0,2,1,1);
        GridPane.setConstraints(charRelic,1,2,1,1);
        createCharacter.getChildren().addAll(charNameLabel,charName,chooseClass,charClass,chooseRelic,charRelic);

        BorderPane creationScreen = new BorderPane();
        creationScreen.setTop(welcomeLabel);
        BorderPane.setAlignment(welcomeLabel,Pos.CENTER);
        creationScreen.setBottom(bottomBtns);
        BorderPane.setAlignment(bottomBtns,Pos.BOTTOM_CENTER);
        creationScreen.setCenter(createCharacter);
        BorderPane.setAlignment(createCharacter, Pos.CENTER);
        Scene charCreate = new Scene(creationScreen);
        windowCreateChar.setScene(charCreate);
        windowCreateChar.showAndWait();



    }
}
