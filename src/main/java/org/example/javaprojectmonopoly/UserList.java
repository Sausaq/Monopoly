package org.example.javaprojectmonopoly;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class UserList extends VBox implements UserListinterface{
    public UserList() {
    }

    @Override
    public void createUserList(ArrayList<Player> players) {
        getChildren().add(new PlayerInfoPane(players.get(0)));
        setMargin(getChildren().get(0), new Insets(0, 0, 0, 14));
        for (int i = 1; i < players.size(); i++) {
            getChildren().add(new PlayerInfoPane(players.get(i)));
            setMargin(getChildren().get(i), new Insets(17, 0, 0, 14));
        }
    }
}
