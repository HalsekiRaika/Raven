package raika.halseki.raven.common.library.base;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

import javax.annotation.Nonnull;

public abstract class BaseRavenBlockItem<T extends Block> extends BlockItem {
    public BaseRavenBlockItem(@Nonnull T block, Properties properties) {
        super(block, properties);
    }
}
