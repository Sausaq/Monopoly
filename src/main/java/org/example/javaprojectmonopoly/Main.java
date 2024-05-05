package org.example.javaprojectmonopoly;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;



public class Main extends Application {
    @Override
    public void start(Stage stage) {
        DBManager.connect();

        Menu menu = new Menu();
        menu.playersField(DBManager.getAllPlayers());
        Scene menuScene = new Scene(menu);

        NewPlayerMenu newPlayerMenu = new NewPlayerMenu();
        Scene newPlayerScene = new Scene(newPlayerMenu, 1500, 900);

        ChangePlayerMenu changePlayerMenu = new ChangePlayerMenu();
        Scene changePlayerScene = new Scene(changePlayerMenu, 1500, 900);

        stage.setScene(menuScene);
        stage.setHeight(900);
        stage.setWidth(1500);
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("Esc"));
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.setTitle("Monopoly Board");
        stage.show();

        menu.getNewPlayerButton().setOnAction(e -> stage.setScene(newPlayerScene));
        menu.getChangePlayerButton().setOnAction(e -> stage.setScene(changePlayerScene));
        newPlayerMenu.getCancelButton().setOnAction(b -> stage.setScene(menuScene));
//        newPlayerMenu.getCreate().setOnAction(c -> stage.setScene(menuScene));

        changePlayerMenu.getCancelButton().setOnAction(event -> {
//            menu.playersField(DBManager.getAllPlayers());
            stage.setScene(menuScene);
        });
//        changePlayerMenu.getCreate().setOnAction(c -> stage.setScene(menuScene));

        menu.getStartButton().setOnAction(event -> {
            Game game = new Game(menu.getAddedPlayers());
            Scene gameScene = new Scene(game, 1500, 900);
            stage.setScene(gameScene);
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}

