

import chancekort.Chancekort;
import chancekort.RykTilBestemtFelt;
import chancekort.GratisUdAfFaengsel;
import chancekort.JustererPenge;
import chancekort.RykAntalFelter;
import chancekort.SmidIFaengsel;


import java.util.ArrayList;


public class ChancekortGenerator{

    public static ArrayList<Chancekort> genererChancekort() {

        /*
        Disse Chancekort er IKKE blevet implementeret:

        Kul og kokos priserne er steget, og de skal betale 25kr pr. hus og 125kr pr. hotel.

        Ejendomsskatterne  er steget, og ekstraudgifterne er: 50kr pr. hus og  125kr pr. hotel.

        De har lagt penge ud til sammenskudsgilde. Mærkværdigvis betaler alle straks. Modtag 25kr fra hver medspiller.

        Ryk brikken frem til det nærmeste dampskibsselskab og betal ejeren to gange den leje, han ellers er berettiget
        til. Hvis selskabet  ikke ejes  af nogen kan de købe det af banken. * 2
         */

        ArrayList<Chancekort> chanceKort = new ArrayList<Chancekort>();

        JustererPenge giverPenge;
        JustererPenge tagerPenge;
        GratisUdAfFaengsel gratisUdAfFaengsel;
        SmidIFaengsel smidIFaengsel;
        RykAntalFelter rykAntalFelter;
        RykTilBestemtFelt rykTilBestemtFelt;

        //-----------------------------------Giver spilleren penge - chancekort-------------------------------------------//

        giverPenge = new JustererPenge(+2000, "De modtager Matador legatet. Byens bogmester " +
                "overdrager dem en chack på 2000kr");
        chanceKort.add(giverPenge);

        giverPenge = new JustererPenge(+50, "Modtag udbytte af deres aktier. Modtag 50kr.");
        chanceKort.add(giverPenge);

        giverPenge = new JustererPenge(+200, "Værdien af egen avl fra nyttehaven udgør 200kr, " +
                "som de modtager af banken.");
        chanceKort.add(giverPenge);

        giverPenge = new JustererPenge(+25, "Grundet på dyrtiden har de fået gageforhøjelse. " +
                "Modtag 25kr. ");
        chanceKort.add(giverPenge);

        giverPenge = new JustererPenge(+20, "De har solgt deres gamle klude. Modtag  20kr.");
        chanceKort.add(giverPenge);

        giverPenge = new JustererPenge(+1, "De har rettidigt afleveret deres abonnementskort. " +
                "Depositum 1kr udbetales dem af banken.");
        chanceKort.add(giverPenge);

        giverPenge = new JustererPenge(+50, "Manufakturvarerne er blevet billigere og bedre, " +
                "herved sparer de 50kr, som de modtager af banken.");
        chanceKort.add(giverPenge);

        giverPenge = new JustererPenge(+108, "Efter auktionen på Assistenshuset, " +
                "hvor de havde pantsat deres tøj, modtager de ekstra 108kr.");
        chanceKort.add(giverPenge);

        giverPenge = new JustererPenge(+100, "Deres præmieobligation er kommet ud. " +
                "De modtager 100kr af banken.");
        chanceKort.add(giverPenge);

        //-----------------------------------Gratis ud af fængsel - Chancekort--------------------------------------------//

        for (int i = 0; i < 2; i++) {
            gratisUdAfFaengsel = new GratisUdAfFaengsel("I andledningen af Kongens fødselsdag, " +
                    "benådes der herved for fængsel. Dette kort kan opbevares, indtil de får brug for det.");
            chanceKort.add(gratisUdAfFaengsel);
        }

        //------------------------------------Gå i fængsel - Chancekort---------------------------------------------------//

        for (int i = 0; i < 3; i++) {
            smidIFaengsel = new SmidIFaengsel("Gå i fængsel. Ryk direkte til fængslet. " +
                    "Selvom de passerer start, indkasserer de ikke 200kr");
            chanceKort.add(smidIFaengsel);
        }

        //------------------------------------Tager penge fra spilleren - Chancekort--------------------------------------//

        tagerPenge = new JustererPenge(-100, "De har anskaffet et nyt dæk til deres vogn. " +
                "Indbetal 100kr.");
        chanceKort.add(tagerPenge);

        tagerPenge = new JustererPenge(-100, "De har kørt frem for Fuld Stop. Betal 100kr i bøde.");
        chanceKort.add(tagerPenge);

        for (int i = 0; i < 2; i++) {
            tagerPenge = new JustererPenge(-10, "Betal for vognvask og smøring. 10kr.");
            chanceKort.add(tagerPenge);
        }

        tagerPenge = new JustererPenge(-20, "De har været en tur i udlandet og haft for mange" +
                " cigaretter med hjem. Betal 20kr i told.");
        chanceKort.add(tagerPenge);

        tagerPenge = new JustererPenge(-20, "De har måttet vedtage en parkeringsbøde. " +
                "Betal 20kr til banken.");
        chanceKort.add(tagerPenge);

        //-------------------------------------Ryk antal felter - Chancekort----------------------------------------------//

        for (int i = 0; i < 2; i++) {
            rykAntalFelter = new RykAntalFelter(+3, "Ryk tre felter frem");
            chanceKort.add(rykAntalFelter);
        }

        for (int i = 0; i < 2; i++) {
            rykAntalFelter = new RykAntalFelter(-3, "Ryk tre felter tilbage");
            chanceKort.add(rykAntalFelter);
        }

        //-------------------------------------Ryk til et bestemt felt - Chancekort---------------------------------------//

        rykTilBestemtFelt = new RykTilBestemtFelt(39, "Tag ind på Rådhuspladsen");
        chanceKort.add(rykTilBestemtFelt);

        rykTilBestemtFelt = new RykTilBestemtFelt(24, "Ryk fem til Grønningen, " +
                "hvis du passerer start, modtag 200kr");
        chanceKort.add(rykTilBestemtFelt);

        rykTilBestemtFelt = new RykTilBestemtFelt(5, "Tag med Øresundsbåden, " +
                "hvis du passerer start modtag  200kr.");
        chanceKort.add(rykTilBestemtFelt);

        rykTilBestemtFelt = new RykTilBestemtFelt(0, "Ryk frem til start.");
        chanceKort.add(rykTilBestemtFelt);


        for (int i = 0; i < 1000; i++) {
            int kortIndeks = RandomSingleton.getInstance().nextInt(chanceKort.size());
            Chancekort udvalgtKort = chanceKort.get(kortIndeks);
            chanceKort.remove(udvalgtKort);
            chanceKort.add(udvalgtKort);
        }


        return chanceKort;
    }


}


