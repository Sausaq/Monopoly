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

        playersList = new UserList();
        playersList.createUserList(players);
        board = new GameBoard(players, playersList);
        HBox.setMargin(board, new Insets(0, 10, 0, 75));
        boardAndUsers.getChildren().addAll(board, playersList);

        getChildren().addAll(background, boardAndUsers);
        setMargin(boardAndUsers, new Insets(30,0,0,0));
        for (int i = 0; i < board.getChildren().size(); i++) {
            System.out.println(board.getChildren().get(i) + "  " + i);
//            System.out.println( this.getChildren().get(i) + " " + i);
        }
    }
}
