package Game;


import java.awt.*;

public class Player {

    private String name;
    private int playerNumber;
    private int playerPos=0;
    private Color color;
    private int balance;
    private int PlayerMoveToNewPos;
    private boolean PlayerInJail;
    private boolean dead;



    public Player(String name, int playerNumber, int balance ) {
        this.name = name;
        this.playerNumber = playerNumber;
        this.balance= balance;

    }


    public Player() {
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }


    public boolean isPlayerInJail() {
        return PlayerInJail;
    }

    public void setPlayerInJail(boolean playerInJail) {
        PlayerInJail = playerInJail;
    }






    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public int getPlayerPos() {
        return playerPos;
    }


    public int setPlayerPos(int playerPos) {


        this.playerPos = playerPos;
        return playerPos;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    public int getPlayerMoveToNewPos() {
        return PlayerMoveToNewPos;
    }

    public void setPlayerMoveToNewPos(int playerMoveToNewPos) {
        PlayerMoveToNewPos = playerMoveToNewPos;
    }


    public int addAmount(int amount){
        this.balance += amount;

        return amount;
    }



}
