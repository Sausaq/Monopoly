package org.example.javaprojectmonopoly;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import java.util.Random;

public class Player extends StackPane {
    Circle circle = new Circle(10, Color.GREEN);
    String name;
    private int num = 0;

    public Player(String name, int playerNum){
        this.name = name;
        getChildren().add(circle);

        switch (playerNum){
            case 1:
                setAlignment(circle, Pos.TOP_LEFT);
                setMargin(circle, new javafx.geometry.Insets(10, 0, 0, 10));
                break;
            case 2:
                setAlignment(circle, Pos.TOP_RIGHT);
                setMargin(circle, new javafx.geometry.Insets(10, 10, 0, 0));
                break;
            case 3:
                setAlignment(circle, Pos.BOTTOM_LEFT);
                setMargin(circle, new javafx.geometry.Insets(0, 0, 10, 10));
                break;
            case 4:
                setAlignment(circle, Pos.BOTTOM_RIGHT);
                setMargin(circle, new javafx.geometry.Insets(0, 10, 10, 0));
                break;
        }
    }

    public void moving(GameBoard board, int firstRandom, int secondRandom) {

        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), this);
        TranslateTransition transition2 = new TranslateTransition(Duration.seconds(1), this);
        TranslateTransition transition3 = new TranslateTransition(Duration.seconds(1), this);

//        int step = firstRandom + secondRandom;
        int step =  Integer.parseInt(((TextField)board.getChildren().get(46)).getText());
        int firstCoordinates = num;
        int secondCoordinates = (num + step) % 40;
        num = (num + step) % 40;


        Label label = (Label)board.getChildren().get(44);
        Label label2 = (Label)board.getChildren().get(45);
        label.setText(String.valueOf(firstRandom));
        label2.setText(String.valueOf(secondRandom));

        Cell nextCell = (Cell) board.getChildren().get(secondCoordinates);

        double endLayoutX = nextCell.getLayoutX();
        double endLayoutY = nextCell.getLayoutY();

        System.out.println(firstCoordinates + " " + secondCoordinates);
        System.out.println(getTranslateX() + " " + getTranslateY());
        System.out.println(endLayoutX + " " + endLayoutY);


        // Moving
        if (firstCoordinates <= 11 && secondCoordinates >= 13 && secondCoordinates <= 19){
            transition.setToX(((Cell) board.getChildren().get(12)).getLayoutX());

            transition.play();
            transition.setOnFinished(event -> {
                transition2.setToY(endLayoutY);
                transition2.play();
            });
        }else if (firstCoordinates <= 11 && secondCoordinates >= 19) {
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
        } else if(firstCoordinates <= 19 && secondCoordinates >= 21) {
            transition.setToY(((Cell) board.getChildren().get(20)).getLayoutY());

            transition.play();
            transition.setOnFinished(event -> {
                transition2.setToX(endLayoutX);

                transition2.play();
            });

        } else if(firstCoordinates <= 31 && secondCoordinates >= 33 && secondCoordinates <= 39) {
            transition.setToX(((Cell) board.getChildren().get(32)).getLayoutX());

            transition.play();
            transition.setOnFinished(event -> {
                transition2.setToY(endLayoutY);

                transition2.play();
            });
        }else if (firstCoordinates <= 31 && firstCoordinates >= 21 && secondCoordinates <= 11) {
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

//            firstCoordinates = 0;
        }else if(firstCoordinates <= 39 && firstCoordinates >= 33 && secondCoordinates <= 11) {
            transition.setToY(((Cell) board.getChildren().get(0)).getLayoutY());

            transition.play();
            transition.setOnFinished(event -> {
                transition2.setToX(endLayoutX);

                transition2.play();

            });
//            firstCoordinates = 0;
        } else {
            transition.setFromX(getTranslateX());
            transition.setFromY(getTranslateY());

            transition.setToX(endLayoutX);
            transition.setToY(endLayoutY);
            transition.play();
        }

    }



     public int[] rand(){
        Random rand = new Random();
        int[] twoRandomNumbers = {
                rand.nextInt(6) + 1,rand.nextInt(6) + 1
        };
        return twoRandomNumbers;
     }



    public int getNum() {
        return num;
    }
}
