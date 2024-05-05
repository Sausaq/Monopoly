package org.example.javaprojectmonopoly;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class рррр extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setPrefSize(600, 400);

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonBox.setPrefHeight(100);
        buttonBox.setPrefWidth(200);
        buttonBox.setSpacing(10);


        for (int i = 1; i <= 4; i++) {
            Button button = new Button(Integer.toString(i));
            button.setPrefSize(50, 50);
            button.setStyle("-fx-background-color: #0000FF; -fx-background-radius: 20; -fx-text-fill: #000000; -fx-font-size: 20px; -fx-font-weight: bold;");
            button.setPadding(new Insets(10));

            buttonBox.getChildren().add(button);
        }

        Label label = new Label("ВЫБЕРИТЕ КОЛИЧЕСТВО ИГРОКОВ");
        label.setPrefSize(262, 28);
        label.setStyle("-fx-background-color: #0000FF; -fx-background-radius: 10; -fx-font-size: 12; -fx-font-weight: bold;");

        Button startButton = new Button("START");
        startButton.setPrefSize(136, 48);
        startButton.setStyle("-fx-background-color: FFBD59; -fx-border-color: black; -fx-border-width: 3; -fx-background-radius: 10; -fx-border-radius: 10;");
        startButton.setPadding(new Insets(10));
        startButton.setFont(Font.font("Bodoni MT Black", 20));

        VBox.setMargin(startButton, new Insets(10));

        root.getChildren().addAll(buttonBox, label, startButton);

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("JavaFX App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

