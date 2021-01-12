package raika.halseki.raven.common.library.base;

import net.minecraft.tileentity.TileEntity;
import raika.halseki.raven.common.library.base.inventory.container.ContainerInventory;
import raika.halseki.raven.common.library.provider.IRavenBlockProvider;
import raika.halseki.raven.common.library.provider.IRavenTileProvider;

public abstract class BaseRavenTileEntity extends TileEntity {
    private final ContainerInventory inventory;

    public BaseRavenTileEntity(IRavenBlockProvider provider) {
        super(((IRavenTileProvider<? extends TileEntity> ) provider.getBlock()).getTileEntityType());
        this.inventory = new ContainerInventory(this, () -> 34, null);
    }

    public ContainerInventory getInventory() {
        return inventory;
    }
}
