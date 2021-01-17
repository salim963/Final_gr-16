package Game;

import Fields.Estate;
import Fields.Ferry;
import Fields.Field;
import Fields.Tax;
import chancecardv2.ChanceCard;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Street;

import java.util.Objects;

import static java.lang.Thread.sleep;

public class Controller {

    private GuiView guiView = new GuiView();
    private ControllerField controllerField = new ControllerField();
    private Dice dice = new Dice();
    public Player player;
    int startPlayer = -1;
    private int sum;


    private Player nextPlayer(){
        startPlayer++;
        startPlayer %= guiView.player.length;
        return guiView.player[startPlayer];
    }

    public Controller() {
        boolean endGame = true;
        while (endGame) {

            player =  nextPlayer();

            playerTurn();
            landOnFields();
            updatePlayerBalance(player);

            if (player.getBalance() <= 0) {
                guiView.showInfo("Spiller har vundet, spillet afsluttes");
                endGame = false;
            }
        }
    }

    public void playerLost(){

        if (player.isDead()){
            System.out.println("Spilleren har tabt");
            player =  nextPlayer();
        }


        if (player.getBalance()<=0){

            player.setDead(true);

            guiView.player[player.getPlayerNumber()].isDead();

            guiView.gui.getFields()[player.getPlayerPos()].setCar(guiView.guiPlayer[player.getPlayerNumber()],false);
            guiView.gui.getFields()[0].setCar(guiView.guiPlayer[player.getPlayerNumber()],true);

        }/*else if (0==0){
            player.isDead();
        }*/

    }

