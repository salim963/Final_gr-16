package Game;

import Game.PlayerController;

import java.awt.*;

public class Player {

    private int playerId;
    private String name;
    private int balance;



    public boolean isPlayerTurn() {
        return PlayerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        PlayerTurn = playerTurn;
    }

    private boolean PlayerTurn;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    private Color color;

    public Player(int playerId, String name, int balance) {
        this.playerId = playerId;
        this.name = name;
        this.balance = balance;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int addAmount(int amount){
        this.balance += amount;

        return amount;
    }



    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getNewPosition() {
        return newPosition;
    }

    public void setNewPosition(int newPosition) {
        this.newPosition = newPosition;
    }

    private int currentPosition;
    private int newPosition;



}
