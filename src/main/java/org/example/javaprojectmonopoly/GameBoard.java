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
import javafx.scene.text.Font;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class GameBoard extends GridPane {
    private int countOfPlayers;
    private ArrayList<Player> players = new ArrayList<>();
    private MyButton moveButton = new MyButton("Move", 200, 60);
    private MyButton buyButton = new MyButton("Buy", 200, 60);
    private MyButton payButton = new MyButton("Pay", 200, 60);
    private MyButton continueButton = new MyButton("Continue", 200, 60);
    private HBox avatarAndButtons;
    private VBox buttons;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private boolean bool = true;

    private UserList userList;

    private int queue = 0;
    private ArrayList<Company> companies = new ArrayList<>();

    private Circle circle;
    private Label nameLabel;

    {
        companies.add(new Company(1, 0, 0, Images.getStart(),"start", false));

        companies.add(new Company(2, 1, 0, Images.getFlagBritain(), 60000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp2.png"))), 2000, 50000, new int[]{4000, 10000, 30000, 90000, 160000, 250000}));//RollsRoyce
        companies.add(new Company(2, 2, 0, Images.getFlagChina(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp3.png"))), 2000, 50000, new int[]{4000, 10000, 30000, 90000, 160000, 250000}));//bp
        companies.add(new Company(2, 3, 0, Images.getFlagBritain(), 60000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp4.png"))), 25000));
        companies.add(new Company(2, 4, 0, Images.getFlagBritain(), 80000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp5.png"))), 4000, 50000, new int[]{8000, 20000, 60000, 180000, 320000, 450000}));//bbc
        companies.add(new Company(2, 5, 0, Images.getForce(),"force", false));
        companies.add(new Company(2, 6, 0, Images.getFlagKorea(), 150000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp7.png"))), 10000));
        companies.add(new Company(2, 7, 0, Images.getChance(),"chance", false));
        companies.add(new Company(2, 8, 0, Images.getFlagFrance(), 100000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp9.png"))), 6000, 50000, new int[]{12000, 30000, 90000, 270000, 400000, 550000}));//danone
        companies.add(new Company(2, 9, 0, Images.getFlagFrance(), 100000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp10.png"))), 6000, 50000, new int[]{12000, 30000, 90000, 270000, 400000, 550000}));//hennessy
        companies.add(new Company(2, 10, 0, Images.getFlagChina(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp11.png"))), 20000));
        companies.add(new Company(2, 11, 0, Images.getFlagFrance(), 100000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp12.png"))), 8000, 50000, new int[]{16000, 40000, 100000, 300000, 450000, 600000}));//L'oreal

        companies.add(new Company(1, 12, 0, Images.getPrison(),"prison", false));

        companies.add(new Company(3, 12, 1, Images.getFlagSweden(), 140000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp14.png"))), 10000, 100000, new int[]{20000, 50000, 150000, 450000, 625000, 750000}));//ikea
        companies.add(new Company(3, 12, 2, Images.getFlagSweden(), 140000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp15.png"))), 10000, 100000, new int[]{20000, 50000, 150000, 450000, 625000, 750000}));//volvo
        companies.add(new Company(3, 12, 3, Images.getFlagItaly(), 180000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp16.png"))), 14000, 100000, new int[]{28000, 70000, 200000, 550000, 750000, 950000}));//giorgio armani
        companies.add(new Company(3, 12, 4, Images.getTax(),"tax", false));
        companies.add(new Company(3, 12, 5, Images.getFlagItaly(), 180000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp18.png"))), 14000, 100000, new int[]{28000, 70000, 200000, 550000, 750000, 950000}));//versace
        companies.add(new Company(3, 12, 6, Images.getFlagItaly(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp19.png"))), 16000, 100000, new int[]{32000, 80000, 220000, 600000, 800000, 1000000}));//ferrari

        companies.add(new Company(1, 12, 7, Images.getChill(),"chill", false));

        companies.add(new Company(2, 11, 7, Images.getFlagJapan(), 220000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp21.png"))), 18000, 150000, new int[]{36000, 90000, 250000, 700000, 875000, 1050000}));//sony
        companies.add(new Company(2, 10, 7, Images.getFlagChina(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp22.png"))), 25000));
        companies.add(new Company(2, 9, 7, Images.getFlagJapan(), 220000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp23.png"))), 18000, 150000, new int[]{36000, 90000, 250000, 700000, 875000, 1050000}));//canon
        companies.add(new Company(2, 8, 7, Images.getFlagJapan(), 240000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp24.png"))), 20000, 150000, new int[]{40000, 100000, 300000, 750000, 925000, 1100000}));//toyota
        companies.add(new Company(2, 7, 7, Images.getForce(),"force", false));
        companies.add(new Company(2, 6, 7, Images.getFlagKorea(), 150000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp26.png"))), 60000));
        companies.add(new Company(2, 5, 7, Images.getChance(),"chance", false));
        companies.add(new Company(2, 4, 7, Images.getFlagGermany(), 260000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp28.png"))), 22000, 150000, new int[]{44000, 110000, 330000, 800000, 975000, 1150000}));//siemens
        companies.add(new Company(2, 3, 7, Images.getFlagGermany(), 260000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp29.png"))), 22000, 150000, new int[]{44000, 110000, 330000, 800000, 975000, 1150000}));//adidas
        companies.add(new Company(2, 2, 7, Images.getFlagChina(), 200000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp30.png"))), 25000));
        companies.add(new Company(2, 1, 7, Images.getFlagGermany(), 280000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp31.png"))), 24000, 150000, new int[]{48000, 120000, 360000, 850000, 1110000, 1200000}));//mercedes

        companies.add(new Company(1, 0, 7, Images.getCustoms(),"custom", false));

        companies.add(new Company(3, 0, 6, Images.getFlagSwiss(), 320000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp33.png"))), 28000, 200000, new int[]{56000, 150000, 450000, 1000000, 1200000, 1400000}));//nestle
        companies.add(new Company(3, 0, 5, Images.getFlagSwiss(), 320000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp34.png"))), 28000, 200000, new int[]{56000, 150000, 450000, 1000000, 1200000, 1400000}));//rolex
        companies.add(new Company(3, 0, 4, Images.getFlagUSA(), 350000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp35.png"))), 35000, 200000, new int[]{70000, 175000, 500000, 1100000, 1300000, 1500000}));//mac
        companies.add(new Company(3, 0, 3, Images.getTax(),"tax", false));
        companies.add(new Company(3, 0, 2, Images.getFlagUSA(), 350000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp37.png"))), 35000, 200000, new int[]{70000, 175000, 500000, 1100000, 1300000, 1500000}));//Disney
        companies.add(new Company(3, 0, 1, Images.getFlagUSA(), 400000, new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/Companies/comp38.png"))), 50000, 200000, new int[]{100000, 200000, 600000, 1400000, 1700000, 2000000}));//CocaCola
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

        moveButton.setOnAction(event -> initializeMoveButton());
        VBox.setMargin(moveButton, new Insets(32, 0, 0, 20));

        buyButton.setOnAction(event -> initializeBuyButton());
        VBox.setMargin(buyButton, new Insets(32, 0, 0, 20));

        continueButton.setOnAction(event -> initializeContinueButton());
        VBox.setMargin(continueButton, new Insets(12, 0, 0, 20));

        payButton.setOnAction(event -> initializePayButton());
        VBox.setMargin(payButton, new Insets(32, 0, 0, 20));

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
        add(buttonsPane, 2, 2);
        setColumnSpan(buttonsPane, 5);
        setRowSpan(buttonsPane, 4);
    }

    private void initializeMoveButton(){
        Random rand = new Random();
        int firstRandom = rand.nextInt(6) + 1;
        int secondRandom = rand.nextInt(6) + 1;
        dieNumer.setText(String.valueOf(firstRandom) + "   " + String.valueOf(secondRandom));

        Player currentPlayer = players.get(queue);
        Company nextCompany = companies.get(currentPlayer.getIndex() + firstRandom + secondRandom);

        if (queue == 0) {
            players.getFirst().moving(companies, firstRandom, secondRandom);
        } else if (queue == 1) {
            players.get(1).moving(companies, firstRandom, secondRandom);
        } else if (queue == 2) {
            players.get(2).moving(companies, firstRandom, secondRandom);
        } else if (queue == 3) {
            players.get(3).moving(companies, firstRandom, secondRandom);
        } else {
            System.out.println("Error" + queue);
        }

        buttons.getChildren().remove(moveButton);

        if (nextCompany.isFree()){
            buttons.getChildren().addAll(buyButton, continueButton);
        }else if (!nextCompany.isFree()){
            buttons.getChildren().addAll(payButton, continueButton);
        }
        else if(nextCompany.getOtherTypes().equals("chance")){
            buttons.getChildren().addAll(continueButton);
            int randomMoney = rand.nextInt(3);
            switch (randomMoney){
                case 0:
                    currentPlayer.setMoney(currentPlayer.getMoney() + 100000);
                    break;
                case 1:
                    currentPlayer.setMoney(currentPlayer.getMoney() + 150000);
                    break;
                case 2:
                    currentPlayer.setMoney(currentPlayer.getMoney() + 200000);
                    break;
            }
        }

    }

    private void initializePayButton() {
        Player currentPlayer = players.get(queue);
        Company currentCompany = companies.get(currentPlayer.getIndex());

        currentPlayer.setMoney(currentPlayer.getMoney() - currentCompany.getIncomePrice());
        ((PlayerInfoPane) userList.getChildren().get(queue)).updatePrice();
        queue = (queue + 1) % countOfPlayers;

        circle.setFill(Color.valueOf(players.get(queue).getColorCode()));
        nameLabel.setText(players.get(queue).getName());
        buttons.getChildren().removeAll(buyButton, continueButton, payButton);
        buttons.getChildren().add(moveButton);
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
        for (Company company : companies){
            System.out.println(company);
            add(company, company.getX(), company.getY());
        }
    }

    private void initializeBuyButton() {
        Player currentPlayer = players.get(queue);
        Company currentCompany = companies.get(currentPlayer.getIndex());
        if (currentCompany.isFree()) {
            currentCompany.setAuthor(currentPlayer);
            ((PlayerInfoPane) userList.getChildren().get(queue)).updatePrice();

            currentCompany.getLabel().setText(String.valueOf(currentCompany.getIncomePrice()) + " $");
            currentCompany.setFree(false);

            queue = (queue + 1) % countOfPlayers;
            circle.setFill(Color.valueOf(players.get(queue).getColorCode()));
            nameLabel.setText(players.get(queue).getName());

            buttons.getChildren().removeAll(buyButton, continueButton, payButton);
            buttons.getChildren().add(moveButton);

            System.out.println(currentPlayer.getPrice());
            transactions.add(new Transaction(currentPlayer, currentCompany));
            saveTransaction(transactions);

            currentCompany.getBack().setFill(Color.valueOf(currentPlayer.getColorCode()));
            currentPlayer.setMoney(currentPlayer.getMoney() - currentCompany.getCost());
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