package raika.halseki.raven.common.container;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import raika.halseki.raven.common.block.tiles.TileEntityCastingMatrix;
import raika.halseki.raven.common.library.base.BaseRavenContainer;
import raika.halseki.raven.common.library.base.inventory.container.ContainerInventory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ContainerCastingMatrix extends BaseRavenContainer<TileEntityCastingMatrix> {
    public ContainerCastingMatrix(@Nullable ContainerType<?> type, int id, TileEntityCastingMatrix tileEntity, PlayerInventory playerInventory) {
        super(type, id, tileEntity, playerInventory);
    }
}
