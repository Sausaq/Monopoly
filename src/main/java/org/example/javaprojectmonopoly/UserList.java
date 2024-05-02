package org.example.javaprojectmonopoly;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class UserList extends VBox {
    public UserList(GameBoard board) {
        PlayerInfoPane playerInfoPane1 = new PlayerInfoPane(((Player)board.getChildren().get(42)).getName());
        PlayerInfoPane playerInfoPane2 = new PlayerInfoPane(((Player)board.getChildren().get(43)).getName());
        PlayerInfoPane playerInfoPane3 = new PlayerInfoPane(((Player)board.getChildren().get(44)).getName());
        PlayerInfoPane playerInfoPane4 = new PlayerInfoPane(((Player)board.getChildren().get(45)).getName());
        getChildren().add(playerInfoPane1);
        getChildren().add(playerInfoPane2);
        getChildren().add(playerInfoPane3);
        getChildren().add(playerInfoPane4);

        setMargin(getChildren().getFirst(), new Insets(0, 17, 17, 17));
        setMargin(getChildren().get(1), new Insets(17));
        setMargin(getChildren().get(2), new Insets(17));
        setMargin(getChildren().get(3), new Insets(17));

    }
}
