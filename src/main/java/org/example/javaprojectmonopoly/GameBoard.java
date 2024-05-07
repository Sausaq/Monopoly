package org.example.javaprojectmonopoly;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;


public class GameBoard extends GridPane {
    private int countOfPlayers;
    private ArrayList<Player> players = new ArrayList<>();
    private Button moveButton = new Button("Move");
    private Button buyButton = new Button("Buy");
    private int queue = 0;
    private ArrayList<Cell> cells = new ArrayList<>();

    private StackPane avatar = new StackPane();

    {
        cells.add(new Cell(1, 0, 0));

        cells.add(new Cell(2, 1, 0, Flags.getFlagBritain(), 60000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp2.png")))));
        cells.add(new Cell(2, 2, 0, Flags.getFlagChina(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp3.png")))));
        cells.add(new Cell(2, 3, 0, Flags.getFlagBritain(), 60000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp4.png")))));
        cells.add(new Cell(2, 4, 0, Flags.getFlagBritain(), 80000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp5.png")))));
        cells.add(new Cell(2, 5, 0));
        cells.add(new Cell(2, 6, 0, Flags.getFlagKorea(), 150000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp7.png")))));
        cells.add(new Cell(2, 7, 0));
        cells.add(new Cell(2, 8, 0, Flags.getFlagFrance(), 100000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp9.png")))));
        cells.add(new Cell(2, 9, 0, Flags.getFlagFrance(), 100000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp10.png")))));
        cells.add(new Cell(2, 10, 0, Flags.getFlagChina(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp11.png")))));
        cells.add(new Cell(2, 11, 0, Flags.getFlagFrance(), 100000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp12.png")))));

        cells.add(new Cell(1, 12, 0));

        cells.add(new Cell(3, 12, 1, Flags.getFlagSweden(), 140000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp14.png")))));
        cells.add(new Cell(3, 12, 2, Flags.getFlagSweden(), 140000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp15.png")))));
        cells.add(new Cell(3, 12, 3, Flags.getFlagItaly(), 180000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp16.png")))));
        cells.add(new Cell(3, 12, 4));
        cells.add(new Cell(3, 12, 5, Flags.getFlagItaly(), 180000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp18.png")))));
        cells.add(new Cell(3, 12, 6, Flags.getFlagItaly(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp19.png")))));

        cells.add(new Cell(1, 12, 7));

        cells.add(new Cell(2, 11, 7, Flags.getFlagJapan(), 220000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp21.png")))));
        cells.add(new Cell(2, 10, 7, Flags.getFlagChina(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp22.png")))));
        cells.add(new Cell(2, 9, 7, Flags.getFlagJapan(), 220000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp23.png")))));
        cells.add(new Cell(2, 8, 7, Flags.getFlagJapan(), 240000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp24.png")))));
        cells.add(new Cell(2, 7, 7));
        cells.add(new Cell(2, 6, 7, Flags.getFlagKorea(), 150000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp26.png")))));
        cells.add(new Cell(2, 5, 7));
        cells.add(new Cell(2, 4, 7, Flags.getFlagGermany(), 260000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp28.png")))));
        cells.add(new Cell(2, 3, 7, Flags.getFlagGermany(), 260000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp29.png")))));
        cells.add(new Cell(2, 2, 7, Flags.getFlagChina(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp30.png")))));
        cells.add(new Cell(2, 1, 7, Flags.getFlagGermany(), 280000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp31.png")))));

        cells.add(new Cell(1, 0, 7));

        cells.add(new Cell(3, 0, 6, Flags.getFlagSwiss(), 320000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp33.png")))));
        cells.add(new Cell(3, 0, 5, Flags.getFlagSwiss(), 320000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp34.png")))));
        cells.add(new Cell(3, 0, 4, Flags.getFlagUSA(), 350000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp35.png")))));
        cells.add(new Cell(3, 0, 3));
        cells.add(new Cell(3, 0, 2, Flags.getFlagUSA(), 350000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp37.png")))));
        cells.add(new Cell(3, 0, 1, Flags.getFlagUSA(), 400000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp38.png")))));
    }
    private Label dieNumer = new Label();

    public GameBoard(ArrayList<Player> addedPlayers) {
        super();
        initialize();
        players = addedPlayers;
        countOfPlayers = addedPlayers.size();
        System.out.println(countOfPlayers);

        add(new Label(), 4, 4);
        add(new Label(), 5, 4);

        for (Player player : players) {
            getChildren().add(player);
            player.addPlayerToBoard();
        }

        moveButton.setOnAction(event -> playersMoving());

        Rectangle buttonsBackground = new Rectangle(450, 270, Color.valueOf("#A6A6A6"));
        buttonsBackground.setStroke(Color.BLACK);
        buttonsBackground.setStrokeWidth(2);

        Circle circle = new Circle(55);
        circle.setFill(Color.valueOf(players.get(queue).getColorCode()));
        circle.setStrokeWidth(2);
        circle.setStroke(Color.BLACK);
        Rectangle avatarBackground = new Rectangle(146, 146);
        avatarBackground.setFill(Color.valueOf("#FF3131"));
        avatarBackground.setArcWidth(50);
        avatarBackground.setArcHeight(50);
        avatarBackground.setStrokeWidth(2);
        avatarBackground.setStroke(Color.BLACK);
        avatar.getChildren().addAll(avatarBackground, circle);
        HBox.setMargin(avatar, new Insets(0, 0, 0, 36));

        VBox avatarAndName = new VBox(avatar);

        HBox avatarAndButtons = new HBox(avatarAndName, moveButton, buyButton, dieNumer);
        avatarAndButtons.setMaxSize(450, 270);
        avatarAndButtons.setAlignment(Pos.CENTER_LEFT);

        StackPane buttonsPane = new StackPane(buttonsBackground, avatarAndButtons);
        add(buttonsPane, 3, 2);
        setColumnSpan(buttonsPane, 5);
        setRowSpan(buttonsPane, 4);

    }

    private void playersMoving(){
        ((Circle)avatar.getChildren().get(1)).setFill(Color.valueOf(players.get(queue).getColorCode()));
        int firstRandom = Player.rand()[0];
        int secondRandom = Player.rand()[1];
        dieNumer.setText(String.valueOf(firstRandom) + "   " + String.valueOf(secondRandom));


        if (queue == 0) {
            players.getFirst().moving(cells, firstRandom, secondRandom);
            queue = (queue + 1) % countOfPlayers;
        } else if (queue == 1) {
            players.get(1).moving(cells, firstRandom, secondRandom);
            queue = (queue + 1) % countOfPlayers;
        } else if (queue == 2) {
            players.get(2).moving(cells, firstRandom, secondRandom);
            queue = (queue + 1) % countOfPlayers;
        } else if (queue == 3) {
            players.get(3).moving(cells, firstRandom, secondRandom);
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