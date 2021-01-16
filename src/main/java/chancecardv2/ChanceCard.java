package chancecardv2;

import java.util.ArrayList;

public class ChanceCard {

    private ArrayList<String> cardDescription;
    private ArrayList<Integer> cardValue;

    public ChanceCard() {
        this.cardDescription = cardDescription();
        this.cardValue = cardValue();
    }

    public ArrayList<String> cardDescription() {
        ArrayList <String> cardDescription = new ArrayList<String>();

        cardDescription.add("De modtager Matador legatet. Byens bogmester overdrager dem en chack på 2000kr");                     //0
        cardDescription.add("Modtag udbytte af deres aktier. Modtag 50kr.");                                                       //1
        cardDescription.add("Værdien af egen avl fra nyttehaven udgør 200kr, som de modtager af banken.");                         //2
        cardDescription.add("Grundet på dyrtiden har de fået gageforhøjelse. Modtag 25kr. ");                                      //3
        cardDescription.add("De har solgt deres gamle klude. Modtag  20kr.");                                                      //4
        cardDescription.add("De har rettidigt afleveret deres abonnementskort. Depositum 1kr udbetales dem af banken.");           //5
        cardDescription.add("Manufakturvarerne er blevet billigere og bedre, herved sparer de 50kr, som de modtager af banken.");  //6
        cardDescription.add("Efter auktionen på Assistenshuset, hvor de havde pantsat deres tøj, modtager de ekstra 108kr.");      //7
        cardDescription.add("Deres præmieobligation er kommet ud. De modtager 100kr af banken.");                                  //8
        cardDescription.add("De har anskaffet et nyt dæk til deres vogn. Indbetal 100kr.");                                        //9
        cardDescription.add("De har kørt frem for Fuld Stop. Betal 100kr i bøde.");                                                //10
        cardDescription.add("Betal for vognvask og smøring. 10kr.");                                                               //11
        cardDescription.add("De har været en tur i udlandet og haft for mange cigaretter med hjem. Betal 20kr i told.");           //12
        cardDescription.add("De har måttet vedtage en parkeringsbøde. Betal 20kr til banken.");                                    //13

        cardDescription.add("Ryk tre felter frem");        //14
        cardDescription.add("Ryk tre felter tilbage");     //15
        cardDescription.add("Tag ind på Rådhuspladsen");   //16
        cardDescription.add("Ryk fem til Grønningen");     //17
        cardDescription.add("Tag med Øresundsbåden");      //18
        cardDescription.add("Ryk frem til start");         //19

        return cardDescription;
    }

    public ArrayList<Integer> cardValue() {
        ArrayList<Integer> cardValue = new ArrayList<Integer>();

        cardValue.add(2000);   //0
        cardValue.add(50);     //1
        cardValue.add(200);    //2
        cardValue.add(25);     //3
        cardValue.add(20);     //4
        cardValue.add(1);      //5
        cardValue.add(50);     //6
        cardValue.add(108);    //7
        cardValue.add(100);    //8
        cardValue.add(-100);   //9
        cardValue.add(-100);   //10
        cardValue.add(-10);    //11
        cardValue.add(-20);    //12
        cardValue.add(-20);    //13

        cardValue.add(3);      //14
        cardValue.add(-3);     //15
        cardValue.add(39);     //16
        cardValue.add(24);     //17
        cardValue.add(5);      //18
        cardValue.add(0);      //19

        return cardValue;
    }


    public ArrayList<String> getCardDescription() {
        return cardDescription;
    }

    public ArrayList<Integer> getCardValue() {
        return cardValue;
    }

}
