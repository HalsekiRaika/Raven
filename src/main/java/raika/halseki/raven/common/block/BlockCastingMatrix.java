package raika.halseki.raven.common.block;

import net.minecraft.block.Block;
import net.minecraftforge.common.ToolType;

public class BlockCastingMatrix extends Block {
    public BlockCastingMatrix(Properties properties) {
        super(properties.harvestTool(ToolType.PICKAXE)
                .doesNotBlockMovement()
                .hardnessAndResistance(4f)
        );
    }
}
