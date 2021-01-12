package raika.halseki.raven.common.registries.impl.objects;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import raika.halseki.raven.common.registries.impl.wrapper.RavenRegistryWrapper;

import javax.annotation.Nonnull;

public class RavenRegistryTileEntity<T extends TileEntity> extends RavenRegistryWrapper<TileEntityType<T>> {
    public RavenRegistryTileEntity(RegistryObject<TileEntityType<T>> registryObject) {
        super(registryObject);
    }

    @Nonnull
    public TileEntityType<T> getTileEntityType() {
        return get();
    }
}
