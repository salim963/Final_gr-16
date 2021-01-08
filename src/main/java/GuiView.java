import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class GuiView {
    private GUI gui;
    private GUI_Player[] guiPlayers;
    private Player[] players;

    GuiView() {
        gui = new GUI(customFields(),Color.CYAN);
        setupPlayers();

    }

    public GUI_Field[] customFields() {
        GUI_Field[] fields = new GUI_Field[20];

        fields[0] = new GUI_Start("Start", "", "Hver gang du passerer start, modtager du 2 kr.", Color.GREEN.darker(), Color.BLACK);
        fields[1] = new GUI_Street("Burgerbaren", "1M", "Få en burger på parkens bedste burgerbar. ('Bedste' nomineret af egen resturant.)", "1", Color.ORANGE, Color.BLACK);
        fields[2] = new GUI_Street("Pizzariaet", "1M", "Hvis munden nu ikke er stor nok til den burger.", "1", Color.ORANGE, Color.BLACK);
        fields[3] = new GUI_Street("Slikbutikken", "1M", "Til den lille slikmund.", "1", Color.BLUE.brighter(), Color.BLACK);
        fields[4] = new GUI_Street("Iskiosken", "1M", "Hjælper når solen er fremme.", "1", Color.BLUE.brighter(), Color.BLACK);
        fields[5] = new GUI_Jail();
        fields[5].setSubText("");
        fields[6] = new GUI_Street("Museet", "2M", "Både sjovt og lærerigt.", "2", Color.PINK, Color.BLACK);
        fields[7] = new GUI_Street("Biblioteket", "2M", "Lærerigt, men ikke så sjovt som museet.", "2", Color.PINK, Color.BLACK);
        fields[8] = new GUI_Street("Skaterparken", "3M", "Husk nu hjelmen.", "2", Color.YELLOW.brighter(), Color.BLACK);
        fields[9] = new GUI_Street("Svømmingpoolen", "3M", "Ikke løbe ved poolen!.", "2", Color.YELLOW.brighter(), Color.BLACK);
        fields[10] = new GUI_Refuge();
        fields[10].setTitle("Gratis parkering");
        fields[10].setSubText("");
        fields[11] = new GUI_Street("Spillehallen", "4M", "Forældrenes undskyldning for deres ludomani.", "3", Color.RED, Color.BLACK);
        fields[12] = new GUI_Street("Biografen", "4M", "Brug tid sammen med familien, uden at snakke med dem.", "3", Color.RED, Color.BLACK);
        fields[13] = new GUI_Street("Legetøjsbutikken", "4M", "Hvem siger man ikke kan købe kærlighed.", "3", Color.YELLOW, Color.BLACK);
        fields[14] = new GUI_Street("Dyrehandlen", "4M", "Hvis familien nu ikke er stor nok.", "3", Color.YELLOW, Color.BLACK);
        fields[15] = new GUI_Shipping();
        fields[15].setTitle("Gå i fængsel");
        fields[15].setSubText("");
        fields[16] = new GUI_Street("Bowlinghallen", "5M", "Når far skal vise sig.", "4", Color.GREEN, Color.BLACK);
        fields[17] = new GUI_Street("Zoo", "5M", "Det eneste sted dine forældre tillader dyr.", "4", Color.GREEN, Color.BLACK);
        fields[18] = new GUI_Street("Vandlandet", "5M", "Samme som poolen, bare dyrer.", "5", Color.BLUE.darker(), Color.WHITE);
        fields[19] = new GUI_Street("Strandpromenaden", "5M", "Sand. Alle. Steder.", "5", Color.BLUE.darker(), Color.WHITE);

        return fields;
    }

    public GUI_Car vehicleChoice(int playerId) {
        String vehicle = gui.getUserSelection("Vælg din transport", "Bil", "Traktor", "UFO");
        Color color = getVehicleColor(playerId);
        if (vehicle.equals("Bil")) {
            return new GUI_Car(color, color, GUI_Car.Type.CAR, GUI_Car.Pattern.ZEBRA);
        } else if (vehicle.equals("Traktor")) {
            return new GUI_Car(color, color, GUI_Car.Type.TRACTOR, GUI_Car.Pattern.FILL);
        } else if (vehicle.equals("UFO")) {
            return new GUI_Car(color, color, GUI_Car.Type.UFO, GUI_Car.Pattern.FILL);
        }
        return new GUI_Car(color, color, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
    }

    public Color getVehicleColor(int playerId) {
        switch (playerId) {
            case 1:
                return Color.RED;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.YELLOW;
            default:
                return Color.BLUE;
        }
    }

    public void setupPlayers() {
        int number;
        String playerName;
        number=  Integer.parseInt(requestNumberOfPlayers());
        int balance=24 - 2 * number;

        players = new Player[number];

        for (int i = 0; i < number; i++) {

            playerName = messageToPlayer("Spiller " + (i + 1) + ", indtast dit navn");
            if (playerName.equals("")) {
                playerName = "Spiller" + (i + 1);
            }

            players[i] = new Player(i, playerName, balance);
            addUIPlayer(players[i], number);
        }
    }

    public String requestNumberOfPlayers() {
        return  gui.getUserSelection("Hvor mange spillere skal der være?", "2", "3","4","5","6");
    }

    public String messageToPlayer(String message) {
        return gui.getUserString(message);
    }

    public void addUIPlayer(Player player, int amountOfPlayers) {
        if (guiPlayers == null) {
            guiPlayers = new GUI_Player[amountOfPlayers];
        }
        guiPlayers[player.getPlayerId()] = new GUI_Player(player.getName(), player.getBalance().getAmount(), vehicleChoice(player.getPlayerId()));
        gui.addPlayer(guiPlayers[player.getPlayerId()]);
    }
}
