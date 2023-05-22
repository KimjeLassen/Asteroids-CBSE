package dk.sdu.mmmi.playersystem;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IBulletService;
import dk.sdu.mmmi.cbse.playersystem.Player;
import dk.sdu.mmmi.cbse.playersystem.PlayerPlugin;
import dk.sdu.mmmi.cbse.playersystem.util.SPILocator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShootTest {
    private static GameData gameData;
    private World world;
    private PlayerPlugin playerPlugin;

    @BeforeEach
    void setUp() {
        gameData = mock(GameData.class);
        gameData.setDisplayHeight(500);
        gameData.setDisplayWidth(500);
        world = new World();
        playerPlugin = new PlayerPlugin();
        playerPlugin.start(gameData,world);
    }

    @Test
    void bulletCreated() {
        for (Entity player : world.getEntities(Player.class)) {
            for (IBulletService bullet : SPILocator.locateAll(IBulletService.class)) {
                Entity entity = bullet.createBullet(player, gameData);
                world.addEntity(entity);
            }
        }
        playerPlugin.stop(gameData,world);
        int size = world.getEntities().size();
        int expected = 1;
        Assertions.assertEquals(expected, size);
    }
}

