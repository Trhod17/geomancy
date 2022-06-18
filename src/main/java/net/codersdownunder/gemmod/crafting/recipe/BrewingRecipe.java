package net.codersdownunder.gemmod.crafting.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.RecipeInit;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.util.RecipeMatcher;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class BrewingRecipe implements Recipe<SimpleContainer>
{
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;


    public BrewingRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeInit.BREWING_TYPE.get();
    }


    @Override
    public boolean matches(SimpleContainer pInv, Level pLevel) {
        List<ItemStack> inputs = new ArrayList<>();
        int matched = 0;

        for (int i = 0; i < pInv.getContainerSize(); i++) {
            ItemStack stack = pInv.getItem(i);

            if (!stack.isEmpty()) {
                inputs.add(stack);

                matched++;
            }
        }

        return matched == inputs.size() && RecipeMatcher.findMatches(inputs, this.recipeItems) != null && this.matches(pInv, false);
    }

    private boolean matches(SimpleContainer pCraftingInventory, boolean pMirrored) {

        Ingredient ingredient = Ingredient.EMPTY;
        ingredient = this.recipeItems.get(6);

        if (!ingredient.test(pCraftingInventory.getItem(6))) {
            return false;
        }

        return true;
    }


    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public ItemStack assemble(SimpleContainer pInv) {
        return this.output;
    }


    @Override
    public ItemStack getResultItem() {
        //ItemStack output = this.output;


        //if (output.isEmpty()) // Should only happen if the result from matches() gets ignored
        //	return ItemStack.EMPTY;

        //CompoundTag output_nbt = new CompoundTag();
        //output_nbt.putInt("Id", ((BannerItem)banner.getItem()).getColor().getId());
        //book.setTagInfo("BlockEntityTag", output_nbt);
        return this.output.copy();
    }

    public ItemStack getIcon() {
        return new ItemStack(BlockInit.INFUSION_STAND.get());
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeInit.BREWING.get();
    }

    public static class Serializer<T extends BrewingRecipe> implements RecipeSerializer<BrewingRecipe> {
        final BrewingRecipe.Serializer.IRecipeFactory<T> factory;

        public Serializer(BrewingRecipe.Serializer.IRecipeFactory<T> factory) {
            this.factory = factory;
        }

        @Override
        public BrewingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
            ItemStack output = CraftingHelper.getItemStack(pJson, true);
            //int infusingTime = JSONUtils.getAsInt(pJson, "time");

            JsonArray ingredients = GsonHelper.getAsJsonArray(pJson, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return this.factory.create(pRecipeId, output, inputs);
        }

        @Nullable
        @Override
        public BrewingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);
            pBuffer.readInt();
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }

            ItemStack output = pBuffer.readItem();

            return this.factory.create(pRecipeId, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, BrewingRecipe pRecipe) {
            pBuffer.writeInt(pRecipe.getIngredients().size());
            for (Ingredient ing : pRecipe.getIngredients()) {
                ing.toNetwork(pBuffer);
            }

            pBuffer.writeItemStack(pRecipe.output, false);
        }

        public interface IRecipeFactory<T extends BrewingRecipe> {
            T create(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems);
        }
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }
}

