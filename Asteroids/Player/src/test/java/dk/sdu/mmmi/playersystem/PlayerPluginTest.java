package dk.sdu.mmmi.playersystem;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.playersystem.Player;
import dk.sdu.mmmi.cbse.playersystem.PlayerPlugin;
import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlayerPluginTest {

    private static GameData gameData;
    private static World world;
    private static PlayerPlugin playerPlugin;

    @BeforeAll
    static void setUp() {
        gameData = mock(GameData.class);
        world = mock(World.class);
        playerPlugin = new PlayerPlugin();
    }
    @Test
    @Order(1)
    void start() {
        playerPlugin.start(gameData, world);
        verify(world).addEntity(any(Player.class));
    }
    @Test
    @Order(2)
    void stop() {
        playerPlugin.stop(gameData, world);

        verify(world).removeEntity(any(Player.class));
    }
}
