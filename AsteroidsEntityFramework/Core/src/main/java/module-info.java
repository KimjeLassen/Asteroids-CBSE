import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module Core {
    requires Common;
    requires java.desktop;
    requires gdx;
    requires gdx.backend.lwjgl;

    exports dk.sdu.mmmi.cbse.main;
    exports dk.sdu.mmmi.cbse.managers;

    uses IGamePluginService;
    uses IEntityProcessingService;
    uses IPostEntityProcessingService;

}