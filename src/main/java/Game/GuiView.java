package Game;

import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class GuiView {
    public GUI gui;
    public GUI_Player[] guiPlayer;
    public Player[] player;



    public GuiView() {
        gui = new GUI( new GUI_FieldDesigne().customFields(),Color.CYAN);
        setupPlayers();
    }


    public GUI_Car vehicleChoice(int playerId) {
        String vehicle = gui.getUserSelection("Vælg din transport", "Bil", "Traktor", "UFO");
        Color color = getPlayerColor(playerId);

        if (vehicle.equals("Bil")) {
            return new GUI_Car(color, color, GUI_Car.Type.CAR, GUI_Car.Pattern.ZEBRA);
        } else if (vehicle.equals("Traktor")) {
            return new GUI_Car(color, color, GUI_Car.Type.TRACTOR, GUI_Car.Pattern.FILL);
        } else if (vehicle.equals("UFO")) {
            return new GUI_Car(color, color, GUI_Car.Type.UFO, GUI_Car.Pattern.FILL);
        }
        return new GUI_Car(color, color, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
    }

    public Color getPlayerColor(int playerId) {
        switch (playerId) {
            case 0:
                return Color.RED;
            case 1:
                return Color.GREEN;
            case 2:
                return Color.YELLOW;
            case 3:
                return Color.CYAN;
            case 4:
                return Color.black;
            case 5:
                return Color.MAGENTA;
            default:
                return Color.BLUE;
        }
    }

    public void setupPlayers() {

       int number =  Integer.parseInt(requestNumberOfPlayers());
       int balance = 30000;

        player = new Player[number];

        for (int i = 0; i < number; i++) {

            String playerName = messageToPlayer("Spiller " + (i + 1) + ", indtast dit navn");

            if (playerName.equals("")) {
                playerName = "Spiller" + (i + 1);
            }

            player[i] = new Player(i, playerName, balance);
            addUIPlayer(player[i], number);
        }
    }

    public String requestNumberOfPlayers() {
        return  gui.getUserSelection("Hvor mange spillere skal der være?",  "2","3","4","5","6");
    }

    public String messageToPlayer(String message) {
        return gui.getUserString(message);
    }

    public void addUIPlayer(Player player, int amountOfPlayers) {
        if (guiPlayer == null) {
            guiPlayer = new GUI_Player[amountOfPlayers];
        }
        guiPlayer[player.getPlayerId()] = new GUI_Player(player.getName(), player.getBalance(), vehicleChoice(player.getPlayerId()));
        gui.addPlayer(guiPlayer[player.getPlayerId()]);
        gui.getFields()[0].setCar(guiPlayer[player.getPlayerId()],true);
    }
}
