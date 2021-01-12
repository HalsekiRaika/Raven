package raika.halseki.raven.common.registries.impl.objects;

import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import raika.halseki.raven.common.registries.impl.wrapper.RavenRegistryWrapper;

import javax.annotation.Nonnull;

public class RavenRegistryContainer<T extends Container> extends RavenRegistryWrapper<ContainerType<T>> {
    @SuppressWarnings("null")
    public RavenRegistryContainer(@Nonnull RegistryObject<ContainerType<T>> registryObject) {
        super(registryObject);
    }

    protected RavenRegistryContainer<T> setRegistryObject(RegistryObject<ContainerType<T>> registryObject) {
        this.registryObject = registryObject;
        return this;
    }

    @Nonnull
    public ContainerType<T> getContainerType() {
        return get();
    }
}
