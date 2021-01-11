package Game;

import Fields.*;
import gui_fields.GUI_Ownable;

import java.util.Objects;

import static java.lang.Thread.sleep;

public class Controller {

    private GuiView guiView = new GuiView();
    private ControllerField controllerField = new ControllerField();
    private Dice dice = new Dice();
    public Player player;
    int startPlayer=-1;



    public Controller() {

        while (true) {
            playerTurn();
            updatePlayersPosition();
            buyAndSell();
            updatePlayerBalance(player);
        }
    }


    private Player nextPlayer(){
        startPlayer++;
        startPlayer %= guiView.player.length;
        return guiView.player[startPlayer];
    }

    public void playerTurn() {
        player = nextPlayer();

        guiView.gui.showMessage(player.getName() + "s tur");
        String pressButton = guiView.gui.getUserSelection(player.getName() + " vil du gerne kaste terningerne?", "Ja", "Nej");

        if (pressButton.equals("Nej")) {
            return;
        }

        if (pressButton.equals("Ja")) {
            int dice1 = dice.rollDice();
            int dice2 = dice.rollDice();
            int sum = dice1 + dice2;
            player.setNewPosition(sum);

            for (int rotate = 0; rotate <= 500; rotate++) {
                guiView.gui.setDice(dice1, rotate, 3/2, 5, dice2 , rotate, 3, 5);// sum,Rotat,4, 1,sum, Rotat, 5, 1

                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public void updatePlayersPosition() {
        int currentPlayerPosition = player.getPosition();
        int moveCurrentPlayerTo =  player.getPosition() +  player.getNewPosition();
        int theDifferentSpace = (guiView.gui.getFields().length + moveCurrentPlayerTo - currentPlayerPosition - 1) % guiView.gui.getFields().length + 1;

        for (int i = 0; i < theDifferentSpace; i++) {

            moveCurrentPlayerTo = (currentPlayerPosition + 1) % guiView.gui.getFields().length;

            guiView.gui.getFields()[currentPlayerPosition].setCar(guiView.guiPlayer[player.getPlayerId()], false);
            guiView.gui.getFields()[moveCurrentPlayerTo].setCar(guiView.guiPlayer[player.getPlayerId()], true);
            try {
                sleep(170);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            currentPlayerPosition = (currentPlayerPosition + 1) % guiView.gui.getFields().length;
            player.setPosition(moveCurrentPlayerTo);

        }
    }


    public void setPropertyOwner(int fieldID, int playerID){
        try{
            GUI_Ownable ownable = (GUI_Ownable) guiView.gui.getFields()[fieldID];
            ownable.setBorder(guiView.getPlayerColor(playerID));
            ownable.setOwnerName(guiView.guiPlayer[playerID].getName());
            ((ModelProperty) controllerField.fields[fieldID]).setOwner(guiView.guiPlayer[playerID].getName());

        } catch (RuntimeException e){
            System.out.println("WARNING" + guiView.gui.getFields()[fieldID].getClass().getName());
        }
    }


    public String getPropertyOwner(int fieldID, int playerID){

        String name;
        name=((ModelProperty) controllerField.fields[fieldID]).getOwner();

        return name;
    }


    public void updatePlayerBalance(Player player) {
        guiView.guiPlayer[player.getPlayerId()].setBalance(player.getBalance());
        player.setPosition(player.getPlayerId());
    }

    public void playerPayMoney(int chargeAmount){

        int newBalance= player.getBalance() - chargeAmount;

        player.setBalance(newBalance);
    }

    public void playerReceiveMoney(String playerID, int chargeAmount){

        int newBalance= player.getBalance()+ chargeAmount;

        player.setBalance(newBalance);

    }


    public void buyAndSell(){

        Field f = controllerField.fields[player.getPosition()];
        String t = String.valueOf(f);
        System.out.println(t + " " + "getFieldType");



        if (Objects.equals(t, "Estate")){

            String owner = getPropertyOwner(player.getPosition(),player.getPlayerId());
            if ( owner == null ) {
                int[] TheRent= ((Estate) controllerField.fields[player.getPosition()]).getRent();
                System.out.println(TheRent[0]+"The rent");

                int PropertyPrice = controllerField.getPropertyPrice(player.getPosition());
                String buy = guiView.gui.getUserButtonPressed("Vil du gerne købe denne felt for" + " " + PropertyPrice , "Ja","Nej");


                //int newbalance= player.getBalance()  - PropertyPrice;
                if (buy.equals("Yes")) {

                    playerPayMoney(PropertyPrice);
                    setPropertyOwner(player.getPosition(),player.getPlayerId());

                }if (buy.equals("No")) {
                    return;
                }


            } else if (owner.equals(player.getName())){

                guiView.gui.showMessage(" Denne felt er allerede din, du skal ikke betale noget ");


            } else {
                guiView.gui.showMessage("Der er andre spillere der ejer dette her felt " + "  " + owner + " og du "+ player.getName()+ " betale lejepengene til "+ owner);
                int[] TheRent= ((Estate) controllerField.fields[player.getPosition()]).getRent();
                // add money to the owner player.
                playerPayMoney(TheRent[0]);
                //The player will pay to other player
                getPlayer(owner).addAmount(TheRent[0]);
                updatePlayerBalance(getPlayer(owner));

            }

        }


        else if (Objects.equals(t, "Skat")){

            ((Tax) controllerField.fields[player.getPosition()]).getRent();

            System.out.println("Skat du skal betale" +((Tax) controllerField.fields[player.getPosition()]).getRent() );
            playerPayMoney(((Tax) controllerField.fields[player.getPosition()]).getRent());
        }

        else if(Objects.equals(t, "Parkering")){

            guiView.gui.showMessage(" Du skal ikke betale noget, parkering er gratis ");

        }


        else if(Objects.equals(t, "Gå til fængsel")){

        }
        else if(Objects.equals(t, "ModelParking")){
            return;
        }

    }


    public Player getPlayer(String name) {
        for (Player aPlayer : guiView.player) {
            if (aPlayer.getName().equals(name)) return aPlayer;
        }
        return null;
    }




}
