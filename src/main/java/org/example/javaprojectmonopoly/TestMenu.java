package org.example.javaprojectmonopoly;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TestMenu extends VBox {
    private final Button gameStartButton = new Button("Start");
    private TextField numberOfPlayer = new TextField();

    public TestMenu(){
        setAlignment(Pos.CENTER);

        Label label = new Label("Count of Players (1-4)");
        numberOfPlayer.setMaxSize(90, 10);


        getChildren().addAll(gameStartButton, label, numberOfPlayer);

        gameStartButton.setDisable(true);


        numberOfPlayer.textProperty().addListener((observable, oldValue, newValue) -> {
            gameStartButton.setDisable(newValue.trim().isEmpty());
        });
    }

    public Button getGameStartButton() {
        return gameStartButton;
    }

    public int count() {
        if (!numberOfPlayer.getText().isEmpty()) {
            return Integer.parseInt(numberOfPlayer.getText());
        } else {
            return 0;
        }
    }
}
