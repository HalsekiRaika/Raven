package raika.halseki.raven.common.registries.impl.wrapper;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistryEntry;
import raika.halseki.raven.common.registries.impl.wrapper.interfaces.IHasNameEntry;

import javax.annotation.Nonnull;

public class RavenRegistryComplexWrapper<T extends IForgeRegistryEntry<? super T>,
        R extends IForgeRegistryEntry<? super R>> implements IHasNameEntry {

    private final RegistryObject<T> registryObjectA;
    private final RegistryObject<R> registryObjectB;

    public RavenRegistryComplexWrapper(RegistryObject<T> registryObjectA, RegistryObject<R> registryObjectB) {
        this.registryObjectA = registryObjectA;
        this.registryObjectB = registryObjectB;
    }

    @Nonnull
    public T getRegistryA() {
        return registryObjectA.get();
    }

    @Nonnull
    public R getRegistryB() {
        return registryObjectB.get();
    }

    @Override
    public String getLocalizeName() {
        return registryObjectA.getId().getPath();
    }
}
