package org.example.javaprojectmonopoly;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class UserList extends VBox {
    public UserList(ArrayList<Player> players) {
        getChildren().add(new PlayerInfoPane(players.getFirst()));
        setMargin(getChildren().getFirst(), new Insets(0, 0, 0, 14));
        for (int i = 1; i < players.size(); i++) {
            getChildren().add(new PlayerInfoPane(players.get(i)));
            setMargin(getChildren().get(i), new Insets(17, 0, 0, 14));
        }

    }
}
