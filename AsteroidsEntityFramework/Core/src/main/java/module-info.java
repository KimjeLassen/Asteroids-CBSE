import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module Core {
    requires Common;
    requires java.desktop;
    requires com.badlogic.gdx;
    requires spring.context;

    exports dk.sdu.mmmi.cbse.main;
    exports dk.sdu.mmmi.cbse.components;

    uses IGamePluginService;
    uses IEntityProcessingService;
    uses IPostEntityProcessingService;

}