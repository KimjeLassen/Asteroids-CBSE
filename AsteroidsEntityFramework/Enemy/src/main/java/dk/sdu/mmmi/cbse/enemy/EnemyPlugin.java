package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;


public class EnemyPlugin implements IGamePluginService {
    private Entity enemy;

    public EnemyPlugin(){
    }

    @Override
    public void start(GameData gameData, World world) {
        enemy = createEnemy(gameData);
        world.addEntity(enemy);
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(enemy);
    }

    private Entity createEnemy(GameData gameData) {
        float deacceleration = 10;
        float acceleration = 150;
        float maxSpeed = 300;
        float rotationSpeed = 5;
        float x = new Random().nextFloat() * gameData.getDisplayWidth();
        float y = new Random().nextFloat() * gameData.getDisplayHeight();
        float radians = 3.1415f / 2;

        float[] colour = new float[4];
        colour[0] = 1.0f;
        colour[1] = 0.0f;
        colour[2] = 0.0f;
        colour[3] = 1.0f;

        Entity enemyShip = new Enemy();
        enemyShip.setRadius(8);
        enemyShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        enemyShip.add(new PositionPart(x, y, radians));
        enemyShip.add(new LifePart(1));
        return enemyShip;
    }
}
