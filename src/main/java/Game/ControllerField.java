package Game;

import Fields.*;

import java.awt.*;

public class ControllerField {
    public Field[] fields;

    ControllerField(){
        createFields();
    }

    public void createFields(){

        fields = new Field[40];

        fields[0] = new Start("tart",null);
        fields[1] = new Estate("rødovrevej",Color.BLUE,1200, new int[]{50,250,750,2250,4000,6000});
        fields[2] = new ChanceField("prøvLykken", null);
        fields[3] = new Estate("hvidovrevej",Color.BLUE,1200, new int[]{50,250,750,2250,4000,6000});
        fields[4] = new Tax("betalIndkomstskat",null, 4000);
        fields[5] = new Ferry("øresund",Color.ORANGE,4000,500);
        fields[6] = new Estate("roskildevej",Color.PINK,2000,new int[]{100,600,1800,5400,8000,11000});
        fields[7] = new ChanceField("prøvLykken", null);
        fields[8] = new Estate("valbyLanggade",Color.PINK,2000,new int[]{100,600,1800,5400,8000,11000});
        fields[9] = new Estate("allegade",Color.PINK,2400,new int[]{150,800,2000,6000,9000,12000});
        fields[10] = new VisitJail("fængsel",null);
        fields[11] = new Estate("frederiksbergsAlle",Color.GREEN,2800,new int[]{200,1000,3000,9000,12500,15000});
        fields[12] = new Brewery("tuborg",new Color(152,251,152),3000,100);
        fields[13] = new Estate("bulowsvej",Color.GREEN,2800,new int[]{200,1000,3000,9000,12500,15000});
        fields[14] = new Estate("gammelKongevej",Color.GREEN,3200,new int[]{250,1250,3750,10000,14000,18000});
        fields[15] = new Ferry("dFDS",Color.ORANGE,4000,500);
        fields[16] = new Estate("bernstorffsvej", Color.GRAY, 3600,new int[]{300,1400,4000,11000,15000,19000});
        fields[17] = new ChanceField("prøvLykken", null);
        fields[18] = new Estate("hellerupvej", Color.GRAY, 3600,new int[]{300,1400,4000,11000,15000,19000});
        fields[19] = new Estate("strandvejen", Color.GRAY, 4000,new int[]{350,1600,4400,12000,16000,20000});
        fields[20] = new Parking("helle",null);
        fields[21] = new Estate("trianglen",Color.RED,4400,new int[]{350,1800,5000,14000,17500,21000});
        fields[22] = new ChanceField("prøvLykken",null);
        fields[23] = new Estate("østerbrogade",Color.RED,4400,new int[]{350,1800,5000,14000,17500,21000});
        fields[24] = new Estate("grønningen",Color.RED,4800,new int[]{400,2000,6000,15000,18500,22000});
        fields[25] = new Ferry("øS",Color.ORANGE,4000,500);
        fields[26] = new Estate("bredgade",Color.CYAN,5200,new int[]{450,2200,6600,16000,19500,23000});
        fields[27] = new Estate("kgsNytorv",Color.CYAN,5200,new int[]{450,2200,6600,16000,19500,23000});
        fields[28] = new Brewery("carlsberg", new Color(152,251,152),3000,100);
        fields[29] = new Estate("østergade",Color.CYAN,5600,new int[]{500,2400,7200,17000,20500,24000});
        fields[30] = new GotoJail("gåIFængsel",null);
        fields[31] = new Estate("amagertorv",Color.YELLOW,6000,new int[]{550,2600,7800,18000,22000,25000});
        fields[32] = new Estate("vimmelskaftet",Color.YELLOW,6000,new int[]{550,2600,7800,18000,22000,25000});
        fields[33] = new ChanceField("prøvLykken",null);
        fields[34] = new Estate("nygade",Color.YELLOW,6400,new int[]{600,3000,9000,20000,24000,28000});
        fields[35] = new Ferry("bornholm",Color.ORANGE,4000,500);
        fields[36] = new ChanceField("prøvLykken",null);
        fields[37] = new Estate("frederiksberggade",Color.MAGENTA,7000,new int[]{700,3500,10000,22000,26000,30000});
        fields[38] = new Tax("ekstraordinærStatsskat",null, 2000);
        fields[39] = new Estate("rådhuspladsen",Color.MAGENTA,8000,new int[]{1000,4000,12000,28000,34000,40000});
    }

    public int getPropertyPrice(int field){

        return ((Estate)fields[field]).getPropertyPrice();
    }

}
