package org.example.javaprojectmonopoly;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class UserList extends VBox {
    public UserList(ArrayList<Player> players) {
        getChildren().add(new PlayerInfoPane(players.getFirst().getName()));
        setMargin(getChildren().getFirst(), new Insets(0, 17, 17, 17));
        for (int i = 1; i < players.size(); i++) {
            getChildren().add(new PlayerInfoPane(players.get(i).getName()));
            setMargin(getChildren().get(i), new Insets(17));
        }

    }
}
