package Game;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;


class ControllerTest {

    Controller controller = mock(Controller.class);
    Player player = new Player();

    @BeforeEach
    void setUpPlayer() {
        player.setName("John");
        player.setBalance(20000);
        player.setPlayerPos(3);
    }

    @Test
    void updatePlayerPositionTest() {
        when(controller.updatePlayersPosition()).thenReturn(player.setPlayerPos(player.getPlayerPos() + 3));
        assertEquals(player.getPlayerPos(), 6);
    }

    @Test
    void setPropertyOwnerTest() {
        when(controller.getPropertyOwner(3)).thenReturn(player.getName());
        assertEquals(player.getName() + " owns the place", "John owns the place");
    }


}