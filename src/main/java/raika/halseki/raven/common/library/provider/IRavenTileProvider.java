package raika.halseki.raven.common.library.provider;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public interface IRavenTileProvider<T extends TileEntity> {
    public TileEntityType<? extends T> getTileEntityType();
}
