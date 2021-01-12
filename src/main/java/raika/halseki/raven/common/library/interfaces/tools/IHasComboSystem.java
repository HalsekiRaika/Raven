package raika.halseki.raven.common.library.interfaces.tools;

import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public interface IHasComboSystem {
    default boolean isComboDecreasedTick() { return false; }
    default int getComboLimit() { return 512; }
}
