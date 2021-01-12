package raika.halseki.raven.common.registries.impl;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import raika.halseki.raven.common.library.provider.IRavenBlockProvider;
import raika.halseki.raven.common.registries.impl.objects.RavenRegistryBlock;
import raika.halseki.raven.common.registries.impl.wrapper.RavenLazyRegistryComplexWrapper;
import raika.halseki.raven.common.registries.impl.wrapper.RavenRegistryComplexWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class RavenLazyBlockRegister extends RavenLazyRegistryComplexWrapper<Block, Item> {
    private final List<IRavenBlockProvider> blocks = new ArrayList<>();

    public RavenLazyBlockRegister(String modid) {
        super(modid, ForgeRegistries.BLOCKS, ForgeRegistries.ITEMS);
    }

    public RavenRegistryComplexWrapper<Block, BlockItem> register(String name, AbstractBlock.Properties properties) {
        return registerBaseProperties(name, () -> new Block(properties), BlockItem::new);
    }

    public <T extends Block> RavenRegistryComplexWrapper<T, BlockItem> register(String name, Supplier<? extends T> blockSupplier) {
        return registerBaseProperties(name, blockSupplier, BlockItem::new);
    }

    public <T extends Block, R extends BlockItem> RavenRegistryComplexWrapper<T, R> registerBaseProperties(
            String name, Supplier<? extends T> blockSupplier, BiFunction<T, Item.Properties, R> itemCreator) {
        return register(name, blockSupplier, block -> itemCreator.apply(block, RavenLazyItemRegister.getBaseProperties()));
    }

    public <T extends Block, R extends BlockItem> RavenRegistryComplexWrapper<T, R> register(
            String name, Supplier<? extends T> blockSupplier, Function<T, R> itemCreator) {
        RavenRegistryBlock<T, R> registeredBlock = register(name, blockSupplier, itemCreator, RavenRegistryBlock::new);
        blocks.add(registeredBlock);
        return registeredBlock;
    }

    public List<IRavenBlockProvider> getAllBlocks() {
        return blocks;
    }
}
