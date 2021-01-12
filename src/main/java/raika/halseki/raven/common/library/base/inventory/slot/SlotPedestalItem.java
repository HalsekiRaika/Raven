package raika.halseki.raven.common.library.base.inventory.slot;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;

import javax.annotation.Nonnull;

public class SlotPedestalItem extends Slot {
    public SlotPedestalItem(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    @Override
    public boolean canTakeStack(@Nonnull PlayerEntity playerIn) {
        return false;
    }
}