    public void playerTurn() {

        guiView.gui.showMessage(player.getName() + "'s tur");

        String selection = guiView.gui.getUserSelection(player.getName() + ", vil du gerne kaste terningerne?", "Ja", "Nej");
        if (selection.equals("Nej")) {
            return;
        }

        if (selection.equals("Ja")) {
            int rolle1 =  dice.rollDice();
            int rolle2 =  dice.rollDice();
            sum = rolle1 +rolle2 ;

            player.setPlayerMoveToNewPos(sum);

            for (int Rotat = 0; Rotat <= 500; Rotat++) {
                guiView.gui.setDice(rolle1, Rotat, 3/2, 5,rolle2 , Rotat, 3, 5);


                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            updatePlayersPosition();

        }

    }

    public int updatePlayersPosition() {
        int currentPlayerPosition = player.getPlayerPos();
        int moveCurrentPlayersPositionTo = (player.getPlayerPos() + player.getPlayerMoveToNewPos())% guiView.gui.getFields().length;

        guiView.gui.getFields()[currentPlayerPosition].setCar(guiView.guiPlayer[player.getPlayerNumber()], false);

        guiView.gui.getFields()[moveCurrentPlayersPositionTo].setCar(guiView.guiPlayer[player.getPlayerNumber()], true);
        player.setPlayerPos(moveCurrentPlayersPositionTo );

        // tilføj 4000 hver gange passer start field
        if (currentPlayerPosition >= moveCurrentPlayersPositionTo ){
            playerReceivesMoney(4000);
            updatePlayerBalance(player);
        }

        return moveCurrentPlayersPositionTo;
    }


    public void setPropertyOwner(int fieldID){

        try{
            GUI_Ownable ownable = (GUI_Ownable) guiView.gui.getFields()[fieldID];
            ownable.setBorder(guiView.getPlayerColor(player.getPlayerNumber()));
            ownable.setOwnerName(player.getName());
            //iView.guiPlayer[player.getPlayerNumber()].getName()
            ((Estate) controllerField.fields[fieldID]).setOwner(guiView.guiPlayer[player.getPlayerNumber()].getName());

        } catch (RuntimeException e){
            System.out.println("WARNING" + guiView.gui.getFields()[fieldID].getClass().getName());
        }
    }


    public String getPropertyOwner(int fieldID){

        String name;
        name=((Estate) controllerField.fields[fieldID]).getOwner();

        return name;
    }

    public void updatePlayerBalance(Player player) {
        guiView.guiPlayer[player.getPlayerNumber()].setBalance(player.getBalance());
    }

    public int playerPayMoney(int chargeAmount){

        int newBalance= player.getBalance() - chargeAmount;

        player.setBalance(newBalance);

        return chargeAmount;
    }

    public void playerReceivesMoney(int chargeAmount){

        int newBalance= player.getBalance() + chargeAmount;

        player.setBalance(newBalance);
    }

    public void landOnFields(){

        Field f = controllerField.fields[player.getPlayerPos()];
        String t = String.valueOf(f);
        System.out.println(t + " " + "field_Type");

        if (Objects.equals(t, "Estate")){
            estateHandling();
        }

        else if (Objects.equals(t, "Tax")){
            payTax();
        }

        else if (Objects.equals(t, "Ferry")){
            ferryHandling();
        }

        else if(Objects.equals(t, "Parking")){
            parkingHandling();
        }

        else if(Objects.equals(t, "VisitJail")){

        }

        else if(Objects.equals(t, "ChanceField")){
            pullChanceCard();
            updatePlayersPosition();

        } else if(Objects.equals(t, "GotoJail")){
            jailHandling();
        }
    }


    public Player getPlayer(String name) {
        for (Player aPlayer : guiView.player) {
            if (aPlayer.getName().equals(name)) return aPlayer;
        }
        return null;
    }


    public void payAHouse(){

        GUI_Street street = (GUI_Street) guiView.gui.getFields()[player.getPlayerPos()];
        street.setHouses(0);
    }

    public void estateHandling(){

        String owner = getPropertyOwner(player.getPlayerPos());

        if ( owner == null ) {
            int[] TheRent= ((Estate) controllerField.fields[player.getPlayerPos()]).getRent();
            System.out.println(TheRent[0]+" leje");
            int propertyPrice = controllerField.getPropertyPrice(player.getPlayerPos());

            String buy = guiView.gui.getUserButtonPressed("Vil du gerne købe denne her felt for" + " " + propertyPrice + "?", "Ja","Nej");

            if (buy.equals("Ja")) {

                playerPayMoney(propertyPrice);
                updatePlayerBalance(player);
                setPropertyOwner(player.getPlayerPos());

            }if (buy.equals("Nej")) {
                return;
            }


        }else if (owner==player.getName()){
            guiView.gui.showMessage("Du skal ikke betale noget, da du allerede ejer dette felt ");
            return;


        } else if (owner != null){

            guiView.gui.showMessage("Der er en anden spiller, som ejer denne felt " + ", hans/hendes nav er " + owner + " så du " + " skal betale skat til " + owner);
            int[] rent= ((Estate) controllerField.fields[player.getPlayerPos()]).getRent();
            // add money to the owner player.
            playerPayMoney(rent[0]);
            updatePlayerBalance(player);
            //The player will pay to other player
            getPlayer(owner).addAmount(rent[0]);
            updatePlayerBalance(getPlayer(owner));
            //

        }
    }

    public void payTax(){

        ((Tax) controllerField.fields[player.getPlayerPos()]).getRent();

        System.out.println("Skat du skal betale" +((Tax) controllerField.fields[player.getPlayerPos()]).getRent() );
        playerPayMoney(((Tax) controllerField.fields[player.getPlayerPos()]).getRent());
    }

    public void ferryHandling(){


        String owner =((Ferry) controllerField.fields[player.getPlayerPos()]).getOwner();

        if ( owner == null ) {

            int propertyPrice = ((Ferry) controllerField.fields[player.getPlayerPos()]).getPropertyPrice();

            String buy = guiView.gui.getUserButtonPressed("Vil du gerne købe denne her felt for" + " " + propertyPrice + "?" , "Ja","Nej");

            if (buy.equals("Ja")) {
                playerPayMoney(propertyPrice);
                updatePlayerBalance(player);
                setPropertyOwner(player.getPlayerPos());

            }if (buy.equals("Nej")) {
                return;
            }


        }else if (owner.equals(player.getName())){
            guiView.gui.showMessage("Du skal ikke betale noget, da du allerede ejer dette felt ");
            return;


        } else if (owner != null){
            int TheRent= ((Ferry) controllerField.fields[player.getPlayerPos()]).getRent();
            System.out.println(TheRent + " rent");
            guiView.gui.showMessage("Der er en anden spiller, som ejer denne felt " +", hans/hendes nav er " + owner + " så du " + " skal betale lejepengene til " + owner);
            // add money to the owner player.
            playerPayMoney(TheRent);
            updatePlayerBalance(player);
            //The player will pay to other player
            getPlayer(owner).addAmount(TheRent);
            updatePlayerBalance(getPlayer(owner));
            //

        }
    }

    public void parkingHandling() {
        guiView.gui.showMessage(" Du skal ikke betale noget her, da parkering er gratis ");
    }

    public void jailHandling() {

        guiView.gui.showMessage(" Du skal gå til fængsel");
        // player.setPlayerInJail(true);
        player.setPlayerMoveToNewPos(20);
        updatePlayersPosition();
        playerPayMoney(4000);

    }

    public void pullChanceCard() {
        ChanceCard chanceCard = new ChanceCard();

        switch (dice.pullChanceCard()) {
            case 1:
                guiView.showInfo(chanceCard.cardDescription().get(0));
                player.setBalance(player.getBalance() + chanceCard.getCardValue().get(0));
                break;
            case 2:
                guiView.showInfo(chanceCard.cardDescription().get(1));
                player.setBalance(player.getBalance() + chanceCard.getCardValue().get(1));
                break;
            case 3:
                guiView.showInfo(chanceCard.cardDescription().get(2));
                player.setBalance(player.getBalance() + chanceCard.getCardValue().get(2));
                break;
            case 4:
                guiView.showInfo(chanceCard.cardDescription().get(3));
                player.setBalance(player.getBalance() + chanceCard.getCardValue().get(3));
                break;
            case 5:
                guiView.showInfo(chanceCard.cardDescription().get(4));
                player.setBalance(player.getBalance() + chanceCard.getCardValue().get(4));
                break;
            case 6:
                guiView.showInfo(chanceCard.cardDescription().get(5));
                player.setBalance(player.getBalance() + chanceCard.getCardValue().get(5));
                break;
            case 7:
                guiView.showInfo(chanceCard.cardDescription().get(6));
                player.setBalance(player.getBalance() + chanceCard.getCardValue().get(6));
                break;
            case 8:
                guiView.showInfo(chanceCard.cardDescription().get(7));
                player.setBalance(player.getBalance() + chanceCard.getCardValue().get(7));
                break;
            case 9:
                guiView.showInfo(chanceCard.cardDescription().get(8));
                player.setBalance(player.getBalance() + chanceCard.getCardValue().get(8));
                break;
            case 10:
                guiView.showInfo(chanceCard.cardDescription().get(9));
                player.setBalance(player.getBalance() + chanceCard.getCardValue().get(9));
                break;
            case 11:
                guiView.showInfo(chanceCard.cardDescription().get(10));
                player.setBalance(player.getBalance() + chanceCard.getCardValue().get(10));
                break;
            case 12:
                guiView.showInfo(chanceCard.cardDescription().get(11));
                player.setBalance(player.getBalance() + chanceCard.getCardValue().get(11));
                break;
            case 13:
                guiView.showInfo(chanceCard.cardDescription().get(12));
                player.setBalance(player.getBalance() + chanceCard.getCardValue().get(12));
                break;
            case 14:
                guiView.showInfo(chanceCard.cardDescription().get(13));
                player.setBalance(player.getBalance() + chanceCard.getCardValue().get(13));
                break;
            case 15:
                guiView.showInfo(chanceCard.cardDescription().get(14));
                player.setPlayerPos(player.getPlayerPos() + chanceCard.getCardValue().get(14));
                break;
            case 16:
                guiView.showInfo(chanceCard.cardDescription().get(15));
                player.setPlayerPos(player.getPlayerPos() + chanceCard.getCardValue().get(15));
                break;
            case 17:
                guiView.showInfo(chanceCard.cardDescription().get(16));
                player.setPlayerPos(chanceCard.getCardValue().get(16));
                break;
            case 18:
                guiView.showInfo(chanceCard.cardDescription().get(17));
                player.setPlayerPos(chanceCard.getCardValue().get(17));
                break;
            case 19:
                guiView.showInfo(chanceCard.cardDescription().get(18));
                player.setPlayerPos(chanceCard.getCardValue().get(18));
                break;
            case 20:
                guiView.showInfo(chanceCard.cardDescription().get(19));
                player.setPlayerPos(chanceCard.getCardValue().get(19));
                break;
        }
    }

}

