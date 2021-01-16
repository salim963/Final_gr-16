package Game;

import java.util.Random;

public class RandomSingleton {
    private static RandomSingleton instance;
    private Random rand = new Random();

    private RandomSingleton (){}


    public static RandomSingleton getInstance() {
        if (instance == null) {
            instance = new RandomSingleton();
        }
        return instance;
    }


    public int nextInt(int grense) {
        return rand.nextInt(grense);
    }
}