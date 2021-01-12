package Game;

import Fields.*;
import gui_fields.GUI_Ownable;

import java.util.Objects;

import static java.lang.Thread.sleep;

public class Controller {

    private GuiView guiView = new GuiView();
    private ControllerField c_field = new ControllerField();
    private Dice dice = new Dice();
    public Player player;
    int startPlayer=-1;



    public Controller() {

        while (true) {
            PlayerTurn();
            UpdatePlayersPosition();
            buyorSell();
            updatePlayerBalance(player);
        }
    }


    private Player nextPlayer(){


        startPlayer++;
        startPlayer %= guiView.player.length;
        guiView.player[startPlayer].setPlayerTurn(true);
        return guiView.player[startPlayer];
    }

    int sum;
    public void PlayerTurn() {
        player =  nextPlayer();

        guiView.gui.showMessage(player.getName() + " s tur");
        String tryk = guiView.gui.getUserSelection(player.getName() + "Do you want to rolle the dice", "Roll", "Don,t rolle");

        if (tryk.equals("Don,t rolle")) {
            return;
        }


        if (tryk.equals("Roll")) {
            int rolle1 = dice.rollDice();
            int rolle2 = dice.rollDice();
            sum=rolle1 +rolle2 ;
            player.setNewPosition(sum);
            System.out.println(sum);

            for (int Rotat = 0; Rotat <= 500; Rotat++) {
                guiView.gui.setDice(rolle1, Rotat, 3/2, 5,rolle2 , Rotat, 3, 5);// sum,Rotat,4, 1,sum, Rotat, 5, 1

                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public void UpdatePlayersPosition() {
        int CorrentPlayerPpstion = player.getCurrentPosition();
        int MoveCorrentPlayerPpstionTo =  CorrentPlayerPpstion + sum ;


       // MoveCorrentPlayerPpstionTo = (CorrentPlayerPpstion + 1) % guiView.gui.getFields().length;//% fieldDesign.Design.length;


                guiView.gui.getFields()[CorrentPlayerPpstion].setCar(guiView.guiPlayer[player.getPlayerId()], false);
                guiView.gui.getFields()[MoveCorrentPlayerPpstionTo].setCar(guiView.guiPlayer[player.getPlayerId()], true);

                player.setCurrentPosition(MoveCorrentPlayerPpstionTo);

    }


    public void setPropertyOwner(int fieldID, int playerID){
        try{
            GUI_Ownable ownable = (GUI_Ownable) guiView.gui.getFields()[fieldID];
            ownable.setBorder(guiView.getPlayerColor(playerID));
            ownable.setOwnerName(guiView.guiPlayer[playerID].getName());
            ((Estate)c_field.fields[fieldID]).setOwner(guiView.guiPlayer[playerID].getName());

        } catch (RuntimeException e){
            System.out.println("WARNING" + guiView.gui.getFields()[fieldID].getClass().getName());
        }
    }


    public String getPropertyOwner(int fieldID, int playerID){

        String nam;
        nam=((Estate)c_field.fields[fieldID]).getOwner();

        return nam;
    }

    public void updatePlayerBalance(Player player) {
        guiView.guiPlayer[player.getPlayerId()].setBalance(player.getBalance());
        player.setCurrentPosition(player.getPlayerId());
    }

    public void playerPayMoney(int chargeAmount){

        int newbalance= player.getBalance()- chargeAmount;

        player.setBalance(newbalance);
    }
    public void PlayerReciveMoney(String playerID, int chargeAmount){

        int newbalance= player.getBalance()+ chargeAmount;

        player.setBalance(newbalance);

    }


    public void buyorSell(){

        Field f = c_field.fields[player.getCurrentPosition()];
        String t = String.valueOf(f);
        System.out.println(t + " " + "getFieldType");



        if (Objects.equals(t, "Estate")){

            String TheOwner = getPropertyOwner(player.getCurrentPosition(),player.getPlayerId());
            if ( TheOwner == null ) {
                int[] TheRent= ((Estate)c_field.fields[player.getCurrentPosition()]).getRent();
                System.out.println(TheRent[0]+"The rent");

                int PropertyPrice = c_field.getPropertyPrice(player.getCurrentPosition());
                String buy = guiView.gui.getUserButtonPressed("Do you want to buy this field for" + " " + PropertyPrice , "Yes","No");


                //int newbalance= player.getBalance()  - PropertyPrice;
                if (buy.equals("Yes")) {

                    playerPayMoney(PropertyPrice);
                    setPropertyOwner(player.getCurrentPosition(),player.getPlayerId());

                }if (buy.equals("No")) {
                    return;
                }


            }else if (TheOwner==player.getName()){

                guiView.gui.showMessage("you Alleredy owende the field and you do not have to paly any cost ");
                return;


            } else if (TheOwner != null){
                guiView.gui.showMessage("There is other player who wone this field " +"  " + TheOwner + " And you"+ player.getName()+ " have to pay rent to "+ TheOwner);
                int[] TheRent= ((Estate)c_field.fields[player.getCurrentPosition()]).getRent();
                // add money to the owner player.
                playerPayMoney(TheRent[0]);
                //The player will pay to other player
                getPlayer(TheOwner).addAmount(TheRent[0]);
                updatePlayerBalance(getPlayer(TheOwner));

            }

        }


        else if (Objects.equals(t, "Tax")){

            ((Tax)c_field.fields[player.getCurrentPosition()]).getRent();

            System.out.println("The Tax you have pay" +((Tax)c_field.fields[player.getCurrentPosition()]).getRent() );
            playerPayMoney(((Tax)c_field.fields[player.getCurrentPosition()]).getRent());
        }


        else if (Objects.equals(t, "Ferry")){

        }

        else if(Objects.equals(t, "Parking")){

            guiView.gui.showMessage(" you do not have to paly any cost it is free parking ");


        }

        else if(Objects.equals(t, "VisitJail")){

        }

    }


    public Player getPlayer(String name) {
        for (Player aPlayer : guiView.player) {
            if (aPlayer.getName().equals(name)) return aPlayer;
        }
        return null;
    }




}
