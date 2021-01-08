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
        GUI_Field[] fields = new GUI_Field[40];

        fields[0] = new GUI_Start("Start", "", "Hver gang du passerer start, modtager du 4000 kr.", Color.white.brighter(), Color.BLACK);
        fields[1] = new GUI_Street("rødovrevej", "pris:600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[2] = new GUI_Street("prøvLykken", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[3] = new GUI_Street("hvidovrevej", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[4] = new GUI_Street("betalIndkomstskat", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[5] = new GUI_Street("scandlines", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[5] = new GUI_Street("roskildevej", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[6] = new GUI_Street("prøvLykken", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[7] = new GUI_Street("valbyLanggade", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[8] = new GUI_Street("allegade", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[9] = new GUI_Street("fængsel", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[10] = new GUI_Street("frederiksbergsAlle", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[11] = new GUI_Street("tuborg", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[12] = new GUI_Street("bulowsvej", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[13] = new GUI_Street("gammelKongevej", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[14] = new GUI_Street("Mols-Linien", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[15] = new GUI_Street("bernstorffsvej", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[16] = new GUI_Street("prøvLykken", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);

        fields[17] = new GUI_Street("strandvejen", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[18] = new GUI_Street("Parkring", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[19] = new GUI_Street("Trlanglen", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[20] = new GUI_Street("prøvLykke", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[21] = new GUI_Street("østergade", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[21] = new GUI_Street("Grønningen", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[21] = new GUI_Street("kgsNytorv", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);

        fields[22] = new GUI_Street("carlsberg", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[23] = new GUI_Street("østergade", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[24] = new GUI_Street("gåIFængsel", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[25] = new GUI_Street("amagertorv", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[26] = new GUI_Street("vimmelskaftet", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[27] = new GUI_Street("prøvLykken", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[28] = new GUI_Street("frederiksberggade", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);;
        fields[29] = new GUI_Street("ekstraordinærStatsskat", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[30] = new GUI_Street("rådhuspladsen", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[31] = new GUI_Street("rødovrevej", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[32] = new GUI_Street("rødovrevej", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[33] = new GUI_Street("rødovrevej", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[34] = new GUI_Street("rødovrevej", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[35] = new GUI_Street("rødovrevej", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[36] = new GUI_Street("rødovrevej", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[37] = new GUI_Street("rødovrevej", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[38] = new GUI_Street("rødovrevej", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[39] = new GUI_Street("rødovrevej", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);

        return fields;
    }



    /*
    fields[0] = new ModelStart("start",null);
        fields[1] = new ModelEstate("rødovrevej",Color.BLUE,1200, new int[]{50,250,750,2250,4000,6000}, 1000);
        fields[2] = new ModelChanceField("prøvLykken", null);
        fields[3] = new ModelEstate("hvidovrevej",Color.BLUE,1200, new int[]{50,250,750,2250,4000,6000}, 1000);
        fields[4] = new ModelIncomeTax("betalIndkomstskat",null, 4000);
        fields[5] = new ModelFerry("øresund",Color.ORANGE,4000,500);
        fields[6] = new ModelEstate("roskildevej",Color.PINK,2000,new int[]{100,600,1800,5400,8000,11000}, 1000);
        fields[7] = new ModelChanceField("prøvLykken", null);
        fields[8] = new ModelEstate("valbyLanggade",Color.PINK,2000,new int[]{100,600,1800,5400,8000,11000}, 1000);
        fields[9] = new ModelEstate("allegade",Color.PINK,2400,new int[]{150,800,2000,6000,9000,12000}, 1000);
        fields[10] = new ModelVisitJail("fængsel",null);
        fields[11] = new ModelEstate("frederiksbergsAlle",Color.GREEN,2800,new int[]{200,1000,3000,9000,12500,15000}, 2000);
        fields[12] = new ModelBrewery("tuborg",new Color(152,251,152),3000,100);
        fields[13] = new ModelEstate("bulowsvej",Color.GREEN,2800,new int[]{200,1000,3000,9000,12500,15000}, 2000);
        fields[14] = new ModelEstate("gammelKongevej",Color.GREEN,3200,new int[]{250,1250,3750,10000,14000,18000}, 2000);
        fields[15] = new ModelFerry("dFDS",Color.ORANGE,4000,500);
        fields[16] = new ModelEstate("bernstorffsvej", Color.GRAY, 3600,new int[]{300,1400,4000,11000,15000,19000},2000);
        fields[17] = new ModelChanceField("prøvLykken", null);
        fields[18] = new ModelEstate("hellerupvej", Color.GRAY, 3600,new int[]{300,1400,4000,11000,15000,19000},2000);
        fields[19] = new ModelEstate("strandvejen", Color.GRAY, 4000,new int[]{350,1600,4400,12000,16000,20000},2000);
        fields[20] = new ModelParking("helle",null);
        fields[21] = new ModelEstate("trianglen",Color.RED,4400,new int[]{350,1800,5000,14000,17500,21000},3000);
        fields[22] = new ModelChanceField("prøvLykken",null);
        fields[23] = new ModelEstate("østerbrogade",Color.RED,4400,new int[]{350,1800,5000,14000,17500,21000},3000);
        fields[24] = new ModelEstate("grønningen",Color.RED,4800,new int[]{400,2000,6000,15000,18500,22000},3000);
        fields[25] = new ModelFerry("øS",Color.ORANGE,4000,500);
        fields[26] = new ModelEstate("bredgade",Color.CYAN,5200,new int[]{450,2200,6600,16000,19500,23000},3000);
        fields[27] = new ModelEstate("kgsNytorv",Color.CYAN,5200,new int[]{450,2200,6600,16000,19500,23000},3000);
        fields[28] = new ModelBrewery("carlsberg", new Color(152,251,152),3000,100);
        fields[29] = new ModelEstate("østergade",Color.CYAN,5600,new int[]{500,2400,7200,17000,20500,24000},3000);
        fields[30] = new ModelGotoJail("gåIFængsel",null);
        fields[31] = new ModelEstate("amagertorv",Color.YELLOW,6000,new int[]{550,2600,7800,18000,22000,25000}, 4000);
        fields[32] = new ModelEstate("vimmelskaftet",Color.YELLOW,6000,new int[]{550,2600,7800,18000,22000,25000}, 4000);
        fields[33] = new ModelChanceField("prøvLykken",null);
        fields[34] = new ModelEstate("nygade",Color.YELLOW,6400,new int[]{600,3000,9000,20000,24000,28000}, 4000);
        fields[35] = new ModelFerry("bornholm",Color.ORANGE,4000,500);
        fields[36] = new ModelChanceField("prøvLykken",null);
        fields[37] = new ModelEstate("frederiksberggade",Color.MAGENTA,7000,new int[]{700,3500,10000,22000,26000,30000},4000);
        fields[38] = new ModelIncomeTax("ekstraordinærStatsskat",null, 2000);
        fields[39] = new ModelEstate("rådhuspladsen",Color.MAGENTA,8000,new int[]{1000,4000,12000,28000,34000,40000},4000);
    }
     */

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
