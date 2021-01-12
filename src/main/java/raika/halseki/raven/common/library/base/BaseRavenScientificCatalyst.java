package raika.halseki.raven.common.library.base;

import net.minecraft.block.Block;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.ToolItem;
import net.minecraft.util.text.TextFormatting;

import java.util.Set;

public abstract class BaseRavenScientificCatalyst extends ToolItem {
    public BaseRavenScientificCatalyst(float attackDamageIn, float attackSpeedIn, IItemTier tier, Set<Block> effectiveBlocksIn, Properties properties) {
        super(0.0f, 0.0f, tier, effectiveBlocksIn, properties.rarity(Rarity.create("scientific", TextFormatting.GREEN)));
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }
}
