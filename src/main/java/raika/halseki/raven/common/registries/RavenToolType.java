package raika.halseki.raven.common.registries;

import net.minecraft.item.Item;
import raika.halseki.raven.common.item.tools.ToolKatanaKagura;
import raika.halseki.raven.common.library.base.tools.BaseRavenComboSword;
import raika.halseki.raven.common.registries.impl.RavenLazyItemRegister;
import raika.halseki.raven.common.registries.impl.objects.RavenRegistryItem;

public class RavenToolType {
    public static final RavenLazyItemRegister ITEM_REGISTER = new RavenLazyItemRegister("raven");

    public static final RavenRegistryItem<BaseRavenComboSword> TOOL_KATANA_KAGURA = ITEM_REGISTER.registry("katana_kagura", ToolKatanaKagura::new);
}
