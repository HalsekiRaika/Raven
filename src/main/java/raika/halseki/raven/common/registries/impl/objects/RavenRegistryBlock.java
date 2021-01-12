package raika.halseki.raven.common.registries.impl.objects;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import raika.halseki.raven.common.library.provider.IRavenBlockProvider;
import raika.halseki.raven.common.registries.impl.wrapper.RavenRegistryComplexWrapper;

import javax.annotation.Nonnull;

public class RavenRegistryBlock<T extends Block, R extends Item> extends RavenRegistryComplexWrapper<T, R> implements IRavenBlockProvider {
    public RavenRegistryBlock(RegistryObject<T> registryObjectA, RegistryObject<R> registryObjectB) {
        super(registryObjectA, registryObjectB);
    }
    /** @return T extends Block */
    @Nonnull
    @Override
    public Block getBlock() {
        return getRegistryA();
    }

    /** @return  R extends Item  */
    @Nonnull
    @Override
    public Item getItem() {
        return getRegistryB();
    }
}
