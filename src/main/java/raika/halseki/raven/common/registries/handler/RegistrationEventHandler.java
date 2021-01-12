package raika.halseki.raven.common.registries.handler;

import net.minecraftforge.eventbus.api.IEventBus;
import raika.halseki.raven.Raven;
import raika.halseki.raven.common.registries.RavenItemType;

public class RegistrationEventHandler {
    public static void onAttach(IEventBus eventBus) {
        RavenItemType.ItemRegister.Register(eventBus);
        Raven.getLogger().info("Registered Item");

    }
}
