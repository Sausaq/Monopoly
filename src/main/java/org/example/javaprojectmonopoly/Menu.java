package org.example.javaprojectmonopoly;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class Menu extends StackPane {
    private HBox menu = new HBox();
    private static VBox addedPlayerlist = new VBox();
    private static VBox playerlist = new VBox();
    private static Font beaumaris = Font.font(20);
    private static Font peaceSans = Font.font(36);

    private MyButton newPlayerButton = new MyButton("Новый игрок", 640, 105, peaceSans);
    private MyButton startButton = new MyButton("Начать игру", 640, 105, peaceSans);
    private MyButton changePlayerButton = new MyButton("Изменить", 640, 105, peaceSans);
    private MyButton deletePlayerButton = new MyButton("Удалить", 640, 105, peaceSans);

    private static ArrayList<Player> addedPlayers = new ArrayList<>();
    private static ArrayList<Player> players;

    public Menu(ArrayList<Player> players) {
        ImageView background = new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/background.png")));
        Menu.players = players;


        //Часть кода для левой части меню
        Rectangle leftSideRectangle1 = new Rectangle(726, 473);
        leftSideRectangle1.setFill(Color.valueOf("#A6A6A6"));
        leftSideRectangle1.setArcWidth(50);
        leftSideRectangle1.setArcHeight(50);

        ImageView monopoly = new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/monopoly_icon.jpg")));
        monopoly.setFitHeight(91);
        monopoly.setFitWidth(91);

        VBox buttons = new VBox(monopoly, newPlayerButton, changePlayerButton, deletePlayerButton);

        VBox.setMargin(newPlayerButton, new Insets(10, 0, 0, 45));
        VBox.setMargin(changePlayerButton, new Insets(10, 0, 0, 45));
        VBox.setMargin(deletePlayerButton, new Insets(10, 0, 0, 45));
        VBox.setMargin(monopoly, new Insets(10, 0, 0, 45));

        StackPane buttonsPane = new StackPane(leftSideRectangle1, buttons);
        VBox.setMargin(buttonsPane, new Insets(17, 0, 10, 40));

        Rectangle leftSideRectangle2 = new Rectangle(726, 394);
        Rectangle textBack = new Rectangle(676, 63);
        textBack.setFill(Color.valueOf("#FF3131"));
        textBack.setArcWidth(30);
        textBack.setArcHeight(30);
        Label textlabel = new Label("Выбранные игроки");
        textlabel.setFont(beaumaris);
        StackPane textAddedPlayers = new StackPane(textBack, textlabel);
        VBox.setMargin(textAddedPlayers, new Insets(10,0,0,30));

        addedPlayerlist.getChildren().add(textAddedPlayers);

        leftSideRectangle2.setFill(Color.valueOf("#A6A6A6"));
        leftSideRectangle2.setArcWidth(50);
        leftSideRectangle2.setArcHeight(50);
        StackPane addedPlayersPane = new StackPane(leftSideRectangle2, addedPlayerlist);

        StackPane.setMargin(leftSideRectangle2, new Insets(0, 0, 33, 40));


        VBox.setMargin(startButton, new Insets(10, 0, 0, 45));

        VBox leftSide = new VBox(buttonsPane, addedPlayersPane, startButton);

        menu.getChildren().add(leftSide);
        getChildren().addAll(background, menu);

        playerlist.setAlignment(Pos.CENTER);
        playerlist.setSpacing(10);
        playerlist.setStyle("-fx-background-color: #D9D9D9;");

        int i = 0;
        for (Player player: this.players) {
            Rectangle rec = new Rectangle(900, 200);
            rec.setStroke(Color.BLACK);
            rec.setStrokeWidth(2);
            i++;
            if (i % 2 == 0) {
                rec.setFill(Color.valueOf("#EFB800"));
            }else{
                rec.setFill(Color.valueOf("#FFE17C"));
            }
            rec.setArcHeight(50);
            rec.setArcWidth(50);

            HBox playerInfo = new HBox();

            Circle circle = new Circle(70);
            circle.setFill(Color.valueOf(player.getColorCode()));
            circle.setStrokeWidth(2);
            circle.setStroke(Color.BLACK);
            Rectangle avatarBackground = new Rectangle(180, 180);
            avatarBackground.setFill(Color.valueOf("#FF3131"));
            avatarBackground.setArcWidth(50);
            avatarBackground.setArcHeight(50);
            avatarBackground.setStrokeWidth(2);
            avatarBackground.setStroke(Color.BLACK);
            StackPane avatar = new StackPane(avatarBackground ,circle);
            HBox.setMargin(avatar, new Insets(0,0,0,36));

            VBox nameAndScore = new VBox();

            Rectangle nameBackground = new Rectangle(600, 78);
            nameBackground.setFill(Color.valueOf("#FF3131"));
            nameBackground.setArcWidth(50);
            nameBackground.setArcHeight(50);
            nameBackground.setStrokeWidth(2);
            nameBackground.setStroke(Color.BLACK);
            Label nameLabel = new Label(player.getName());
            nameLabel.setFont(beaumaris);

            StackPane name = new StackPane(nameBackground, nameLabel);
            VBox.setMargin(name, new Insets(10,0,0,36));


            HBox winsAndGames = new HBox();

            Rectangle winsBackground = new Rectangle(220, 78);
            winsBackground.setFill(Color.valueOf("#FF3131"));
            winsBackground.setArcWidth(50);
            winsBackground.setArcHeight(50);
            winsBackground.setStrokeWidth(2);
            winsBackground.setStroke(Color.BLACK);

            ImageView corona = new ImageView(new Image( getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/corona.png")));
            corona.setFitWidth(94);
            corona.setFitHeight(47);

            Label winslabel = new Label(String.valueOf(player.getWins()));
            winslabel.setFont(beaumaris);

            StackPane wins = new StackPane(winsBackground, corona, winslabel);
            wins.setAlignment(Pos.CENTER_LEFT);

            HBox.setMargin(wins, new Insets(20,0,0,36));
            StackPane.setMargin(corona, new Insets(0,0,0,30));
            StackPane.setMargin(winslabel, new Insets(0,0,0,160));


            Rectangle gamesBackground = new Rectangle(220, 78);
            gamesBackground.setFill(Color.valueOf("#FF3131"));
            gamesBackground.setArcWidth(50);
            gamesBackground.setArcHeight(50);
            gamesBackground.setStrokeWidth(2);
            gamesBackground.setStroke(Color.BLACK);

            ImageView gamepad = new ImageView(new Image( getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/gamepad.png")));
            gamepad.setFitWidth(94);
            gamepad.setFitHeight(55);

            Label gamesLabel = new Label(String.valueOf(player.getGames()));
            gamesLabel.setFont(beaumaris);

            StackPane games = new StackPane(gamesBackground, gamepad, gamesLabel);
            HBox.setMargin(games, new Insets(20,0,0,40));
            StackPane.setMargin(gamepad, new Insets(0,0,0,30));
            StackPane.setMargin(gamesLabel, new Insets(0,0,0,160));

            games.setAlignment(Pos.CENTER_LEFT);

            MyButton addPlayerButton = new MyButton("+", 78, 78, peaceSans);

            addPlayerButton.setOnAction(e -> {
                updateAddedPlayersList(player);
                addPlayerButton.setDisable(true);
            });

            HBox.setMargin(addPlayerButton, new Insets(20,0,0,40));

            winsAndGames.getChildren().addAll(wins, games, addPlayerButton);

            nameAndScore.getChildren().addAll(name, winsAndGames);

            playerInfo.getChildren().addAll(avatar, nameAndScore);

            StackPane stackPane = new StackPane(rec, playerInfo);
            stackPane.setMaxSize(900, 200);

            playerlist.getChildren().add(stackPane);
        }

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefSize(1019, 980);
        scrollPane.setMaxSize(1019, 980);
        scrollPane.setContent(playerlist);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: #D9D9D9;");


        Rectangle rightSideRectangle = new Rectangle(1019, 1025);
        rightSideRectangle.setFill(Color.valueOf("#D9D9D9"));
        rightSideRectangle.setArcWidth(50);
        rightSideRectangle.setArcHeight(50);

        StackPane listOfPlayers = new StackPane(rightSideRectangle, scrollPane);
        StackPane.setMargin(rightSideRectangle, new Insets(17, 0, 36, 90));
        StackPane.setMargin(scrollPane, new Insets(17, 0, 36, 90));

        menu.getChildren().add(listOfPlayers);

        for (int j = 0; j < addedPlayerlist.getChildren().size(); j++) {
            System.out.println(addedPlayerlist.getChildren().get(j));
        }
    }

    private static int i = 1;
    public static void updateAddedPlayersList(Player player) {
        if (i <= 4) {
            player.setPlayerNum(i);
            addedPlayers.add(player);

            HBox addedPlayer = new HBox();
            Rectangle numberTextBack = new Rectangle(58, 58);
            numberTextBack.setFill(Color.valueOf("#FF3131"));
            numberTextBack.setArcWidth(30);
            numberTextBack.setArcHeight(30);
            Label numberText = new Label(String.valueOf(i));
            numberText.setFont(beaumaris);
            StackPane number = new StackPane(numberTextBack, numberText);

            Rectangle addedPlayerNameBack = new Rectangle(584, 58);
            addedPlayerNameBack.setFill(Color.valueOf("#EFB800"));
            addedPlayerNameBack.setArcWidth(30);
            addedPlayerNameBack.setArcHeight(30);
            Label AddedPlayerNameText = new Label(player.getName());
            AddedPlayerNameText.setFont(beaumaris);
            StackPane addedPlayerName = new StackPane(addedPlayerNameBack, AddedPlayerNameText);


            VBox.setMargin(addedPlayer, new Insets(0, 0, 0, 30));
            HBox.setMargin(number, new Insets(10, 0, 0, 30));
            HBox.setMargin(addedPlayerName, new Insets(10, 0, 0, 30));

            addedPlayer.getChildren().addAll(number, addedPlayerName);

            addedPlayerlist.getChildren().add(addedPlayer);
        }
        i++;
    }

    private static int j = 1;
    public static void updatePlayersList(Player player) {
        players.add(player);
        Rectangle rec = new Rectangle(900, 200);
        rec.setStroke(Color.BLACK);
        rec.setStrokeWidth(2);
        j++;
        if (j % 2 == 0) {
            rec.setFill(Color.valueOf("#EFB800"));
        }else{
            rec.setFill(Color.valueOf("#FFE17C"));
        }
        rec.setArcHeight(50);
        rec.setArcWidth(50);

        HBox playerInfo = new HBox();

        Circle circle = new Circle(70);
        circle.setFill(Color.valueOf(player.getColorCode()));
        circle.setStrokeWidth(2);
        circle.setStroke(Color.BLACK);
        Rectangle avatarBackground = new Rectangle(180, 180);
        avatarBackground.setFill(Color.valueOf("#FF3131"));
        avatarBackground.setArcWidth(50);
        avatarBackground.setArcHeight(50);
        avatarBackground.setStrokeWidth(2);
        avatarBackground.setStroke(Color.BLACK);
        StackPane avatar = new StackPane(avatarBackground ,circle);
        HBox.setMargin(avatar, new Insets(0,0,0,36));

        VBox nameAndScore = new VBox();

        Rectangle nameBackground = new Rectangle(600, 78);
        nameBackground.setFill(Color.valueOf("#FF3131"));
        nameBackground.setArcWidth(50);
        nameBackground.setArcHeight(50);
        nameBackground.setStrokeWidth(2);
        nameBackground.setStroke(Color.BLACK);
        Label nameLabel = new Label(player.getName());
        nameLabel.setFont(beaumaris);

        StackPane name = new StackPane(nameBackground, nameLabel);
        VBox.setMargin(name, new Insets(10,0,0,36));


        HBox winsAndGames = new HBox();

        Rectangle winsBackground = new Rectangle(220, 78);
        winsBackground.setFill(Color.valueOf("#FF3131"));
        winsBackground.setArcWidth(50);
        winsBackground.setArcHeight(50);
        winsBackground.setStrokeWidth(2);
        winsBackground.setStroke(Color.BLACK);

        ImageView corona = new ImageView(new Image( Menu.class.getResourceAsStream("/org/example/javaprojectmonopoly/images/corona.png")));
        corona.setFitWidth(94);
        corona.setFitHeight(47);

        Label winslabel = new Label(String.valueOf(player.getWins()));
        winslabel.setFont(beaumaris);

        StackPane wins = new StackPane(winsBackground, corona, winslabel);
        wins.setAlignment(Pos.CENTER_LEFT);

        HBox.setMargin(wins, new Insets(20,0,0,36));
        StackPane.setMargin(corona, new Insets(0,0,0,30));
        StackPane.setMargin(winslabel, new Insets(0,0,0,160));

        Rectangle gamesBackground = new Rectangle(220, 78);
        gamesBackground.setFill(Color.valueOf("#FF3131"));
        gamesBackground.setArcWidth(50);
        gamesBackground.setArcHeight(50);
        gamesBackground.setStrokeWidth(2);
        gamesBackground.setStroke(Color.BLACK);

        ImageView gamepad = new ImageView(new Image( Menu.class.getResourceAsStream("/org/example/javaprojectmonopoly/images/gamepad.png")));
        gamepad.setFitWidth(94);
        gamepad.setFitHeight(55);

        Label gamesLabel = new Label(String.valueOf(player.getGames()));
        gamesLabel.setFont(beaumaris);

        StackPane games = new StackPane(gamesBackground, gamepad, gamesLabel);
        HBox.setMargin(games, new Insets(20,0,0,40));
        StackPane.setMargin(gamepad, new Insets(0,0,0,30));
        StackPane.setMargin(gamesLabel, new Insets(0,0,0,160));

        games.setAlignment(Pos.CENTER_LEFT);

        MyButton addPlayerButton = new MyButton("+", 78, 78);
        addPlayerButton.setFont(peaceSans);

        addPlayerButton.setOnAction(e -> {
            updateAddedPlayersList(player);
            addPlayerButton.setDisable(true);
        });

        HBox.setMargin(addPlayerButton, new Insets(20,0,0,40));

        winsAndGames.getChildren().addAll(wins, games, addPlayerButton);

        nameAndScore.getChildren().addAll(name, winsAndGames);

        playerInfo.getChildren().addAll(avatar, nameAndScore);

        StackPane stackPane = new StackPane(rec, playerInfo);
        stackPane.setMaxSize(900, 200);

        playerlist.getChildren().add(stackPane);
    }

    public Button getNewPlayerButton(){
        return newPlayerButton;
    }

    public Button getChangePlayerButton(){
        return changePlayerButton;
    }

    public Button getDeletePlayerButton(){
        return deletePlayerButton;
    }

    public ArrayList<Player> getAddedPlayers() {
        return addedPlayers;
    }

    public Button getStartButton() {
        return startButton;
    }
}
