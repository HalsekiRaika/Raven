package raika.halseki.raven.common.block.tiles;

import net.minecraft.tileentity.TileEntityType;
import raika.halseki.raven.common.library.base.BaseRavenTileEntity;
import raika.halseki.raven.common.library.interfaces.tile.ITriggerableWithWand;
import raika.halseki.raven.common.library.provider.IRavenBlockProvider;

public class TileEntityCastingMatrix extends BaseRavenTileEntity implements ITriggerableWithWand {
    public TileEntityCastingMatrix(TileEntityType<?> type) {
        super((IRavenBlockProvider) type);
    }

    @Override
    public void onTrigger() {

    }

}
