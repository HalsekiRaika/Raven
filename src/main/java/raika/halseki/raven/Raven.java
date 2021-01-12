package raika.halseki.raven;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import raika.halseki.raven.common.RavenCreativeTabs;
import raika.halseki.raven.common.registries.RavenItemType;

@Mod("raven")
public class Raven {
    private static final Logger LOGGER = LogManager.getLogger("Raven");
    public static final RavenCreativeTabs creativeTab = new RavenCreativeTabs();

    public Raven() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        DeferredRegister(eventBus);
    }

    public static Logger getLogger() {
        return LOGGER;
    }

    public static void DeferredRegister(IEventBus eventBus) {
        LOGGER.info("Raven Start Registration.");
        LOGGER.info("--> Start Item Registration.");
        RavenItemType.ItemRegister.Register(eventBus);
        LOGGER.info("--> Finished Item Registration.");
    }
}
