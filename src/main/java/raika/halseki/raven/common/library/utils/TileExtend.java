package raika.halseki.raven.common.library.utils;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.IChunk;
import raika.halseki.raven.Raven;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;

@ParametersAreNonnullByDefault
public class TileExtend {
    /// TODO : Write doc
    public static Optional<IChunk> getTileChunkPos(@Nullable IWorld worldIn, Long2ObjectMap<IChunk> chunkMap, BlockPos pos) {
        if (WorldExtend.isTruthfulWorld(worldIn, pos)) return Optional.empty();
        int chunkPosX = pos.getX() >> 4;
        int chunkPosY = pos.getZ() >> 4;

        long chunkProperty = ((long) chunkPosX << 32) | ((long) chunkPosY & 0xFFFFFFFFL);
        Optional<IChunk> chunk = Optional.of(chunkMap.get(chunkProperty));
        if (!chunk.isPresent()) {
            chunk = Optional.of(worldIn.getChunk(chunkPosX, chunkPosY, ChunkStatus.FULL, false));
            if (chunk.isPresent()) {
                chunkMap.put(chunkProperty, chunk.orElseGet(() -> null));
            }
        }
        return chunk;
    }

    public static <T extends TileEntity> Optional<T> getTile(Class<T> tileExpect, @Nullable IBlockReader worldIn, BlockPos pos) {
        Optional<TileEntity> tileEntity = getTile(worldIn, pos);
        if (!tileEntity.isPresent()) return Optional.empty();
        if (tileExpect.isInstance(tileEntity.orElse(null))) {
            return Optional.of(tileExpect.cast(tileEntity.orElse(null)));
        } else {
            Raven.getLogger().warn("Unexpect Tile Class XP: [{}] / Found!: [{}] / Expect?: [{}]", pos, tileExpect, tileEntity.getClass());
        }
        return Optional.empty();
    }

    public static Optional<TileEntity> getTile(@Nullable IBlockReader worldIn, BlockPos pos) {
        return !WorldExtend.isTruthfulWorld(worldIn, pos) ? Optional.empty() : Optional.of(worldIn.getTileEntity(pos));
    }

    public static boolean isTileLoaded(@Nullable IBlockReader worldIn, BlockPos pos) {
        return !WorldExtend.isTruthfulWorld(worldIn, pos) && (worldIn instanceof IWorldReader);
    }
}
