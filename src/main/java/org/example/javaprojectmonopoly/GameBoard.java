package org.example.javaprojectmonopoly;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class GameBoard extends GridPane {
    private final Pane playersContainer;
    private int countOfPlayers;
    ArrayList<Player> players = new ArrayList<>();
    Button button = new Button("Move");

    public GameBoard(int countOfPlayers) {
        super();
        initialize();
        playersContainer = new Pane();
        this.countOfPlayers = countOfPlayers;
        System.out.println(countOfPlayers);


        add(new Label(), 4, 4);
        add(new Label(), 5, 4);

        players.add(new Player("Madi", 1, Color.RED));
        players.add(new Player("Rasul", 2, Color.YELLOW));
        players.add(new Player("Aqylbel", 3, Color.GREEN));
        players.add(new Player("Nail", 4, Color.BLACK));

        getChildren().add(players.getFirst());
        getChildren().add(players.get(1));
        getChildren().add(players.get(2));
        getChildren().add(players.get(3));


        add(button, 5, 5);
        button.setOnAction(event -> playersMoving());
    }

    private int queue = 0;
    private void playersMoving(){
        if (queue == 0) {
            players.getFirst().moving(this, Player.rand()[0], Player.rand()[1]);
            queue = (queue + 1) % 4;
        } else if (queue == 1) {
            players.get(1).moving(this, Player.rand()[0], Player.rand()[1]);
            queue = (queue + 1) % 4;
        } else if (queue == 2) {
            players.get(2).moving(this, Player.rand()[0], Player.rand()[1]);
            queue = (queue + 1) % 4;
        } else if (queue == 3) {
            players.get(3).moving(this, Player.rand()[0], Player.rand()[1]);
            queue = (queue + 1) % 4;
        } else {
            System.out.println("Error" + queue);
        }
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


    public void setCountOfPlayers(int i){
        countOfPlayers = i;
    }

    public void addPlayer(Player player) {
        playersContainer.getChildren().add(player);
    }
}