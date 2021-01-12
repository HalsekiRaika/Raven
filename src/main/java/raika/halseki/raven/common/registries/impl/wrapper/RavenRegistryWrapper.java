package raika.halseki.raven.common.registries.impl.wrapper;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistryEntry;
import raika.halseki.raven.common.registries.impl.wrapper.interfaces.IHasNameEntry;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class RavenRegistryWrapper<T extends IForgeRegistryEntry<? super T>> implements Supplier<T>, IHasNameEntry {
    @Nonnull
    protected RegistryObject<T> registryObject;

    protected RavenRegistryWrapper(@Nonnull RegistryObject<T> registryObject) {
        this.registryObject = registryObject;
    }

    @Nonnull
    @Override
    public T get() {
        return registryObject.get();
    }

    @Override
    public String getLocalizeName() {
        return registryObject.getId().getPath();
    }
}
