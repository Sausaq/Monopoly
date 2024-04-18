package org.example.javaprojectmonopoly;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        GameBoard board = new GameBoard();
        Player player = new Player("Player1", 1);
        Player player2 = new Player("Player2", 2);

        board.addPlayer(player);
        board.addPlayer(player2);

        board.getChildren().add(player);
        board.getChildren().add(player2);

        Button button = new Button();


        board.add(button, 5, 5);


        board.add(new Label(), 4, 4);
        board.add(new Label(), 5, 4);

        button.setOnAction(event -> player.moving(board, player.rand()[0], player.rand()[1]));

        for (int i = 0; i < board.getChildren().size(); i++) {
            System.out.println( board.getChildren().get(i) + " " + i);
        }


        Scene scene = new Scene(board, 800, 800);

        primaryStage.setScene(scene);
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1500);
        primaryStage.setTitle("Monopoly Board");
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
