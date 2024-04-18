package org.example.javaprojectmonopoly;

import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.Random;

public class Player extends StackPane implements Runnable {
    Circle circle = new Circle(10, Color.GREEN);
    String name;
    private int num = 0;
    private final double CELL_SIZE = 50;


    public Player(String name, int playerNum){
        this.name = name;
        getChildren().add(circle);

        switch (playerNum){
            case 1:
                setTranslateX(10);
                setTranslateY(10);
                break;
            case 2:
                setTranslateX(390);
                setTranslateY(10);
                break;
            case 3:
                setTranslateX(10);
                setTranslateY(390);
                break;
            case 4:
                setTranslateX(390);
                setTranslateY(390);
                break;
        }
    }

    public void moving(GameBoard board, int firstRandom, int secondRandom) {
        int step = firstRandom + secondRandom;
        num = (num + step) % 40;
        Cell current = (Cell) board.getChildren().get(num);

        animateMove(current.getLayoutX(), current.getLayoutY());
    }

    private void animateMove(double targetX, double targetY) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), this);
        transition.setToX(targetX - (CELL_SIZE / 2));
        transition.setToY(targetY - (CELL_SIZE / 2));
        transition.play();
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

    @Override
    public void run() {

    }
}
