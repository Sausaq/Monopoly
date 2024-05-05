package org.example.javaprojectmonopoly;

import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends StackPane {
    Rectangle border = new Rectangle();

    public Cell(){
        border.setFill(Color.valueOf("#FFBD59"));
        border.setStroke(Color.BLACK);
        border.setArcWidth(10);
        border.setArcHeight(10);
        setMargin(border, new Insets(1));

        getChildren().add(border);
    }

    public void setSize(int x, int y) {
        border.setHeight(y);
        border.setWidth(x);
    }
}

class AngleCell extends Cell {

    public AngleCell() {
        setSize(150, 150);
    }
}

class BoardYCell extends Cell {

    public BoardYCell() {
        setSize(150, 90);
    }
}

class Board extends Cell{

    public Board(){
        setSize(90, 150);
    }
}
