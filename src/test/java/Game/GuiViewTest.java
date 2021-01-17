package Game;

import gui_fields.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class GuiViewTest {

    GuiView guiView = mock(GuiView.class);

    GUI_Field[] madeUp() {
        GUI_Field[] fields = new GUI_Field[5];
        fields[0] = new GUI_Start("Start", "", "", Color.white.brighter(), Color.BLACK);
        fields[1] = new GUI_Street("Rødovrevej", "", "", "", Color.BLUE, Color.white);
        fields[2] = new GUI_Chance("ChanceKort","","",Color.gray,Color.green);
        fields[3] = new GUI_Jail();

        return fields;
    }

    @BeforeEach
    void setUp() {
        madeUp();
    }

    @Test
    void customFieldsTest() {
        when(guiView.customFields()).thenReturn(madeUp());
        assertEquals(madeUp().length,4);
    }

}