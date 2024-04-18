package org.example.javaprojectmonopoly;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GameBoard extends GridPane {
    private final int rows = 18; // Количество строк на доске
    private final int cols = 13; // Количество столбцов на доске
    private Pane playersContainer;

    public GameBoard() {
        super();
        initialize();
        playersContainer = new Pane();
        getChildren().add(playersContainer);
    }

    private void initialize() {

        add(new AngleCell(), 0,0);

        add(new Board(), 1,0);
        add(new Board(), 2,0);
        add(new Board(), 3,0);
        add(new Board(), 4,0);
        add(new Board(), 5,0);
        add(new Board(), 6,0);
        add(new Board(), 7,0);
        add(new Board(), 8,0);
        add(new Board(), 9,0);
        add(new Board(), 10,0);
        add(new Board(), 11,0);

        add(new AngleCell(), 12,0);

        add(new BoardYCell(), 12,1);
        add(new BoardYCell(), 12,2);
        add(new BoardYCell(), 12,3);
        add(new BoardYCell(), 12,4);
        add(new BoardYCell(), 12,5);
        add(new BoardYCell(), 12,6);
        add(new BoardYCell(), 12,7);

        add(new AngleCell(), 12,8);

        add(new Board(), 11,8);
        add(new Board(), 10,8);
        add(new Board(), 9,8);
        add(new Board(), 8,8);
        add(new Board(), 7,8);
        add(new Board(), 6,8);
        add(new Board(), 5,8);
        add(new Board(), 4,8);
        add(new Board(), 3,8);
        add(new Board(), 2,8);
        add(new Board(), 1,8);

        add(new AngleCell(), 0,8);

        add(new BoardYCell(), 0,7);
        add(new BoardYCell(), 0,6);
        add(new BoardYCell(), 0,5);
        add(new BoardYCell(), 0,4);
        add(new BoardYCell(), 0,3);
        add(new BoardYCell(), 0,2);
        add(new BoardYCell(), 0,1);
    }

    public void addPlayer(Player player) {
        playersContainer.getChildren().add(player);
    }
}