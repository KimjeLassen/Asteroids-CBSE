package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;


/**
 *
 * @author corfixen
 */
public class AsteroidPlugin implements IGamePluginService {
    private Entity asteroid;

    @Override
    public void start(GameData gameData, World world) {
        //Creates a random amount of asteroids, up to 3, at least 1.
        Random random = new Random();
        int rnd = random.nextInt(1,4);
        for (int i =0;i<rnd;i++) {
            asteroid = createAsteroid(gameData);
            world.addEntity(asteroid);
        }
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(asteroid);
    }

    /**
     * Creates an asteroid in the game
     *
     *  Pre-condition: Program is running. Asteroid needs to be created in accordance to game data.
     *  Post-condition: Asteroid has been created
     *
     * @param gameData data for creating an asteroid
     * @return asteroid entity
     */
    private Entity createAsteroid(GameData gameData) {
        Entity asteroid = new Asteroid();
        float radians = (float) Math.random() * 2 * 3.1415f;
        float speed = (float) Math.random() * 10f + 20f;
        float x = (float) (Math.random() * gameData.getDisplayWidth());
        float y = (float) (Math.random() * gameData.getDisplayHeight());

        asteroid.setRadius(20);
        asteroid.add(new MovingPart(0, speed, speed, 0));
        asteroid.add(new PositionPart(x, y, radians));
        asteroid.add(new LifePart(1));

        return asteroid;
    }
}
