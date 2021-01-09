package Game;

import gui_fields.*;

import java.awt.*;

public class GUI_FieldDesigne {

    public GUI_Field[] fields;

    public  GUI_Field[] customFields() {
        fields = new GUI_Field[40];

        fields[0] = new GUI_Start("Start", "", "Hver gang du passerer start, modtager du 4000 kr.", Color.white.brighter(), Color.BLACK);
        fields[1] = new GUI_Street("Rødovrevej", "pris: 600 kr", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[2] = new GUI_Chance("?","Prøv Lykken","",Color.gray,Color.green);
        fields[3] = new GUI_Street("hvidovrevej", "pris: 600 kr ", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE.darker(), Color.white);
        fields[4] = new GUI_Tax("skat","inkomstskat ", "Betal 10% skat eller 4000 kr",Color.red,Color.BLACK );
        fields[5] = new GUI_Shipping();fields[5].setTitle("scandlines");fields[5].setSubText("Pris 2000"); fields[5].setDescription("leje 500 kr,2 rederier 1000,3 rederier 2000 ,4 rederier 4000");
        fields[6] = new GUI_Street("Roskildevej", "pris :1000", "leje af grund:100 ,Med et Hus 600, to Huse 1800, tre Huse 5400, fire huse 8000, Hotel 11000}, hus,hotel pris: 1000", "1", Color.orange, Color.black);
        fields[7] = new GUI_Chance ("?","Prøv Lykken","",Color.gray,Color.green);
        fields[8] = new GUI_Street("valbyLanggade", "pris 1000", "leje af grund:100 ,Med et Hus 600, to Huse 1800, tre Huse 5400, fire huse 8000, Hotel 11000}, hus,hotel pris: 1000", "1", Color.orange, Color.black);
        fields[9] = new GUI_Street("allegade", "pris: 1200", "leje af grund:150,Med et Hus 800, to Huse 2000, tre Huse 6000, fire huse 9000, Hotel 12000}, hus,hotel pris: 1000", "1", Color.orange, Color.black);
        fields[10] = new GUI_Jail();fields[10].setTitle("");fields[10].setSubText("Fængsel");fields[10].setDescription("Du er på besøg i Fængsel");
        fields[11] = new GUI_Street("frederiksbergsAlle", "pris 1400", "leje af grund:200,Med et Hus 1000, to Huse 3000, tre Huse 9000, fire huse 12500, Hotel 15000}, hus,hotel pris: 2000", "1", Color.YELLOW, Color.BLACK);
        fields[12] = new GUI_Brewery(); fields[12].setTitle("Tuborg"); fields[12].setSubText("pris :1500 kr"); fields[12].setDescription(" Man betaler 100 gange så meget som øjne viser ");
        fields[13] = new GUI_Street("bulowsvej", "pris : 1400 ", "leje af grund:200,Med et Hus 1000, to Huse 3000, tre Huse 9000, fire huse 12500, Hotel 15000}, hus,hotel pris: 2000 ", "1", Color.YELLOW, Color.BLACK);
        fields[14] = new GUI_Street("gammelKongevej", "1600", "leje af grund:250,Med et Hus 1250, to Huse 3750, tre Huse 10000, fire huse 14000, Hotel 18000}, hus,hotel pris: 2000", "1", Color.YELLOW, Color.BLACK);
        fields[15] = new GUI_Shipping();fields[15].setTitle("Mols-Linien");fields[15].setSubText("Pris 2000"); fields[15].setDescription("leje 500 kr,2 rederier 1000,3 rederier 2000 ,4 rederier 4000");

        fields[16] = new GUI_Street("bernstorffsvej", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[17] = new GUI_Chance ("?","Prøv Lykken","",Color.gray,Color.green);
        fields[18] = new GUI_Street("Hellerupvej", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[19] = new GUI_Street("strandvejen", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[20] = new GUI_Street("Parkring", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[21] = new GUI_Street("Trlanglen", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[22] = new GUI_Chance ("?","Prøv Lykken","",Color.gray,Color.green);
        fields[23] = new GUI_Street("østergade", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[24] = new GUI_Street("Grønningen", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[25] = new GUI_Street("ScandLines", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[26] = new GUI_Street("Bredgade", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);

        fields[27] = new GUI_Street("kgsNytorv", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[28] = new GUI_Street("Cocacola", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[29] = new GUI_Street("østergade", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[30] = new GUI_Street("Fængsel", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);

        fields[31] = new GUI_Street("amagertorv", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[32] = new GUI_Street("vimmelskaftet", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[33] = new GUI_Chance ("?","Prøv Lykken","",Color.gray,Color.green);
        fields[34] = new GUI_Street("Nygade", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[35] = new GUI_Street("scandlines", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[36] = new GUI_Chance ("?","Prøv Lykken","",Color.gray,Color.green);
        fields[37] = new GUI_Street("frederiksberggade", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[38] = new GUI_Street("Statskat", "600", "leje af grund:50,Med et Hus 250, to Huse 750, tre Huse 2250, fire huse 4000, Hotel 6000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);
        fields[39] = new GUI_Street("rådhuspladsen", "600", "leje af grund:8000,Med et Hus 1000, to Huse 12000, tre Huse 28000, fire huse 34000, Hotel 40000}, hus,hotel pris: 1000", "1", Color.BLUE, Color.white);


        return fields;
    }
}
