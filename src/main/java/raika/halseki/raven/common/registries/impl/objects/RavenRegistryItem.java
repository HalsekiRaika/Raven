package raika.halseki.raven.common.registries.impl.objects;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import raika.halseki.raven.common.library.provider.IRavenItemProvider;
import raika.halseki.raven.common.registries.impl.wrapper.RavenRegistryWrapper;

import javax.annotation.Nonnull;

public class RavenRegistryItem<T extends Item> extends RavenRegistryWrapper<Item> implements IRavenItemProvider {
    public RavenRegistryItem(@Nonnull RegistryObject<Item> registryObject) {
        super(registryObject);
    }

    @Nonnull
    @Override
    public Item getItem() {
        return get();
    }
}
