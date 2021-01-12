package raika.halseki.raven.common.registries.impl;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.registries.ForgeRegistries;
import raika.halseki.raven.common.library.base.BaseRavenContainer;
import raika.halseki.raven.common.library.base.BaseRavenTileEntity;
import raika.halseki.raven.common.registries.impl.objects.RavenRegistryContainer;
import raika.halseki.raven.common.registries.impl.wrapper.RavenLazyRegistryWrapper;
import raika.halseki.raven.common.registries.impl.wrapper.interfaces.IHasNameEntry;

// JISSOU MENDOUKUSAI
public class RavenLazyContainerRegister extends RavenLazyRegistryWrapper<ContainerType<?>> {
    public RavenLazyContainerRegister(String modId) {
        super(modId, ForgeRegistries.CONTAINERS);
    }

    public <T extends BaseRavenTileEntity> RavenRegistryContainer<BaseRavenContainer<T>> registry(IHasNameEntry entry, Class<T> clazz) {
        return registry(entry.getLocalizeName(), clazz);
    }

    @SuppressWarnings("null")
    public <T extends BaseRavenTileEntity> RavenRegistryContainer<BaseRavenContainer<T>> registry(String internalName, Class<T> clazz) {
        RavenRegistryContainer<BaseRavenContainer<T>> registry = new RavenRegistryContainer<BaseRavenContainer<T>>(null);
        IContainerFactory<BaseRavenContainer<T>> factory = (windowId, inv, data) ->
                new BaseRavenContainer<T>(registry, windowId, BaseRavenContainer.getTile(data, clazz), inv){};
        return null;
    }
}
