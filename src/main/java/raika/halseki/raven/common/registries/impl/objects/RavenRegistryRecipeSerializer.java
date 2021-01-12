package raika.halseki.raven.common.registries.impl.objects;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import raika.halseki.raven.common.registries.impl.wrapper.RavenRegistryWrapper;

import javax.annotation.Nonnull;

public class RavenRegistryRecipeSerializer<T extends IRecipe<?>> extends RavenRegistryWrapper<IRecipeSerializer<T>> {
    public RavenRegistryRecipeSerializer(RegistryObject<IRecipeSerializer<T>> registryObject) {
        super(registryObject);
    }

    @Nonnull
    public IRecipeSerializer<T> getRecipeSerializer() {
        return get();
    }
}
