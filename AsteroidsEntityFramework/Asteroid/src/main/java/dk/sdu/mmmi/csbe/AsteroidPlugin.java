package dk.sdu.mmmi.csbe;

import com.example.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {
    private Entity asteroid;

    public AsteroidPlugin(){
    }

    @Override
    public void start(GameData gameData, World world) {
        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(asteroid);
    }

    private Entity createAsteroid(GameData gameData) {
        float acceleration = 150;
        Random r = new Random();
        float maxSpeed = 1f;
        float speed = r.nextFloat(10f) * 10;
        float rotationSpeed = 5;
        float x = gameData.getDisplayWidth()/2;
        float y = gameData.getDisplayHeight()/2;
        float radians = 3.1415f / 2;

        Entity asteroid = new Asteroid();
        asteroid.setRadius(20);
        asteroid.add(new MovingPart(0,speed,speed, rotationSpeed));
        asteroid.add(new PositionPart(30, 30, radians));
        return asteroid;
    }
}
