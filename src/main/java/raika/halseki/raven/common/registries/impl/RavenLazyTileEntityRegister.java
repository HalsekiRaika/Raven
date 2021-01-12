package raika.halseki.raven.common.registries.impl;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ForgeRegistries;
import raika.halseki.raven.common.registries.impl.objects.RavenRegistryBlock;
import raika.halseki.raven.common.registries.impl.objects.RavenRegistryTileEntity;
import raika.halseki.raven.common.registries.impl.wrapper.RavenLazyRegistryWrapper;

import java.util.function.Supplier;

public class RavenLazyTileEntityRegister extends RavenLazyRegistryWrapper<TileEntityType<?>> {
    public RavenLazyTileEntityRegister(String modId) {
        super(modId, ForgeRegistries.TILE_ENTITIES);
    }

    @SuppressWarnings("all")
    public <T extends TileEntity> RavenRegistryTileEntity<T> register(RavenRegistryBlock<?, ?> block, Supplier<? extends T> factory) {
        return register(block.getLocalizeName(),
                () -> TileEntityType.Builder.<T>create(factory, block.getBlock()).build(null), // <- Idk DataFixer. How do I use this?
                RavenRegistryTileEntity::new
        );
    }
}
