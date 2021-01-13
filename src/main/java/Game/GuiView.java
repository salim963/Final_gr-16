package Game;

import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class GuiView {
    public GUI gui;
    public GUI_Player[] guiPlayer;
    public Player[] player;
    public GUI_Field[] fields;

    public  GUI_Field[] customFields() {

        fields = new GUI_Field[40];

        fields[0] = new GUI_Start("Start", "", "Hver gang du passerer start, modtager du 4000 kr.", Color.white.brighter(), Color.BLACK);
        fields[1] = new GUI_Street("Rødovrevej", "pris: 600 ", "leje af grund:50,Med {et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[2] = new GUI_Chance("?","Prøv Lykken","",Color.gray,Color.green);
        fields[3] = new GUI_Street("Hvidovrevej", "pris: 600  ", "leje af grund:50,Med {et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE.darker(), Color.white);
        fields[4] = new GUI_Tax("Skat","Indkomstskat ", "Betal 10% skat eller 4000 kr",Color.BLACK,Color.WHITE );
        fields[5] = new GUI_Shipping();fields[5].setTitle("Scandilines");fields[5].setSubText("Pris 2000"); fields[5].setDescription("leje 500 kr,2 rederier 1000,3 rederier 2000 ,4 rederier 4000");
        fields[6] = new GUI_Street("Roskildevej", "pris :1000", "leje af grund:100 ,Med {et Hus 600, to Huse 1800, tre Huse 5400, fire huse 8000, Hotel 11000}, hus,hotel pris: 1000", "1", Color.orange, Color.black);
        fields[7] = new GUI_Chance ("?","Prøv Lykken","",Color.gray,Color.green);
        fields[8] = new GUI_Street("ValbyLanggade", "pris 1000", "leje af grund:100 ,Med {et Hus 600, to Huse 1800, tre Huse 5400, fire huse 8000, Hotel 11000}, hus,hotel pris: 1000", "1", Color.orange, Color.black);
        fields[9] = new GUI_Street("Allegade", "pris: 1200", "leje af grund:150,Med {et Hus 800, to Huse 2000, tre Huse 6000, fire huse 9000, Hotel 12000}, hus,hotel pris: 1000", "1", Color.orange, Color.black);
        fields[10] = new GUI_Jail();fields[10].setTitle("");fields[10].setSubText("Fængsel");fields[10].setDescription("Du er på besøg i Fængsel");

        fields[11] = new GUI_Street("FrederiksbergsAlle", "pris 1400", "leje af grund:200,Med {et Hus 1000, to Huse 3000, tre Huse 9000, fire huse 12500, Hotel 15000}, hus,hotel pris: 2000", "1", Color.GREEN, Color.BLACK);
        fields[12] = new GUI_Brewery(); fields[12].setTitle("Tuborg"); fields[12].setSubText("pris :1500 kr"); fields[12].setDescription(" Man betaler 100 gange så meget som øjne viser ");
        fields[13] = new GUI_Street("Bulowsvej", "pris : 1400 ", "leje af grund:200,Med {et Hus 1000, to Huse 3000, tre Huse 9000, fire huse 12500, Hotel 15000}, hus,hotel pris: 2000 ", "1", Color.GREEN, Color.BLACK);
        fields[14] = new GUI_Street("GammelKongevej", "pris: 1600", "leje af grund:250,Med {et Hus 1250, to Huse 3750, tre Huse 10000, fire huse 14000, Hotel 18000}, hus,hotel pris: 2000", "1", Color.GREEN, Color.BLACK);
        fields[15] = new GUI_Shipping();fields[15].setTitle("Mols-Linien");fields[15].setSubText("Pris 2000"); fields[15].setDescription("leje 500 kr,2 rederier 1000,3 rederier 2000 ,4 rederier 4000");
        fields[16] = new GUI_Street("bernstorffsvej", "pris :1800", "leje af grund:300,Med {et Hus 1400, to Huse 4000, tre Huse 11000, fire huse 15000, Hotel 19000}, hus,hotel pris: 2000", "1", Color.PINK.darker(), Color.BLACK);
        fields[17] = new GUI_Chance ("?","Prøv Lykken","",Color.gray,Color.green);
        fields[18] = new GUI_Street("Hellerupvej", "pris:1800", "leje af grund:300,Med {et Hus 1400, to Huse 4000, tre Huse 11000, fire huse 15000, Hotel 19000}, hus,hotel pris: 2000", "1", Color.PINK.darker(), Color.BLACK);
        fields[19] = new GUI_Street("strandvejen", "pris :2000", "leje af grund:350,Med {et Hus 1600, to Huse 4400, tre Huse 12000, fire huse 16000, Hotel 20000}, hus,hotel pris: 2000", "1", Color.PINK.darker(), Color.BLACK);
        fields[20] = new GUI_Refuge();fields[20].setTitle("Parkering");fields[20].setSubText("Parkering");fields[20].setDescription("Free Parkering");

        fields[21] = new GUI_Street("Trlanglen", "Pris :2200", "leje af grund:350,Med {et Hus 1800, to Huse 5000, tre Huse 14000, fire huse 17500, Hotel 21000}, hus,hotel pris: 3000", "1", Color.RED.brighter(), Color.black);
        fields[22] = new GUI_Chance ("?","Prøv Lykken","",Color.gray,Color.green);
        fields[23] = new GUI_Street("østergade", "pris :2200", "leje af grund:350 ,Med {et Hus 1800, to Huse 5000, tre Huse 14000, fire huse 17500, Hotel 21000}, hus,hotel pris: 3000", "1", Color.red, Color.black);
        fields[24] = new GUI_Street("Grønningen", "pris :2400", "leje af grund:400,Med {et Hus 2000, to Huse 6000, tre Huse 15000, fire huse 18500, Hotel 22000}, hus,hotel pris: 3000", "1", Color.red, Color.black);
        fields[25] = new GUI_Shipping();fields[25].setTitle("scandlines");fields[25].setSubText("Pris 2000"); fields[25].setDescription("leje 500 kr,2 rederier 1000,3 rederier 2000 ,4 rederier 4000");
        fields[26] = new GUI_Street("Bredgade", "pris: 2600", "leje af grund:450,Med {et Hus 2200, to Huse 6600, tre Huse 16000, fire huse 19500, Hotel 23000}, hus,hotel pris: 3000", "1", Color.LIGHT_GRAY, Color.black);

        fields[27] = new GUI_Street("kgsNytorv", "pris: 2600", "leje af grund:450,Med {et Hus 2200, to Huse 6600, tre Huse 16000, fire huse 19500, Hotel 23000}, hus,hotel pris: 3000", "1", Color.LIGHT_GRAY, Color.black);
        fields[28] = new GUI_Brewery(); fields[28].setTitle("Tuborg"); fields[28].setSubText("pris :1500 kr"); fields[28].setDescription(" Man betaler 100 gange så meget som øjne viser ");
        fields[29] = new GUI_Street("østergade", "pris: 2800", "leje af grund:500,Med {et Hus 2400, to Huse 7200, tre Huse 17000, fire huse 20500, Hotel 24000}, hus,hotel pris: 3000", "1", Color.LIGHT_GRAY, Color.black);
        fields[30] = new GUI_Jail();fields[30].setTitle("");fields[30].setSubText(" Gå i fængsel");fields[30].setDescription("Gå i fængsel");

        fields[31] = new GUI_Street("amagertorv", "pris: 3000", "leje af grund:550,Med {et Hus 2600, to Huse 7800, tre Huse 18000, fire huse 22000, Hotel 25000}, hus,hotel pris: 4000", "1", Color.yellow.brighter(), Color.black);
        fields[32] = new GUI_Street("vimmelskaftet", "pris: 3000", "leje af grund:550,Med {et Hus 2600, to Huse 7800, tre Huse 18000, fire huse 22000, Hotel 25000}, hus,hotel pris: 4000", "1", Color.yellow.brighter(), Color.black);
        fields[33] = new GUI_Chance ("?","Prøv Lykken","",Color.gray,Color.green);
        fields[34] = new GUI_Street("Nygade", "pris: 3200", "leje af grund:600 ,Med {et Hus 3000, to Huse 9000, tre Huse 20000, fire huse 24000, Hotel 28000}, hus,hotel pris: 4000", "1", Color.yellow.brighter(), Color.black);

        fields[35] = new GUI_Shipping();fields[35].setTitle("scandlines");fields[35].setSubText("Pris 2000"); fields[35].setDescription("leje 500 kr,2 rederier 1000,3 rederier 2000 ,4 rederier 4000");
        fields[36] = new GUI_Chance ("?","Prøv Lykken","",Color.gray,Color.green);
        fields[37] = new GUI_Street("frederiksberggade", "pris: 3500", "leje af grund:700,Med {et Hus 3500, to Huse 10000, tre Huse 22000, fire huse 26000, Hotel 3000}, hus,hotel pris: 4000", "1", Color.magenta, Color.white);
        fields[38] = new GUI_Street("Statskat", "Betal skat", "Du skal betale 100 til almenvellet ", "1", Color.BLACK, Color.white);
        fields[39] = new GUI_Street("rådhuspladsen", "pris: 4000", "leje af grund:1000,Med {et Hus 4000, to Huse 12000, tre Huse 28000, fire huse 34000, Hotel 40000}, hus,hotel pris: 4000", "1", Color.magenta, Color.white);


        return fields;
    }
    public GuiView() {
        gui = new GUI(customFields());
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

            player[i] = new Player(playerName,i, balance);
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
        guiPlayer[player.getPlayerNumber()] = new GUI_Player(player.getName(), player.getBalance(), vehicleChoice(player.getPlayerNumber()));
        gui.addPlayer(guiPlayer[player.getPlayerNumber()]);
    }
}
