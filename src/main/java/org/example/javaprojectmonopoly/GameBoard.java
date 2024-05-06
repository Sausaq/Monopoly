package org.example.javaprojectmonopoly;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;


public class GameBoard extends GridPane {
    private int countOfPlayers;
    ArrayList<Player> players = new ArrayList<>();
    Button moveButton = new Button("Move");
    Button buyButton = new Button("Buy");
    private ArrayList<Cell> cells = new ArrayList<>();

    {
        cells.add(new Cell(1, 0, 0));

        cells.add(new Cell(2, 1, 0, Flags.getFlagBritain(), 60000));
        cells.add(new Cell(2, 2, 0));
        cells.add(new Cell(2, 3, 0, Flags.getFlagBritain(), 60000));
        cells.add(new Cell(2, 4, 0, Flags.getFlagBritain(), 80000));
        cells.add(new Cell(2, 5, 0));
        cells.add(new Cell(2, 6, 0, Flags.getFlagKorea(), 150000));
        cells.add(new Cell(2, 7, 0));
        cells.add(new Cell(2, 8, 0, Flags.getFlagFrance(), 100000));
        cells.add(new Cell(2, 9, 0, Flags.getFlagFrance(), 100000));
        cells.add(new Cell(2, 10, 0, Flags.getFlagChina(), 200000));
        cells.add(new Cell(2, 11, 0, Flags.getFlagFrance(), 100000));

        cells.add(new Cell(1, 12, 0));

        cells.add(new Cell(3, 12, 1, Flags.getFlagSweden(), 140000));
        cells.add(new Cell(3, 12, 2, Flags.getFlagSweden(), 140000));
        cells.add(new Cell(3, 12, 3, Flags.getFlagItaly(), 180000));
        cells.add(new Cell(3, 12, 4));
        cells.add(new Cell(3, 12, 5, Flags.getFlagItaly(), 180000));
        cells.add(new Cell(3, 12, 6, Flags.getFlagItaly(), 200000));

        cells.add(new Cell(1, 12, 7));

        cells.add(new Cell(2, 11, 7, Flags.getFlagJapan(), 220000));
        cells.add(new Cell(2, 10, 7, Flags.getFlagChina(), 200000));
        cells.add(new Cell(2, 9, 7, Flags.getFlagJapan(), 220000));
        cells.add(new Cell(2, 8, 7, Flags.getFlagJapan(), 240000));
        cells.add(new Cell(2, 7, 7));
        cells.add(new Cell(2, 6, 7, Flags.getFlagKorea(), 150000));
        cells.add(new Cell(2, 5, 7));
        cells.add(new Cell(2, 4, 7, Flags.getFlagGermany(), 260000));
        cells.add(new Cell(2, 3, 7, Flags.getFlagGermany(), 260000));
        cells.add(new Cell(2, 2, 7, Flags.getFlagChina(), 200000));
        cells.add(new Cell(2, 1, 7, Flags.getFlagGermany(), 280000));

        cells.add(new Cell(1, 0, 7));

        cells.add(new Cell(3, 0, 6, Flags.getFlagSwiss(), 320000));
        cells.add(new Cell(3, 0, 5, Flags.getFlagSwiss(), 320000));
        cells.add(new Cell(3, 0, 4, Flags.getFlagUSA(), 350000));
        cells.add(new Cell(3, 0, 3));
        cells.add(new Cell(3, 0, 2, Flags.getFlagUSA(), 350000));
        cells.add(new Cell(3, 0, 1, Flags.getFlagUSA(), 400000));
    }

    public GameBoard(ArrayList<Player> addedPlayers) {
        super();
        initialize();
        players = addedPlayers;
        countOfPlayers = addedPlayers.size();
        System.out.println(countOfPlayers);

        add(new Label(), 4, 4);
        add(new Label(), 5, 4);

        for (int i = 0; i < addedPlayers.size(); i++) {
            getChildren().add(players.get(i));
            addedPlayers.get(i).addPlayerToBoard();
        }

        add(moveButton, 5, 5);
        add(buyButton, 5, 6);
        moveButton.setOnAction(event -> playersMoving());
    }


    private int queue = 0;
    private void playersMoving(){

        if (queue == 0) {
            players.getFirst().moving(this, Player.rand()[0], Player.rand()[1]);
            queue = (queue + 1) % countOfPlayers;
        } else if (queue == 1) {
            players.get(1).moving(this, Player.rand()[0], Player.rand()[1]);
            queue = (queue + 1) % countOfPlayers;
        } else if (queue == 2) {
            players.get(2).moving(this, Player.rand()[0], Player.rand()[1]);
            queue = (queue + 1) % countOfPlayers;
        } else if (queue == 3) {
            players.get(3).moving(this, Player.rand()[0], Player.rand()[1]);
            queue = (queue + 1) % countOfPlayers;
        } else {
            System.out.println("Error" + queue);
        }
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }


    private void initialize() {
        for (Cell cell: cells){
            System.out.println(cell);
            add(cell, cell.getX(), cell.getY());
        }
    }
}