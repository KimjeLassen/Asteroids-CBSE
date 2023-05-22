import dk.sdu.mmmi.cbse.bulletsystem.Bullet;
import dk.sdu.mmmi.cbse.bulletsystem.BulletControlSystem;
import dk.sdu.mmmi.cbse.bulletsystem.BulletPlugin;
import dk.sdu.mmmi.cbse.common.services.IBulletService;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Bullet {
    requires Common;

    provides IBulletService with BulletPlugin;
    provides IGamePluginService with BulletPlugin;
    provides IEntityProcessingService with BulletControlSystem;
}