package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {


    Dice dice = new Dice();

    @Test
    public void rolleDice() {

        int value = dice.rollDice();
        assertEquals(value >= 1 && value <= 6,true ,"Test" );
    }

}