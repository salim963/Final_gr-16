package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {


    Dice dice = new Dice();

    @Test
    void rollDice() {
        for (int i = 0; i < 10000; i ++) {
            int value = dice.rollDice();
            System.out.println(value);
            assertTrue(value >= 1 && value <= 6, "Success");
        }
    }

    @Test
    void pullChanceCard() {
        for (int i = 0; i < 10000; i ++) {
            int value = dice.pullChanceCard();
            System.out.println(value);
            assertTrue(value >= 1 && value <= 19, "Success");
        }
    }

}