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
    private Button continueButton = new Button("Continue");
    private HBox avatarAndButtons;

    private UserList userList;

    private int queue = 0;
    private ArrayList<Cell> cells = new ArrayList<>();

    private StackPane avatar = new StackPane();

    {
        cells.add(new Cell(1, 0, 0));

        cells.add(new Cell(2, 1, 0, Flags.getFlagBritain(), 60000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp2.png"))), 6000));
        cells.add(new Cell(2, 2, 0, Flags.getFlagChina(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp3.png"))), 6000));
        cells.add(new Cell(2, 3, 0, Flags.getFlagBritain(), 60000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp4.png"))), 6000));
        cells.add(new Cell(2, 4, 0, Flags.getFlagBritain(), 80000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp5.png"))), 60000));
        cells.add(new Cell(2, 5, 0));
        cells.add(new Cell(2, 6, 0, Flags.getFlagKorea(), 150000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp7.png"))), 60000));
        cells.add(new Cell(2, 7, 0));
        cells.add(new Cell(2, 8, 0, Flags.getFlagFrance(), 100000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp9.png"))), 60000));
        cells.add(new Cell(2, 9, 0, Flags.getFlagFrance(), 100000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp10.png"))), 60000));
        cells.add(new Cell(2, 10, 0, Flags.getFlagChina(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp11.png"))), 60000));
        cells.add(new Cell(2, 11, 0, Flags.getFlagFrance(), 100000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp12.png"))), 60000));

        cells.add(new Cell(1, 12, 0));

        cells.add(new Cell(3, 12, 1, Flags.getFlagSweden(), 140000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp14.png"))), 60000));
        cells.add(new Cell(3, 12, 2, Flags.getFlagSweden(), 140000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp15.png"))), 60000));
        cells.add(new Cell(3, 12, 3, Flags.getFlagItaly(), 180000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp16.png"))), 60000));
        cells.add(new Cell(3, 12, 4));
        cells.add(new Cell(3, 12, 5, Flags.getFlagItaly(), 180000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp18.png"))), 60000));
        cells.add(new Cell(3, 12, 6, Flags.getFlagItaly(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp19.png"))), 60000));

        cells.add(new Cell(1, 12, 7));

        cells.add(new Cell(2, 11, 7, Flags.getFlagJapan(), 220000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp21.png"))), 60000));
        cells.add(new Cell(2, 10, 7, Flags.getFlagChina(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp22.png"))), 60000));
        cells.add(new Cell(2, 9, 7, Flags.getFlagJapan(), 220000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp23.png"))), 60000));
        cells.add(new Cell(2, 8, 7, Flags.getFlagJapan(), 240000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp24.png"))), 60000));
        cells.add(new Cell(2, 7, 7));
        cells.add(new Cell(2, 6, 7, Flags.getFlagKorea(), 150000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp26.png"))), 60000));
        cells.add(new Cell(2, 5, 7));
        cells.add(new Cell(2, 4, 7, Flags.getFlagGermany(), 260000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp28.png"))), 60000));
        cells.add(new Cell(2, 3, 7, Flags.getFlagGermany(), 260000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp29.png"))), 60000));
        cells.add(new Cell(2, 2, 7, Flags.getFlagChina(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp30.png"))), 60000));
        cells.add(new Cell(2, 1, 7, Flags.getFlagGermany(), 280000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp31.png"))), 60000));

        cells.add(new Cell(1, 0, 7));

        cells.add(new Cell(3, 0, 6, Flags.getFlagSwiss(), 320000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp33.png"))), 60000));
        cells.add(new Cell(3, 0, 5, Flags.getFlagSwiss(), 320000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp34.png"))), 60000));
        cells.add(new Cell(3, 0, 4, Flags.getFlagUSA(), 350000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp35.png"))), 60000));
        cells.add(new Cell(3, 0, 3));
        cells.add(new Cell(3, 0, 2, Flags.getFlagUSA(), 350000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp37.png"))), 60000));
        cells.add(new Cell(3, 0, 1, Flags.getFlagUSA(), 400000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp38.png"))), 60000));
    }
    private Label dieNumer = new Label();

    public GameBoard(ArrayList<Player> addedPlayers, UserList userList) {
        super();
        initialize();
        players = addedPlayers;
        countOfPlayers = addedPlayers.size();
        this.userList = userList;
        System.out.println(countOfPlayers);

        add(new Label(), 4, 4);
        add(new Label(), 5, 4);

        for (Player player : players) {
            getChildren().add(player);
            player.addPlayerToBoard();
        }

        moveButton.setOnAction(event -> playersMoving());
        buyButton.setOnAction(event -> initializeBuy());
        continueButton.setOnAction(event -> continueQueue());

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


        avatarAndButtons = new HBox(avatarAndName, moveButton, dieNumer);
        avatarAndButtons.setMaxSize(450, 270);
        avatarAndButtons.setAlignment(Pos.CENTER_LEFT);

        StackPane buttonsPane = new StackPane(buttonsBackground, avatarAndButtons);
        add(buttonsPane, 3, 2);
        setColumnSpan(buttonsPane, 5);
        setRowSpan(buttonsPane, 4);

    }

    private void playersMoving(){
        int firstRandom = Player.rand()[0];
        int secondRandom = Player.rand()[1];
        dieNumer.setText(String.valueOf(firstRandom) + "   " + String.valueOf(secondRandom));

        if (queue == 0) {
            players.getFirst().moving(cells, firstRandom, secondRandom);
        } else if (queue == 1) {
            players.get(1).moving(cells, firstRandom, secondRandom);
        } else if (queue == 2) {
            players.get(2).moving(cells, firstRandom, secondRandom);
        } else if (queue == 3) {
            players.get(3).moving(cells, firstRandom, secondRandom);
        } else {
            System.out.println("Error" + queue);
        }

        avatarAndButtons.getChildren().remove(moveButton);
        avatarAndButtons.getChildren().add(buyButton);
    }

    private void continueQueue(){
        queue = (queue + 1) % countOfPlayers;
        ((Circle)avatar.getChildren().get(1)).setFill(Color.valueOf(players.get(queue).getColorCode()));
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

    private void initializeBuy() {
        Player currentPlayer = players.get(queue);
        Cell currentCell = cells.get(currentPlayer.getIndex());
        currentPlayer.addCompany(currentCell);
        ((PlayerInfoPane)userList.getChildren().get(queue)).updatePrice();

        currentCell.getLabel().setText(String.valueOf(currentCell.getIncomePrice()) + " $");

        System.out.println("sdfsfddsf " + currentCell.getIncomePrice());
        System.out.println(currentCell.getLabel().getText());

        queue = (queue + 1) % countOfPlayers;
        ((Circle)avatar.getChildren().get(1)).setFill(Color.valueOf(players.get(queue).getColorCode()));

        avatarAndButtons.getChildren().remove(buyButton);
        avatarAndButtons.getChildren().add(moveButton);

        System.out.println( currentPlayer.getPrice());
    }
}