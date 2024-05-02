package org.example.javaprojectmonopoly;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {

        MainScene gameWindow = new MainScene();
        Menu menuBar = new Menu();

        Scene menu = new Scene(menuBar);
        primaryStage.setScene(menu);
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1500);
        primaryStage.setTitle("Monopoly Board");
        primaryStage.show();

        menuBar.getGameStartButton().setOnAction(event -> {
            GameBoard board = new GameBoard(menuBar.count());
            UserList playersList = new UserList(board);
            gameWindow.getChildren().addAll(board, playersList);

            Scene scene = new Scene(gameWindow, 800, 800);
            primaryStage.setScene(scene);

            for (int i = 0; i < board.getChildren().size(); i++) {
                System.out.println(board.getChildren().get(i) + "  " + i);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

