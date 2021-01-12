package raika.halseki.raven.common.registries.impl;

import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.registries.ForgeRegistries;
import raika.halseki.raven.Raven;
import raika.halseki.raven.common.library.provider.IRavenItemProvider;
import raika.halseki.raven.common.registries.impl.objects.RavenRegistryItem;
import raika.halseki.raven.common.registries.impl.wrapper.RavenLazyRegistryWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/// Deferred and Lazy are essentially different words,
/// but since the name is long, I use Lazy, which essentially means the same thing.
/// Well, I just don't have the naming sense. XD
public class RavenLazyItemRegister extends RavenLazyRegistryWrapper<Item>  {
    private static final List<IRavenItemProvider> items = new ArrayList<>();

    public RavenLazyItemRegister(String modId) {
        super(modId, ForgeRegistries.ITEMS);
    }

    public RavenRegistryItem<Item> registry(String name) {
        return registry(name, Item::new);
    }

    public RavenRegistryItem<Item> registry(String name, Rarity rarity) {
        return registry(name, properties -> new Item(properties.rarity(rarity)));
    }

    public <T extends Item> RavenRegistryItem<T> registry(String name, Function<Item.Properties, T> sup) {
        return registry(name, () -> sup.apply(getBaseProperties()));
    }

    public <T extends Item> RavenRegistryItem<T> registry(String name, Supplier<? extends T> sup) {
        RavenRegistryItem<T> registeredItem = register(name, sup, RavenRegistryItem::new);
        items.add(registeredItem);
        return registeredItem;
    }

    public static Item.Properties getBaseProperties() {
        return new Item.Properties().group(Raven.creativeTab);
    }

    public static List<IRavenItemProvider> getItems() {
        return items;
    }
}
