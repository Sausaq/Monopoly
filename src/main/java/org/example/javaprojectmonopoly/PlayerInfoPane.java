package org.example.javaprojectmonopoly;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PlayerInfoPane extends VBox {
    private final Label playerBalanceLabel;

    public PlayerInfoPane(String playerName) {
        Label playerNameLabel = new Label(playerName);
        this.playerBalanceLabel = new Label("Balance: $1000");

        setSpacing(10);
        setPadding(new Insets(10));
        setAlignment(Pos.CENTER_LEFT);

        getChildren().addAll(playerNameLabel, playerBalanceLabel);
    }

    public void updatePlayerBalance(int newBalance) {
        playerBalanceLabel.setText("Balance: $" + newBalance);
    }
}