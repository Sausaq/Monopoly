package org.example.javaprojectmonopoly;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class Game extends StackPane {
    HBox boardAndUsers;
    ImageView background;
    GameBoard board;
    UserList playersList;

    public Game(ArrayList<Player> players){
        background = new ImageView(new Image(getClass().getResourceAsStream( "/org/example/javaprojectmonopoly/images/background.png")));
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
