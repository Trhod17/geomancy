package net.codersdownunder.gemmod.crafting.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Pair;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.RecipeInit;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.RecipeMatcher;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class InfusingRecipe implements Recipe<SimpleContainer>
{
    private final ResourceLocation id;
    private final ItemStack output;
    private final ItemStack base;
    private final NonNullList<Ingredient> recipeItems;


    public InfusingRecipe(ResourceLocation id, ItemStack output, ItemStack base, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.base = base;
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeInit.INFUSING_TYPE.get();
    }

    //TODO: fix baseitem matching

    @Override
    public boolean matches(SimpleContainer pInv, Level pLevel) {

        List<ItemStack> inputs = new ArrayList<>();
        ItemStack baseItem = new ItemStack(Items.AIR);
        int matched = 0;

        for (int i = 0; i < pInv.getContainerSize(); i++) {
            ItemStack stack = pInv.getItem(i);


            if (!stack.isEmpty()) {
                if (stack.getItem() == this.getBaseItem().getItem()) {

                    baseItem = stack;
                    continue;
                }
                inputs.add(stack);
                matched++;
            }
        }

        if (baseItem.getItem() == getBaseItem().getItem()) {

            return matched == inputs.size() && RecipeMatcher.findMatches(inputs, this.recipeItems) != null;
        }

        return false;
    }

//    private boolean matches(SimpleContainer pCraftingInventory) {
//        
//              Ingredient ingredient = Ingredient.EMPTY;
//              ingredient = this.recipeItems.get(6);
//                 
//              if (!ingredient.test(pCraftingInventory.getItem(6))) {
//            	  System.out.println("yes");
//                 return false;
//              }
//              System.out.println("no");
//        return true;
//     }


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
        return output.copy();
    }

    public ItemStack getBaseItem() {
        return base;
    }

    public ItemStack getIcon() {
        return new ItemStack(BlockInit.INFUSION_TABLE.get());
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeInit.INFUSING.get();
    }

    public static class Serializer<T extends InfusingRecipe> implements RecipeSerializer<InfusingRecipe> {
        final InfusingRecipe.Serializer.IRecipeFactory<T> factory;

        public Serializer(InfusingRecipe.Serializer.IRecipeFactory<T> factory) {
            this.factory = factory;
        }

        @Override
        public InfusingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "output"));
            //int infusingTime = JSONUtils.getAsInt(pJson, "time");

            ItemStack base = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "base"));


            JsonArray ingredients = GsonHelper.getAsJsonArray(pJson, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(ingredients.size(), Ingredient.EMPTY);

            for (int i = 0; i < ingredients.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return this.factory.create(pRecipeId, output, base, inputs);
        }

        @Nullable
        @Override
        public InfusingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            int size = pBuffer.readInt();

            NonNullList<Ingredient> inputs = NonNullList.withSize(size, Ingredient.EMPTY);

            for (int i = 0; i < size; i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }

            ItemStack base = pBuffer.readItem();
            ItemStack output = pBuffer.readItem();

            return this.factory.create(pRecipeId, output, base, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, InfusingRecipe pRecipe) {
            pBuffer.writeInt(pRecipe.getIngredients().size());
            for (Ingredient ing : pRecipe.getIngredients()) {
                ing.toNetwork(pBuffer);
            }

            pBuffer.writeItemStack(pRecipe.base, false);
            pBuffer.writeItemStack(pRecipe.output, false);

        }

        public interface IRecipeFactory<T extends InfusingRecipe> {
            T create(ResourceLocation id, ItemStack output, ItemStack base, NonNullList<Ingredient> recipeItems);
        }
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }


}

