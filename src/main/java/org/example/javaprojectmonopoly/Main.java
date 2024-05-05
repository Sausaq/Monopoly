package org.example.javaprojectmonopoly;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.security.Key;
import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        DBManager.connect();

        TestMenu menuBar = new TestMenu();
        Menu menu = new Menu(DBManager.getAllPlayers());

        NewPlayerMenu newPlayerMenu = new NewPlayerMenu();
        Scene scene = new Scene(newPlayerMenu, 1500, 900);

        Scene menuScene = new Scene(menu);
//        menuScene.getStylesheets().add(getClass().
//        getResource("file:/D:/IntelijIDEA_Projects/JavaProjectMonopoly/src/main/java/org/exampl/javaprojectmonopoly/css/scrollPane.css").toExternalForm());

        primaryStage.setScene(menuScene);
        primaryStage.setHeight(900);
        primaryStage.setWidth(1500);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.valueOf("Esc"));
        primaryStage.setFullScreenExitHint("");
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Monopoly Board");
        primaryStage.show();

//        menuBar.getGameStartButton().setOnAction(event -> {
//            MainScene gameWindow = new MainScene(menuBar.count());
//            Scene scene2 = new Scene(gameWindow, 1500, 900);
//            primaryStage.setScene(scene2);
//        });

        menu.getNewPlayerButton().setOnAction(e -> primaryStage.setScene(scene));
        newPlayerMenu.getCancelButton().setOnAction(b -> primaryStage.setScene(menuScene));
        newPlayerMenu.getCreate().setOnAction(c -> primaryStage.setScene(menuScene));

        menu.getStartButton().setOnAction(event -> {
            MainScene gameWindow = new MainScene(menu.getAddedPlayers());
            Scene scene2 = new Scene(gameWindow, 1500, 900);
            primaryStage.setScene(scene2);
        });



    }

    public static void main(String[] args) {
        launch(args);
    }
}

