package raika.halseki.raven.common.library.base;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import raika.halseki.raven.common.library.base.inventory.container.ContainerInventory;
import raika.halseki.raven.common.library.base.inventory.slot.SlotPedestalItem;
import raika.halseki.raven.common.library.math.VectorProperty;
import raika.halseki.raven.common.library.MathHelper;
import raika.halseki.raven.common.library.utils.TileExtend;
import raika.halseki.raven.common.registries.impl.objects.RavenRegistryContainer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class BaseRavenContainer<T extends BaseRavenTileEntity> extends Container {
    protected final T tileEntity;
    protected final List<SlotPedestalItem> pedestalItems = new ArrayList<>();

    private final PlayerInventory    playerInventory;
    private final ContainerInventory containerInventory;

    // Debug Mode
    private static final boolean isAlwaysAccess = false;

    public BaseRavenContainer(@Nullable ContainerType<?> type, int id, T tileEntity, PlayerInventory playerInventory) {
        super(type, id);
        this.tileEntity = tileEntity;
        this.playerInventory = playerInventory;
        this.containerInventory = tileEntity.getInventory();
    }

    public BaseRavenContainer(@Nullable RavenRegistryContainer<?> type, int id, T tileEntity, PlayerInventory playerInventory) {
        super(Objects.requireNonNull(type).getContainerType(), id);
        this.tileEntity = tileEntity;
        this.playerInventory = playerInventory;
        this.containerInventory = tileEntity.getInventory();
    }

    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return isAlwaysAccess || isPlayerApart(playerIn);
    }

    /** @return boolean -> container block is player 8 blocks apart. */
    protected final boolean isPlayerApart(PlayerEntity playerIn) {
        return 8 >= MathHelper.pySum(new VectorProperty(
                tileEntity.getPos().getX() - playerIn.getPosX(),
                tileEntity.getPos().getY() - playerIn.getPosY(),
                tileEntity.getPos().getZ() - playerIn.getPosZ()));
    }

    public static <T extends TileEntity> T getTile(PacketBuffer buffer, Class<T> clazz) {
        return buffer != null
                ? DistExecutor.unsafeCallWhenOn(
                        Dist.CLIENT, () -> () -> TileExtend.getTile(clazz, Minecraft.getInstance().world, buffer.readBlockPos())).orElse(null)
                : null;
    }

    @Nonnull
    @Override
    protected Slot addSlot(@Nonnull Slot slotIn) {
        return super.addSlot(slotIn);
    }
}
