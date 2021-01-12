package raika.halseki.raven.common.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import raika.halseki.raven.common.library.interfaces.tile.ITriggerableWithWand;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class ItemRavenManipulator extends Item {
    private static final String TAG_CHARGING = "charging";

    public ItemRavenManipulator(Properties properties) {
        super(properties.rarity(Rarity.EPIC)
                .maxStackSize(1)
                .isImmuneToFire()
        );
    }

    @Override
    public void addInformation(@Nonnull ItemStack stack, @Nullable World worldIn, @Nonnull List<ITextComponent> tooltip, @Nonnull ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Nonnull
    @Override
    public UseAction getUseAction(@Nonnull ItemStack stack) {
        return UseAction.BOW;
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(@Nonnull World worldIn, @Nonnull PlayerEntity playerIn, @Nonnull Hand handIn) {
        //if (handIn == Hand.OFF_HAND) return ActionResult.resultPass(new ItemStack((Item) this));
        playerIn.setActiveHand(handIn);
        ItemStack stack = playerIn.getHeldItem(handIn);
        onCharge(stack, true);
        return ActionResult.resultConsume(stack);
        //return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public void onPlayerStoppedUsing(@Nonnull ItemStack stack, @Nonnull World worldIn, @Nonnull LivingEntity entityLiving, int timeLeft) {
        onCharge(stack, false);
    }

    @Override
    public int getUseDuration(@Nonnull ItemStack stack) {
        return 90000;
    }

    public static void onCharge(@Nonnull ItemStack stack, boolean isDraw) {
        stack.getOrCreateTag().putBoolean(TAG_CHARGING, isDraw);
    }

    @Nonnull
    @Override
    public ActionResultType onItemUse(@Nonnull ItemUseContext context) {
        TileEntity tileEntity = context.getWorld().getTileEntity(context.getPos());
        if (tileEntity instanceof ITriggerableWithWand) {
            ((ITriggerableWithWand) tileEntity).onTrigger();
            if (Objects.requireNonNull(context.getPlayer()).isSneaking()) {
                ((ITriggerableWithWand) tileEntity).onTriggerWithSneaking();
            }
        }

        return ActionResultType.SUCCESS;
    }
}
