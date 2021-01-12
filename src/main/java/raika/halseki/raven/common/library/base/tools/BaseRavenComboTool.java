package raika.halseki.raven.common.library.base.tools;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.world.World;
import raika.halseki.raven.common.library.interfaces.tools.IHasComboSystem;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collections;

@ParametersAreNonnullByDefault
public abstract class BaseRavenComboTool extends ToolItem implements IHasComboSystem {
    protected static final String NBT_COMBO = "raven_combo_num";
    protected static final String NBT_BOSS_KILL = "raven_boss_kill";
    //private final


    public BaseRavenComboTool(Properties builderIn) {
        super(4, 2, ItemTier.NETHERITE, Collections.emptySet(), builderIn);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int combo = 1;
        float targetHealth = target.getHealth();

        if (targetHealth >= 10) {
            combo += 1;
        } else if (targetHealth >= 15) {
            combo += 2;
        } else if (targetHealth >= 20) {
            combo += 2;
        } else if (targetHealth >= 25) {
            combo += 4;
        } else if (targetHealth >= 50) {
            combo += 8;
        } else if (targetHealth >= 100) {
            combo += 8;
        }

        increaseCombo(stack, combo);

        return true;
    }

    @Override
    public float getAttackDamage() {
        return getBaseDamage() * (1.0f + (0.02f * getComboNum(this.getDefaultInstance())));
    }

    public float getBaseDamage() {
        return 4.0f;
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        stack.getOrCreateTag().putInt(NBT_COMBO, 0);
    }

    public void increaseCombo(@Nonnull ItemStack stack, int increaseValue) {
        int oldCombo = getComboNum(stack);
        if (getComboLimit() >= oldCombo + increaseValue) {
            stack.getOrCreateTag().putInt(NBT_COMBO, (oldCombo + increaseValue));
        } else {
            setCombo(stack, getComboLimit());
        }
    }

    public int getComboNum(@Nonnull ItemStack stack) {
        return stack.getOrCreateTag().getInt(NBT_COMBO);
    }

    public void setCombo(@Nonnull ItemStack stack, int comboNum) {
        stack.getOrCreateTag().putInt(NBT_COMBO, comboNum);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
