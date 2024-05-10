package org.example.javaprojectmonopoly;

import javafx.application.Platform;
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
import javafx.scene.text.Font;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class GameBoard extends GridPane {
    private int countOfPlayers;
    private ArrayList<Player> players = new ArrayList<>();
    private Button moveButton = new Button("Move");
    private Button buyButton = new Button("Buy");
    private Button payButton = new Button("Pay");
    private Button continueButton = new Button("Continue");
    private HBox avatarAndButtons;
    private VBox buttons;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private boolean bool = true;

    private UserList userList;

    private int queue = 0;
    private ArrayList<Cell> cells = new ArrayList<>();

    private Circle circle;
    private Label nameLabel;

    {
        cells.add(new Cell(1, 0, 0, false));

        cells.add(new Cell(2, 1, 0, Flags.getFlagBritain(), 60000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp2.png"))), 6000));
        cells.add(new Cell(2, 2, 0, Flags.getFlagChina(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp3.png"))), 6000));
        cells.add(new Cell(2, 3, 0, Flags.getFlagBritain(), 60000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp4.png"))), 6000));
        cells.add(new Cell(2, 4, 0, Flags.getFlagBritain(), 80000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp5.png"))), 60000));
        cells.add(new Cell(2, 5, 0, false));
        cells.add(new Cell(2, 6, 0, Flags.getFlagKorea(), 150000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp7.png"))), 60000));
        cells.add(new Cell(2, 7, 0, false));
        cells.add(new Cell(2, 8, 0, Flags.getFlagFrance(), 100000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp9.png"))), 60000));
        cells.add(new Cell(2, 9, 0, Flags.getFlagFrance(), 100000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp10.png"))), 60000));
        cells.add(new Cell(2, 10, 0, Flags.getFlagChina(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp11.png"))), 60000));
        cells.add(new Cell(2, 11, 0, Flags.getFlagFrance(), 100000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp12.png"))), 60000));

        cells.add(new Cell(1, 12, 0, false));

        cells.add(new Cell(3, 12, 1, Flags.getFlagSweden(), 140000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp14.png"))), 60000));
        cells.add(new Cell(3, 12, 2, Flags.getFlagSweden(), 140000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp15.png"))), 60000));
        cells.add(new Cell(3, 12, 3, Flags.getFlagItaly(), 180000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp16.png"))), 60000));
        cells.add(new Cell(3, 12, 4, false));
        cells.add(new Cell(3, 12, 5, Flags.getFlagItaly(), 180000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp18.png"))), 60000));
        cells.add(new Cell(3, 12, 6, Flags.getFlagItaly(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp19.png"))), 60000));

        cells.add(new Cell(1, 12, 7, false));

        cells.add(new Cell(2, 11, 7, Flags.getFlagJapan(), 220000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp21.png"))), 60000));
        cells.add(new Cell(2, 10, 7, Flags.getFlagChina(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp22.png"))), 60000));
        cells.add(new Cell(2, 9, 7, Flags.getFlagJapan(), 220000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp23.png"))), 60000));
        cells.add(new Cell(2, 8, 7, Flags.getFlagJapan(), 240000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp24.png"))), 60000));
        cells.add(new Cell(2, 7, 7, false));
        cells.add(new Cell(2, 6, 7, Flags.getFlagKorea(), 150000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp26.png"))), 60000));
        cells.add(new Cell(2, 5, 7, false));
        cells.add(new Cell(2, 4, 7, Flags.getFlagGermany(), 260000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp28.png"))), 60000));
        cells.add(new Cell(2, 3, 7, Flags.getFlagGermany(), 260000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp29.png"))), 60000));
        cells.add(new Cell(2, 2, 7, Flags.getFlagChina(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp30.png"))), 60000));
        cells.add(new Cell(2, 1, 7, Flags.getFlagGermany(), 280000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp31.png"))), 60000));

        cells.add(new Cell(1, 0, 7, false));

        cells.add(new Cell(3, 0, 6, Flags.getFlagSwiss(), 320000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp33.png"))), 60000));
        cells.add(new Cell(3, 0, 5, Flags.getFlagSwiss(), 320000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp34.png"))), 60000));
        cells.add(new Cell(3, 0, 4, Flags.getFlagUSA(), 350000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp35.png"))), 60000));
        cells.add(new Cell(3, 0, 3, false));
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

        moveButton.setOnAction(event -> {
            initializeMoveButton();
        });

        moveButton.setPrefSize(200, 60);
        moveButton.setStyle("-fx-background-color: #FFBD59; -fx-background-radius: 30; -fx-border-color: black; -fx-border-width: 5; -fx-border-radius: 30;");
        moveButton.setOnMouseEntered(e -> moveButton.setStyle("-fx-background-color: #EFB800; -fx-background-radius: 30; -fx-border-color: black; -fx-border-width: 5; -fx-border-radius: 30;")); // Красный при наведении
        moveButton.setOnMouseExited(e -> moveButton.setStyle("-fx-background-color: #FFBD59; -fx-background-radius: 30; -fx-border-color: black; -fx-border-width: 5; -fx-border-radius: 30;")); // Возвращаем белый цвет
        VBox.setMargin(moveButton, new Insets(32, 0, 0, 20));

        buyButton.setOnAction(event -> initializeBuyButton());
        buyButton.setPrefSize(200, 60);
        buyButton.setStyle("-fx-background-color: #FFBD59; -fx-background-radius: 30; -fx-border-color: black; -fx-border-width: 5; -fx-border-radius: 30;");
        buyButton.setOnMouseEntered(e -> buyButton.setStyle("-fx-background-color: #EFB800; -fx-background-radius: 30; -fx-border-color: black; -fx-border-width: 5; -fx-border-radius: 30;")); // Красный при наведении
        buyButton.setOnMouseExited(e -> buyButton.setStyle("-fx-background-color: #FFBD59; -fx-background-radius: 30; -fx-border-color: black; -fx-border-width: 5; -fx-border-radius: 30;")); // Возвращаем белый цвет
        VBox.setMargin(buyButton, new Insets(32, 0, 0, 20));

        continueButton.setOnAction(event -> initializeContinueButton());
        continueButton.setPrefSize(200, 60);
        continueButton.setStyle("-fx-background-color: #FFBD59; -fx-background-radius: 30; -fx-border-color: black; -fx-border-width: 5; -fx-border-radius: 30;");
        continueButton.setOnMouseEntered(e -> continueButton.setStyle("-fx-background-color: #EFB800; -fx-background-radius: 30; -fx-border-color: black; -fx-border-width: 5; -fx-border-radius: 30;")); // Красный при наведении
        continueButton.setOnMouseExited(e -> continueButton.setStyle("-fx-background-color: #FFBD59; -fx-background-radius: 30; -fx-border-color: black; -fx-border-width: 5; -fx-border-radius: 30;")); // Возвращаем белый цвет
        VBox.setMargin(continueButton, new Insets(10, 0, 0, 20));

        payButton.setOnAction(event -> initializePayButton());
        payButton.setPrefSize(200, 60);
        payButton.setStyle("-fx-background-color: #FFBD59; -fx-background-radius: 30; -fx-border-color: black; -fx-border-width: 5; -fx-border-radius: 30;");
        payButton.setOnMouseEntered(e -> payButton.setStyle("-fx-background-color: #EFB800; -fx-background-radius: 30; -fx-border-color: black; -fx-border-width: 5; -fx-border-radius: 30;")); // Красный при наведении
        payButton.setOnMouseExited(e -> payButton.setStyle("-fx-background-color: #FFBD59; -fx-background-radius: 30; -fx-border-color: black; -fx-border-width: 5; -fx-border-radius: 30;")); // Возвращаем белый цвет
        VBox.setMargin(payButton, new Insets(10, 0, 0, 20));

        Rectangle buttonsBackground = new Rectangle(450, 270, Color.valueOf("#A6A6A6"));
        buttonsBackground.setStroke(Color.BLACK);
        buttonsBackground.setStrokeWidth(2);

        circle = new Circle(55);
        circle.setFill(Color.valueOf(players.get(queue).getColorCode()));
        circle.setStrokeWidth(2);
        circle.setStroke(Color.BLACK);
        Rectangle avatarBackground = new Rectangle(146, 146);
        avatarBackground.setFill(Color.valueOf("#FF3131"));
        avatarBackground.setArcWidth(50);
        avatarBackground.setArcHeight(50);
        avatarBackground.setStrokeWidth(2);
        avatarBackground.setStroke(Color.BLACK);
        StackPane avatar = new StackPane(avatarBackground, circle);
        VBox.setMargin(avatar, new Insets(36, 0, 0, 36));

        Rectangle nameBackground = new Rectangle(140, 47);
        nameBackground.setFill(Color.valueOf("#FF3131"));
        nameBackground.setArcWidth(50);
        nameBackground.setArcHeight(50);
        nameBackground.setStrokeWidth(2);
        nameBackground.setStroke(Color.BLACK);
        nameLabel = new Label(players.get(queue).getName());
        nameLabel.setFont(Font.font(20));
        StackPane name = new StackPane(nameBackground, nameLabel);
        VBox.setMargin(name, new Insets(10, 0, 0, 36));

        VBox avatarAndName = new VBox(avatar, name);
        buttons = new VBox(moveButton);

        avatarAndButtons = new HBox(avatarAndName, buttons, dieNumer);
        avatarAndButtons.setMaxSize(450, 270);
        avatarAndButtons.setAlignment(Pos.CENTER_LEFT);

        StackPane buttonsPane = new StackPane(buttonsBackground, avatarAndButtons);
        add(buttonsPane, 3, 2);
        setColumnSpan(buttonsPane, 5);
        setRowSpan(buttonsPane, 4);
    }

    private void initializeMoveButton(){
        Random rand = new Random();
        int firstRandom = rand.nextInt(6) + 1;
        int secondRandom = rand.nextInt(6) + 1;

        Player currentPlayer = players.get(queue);
        Cell currentCell = cells.get(currentPlayer.getIndex());
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

        buttons.getChildren().remove(moveButton);
        buttons.getChildren().addAll(buyButton , continueButton, payButton);
    }

    private void initializePayButton(){
        Player currentPlayer = players.get(queue);
        Cell currentCell = cells.get(currentPlayer.getIndex());

        if (currentCell.isFree() || currentCell.getAuthor().equals(currentPlayer)){
            payButton.setDisable(true);
        }else {
            currentPlayer.setMoney(currentPlayer.getMoney() - currentCell.getIncomePrice());
            ((PlayerInfoPane) userList.getChildren().get(queue)).updatePrice();
            queue = (queue + 1) % countOfPlayers;

            circle.setFill(Color.valueOf(players.get(queue).getColorCode()));
            nameLabel.setText(players.get(queue).getName());
            buttons.getChildren().removeAll(buyButton, continueButton, payButton);
            buttons.getChildren().add(moveButton);
        }
    }

    private void initializeContinueButton(){
        queue = (queue + 1) % countOfPlayers;
        circle.setFill(Color.valueOf(players.get(queue).getColorCode()));
        nameLabel.setText(players.get(queue).getName());

        buttons.getChildren().removeAll(buyButton, continueButton, payButton);
        buttons.getChildren().add(moveButton);
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

    private void initializeBuyButton() {
        Player currentPlayer = players.get(queue);
        Cell currentCell = cells.get(currentPlayer.getIndex());
        if (currentCell.isFree()) {
            currentCell.setAuthor(currentPlayer);
            ((PlayerInfoPane) userList.getChildren().get(queue)).updatePrice();

            currentCell.getLabel().setText(String.valueOf(currentCell.getIncomePrice()) + " $");
            currentCell.setFree(false);

            queue = (queue + 1) % countOfPlayers;
            circle.setFill(Color.valueOf(players.get(queue).getColorCode()));
            nameLabel.setText(players.get(queue).getName());

            buttons.getChildren().removeAll(buyButton, continueButton, payButton);
            buttons.getChildren().add(moveButton);

            System.out.println(currentPlayer.getPrice());
            transactions.add(new Transaction(currentPlayer, currentCell));
            saveTransaction(transactions);
        }
    }

    private void saveTransaction(ArrayList<Transaction> transactions){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/org/example/javaprojectmonopoly/transaction.txt"))) {
            for(Transaction transaction: transactions) {
                bufferedWriter.write(transaction.getPlayer().getName() + " buy the company " + transaction.getCompany() + " to " + transaction.getCompany().getCost());
                bufferedWriter.newLine();
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

}