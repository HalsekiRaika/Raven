package raika.halseki.raven.common.recipes;

import com.google.gson.JsonObject;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.registries.ForgeRegistryEntry;
import raika.halseki.raven.common.recipes.interfaces.ICastingRecipe;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Map;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class RecipeCastingMatrix implements ICastingRecipe {
    @Nonnull
    private final ResourceLocation resourceLocation;
    private final ItemStack outputItem;
    private final NonNullList<Ingredient> inputItems;

    public RecipeCastingMatrix(ResourceLocation rl, ItemStack outputItem, NonNullList<Ingredient> inputItems) {
        this.resourceLocation = rl;
        this.outputItem = outputItem;
        this.inputItems = inputItems;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.inputItems;
    }

    @Override
    public ItemStack getCraftingResult(IItemHandler itemHandler) {
        return this.outputItem.copy();
    }

    @Override
    public boolean canFit(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.outputItem;
    }

    @Override
    public ResourceLocation getId() {
        return this.resourceLocation;
    }

    @Override
    public boolean matches(IItemHandler itemHandler) {
        return false;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return null;
    }

    @Override
    public IRecipeType<?> getType() {
        return null;
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ICastingRecipe> {
        @Override
        public ICastingRecipe read(ResourceLocation recipeId, JsonObject json) {
            NonNullList<Ingredient> nonnullIngredient = NonNullList.create();
            Map<String, Ingredient> itemMap;

            return null;
        }

        @Nullable
        @Override
        public ICastingRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
            return null;
        }

        @Override
        public void write(PacketBuffer buffer, ICastingRecipe recipe) {

        }
    }
}
