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
