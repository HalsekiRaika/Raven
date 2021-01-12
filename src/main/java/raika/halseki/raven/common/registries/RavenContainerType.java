package raika.halseki.raven.common.registries;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class RavenContainerType<T extends Container> extends ForgeRegistryEntry<ContainerType<?>> implements IForgeContainerType<T> {
    // Registration

    // Factory
    private final ContainerType.IFactory<T> factory;

    public RavenContainerType(ContainerType.IFactory<T> factory) {
        this.factory = factory;
    }

    @SuppressWarnings("deprecated")
    private static <T extends Container> ContainerType<T> register(String key, ContainerType.IFactory<T> factory) {
        return Registry.register(Registry.MENU, key, new ContainerType<>(factory));
    }

    @OnlyIn(Dist.CLIENT)
    public T create(int windowId, PlayerInventory player) {
        return this.factory.create(windowId, player);
    }

    @Override
    public T create(int windowId, PlayerInventory playerInv, PacketBuffer extraData) {
        if (this.factory instanceof IContainerFactory) {
            return ((IContainerFactory<T>) this.factory).create(windowId, playerInv, extraData);
        }
        return create(windowId, playerInv);
    }
}
