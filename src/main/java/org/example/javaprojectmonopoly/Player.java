package org.example.javaprojectmonopoly;

import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import java.util.Random;

public class Player extends StackPane {
    PauseTransition pause = new PauseTransition(Duration.seconds(1));
    Circle circle = new Circle(10, Color.GREEN);
    private int index = 0;
    private String name;
    private int price = 1000;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Player(String name, int playerNum, Color color){
        getChildren().add(circle);
        this.name = name;
        circle.setFill(color);
        switch (playerNum){
            case 1:
                setAlignment(circle, Pos.TOP_LEFT);
                setMargin(circle, new javafx.geometry.Insets(25, 0, 0, 15));
                break;
            case 2:
                setAlignment(circle, Pos.TOP_RIGHT);
                setMargin(circle, new javafx.geometry.Insets(25, 80, 0, 0));
                break;
            case 3:
                setAlignment(circle, Pos.BOTTOM_LEFT);
                setMargin(circle, new javafx.geometry.Insets(0, 0, 75, 15));
                break;
            case 4:
                setAlignment(circle, Pos.BOTTOM_RIGHT);
                setMargin(circle, new javafx.geometry.Insets(0, 80, 75, 0));
                break;
        }
    }

    public void moving(GameBoard board, int firstRandom, int secondRandom) {
        if (!pause.getStatus().equals(Animation.Status.RUNNING)) {
            // Логика обработки первого нажатия
            System.out.println("Кнопка нажата");

            TranslateTransition transition = new TranslateTransition(Duration.seconds(1), this);
            TranslateTransition transition2 = new TranslateTransition(Duration.seconds(1), this);
            TranslateTransition transition3 = new TranslateTransition(Duration.seconds(1), this);

            int step = firstRandom + secondRandom;
            int firstCoordinates = index;
            int secondCoordinates = (index + step) % 40;
            index = (index + step) % 40;

            Label label = (Label) board.getChildren().get(40);
            Label label2 = (Label) board.getChildren().get(41);
            label.setText(String.valueOf(firstRandom));
            label2.setText(String.valueOf(secondRandom));

            Cell nextCell = (Cell) board.getChildren().get(secondCoordinates);

            double endLayoutX = nextCell.getLayoutX();
            double endLayoutY = nextCell.getLayoutY();

            System.out.println(firstCoordinates + " " + secondCoordinates);
            System.out.println(getTranslateX() + " " + getTranslateY());
            System.out.println(endLayoutX + " " + endLayoutY);


            // Moving
            if (firstCoordinates <= 11 && secondCoordinates >= 13 && secondCoordinates <= 19) {
                transition.setToX(((Cell) board.getChildren().get(12)).getLayoutX());

                transition.play();
                transition.setOnFinished(event -> {
                    transition2.setToY(endLayoutY);
                    transition2.play();
                });
            } else if (firstCoordinates <= 11 && secondCoordinates >= 19) {
                transition.setToX(((Cell) board.getChildren().get(12)).getLayoutX());
                transition.play();
                transition.setOnFinished(event -> {
                    transition2.setToY(((Cell) board.getChildren().get(20)).getLayoutY());
                    transition2.play();
                    transition2.setOnFinished(event1 -> {
                        transition3.setToX(endLayoutX);
                        transition3.play();
                    });
                });
            } else if (firstCoordinates <= 19 && secondCoordinates >= 21) {
                transition.setToY(((Cell) board.getChildren().get(20)).getLayoutY());

                transition.play();
                transition.setOnFinished(event -> {
                    transition2.setToX(endLayoutX);

                    transition2.play();
                });

            } else if (firstCoordinates <= 31 && secondCoordinates >= 33 && secondCoordinates <= 39) {
                transition.setToX(((Cell) board.getChildren().get(32)).getLayoutX());

                transition.play();
                transition.setOnFinished(event -> {
                    transition2.setToY(endLayoutY);

                    transition2.play();
                });
            } else if (firstCoordinates <= 31 && firstCoordinates >= 21 && secondCoordinates <= 11) {
                transition.setToX(((Cell) board.getChildren().get(32)).getLayoutX());
                transition.play();
                transition.setOnFinished(event -> {
                    transition2.setToY(((Cell) board.getChildren().get(0)).getLayoutY());
                    transition2.play();
                    transition2.setOnFinished(event1 -> {
                        transition3.setToX(endLayoutX);
                        transition3.play();
                    });

                });

            } else if (firstCoordinates <= 39 && firstCoordinates >= 32 && secondCoordinates <= 11) {
                transition.setToY(((Cell) board.getChildren().get(0)).getLayoutY());

                transition.play();
                transition.setOnFinished(event -> {
                    transition2.setToX(endLayoutX);

                    transition2.play();

                });
            } else {
                transition.setFromX(getTranslateX());
                transition.setFromY(getTranslateY());

                transition.setToX(endLayoutX);
                transition.setToY(endLayoutY);
                transition.play();
            }

            pause.playFromStart();
        }

    }

     public static int[] rand(){
        Random rand = new Random();
        int[] twoRandomNumbers = {
                rand.nextInt(6) + 1,rand.nextInt(6) + 1
        };
        return twoRandomNumbers;
     }



    public int getIndex() {
        return index;
    }
}
