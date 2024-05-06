package org.example.javaprojectmonopoly;

import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class Player extends StackPane {
    private PauseTransition pause = new PauseTransition(Duration.seconds(1));
    private Circle circle;
    private int index = 0;
    private int price = 1000;
    private ArrayList<Cell> companies = new ArrayList<>();

    private int id;
    private String name;
    private int wins;
    private int games;
    private String colorCode = "#FF3131";
    private int playerNum;

    private ArrayList<Cell> companiesList;


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Player(int i, String name, int wins, int games, String colorCode) {
        this.id = i;
        this.name = name;
        this.wins = wins;
        this.games = games;
        this.colorCode = colorCode;
        circle = new Circle(13, Color.valueOf(colorCode));
        circle.setStrokeWidth(1);
        circle.setStroke(Color.BLACK);
        companiesList = new ArrayList<>();
    }

    public void addCompany(Cell company){
        companiesList.add(company);
        company.getChildren().add(new Rectangle(10, 10, Color.valueOf(colorCode)));
    }

    public void addPlayerToBoard() {
        getChildren().add(circle);
        switch (playerNum) {
            case 1:
                setAlignment(circle, Pos.TOP_LEFT);
                setMargin(circle, new javafx.geometry.Insets(25, 0, 0, 15));
                break;
            case 2:
                setAlignment(circle, Pos.TOP_RIGHT);
                setMargin(circle, new javafx.geometry.Insets(25, 80, 0, 0));
                break;
            case 3:
                setAlignment(circle, Pos.BOTTOM_LEFT);
                setMargin(circle, new javafx.geometry.Insets(0, 0, 72, 15));
                break;
            case 4:
                setAlignment(circle, Pos.BOTTOM_RIGHT);
                setMargin(circle, new javafx.geometry.Insets(0, 80, 72, 0));
                break;
        }
    }

    public void moving(GameBoard board, int firstRandom, int secondRandom) {
        if (!pause.getStatus().equals(Animation.Status.RUNNING)) {
            TranslateTransition transition = new TranslateTransition(Duration.seconds(1), this);
            TranslateTransition transition2 = new TranslateTransition(Duration.seconds(1), this);
            TranslateTransition transition3 = new TranslateTransition(Duration.seconds(1), this);

            int step = firstRandom + secondRandom;
            int firstCoordinates = index;
            int secondCoordinates = (index + step) % 36;
            index = (index + step) % 36;

            Label label = (Label) board.getChildren().get(38);
            Label label2 = (Label) board.getChildren().get(39);
            label.setText(String.valueOf(firstRandom));
            label2.setText(String.valueOf(secondRandom));

            Cell nextCell = (Cell) board.getChildren().get(secondCoordinates);

            double endLayoutX = nextCell.getLayoutX();
            double endLayoutY = nextCell.getLayoutY();

            System.out.println(firstCoordinates + " " + secondCoordinates);
            System.out.println(getTranslateX() + " " + getTranslateY());
            System.out.println(endLayoutX + " " + endLayoutY);


            // Moving
            if (firstCoordinates <= 11 && secondCoordinates >= 13 && secondCoordinates <= 19) {
                transition.setToX(((Cell) board.getChildren().get(12)).getLayoutX());

                transition.play();
                transition.setOnFinished(event -> {
                    transition2.setToY(endLayoutY);
                    transition2.play();
                });
            } else if (firstCoordinates <= 11 && secondCoordinates >= 20) {
                transition.setToX(((Cell) board.getChildren().get(12)).getLayoutX());
                transition.play();
                transition.setOnFinished(event -> {
                    transition2.setToY(((Cell) board.getChildren().get(19)).getLayoutY());
                    transition2.play();
                    transition2.setOnFinished(event1 -> {
                        transition3.setToX(endLayoutX);
                        transition3.play();
                    });
                });
            } else if (firstCoordinates <= 18 && secondCoordinates >= 20) {
                transition.setToY(((Cell) board.getChildren().get(19)).getLayoutY());

                transition.play();
                transition.setOnFinished(event -> {
                    transition2.setToX(endLayoutX);

                    transition2.play();
                });

            } else if (firstCoordinates <= 30 && secondCoordinates >= 32 && secondCoordinates <= 37) {
                transition.setToX(((Cell) board.getChildren().get(31)).getLayoutX());

                transition.play();
                transition.setOnFinished(event -> {
                    transition2.setToY(endLayoutY);

                    transition2.play();
                });
            } else if (firstCoordinates <= 30 && firstCoordinates >= 20 && secondCoordinates <= 11) {
                transition.setToX(((Cell) board.getChildren().get(31)).getLayoutX());
                transition.play();
                transition.setOnFinished(event -> {
                    transition2.setToY(((Cell) board.getChildren().get(0)).getLayoutY());
                    transition2.play();
                    transition2.setOnFinished(event1 -> {
                        transition3.setToX(endLayoutX);
                        transition3.play();
                    });

                });

            } else if (firstCoordinates <= 37 && firstCoordinates >= 31 && secondCoordinates <= 11) {
                transition.setToY(((Cell) board.getChildren().get(0)).getLayoutY());

                transition.play();
                transition.setOnFinished(event -> {
                    transition2.setToX(endLayoutX);

                    transition2.play();

                });
            } else {
                transition.setFromX(getTranslateX());
                transition.setFromY(getTranslateY());

                transition.setToX(endLayoutX);
                transition.setToY(endLayoutY);
                transition.play();
            }

            pause.playFromStart();
        }

    }

    public static int[] rand() {
        Random rand = new Random();
        int[] twoRandomNumbers = {
                rand.nextInt(6) + 1, rand.nextInt(6) + 1
        };
        return twoRandomNumbers;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getGames() {
        return games;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }
}
