package org.example.javaprojectmonopoly;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class MyButton extends Button{

    public MyButton(String text, int width, int height) {
        this.setText(text);
        this.setPrefSize(width, height);
        this.setStyle("-fx-background-color: #FFBD59; -fx-background-radius: 30; -fx-border-color: black; -fx-border-width: 5; -fx-border-radius: 30;  -fx-font-size: 20;");
        this.setOnMouseEntered(e -> this.setStyle("-fx-background-color: #EFB800; -fx-background-radius: 30; -fx-border-color: black; -fx-border-width: 5; -fx-border-radius: 30; -fx-font-size: 20;")); // Красный при наведении
        this.setOnMouseExited(e -> this.setStyle("-fx-background-color: #FFBD59; -fx-background-radius: 30; -fx-border-color: black; -fx-border-width: 5; -fx-border-radius: 30; -fx-font-size: 20;")); // Возвращаем белый цвет
    }

    public MyButton(String text, int width, int height, Font font) {
        this.setText(text);
        this.setPrefSize(width, height);
        this.setStyle("-fx-background-color: #FFBD59; -fx-background-radius: 30; -fx-border-color: black; -fx-border-width: 5; -fx-border-radius: 30;  -fx-font-size: 20;");
        this.setOnMouseEntered(e -> this.setStyle("-fx-background-color: #EFB800; -fx-background-radius: 30; -fx-border-color: black; -fx-border-width: 5; -fx-border-radius: 30; -fx-font-size: 20;")); // Красный при наведении
        this.setOnMouseExited(e -> this.setStyle("-fx-background-color: #FFBD59; -fx-background-radius: 30; -fx-border-color: black; -fx-border-width: 5; -fx-border-radius: 30; -fx-font-size: 20;")); // Возвращаем белый цвет
        this.setFont(font);
    }

}
