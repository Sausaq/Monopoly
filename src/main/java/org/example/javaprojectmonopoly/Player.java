package org.example.javaprojectmonopoly;

import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import java.util.ArrayList;

public class Player extends StackPane {
    private PauseTransition pause = new PauseTransition(Duration.seconds(1));
    private Circle circle;
    private int index = 0;
    private int secondIndex;

    private int price = 1500000;

    private int id;
    private String name;
    private int wins;
    private int games;
    private String colorCode = "#FF3131";
    private int playerNum;


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Player(String name, String colorCode) {
        this.name = name;
        this.colorCode = colorCode;
        wins = 0;
        games = 0;
        circle = new Circle(13, Color.valueOf(colorCode));
        circle.setStrokeWidth(1);
        circle.setStroke(Color.BLACK);
        getChildren().add(circle);
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
        getChildren().add(circle);
    }

    public void addPlayerToBoard() {
        switch (playerNum) {
            case 1:
                setAlignment(circle, Pos.TOP_LEFT);
                setMargin(circle, new Insets(25, 0, 0, 15));
                break;
            case 2:
                setAlignment(circle, Pos.TOP_RIGHT);
                setMargin(circle, new Insets(25, 80, 0, 0));
                break;
            case 3:
                setAlignment(circle, Pos.BOTTOM_LEFT);
                setMargin(circle, new Insets(0, 0, 72, 15));
                break;
            case 4:
                setAlignment(circle, Pos.BOTTOM_RIGHT);
                setMargin(circle, new Insets(0, 80, 72, 0));
                break;
        }
    }

    public void moving(ArrayList<Company> companies, int firstRandom, int secondRandom) {
        if (!pause.getStatus().equals(Animation.Status.RUNNING)) {
            TranslateTransition transition = new TranslateTransition(Duration.seconds(1), this);
            TranslateTransition transition2 = new TranslateTransition(Duration.seconds(1), this);
            TranslateTransition transition3 = new TranslateTransition(Duration.seconds(1), this);

            int step = firstRandom + secondRandom;
            int firstIndex = index;
            secondIndex = (index + step) % 36;
            index = (index + step) % 36;

            Company nextCompany = companies.get(secondIndex);

            double endLayoutX = nextCompany.getLayoutX();
            double endLayoutY = nextCompany.getLayoutY();


            if (firstIndex <= 11 && secondIndex >= 13 && secondIndex <= 19) {
                transition.setToX(companies.get(12).getLayoutX());

                transition.play();
                transition.setOnFinished(event -> {
                    transition2.setToY(endLayoutY);
                    transition2.play();
                });
            } else if (firstIndex <= 11 && secondIndex >= 20) {
                transition.setToX(companies.get(12).getLayoutX());
                transition.play();
                transition.setOnFinished(event -> {
                    transition2.setToY(companies.get(19).getLayoutY());
                    transition2.play();
                    transition2.setOnFinished(event1 -> {
                        transition3.setToX(endLayoutX);
                        transition3.play();
                    });
                });
            } else if (firstIndex <= 18 && secondIndex >= 20) {
                transition.setToY(companies.get(19).getLayoutY());

                transition.play();
                transition.setOnFinished(event -> {
                    transition2.setToX(endLayoutX);

                    transition2.play();
                });

            } else if (firstIndex <= 30 && secondIndex >= 32 && secondIndex <= 37) {
                transition.setToX(companies.get(31).getLayoutX());

                transition.play();
                transition.setOnFinished(event -> {
                    transition2.setToY(endLayoutY);

                    transition2.play();
                });
            } else if (firstIndex <= 30 && firstIndex >= 20 && secondIndex <= 11) {
                transition.setToX(companies.get(31).getLayoutX());
                transition.play();
                transition.setOnFinished(event -> {
                    transition2.setToY(companies.get(0).getLayoutY());
                    transition2.play();
                    transition2.setOnFinished(event1 -> {
                        transition3.setToX(endLayoutX);
                        transition3.play();
                    });
                });

            } else if (firstIndex <= 37 && firstIndex >= 31 && secondIndex <= 11) {
                transition.setToY(companies.getFirst().getLayoutY());

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

    public int getMoney() {
        return price;
    }

    public void setMoney(int money) {
        price = money;
    }

    public int getIndex() {
        return secondIndex;
    }
}
