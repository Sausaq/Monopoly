package org.example.javaprojectmonopoly;

public class Transaction {
    Player player;
    Cell company;


    public Transaction (){
    }


    public Transaction(Player player, Cell company) {
        this.player = player;
        this.company = company;
    }

    @Override
    public String toString() {
        return "Transaction{" + "Player = " + player.getName() + " buy company = " + company + '}';
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cell getCompany() {
        return company;
    }

    public void setCompany(Cell company) {
        this.company = company;
    }
}
