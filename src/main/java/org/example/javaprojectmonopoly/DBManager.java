package org.example.javaprojectmonopoly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private static final String url = "jdbc:postgresql://localhost/Monopoly";
    private static final String user = "postgres";
    private static final String password = "00000000";
    private static Connection connection;

    public static void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection success!!!");
        } catch (Exception e) {
            System.out.println("Connection error!!!!!");
            e.printStackTrace();
        }
    }

    public static void updatePlayer(String oldName, Player player) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE public.players SET name = ?, color_code = ? WHERE name = ?"
            );
            statement.setString(1, player.getName());
            statement.setString(2, player.getColorCode());
            statement.setString(3, oldName);

            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static ArrayList<Player> getAllPlayers(){
        ArrayList<Player> players = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM public.players"
            );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                players.add(new Player(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("wins"),
                        resultSet.getInt("games"),
                        resultSet.getString("color_code")
                ));
            }
            statement.close();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return players;
    }

    public static void insertPlayer(Player player){
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO public.players(name, games, wins, color_code) VALUES(?, 0, 0, ?)"
            );
            statement.setString(1, player.getName());
            statement.setString(2, player.getColorCode());

            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static void deletePlayer(String name){
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM public.players WHERE name = ?"
            );
            statement.setString(1, name);

            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
