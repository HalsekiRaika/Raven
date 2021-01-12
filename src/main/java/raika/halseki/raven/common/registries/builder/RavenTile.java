package raika.halseki.raven.common.registries.builder;

import net.minecraft.tileentity.TileEntity;
import raika.halseki.raven.common.registries.impl.objects.RavenRegistryTileEntity;

import java.util.function.Supplier;

public class RavenTile<T extends TileEntity> {
    private final Supplier<RavenRegistryTileEntity<T>> registry;

    public RavenTile(Supplier<RavenRegistryTileEntity<T>> registry) {
        this.registry = registry;
    }

    public static class Builder<A extends RavenTile<B>, B extends TileEntity, C extends Builder<A, B, C>> {
        protected final A object;

        protected Builder(A a) { this.object = a; }

        public static <B extends TileEntity> Builder<RavenTile<B>, B, ?> define(Supplier<RavenRegistryTileEntity<B>> registry) {
            return new Builder<>(new RavenTile<>(registry));
        }
    }
}