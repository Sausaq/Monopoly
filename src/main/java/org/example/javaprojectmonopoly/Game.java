package org.example.javaprojectmonopoly;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.ArrayList;

public class Game extends StackPane {
    HBox boardAndUsers;
    ImageView background;
    GameBoard board;
    UserList playersList;
    GameClient client; // Include a GameClient instance

    public Game(ArrayList<Player> players) throws IOException {
        background = new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/background.png")));
        boardAndUsers = new HBox();

        playersList = new UserList();
        playersList.createUserList(players);
        board = new GameBoard(players, playersList);
        HBox.setMargin(board, new Insets(0, 10, 0, 75));
        boardAndUsers.getChildren().addAll(board, playersList);

        getChildren().addAll(background, boardAndUsers);
        setMargin(boardAndUsers, new Insets(30,0,0,0));

        // Create and start the client
        client = new GameClient();
        client.startConnection("server_ip_address", 8080); // Replace "server_ip_address" and port_number with actual values

        Thread printBoardChildrenThread = new Thread(() -> {
            for (int i = 0; i < board.getChildren().size(); i++) {
                System.out.println(board.getChildren().get(i) + "  " + i);
            }
        });
        printBoardChildrenThread.start();
    }

    public void sendDataToServer(String data) {
        client.send(data);
    }

    public String receiveDataFromServer() {
        try {
            return client.receive();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
