package org.example.javaprojectmonopoly;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class UserList extends VBox {
    public UserList() {
        getChildren().add(new PlayerInfoPane("Madi"));
        getChildren().add(new PlayerInfoPane("Akyl"));
        setMargin(getChildren().getFirst(), new Insets(0, 17, 17, 17));
        setMargin(getChildren().get(1), new Insets(17));

    }
}
