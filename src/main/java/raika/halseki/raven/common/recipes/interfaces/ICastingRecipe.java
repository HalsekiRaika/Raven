package raika.halseki.raven.common.recipes.interfaces;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.RecipeMatcher;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ICastingRecipe extends IRecipe<IInventory> {
    @Override
    default boolean matches(@Nonnull IInventory inv, @Nonnull World worldIn) {
        return this.matches(new InvWrapper(inv));
    }

    default boolean matches(IItemHandler itemHandler) {
        return this.matches(itemHandler, 0, itemHandler.getSlots());
    }

    default boolean matches(IItemHandler itemHandler, int startIndex, int endIndex) {
        List<ItemStack> targetItems = new ArrayList<>();
        for (int i = startIndex; i < endIndex; i++) {
            targetItems.add(itemHandler.getStackInSlot(i));
        }
        return RecipeMatcher.findMatches(targetItems, this.getIngredients()) != null;
    }

    @Nonnull
    @Override
    default ItemStack getCraftingResult(@Nonnull IInventory inv) {
        return this.getCraftingResult(new InvWrapper(inv));
    }

    ItemStack getCraftingResult(IItemHandler itemHandler);

    @Nonnull
    @Override
    default NonNullList<ItemStack> getRemainingItems(@Nonnull IInventory inv) {
        return this.getRemainingItems(new InvWrapper(inv));
    }

    default NonNullList<ItemStack> getRemainingItems(IItemHandler itemHandler) {
        NonNullList<ItemStack> itemStacks = NonNullList.withSize(itemHandler.getSlots(), ItemStack.EMPTY);
        for (int i = 0; i < itemStacks.size(); i++) {
            ItemStack stack = itemHandler.getStackInSlot(i);
            if (stack.hasContainerItem()) itemStacks.set(i, stack.getContainerItem());
        }
        return itemStacks;
    }
}
