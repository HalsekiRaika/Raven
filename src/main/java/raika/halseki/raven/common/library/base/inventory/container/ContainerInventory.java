package raika.halseki.raven.common.library.base.inventory.container;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.items.ItemStackHandler;
import raika.halseki.raven.common.library.base.BaseRavenTileEntity;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Supplier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ContainerInventory extends ItemStackHandler implements Iterable<ItemStack> {
    protected final BaseRavenTileEntity tileEntity;
    protected final Supplier<Integer> slotNumberProvider;
    protected final Consumer<Integer> slotWatchDog;

    public ContainerInventory(BaseRavenTileEntity tileEntity, Supplier<Integer> slotNumberProvider, @Nullable Consumer<Integer> listener) {
        super(slotNumberProvider.get());

        this.tileEntity = tileEntity;
        this.slotNumberProvider = slotNumberProvider;
        this.slotWatchDog = listener;
    }

    public ContainerInventory INSTANCE() {
        return new ContainerInventory(this.tileEntity, this.slotNumberProvider, this.slotWatchDog);
    }

    public CompoundNBT serialize() {
        return this.serializeNBT();
    }

    public ContainerInventory deserialize(CompoundNBT context) {
        this.deserializeNBT(context);
        if (this.getSlots() != this.slotNumberProvider.get()) {
            ContainerInventory inventory = this.INSTANCE();
            for (int i = 0; i < Math.min(this.getSlots(), inventory.getSlots()); i++) {
                ItemStack copyObj = this.getStackInSlot(i).copy();
                copyObj.setCount(this.getStackInSlot(i).getCount());
                inventory.setStackInSlot(i, copyObj);
            }
            return inventory;
        }
        return this;
    }

    @Override
    protected void onContentsChanged(int slot) {
        super.onContentsChanged(slot);
        if (slotWatchDog != null) slotWatchDog.accept(slot);
        tileEntity.markDirty();
    }

    @Override
    public Iterator<ItemStack> iterator() {
        return this.stacks.iterator();
    }
}
