package Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    public Player player;

    @BeforeEach
    void setUp() {
        player = new Player("PlayerName",10,5000);
        player.setPlayerPos(20);

    }

    ////// Positives Tests
    @Test
    void PositiveGetName() {

        assertEquals("PlayerName",player.getName());
    }
    @Test
    void PositiveGetNumber() {

        assertEquals(10,player.getPlayerNumber());
    }

    @Test
    void PositiveGetBalance() {
        assertEquals(5000,player.getBalance());
    }

    @Test
    void PositiveGetPlayerPos() {
        assertEquals(20,player.getPlayerPos());
    }
    ////////////////////////////////////////



    ////// Negatives Tests
    @Test
    void NegativeGetName() {

        assertNotEquals("Player",player.getName());
    }
    @Test
    void NegativeGetNumber() {

        assertNotEquals(190,player.getPlayerNumber());
    }

    @Test
    void NegativeGetBalance() {
        assertNotEquals(6000,player.getBalance());
    }

    @Test
    void NegativeGetPlayerPos() {
        assertNotEquals(40,player.getPlayerPos());
    }







}