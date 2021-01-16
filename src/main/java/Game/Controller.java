package Game;

import Fields.Estate;
import Fields.Ferry;
import Fields.Field;
import Fields.Tax;
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
            UpdatePlayersPosition();
            buyorSell();
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









    int sum;
    public void PlayerTurn() {


        guiView.gui.showMessage(player.getName() + " s tur");

        String tryk = guiView.gui.getUserSelection(player.getName() + "Do you want to rolle the dice", "Roll", "Don,t rolle");
        if (tryk.equals("Don,t rolle")) {
            return;
        }

        if (tryk.equals("Roll")) {
            int rolle1 = dice.rollDice();
            int rolle2 = dice.rollDice();
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

        }

    }

    public void UpdatePlayersPosition() {

        int CorrentPlayerPpstion = player.getPlayerPos();
        int MoveCorrentPlayerPpstionTo = (player.getPlayerPos() + player.getPlayerMoveToNewPos())% guiView.gui.getFields().length;

        guiView.gui.getFields()[CorrentPlayerPpstion].setCar(guiView.guiPlayer[player.getPlayerNumber()], false);
        guiView.gui.getFields()[MoveCorrentPlayerPpstionTo].setCar(guiView.guiPlayer[player.getPlayerNumber()], true);

        player.setPlayerPos(MoveCorrentPlayerPpstionTo);


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
    public void PlayerReciveMoney(String playerID, int chargeAmount){

        int newbalance= player.getBalance() + chargeAmount;

        player.setBalance(newbalance);

    }

    public void buyorSell(){

        Field f = c_field.fields[player.getPlayerPos()];
        String t = String.valueOf(f);
        System.out.println(t + " " + "FieldType");

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
            System.out.println(TheRent[0]+" rent");
            int PropertyPrice = c_field.getPropertyPrice(player.getPlayerPos());

            String buy = guiView.gui.getUserButtonPressed("Do you want to buy this field for" + " " + PropertyPrice , "Yes","No");

            if (buy.equals("Yes")) {

                playerPayMoney(PropertyPrice);
                updatePlayerBalance(player);
                setPropertyOwner(player.getPlayerPos());

            }if (buy.equals("No")) {
                return;
            }


        }else if (TheOwner==player.getName()){
            guiView.gui.showMessage("you Already owned the field so you don't have to pay any cost ");
            return;


        } else if (TheOwner != null){

            guiView.gui.showMessage("There is other player who owms this field " +", his/her name is   " + TheOwner + " so you " + " have to pay the rent to " + TheOwner);
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

        System.out.println("The Tax you have to pay" +((Tax)c_field.fields[player.getPlayerPos()]).getRent() );
        playerPayMoney(((Tax)c_field.fields[player.getPlayerPos()]).getRent());
    }

    public void FerryEdition(){


        String TheOwner =((Ferry)c_field.fields[player.getPlayerPos()]).getOwner();

        if ( TheOwner == null ) {

            int PropertyPrice = ((Ferry)c_field.fields[player.getPlayerPos()]).getPropertyPrice();

            String buy = guiView.gui.getUserButtonPressed("Do you want to buy this field for" + " " + PropertyPrice , "Yes","No");

            if (buy.equals("Yes")) {
                playerPayMoney(PropertyPrice);
                updatePlayerBalance(player);
                setPropertyOwner(player.getPlayerPos());

            }if (buy.equals("No")) {
                return;
            }


        }else if (TheOwner==player.getName()){
            guiView.gui.showMessage("you Already owned the field so you don't have to pay any cost ");
            return;


        } else if (TheOwner != null){
            int TheRent= ((Ferry)c_field.fields[player.getPlayerPos()]).getRent();
            System.out.println(TheRent + " rent");
            guiView.gui.showMessage("There is other player who owms this field " +", his/her name is   " + TheOwner + " so you " + " have to pay the rent to " + TheOwner);
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
        guiView.gui.showMessage(" you do not have to pay any cost it is free parking ");

    }



}
