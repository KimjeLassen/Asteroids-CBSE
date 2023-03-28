package dk.sdu.mmmi.csbe;

import com.example.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.csbe.commonenemy.Enemy;

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
        float maxSpeed = 500;
        float rotationSpeed = 5;
        float x = gameData.getDisplayWidth()/2;
        float y = gameData.getDisplayHeight()/2;
        float radians = 3.1415f / 2;

        Entity enemy = new Enemy();
        enemy.setRadius(20);
        enemy.add(new MovingPart(0,maxSpeed,maxSpeed, rotationSpeed));
        enemy.add(new PositionPart(30, 30, radians));
        return enemy;
    }
}
