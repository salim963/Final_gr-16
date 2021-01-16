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
    private ControllerField c_field = new ControllerField();
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


        while (true) {

            player =  nextPlayer();

            //Playerlost();

            PlayerTurn();
            fieldsDefinition();
            updatePlayerBalance(player);

        }
    }

    public void Playerlost(){

        if (player.isDead()){
            System.out.println("PlayerIsDead");
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

    public void PlayerTurn() {


        guiView.gui.showMessage(player.getName() + "'s tur");

        String tryk = guiView.gui.getUserSelection(player.getName() + ", vil du gerne kaste terningerne?", "Ja", "Nej");
        if (tryk.equals("Nej")) {
            return;
        }

        if (tryk.equals("Ja")) {
            int rolle1 =  dice.rollDice();
            int rolle2 =  dice.rollDice();
            sum=rolle1 +rolle2 ;

            player.setPlayerMoveToNewPos(sum);

            for (int Rotat = 0; Rotat <= 500; Rotat++) {
                guiView.gui.setDice(rolle1, Rotat, 3/2, 5,rolle2 , Rotat, 3, 5);


                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            UpdatePlayersPosition();

        }

    }

    public void UpdatePlayersPosition() {

        int CorrentPlayerPpstion = player.getPlayerPos();
        int MoveCorrentPlayerPpstionTo = (player.getPlayerPos() + player.getPlayerMoveToNewPos())% guiView.gui.getFields().length;


            guiView.gui.getFields()[CorrentPlayerPpstion].setCar(guiView.guiPlayer[player.getPlayerNumber()], false);

            guiView.gui.getFields()[MoveCorrentPlayerPpstionTo].setCar(guiView.guiPlayer[player.getPlayerNumber()], true);
            player.setPlayerPos(MoveCorrentPlayerPpstionTo );


        // tilføj 4000 hver gange passer start field
        if (CorrentPlayerPpstion >= MoveCorrentPlayerPpstionTo ){
            PlayerReciveMoney(4000);
            updatePlayerBalance(player);

        }





    }


    public void setPropertyOwner(int fieldID){

        try{
            GUI_Ownable ownable = (GUI_Ownable) guiView.gui.getFields()[fieldID];
            ownable.setBorder(guiView.getPlayerColor(player.getPlayerNumber()));
            ownable.setOwnerName(player.getName());
            //iView.guiPlayer[player.getPlayerNumber()].getName()
            ((Estate)c_field.fields[fieldID]).setOwner(guiView.guiPlayer[player.getPlayerNumber()].getName());

        } catch (RuntimeException e){
            System.out.println("WARNING" + guiView.gui.getFields()[fieldID].getClass().getName());
        }
    }


    public String getPropertyOwner(int fieldID){

        String name;
        name=((Estate)c_field.fields[fieldID]).getOwner();

        return name;
    }

    public void updatePlayerBalance(Player player) {
        guiView.guiPlayer[player.getPlayerNumber()].setBalance(player.getBalance());
        //player.setPlayerPos(player.getPlayerPos());

    }

    public void playerPayMoney(int chargeAmount){

        int newbalance= player.getBalance() - chargeAmount;

        player.setBalance(newbalance);
    }
    public void PlayerReciveMoney( int chargeAmount){

        int newbalance= player.getBalance() + chargeAmount;

        player.setBalance(newbalance);

    }

    public void fieldsDefinition(){

        Field f = c_field.fields[player.getPlayerPos()];
        String t = String.valueOf(f);
        System.out.println(t + " " + "field_Type");

        if (Objects.equals(t, "Estate")){
            EstateEdition();
        }

        else if (Objects.equals(t, "Tax")){
            PayTax();
        }

        else if (Objects.equals(t, "Ferry")){
            FerryEdition();
        }

        else if(Objects.equals(t, "Parking")){
            parkingEdition();
        }

        else if(Objects.equals(t, "VisitJail")){

        }

        else if(Objects.equals(t, "ChanceField")){
            pullChanceCard();

        } else if(Objects.equals(t, "GotoJail")){
            GotoJailEdition();
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


    public void EstateEdition(){

        String TheOwner = getPropertyOwner(player.getPlayerPos());

        if ( TheOwner == null ) {
            int[] TheRent= ((Estate)c_field.fields[player.getPlayerPos()]).getRent();
            System.out.println(TheRent[0]+" leje");
            int PropertyPrice = c_field.getPropertyPrice(player.getPlayerPos());

            String buy = guiView.gui.getUserButtonPressed("Vil du gerne købe denne her felt for" + " " + PropertyPrice + "?", "Ja","Nej");

            if (buy.equals("Ja")) {

                playerPayMoney(PropertyPrice);
                updatePlayerBalance(player);
                setPropertyOwner(player.getPlayerPos());

            }if (buy.equals("Nej")) {
                return;
            }


        }else if (TheOwner==player.getName()){
            guiView.gui.showMessage("Du skal ikke betale noget, da du allerede ejer dette felt ");
            return;


        } else if (TheOwner != null){

            guiView.gui.showMessage("Der er en anden spiller, som ejer denne felt " + ", hans/hendes nav er " + TheOwner + " så du " + " skal betale skat til " + TheOwner);
            int[] TheRent= ((Estate)c_field.fields[player.getPlayerPos()]).getRent();
            // add money to the owner player.
            playerPayMoney(TheRent[0]);
            updatePlayerBalance(player);
            //The player will pay to other player
            getPlayer(TheOwner).addAmount(TheRent[0]);
            updatePlayerBalance(getPlayer(TheOwner));
            //

        }
    }

    public void PayTax(){

        ((Tax)c_field.fields[player.getPlayerPos()]).getRent();

        System.out.println("Skat du skal betale" +((Tax)c_field.fields[player.getPlayerPos()]).getRent() );
        playerPayMoney(((Tax)c_field.fields[player.getPlayerPos()]).getRent());
    }

    public void FerryEdition(){


        String TheOwner =((Ferry)c_field.fields[player.getPlayerPos()]).getOwner();

        if ( TheOwner == null ) {

            int PropertyPrice = ((Ferry)c_field.fields[player.getPlayerPos()]).getPropertyPrice();

            String buy = guiView.gui.getUserButtonPressed("Vil du gerne købe denne her felt for" + " " + PropertyPrice + "?" , "Ja","Nej");

            if (buy.equals("Ja")) {
                playerPayMoney(PropertyPrice);
                updatePlayerBalance(player);
                setPropertyOwner(player.getPlayerPos());

            }if (buy.equals("Nej")) {
                return;
            }


        }else if (TheOwner==player.getName()){
            guiView.gui.showMessage("Du skal ikke betale noget, da du allerede ejer dette felt ");
            return;


        } else if (TheOwner != null){
            int TheRent= ((Ferry)c_field.fields[player.getPlayerPos()]).getRent();
            System.out.println(TheRent + " rent");
            guiView.gui.showMessage("Der er en anden spiller, som ejer denne felt " +", hans/hendes nav er " + TheOwner + " så du " + " skal betale lejepengene til " + TheOwner);
            // add money to the owner player.
            playerPayMoney(TheRent);
            updatePlayerBalance(player);
            //The player will pay to other player
            getPlayer(TheOwner).addAmount(TheRent);
            updatePlayerBalance(getPlayer(TheOwner));
            //

        }
    }

    public void parkingEdition() {
        guiView.gui.showMessage(" Du skal ikke betale noget her, da parkering er gratis ");

    }




    public void GotoJailEdition() {

        guiView.gui.showMessage(" Du skal gå til fængsel");
        // player.setPlayerInJail(true);
        player.setPlayerMoveToNewPos(20);
        UpdatePlayersPosition();
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

