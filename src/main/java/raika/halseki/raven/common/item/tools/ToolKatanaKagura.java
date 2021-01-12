package raika.halseki.raven.common.item.tools;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potions;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import raika.halseki.raven.common.library.base.tools.BaseRavenComboTool;
import raika.halseki.raven.common.potion.RavenEffectOverride;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ToolKatanaKagura extends BaseRavenComboTool {
    private static final String TAG_CHARGING = "charging";

    public ToolKatanaKagura(Properties builderIn) {
        super(builderIn);
    }

    @Override
    public int getComboLimit() {
        return 2048;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        // Override Effects
        entityLiving.addPotionEffect(new EffectInstance(RavenEffectOverride.INSTANCE));

        // Consume Combo
        onOverRide(stack, timeLeft);
    }



    public void onOverRide(ItemStack stack, int time) {
        int combo = this.getComboNum(stack);
        this.setCombo(stack, Math.max(combo - time / 20, 0));
    }
}
