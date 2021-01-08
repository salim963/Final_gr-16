public class Player {

    private int playerId;
    private String name;
    private int position = 0;
    public int oldPosition = 0;
    private Balance balance;

    public Player(int playerId, String name, int amount) {
        this.playerId = playerId;
        this.name = name;
        balance = new Balance(amount);
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

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getOldPosition() {
        return oldPosition;
    }

    public void setOldPosition(int oldPosition) {
        this.oldPosition = oldPosition;
    }

    @Override
    public String toString() {
        return "Bean.Player{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }


}
