package raika.halseki.raven.common.registries.impl;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.registries.ForgeRegistries;
import raika.halseki.raven.common.registries.impl.objects.RavenRegistryRecipeSerializer;
import raika.halseki.raven.common.registries.impl.wrapper.RavenLazyRegistryWrapper;

import java.util.function.Supplier;

public class RavenLazyRecipeSerializerRegister extends RavenLazyRegistryWrapper<IRecipeSerializer<?>> {
    public RavenLazyRecipeSerializerRegister(String modId) {
        super(modId, ForgeRegistries.RECIPE_SERIALIZERS);
    }

    public <T extends IRecipe<?>> RavenRegistryRecipeSerializer<T> register(String name, Supplier<IRecipeSerializer<T>> registryObject) {
        return register(name, registryObject, RavenRegistryRecipeSerializer::new);
    }
}
