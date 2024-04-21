package org.example.javaprojectmonopoly;

import javafx.scene.layout.VBox;

public class UserList extends VBox {
    public UserList() {
        getChildren().add(new PlayerInfoPane("Madi"));
        getChildren().add(new PlayerInfoPane("Akyl"));
    }
}
