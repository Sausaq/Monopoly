package org.example.javaprojectmonopoly;

import javafx.scene.layout.VBox;

public class UserList extends VBox {
    public UserList() {
        getChildren().add(new UserInterface("madi"));
        getChildren().add(new UserInterface("sdfdsfasf"));
        getChildren().add(new UserInterface("Icon"));
        getChildren().add(new UserInterface("loma"));
    }
}
