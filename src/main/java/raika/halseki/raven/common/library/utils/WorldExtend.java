package raika.halseki.raven.common.library.utils;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class WorldExtend {
    public static boolean isTruthfulWorld(@Nullable IBlockReader worldIn, BlockPos pos) {
        return worldIn == null || !World.isValid(pos);
    }

    public static boolean isTruthfulWorld(@Nullable IWorld worldIn, BlockPos pos) {
        return worldIn == null || !World.isValid(pos);
    }
}
