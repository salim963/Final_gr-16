package chancecardv2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class ChanceCardTest {

    ChanceCard chanceCard = mock(ChanceCard.class);
    ArrayList<String> description = new ArrayList<String>();
    ArrayList<Integer> values = new ArrayList<Integer>();

    @BeforeEach
    void setUp() {
        description.add("Taber pengene");
        description.add("Får pengene");
        description.add("Rykker frem");
        description.add("Rykker tilbage");
        description.add("Lande på feltet");

        values.add(-500);
        values.add(500);
        values.add(5);
        values.add(-5);
        values.add(20);
    }

    @Test
    void cardDescriptionTest() {
        when(chanceCard.cardDescription()).thenReturn(description);

        assertEquals(description.size(), 5);
    }

    @Test
    void cardValueTest() {
        when(chanceCard.cardValue()).thenReturn(values);

        assertEquals(values.size(), 5);
    }

    @Test
    void compareSizesTest() {

        assertEquals(description.size(), values.size());
    }

}