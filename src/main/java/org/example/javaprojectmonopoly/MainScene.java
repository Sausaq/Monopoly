package org.example.javaprojectmonopoly;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class MainScene extends StackPane {
    HBox boardAndUsers;
    ImageView background;
    GameBoard board;
    UserList playersList;

    public MainScene(ArrayList<Player> players){
        background = new ImageView("file:/D:/IntelijIDEA_Projects/JavaProjectMonopoly/src/main/resources/org/example/javaprojectmonopoly/background.png");
        boardAndUsers = new HBox();

        board = new GameBoard(players);
        HBox.setMargin(board, new Insets(0, 10, 0, 100));
        playersList = new UserList(board.getPlayers());
        boardAndUsers.getChildren().addAll(board, playersList);

        getChildren().addAll(background, boardAndUsers);
        for (int i = 0; i < board.getChildren().size(); i++) {
            System.out.println(board.getChildren().get(i) + "  " + i);
//            System.out.println( this.getChildren().get(i) + " " + i);
        }
    }
}
