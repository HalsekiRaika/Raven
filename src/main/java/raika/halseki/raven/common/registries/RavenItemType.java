package raika.halseki.raven.common.registries;

import net.minecraft.item.Item;
import raika.halseki.raven.common.item.ItemRavenManipulator;
import raika.halseki.raven.common.item.basic.ItemCadlfriteCrystal;
import raika.halseki.raven.common.item.basic.ItemDarkSunFragment;
import raika.halseki.raven.common.registries.impl.RavenLazyItemRegister;
import raika.halseki.raven.common.registries.impl.objects.RavenRegistryItem;


public class RavenItemType {
    public static final RavenLazyItemRegister ItemRegister = new RavenLazyItemRegister("raven");

    public static final RavenRegistryItem<Item> RAVEN_MANIPULATOR = ItemRegister.registry("raven_manipulator", ItemRavenManipulator::new);
    public static final RavenRegistryItem<Item> CADLFRITE_CRYSTAL = ItemRegister.registry("cadlfrite_crystal", ItemCadlfriteCrystal::new);
    public static final RavenRegistryItem<Item> ECLIPSE_FRAGMENT  = ItemRegister.registry("eclipse_fragment" ,  ItemDarkSunFragment::new);

}
