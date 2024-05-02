package org.example.javaprojectmonopoly;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.w3c.dom.events.Event;

public class Menu extends VBox {
    private final Button gameStartButton = new Button("Start");
    private int countOfPlayer;
    private TextField numberOfPlayer = new TextField("2");

    public Menu(){
        setAlignment(Pos.CENTER);

        Label label = new Label("Count of Players (1-4)");

        getChildren().addAll(gameStartButton, label, numberOfPlayer);

        gameStartButton.setDisable(true);
        countOfPlayer = Integer.parseInt(numberOfPlayer.getText());

        numberOfPlayer.textProperty().addListener((observable, oldValue, newValue) -> {
            gameStartButton.setDisable(newValue.trim().isEmpty());
        });
    }

    public Button getGameStartButton() {
        return gameStartButton;
    }

    public int count() {
        return Integer.parseInt(numberOfPlayer.getText());
    }
}
