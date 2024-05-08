package org.example.javaprojectmonopoly;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class PlayerInfoPane extends HBox {
    Label price;
    Player player;

    public PlayerInfoPane() {
    }

    public PlayerInfoPane(Player player) {
        this.player = player;
        Font beaumaris = Font.font(25);

        Rectangle rec = new Rectangle(460, 200);
        rec.setFill(Color.valueOf("#EFB800"));
        rec.setStroke(Color.BLACK);
        rec.setStrokeWidth(2);
        rec.setArcHeight(50);
        rec.setArcWidth(50);

        HBox playerInfo = new HBox();

        Circle circle = new Circle(55);
        circle.setFill(Color.valueOf(player.getColorCode()));
        circle.setStrokeWidth(2);
        circle.setStroke(Color.BLACK);
        Rectangle avatarBackground = new Rectangle(146, 146);
        avatarBackground.setFill(Color.valueOf("#FF3131"));
        avatarBackground.setArcWidth(50);
        avatarBackground.setArcHeight(50);
        avatarBackground.setStrokeWidth(2);
        avatarBackground.setStroke(Color.BLACK);
        StackPane avatar = new StackPane(avatarBackground, circle);
        HBox.setMargin(avatar, new Insets(0, 0, 0, 36));

        VBox nameAndPrice = new VBox();

        Rectangle nameBackground = new Rectangle(237, 66);
        nameBackground.setFill(Color.valueOf("#FF3131"));
        nameBackground.setArcWidth(50);
        nameBackground.setArcHeight(50);
        nameBackground.setStrokeWidth(2);
        nameBackground.setStroke(Color.BLACK);
        Label nameLabel = new Label(player.getName());
        nameLabel.setFont(beaumaris);

        StackPane name = new StackPane(nameBackground, nameLabel);
        VBox.setMargin(name, new Insets(30, 0, 0, 23));


        Rectangle priceBackground = new Rectangle(237, 66);
        priceBackground.setFill(Color.valueOf("#FF3131"));
        priceBackground.setArcWidth(50);
        priceBackground.setArcHeight(50);
        priceBackground.setStrokeWidth(2);
        priceBackground.setStroke(Color.BLACK);

        price = new Label("$ " + String.valueOf(player.getPrice()));
        price.setFont(Font.font(20));

        StackPane priceStackPane = new StackPane(priceBackground, price);
        priceStackPane.setAlignment(Pos.CENTER);

        VBox.setMargin(priceStackPane, new Insets(10,0,0,23));


        nameAndPrice.getChildren().addAll(name, priceStackPane);

        playerInfo.getChildren().addAll(avatar, nameAndPrice);

        StackPane stackPane = new StackPane(rec, playerInfo);
        stackPane.setMaxSize(900, 200);

        getChildren().add(stackPane);
    }

    public void updatePrice(){
        price.setText("$ " + String.valueOf(player.getPrice()));
    }

    public Label getPrice() {
        return price;
    }
}