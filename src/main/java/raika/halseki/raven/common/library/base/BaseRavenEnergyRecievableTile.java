package raika.halseki.raven.common.library.base;

import net.minecraft.util.math.BlockPos;
import raika.halseki.raven.common.library.interfaces.tile.INetworkLinkable;
import raika.halseki.raven.common.library.provider.IRavenBlockProvider;

import javax.annotation.Nonnull;

public abstract class BaseRavenEnergyRecievableTile extends BaseRavenTileEntity implements INetworkLinkable {
    public BaseRavenEnergyRecievableTile(IRavenBlockProvider provider) {
        super(provider);
    }

    @Nonnull
    @Override
    public BlockPos getPos() {
        return this.pos;
    }


}
