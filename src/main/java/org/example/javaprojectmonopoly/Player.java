package org.example.javaprojectmonopoly;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Player extends StackPane implements Runnable {
    Circle circle = new Circle(10, Color.RED);
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

    public void moving(GameBoard board) {
        int step = rand() + rand();
        num = (num + step) % 40;

        Cell current = (Cell) board.getChildren().get(num);

        // Обновляем позицию игрока на игровом поле
        setTranslateX(current.getLayoutX());
        setTranslateY(current.getLayoutY());
    }
     public int rand(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
     }

    public int getNum() {
        return num;
    }

    @Override
    public void run() {

    }
}
