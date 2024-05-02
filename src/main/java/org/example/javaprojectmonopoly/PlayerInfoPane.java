package org.example.javaprojectmonopoly;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class PlayerInfoPane extends HBox {
    private ImageView icon;
    private Label playerBalanceLabel;
    private VBox nameAndBalance;
    private int price;
    private String name;

    public PlayerInfoPane() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerInfoPane(String name) {
        icon = new ImageView("file:/D:/IntelijIDEA_Projects/JavaProjectMonopoly/src/main/java/org/example/javaprojectmonopoly/images/img.png");
        icon.setFitWidth(157);
        icon.setFitHeight(157);
        setMaxWidth(500);
        setMaxHeight(230);

        setBackground(Background.fill(Color.RED));
        setBorder(Border.stroke(Color.GREEN));
        this.name = name;
        Label playerNameLabel = new Label(this.name);
        playerNameLabel.setFont(Font.font(36.8));

        this.playerBalanceLabel = new Label("Balance: " + price);
        this.playerBalanceLabel.setFont(Font.font(34));

        setSpacing(10);
        setPadding(new Insets(10));
        setAlignment(Pos.CENTER_LEFT);


        getChildren().addAll(icon, new VBox(playerNameLabel, playerBalanceLabel));
    }

    public void updatePlayerBalance(int newBalance) {
        playerBalanceLabel.setText("Balance: $" + newBalance);
    }
}