import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IBulletService;

module Common {
    exports dk.sdu.mmmi.cbse.common.services;
    exports dk.sdu.mmmi.cbse.common.data;
    exports dk.sdu.mmmi.cbse.common.data.entityparts;
    exports dk.sdu.mmmi.cbse.common.events;

    uses IBulletService;
    uses IGamePluginService;
    uses IEntityProcessingService;
    uses IPostEntityProcessingService;
}