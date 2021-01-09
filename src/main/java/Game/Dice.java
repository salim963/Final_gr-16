package Game;

import java.util.Random;

public class Dice {

   public int rolleDice(){
       Random random = new Random();
       int dice = random.nextInt(6)+1;
       return dice;

   }



}
