package org.example.javaprojectmonopoly;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class UserInterface extends HBox {
    ImageView icon = new ImageView();
    Label name = new Label("name");

    public UserInterface() {
    }

    public UserInterface( String name) {
        this.name.setText(name);

        getChildren().add(icon);
        getChildren().add(this.name);
    }
}
