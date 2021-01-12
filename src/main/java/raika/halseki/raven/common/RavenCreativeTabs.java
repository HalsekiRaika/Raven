package raika.halseki.raven.common;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import raika.halseki.raven.common.registries.RavenItemType;

import javax.annotation.Nonnull;

public class RavenCreativeTabs extends ItemGroup {
    public RavenCreativeTabs() {
        super("raven");
    }

    @Nonnull
    @Override
    public ItemStack createIcon() {
        return RavenItemType.RAVEN_MANIPULATOR.getItemStack();
    }
}
