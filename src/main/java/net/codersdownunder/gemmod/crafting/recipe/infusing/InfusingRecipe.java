package net.codersdownunder.gemmod.crafting.recipe.infusing;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.crafting.recipe.ModRecipeTypes;
import net.codersdownunder.gemmod.init.BlockInit;
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
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.RecipeMatcher;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class InfusingRecipe implements Recipe<SimpleContainer>
{

    public static final Serializer SERIALIZER = new Serializer();
    
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;


    public InfusingRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
       
        //System.out.print(id + " " + output + " " + recipeItems);
    }
  
    @Override
    public RecipeType<?> getType()
    {
        return ModRecipeTypes.INFUSING_RECIPE;
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

        return matched == inputs.size() && RecipeMatcher.findMatches(inputs, this.recipeItems) != null;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }
    
    @Override
    public ItemStack assemble(SimpleContainer pInv)
    {
        return this.output;
    }
    
    @Override
    public ItemStack getResultItem()
    {
        return output.copy();
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
        return SERIALIZER;
    }

    public static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>>
            implements RecipeSerializer<InfusingRecipe> {

        Serializer() {
            this.setRegistryName(GemMod.MODID, "infusing_recipe");
        }
        
         @Override
        public InfusingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson)
        {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "output"));
            //int infusingTime = JSONUtils.getAsInt(pJson, "time");

            JsonArray ingredients = GsonHelper.getAsJsonArray(pJson, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(6, Ingredient.EMPTY);
            
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new InfusingRecipe(pRecipeId, output, inputs);
        }

        @Nullable
        @Override
        public InfusingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer)
        {
            NonNullList<Ingredient> inputs = NonNullList.withSize(6, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }

            ItemStack output = pBuffer.readItem();
            
            return new InfusingRecipe(pRecipeId, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, InfusingRecipe pRecipe)
        {
            pBuffer.writeInt(pRecipe.getIngredients().size());
            for (Ingredient ing : pRecipe.getIngredients()) {
                ing.toNetwork(pBuffer);
            }
            
            pBuffer.writeItemStack(pRecipe.output, false);

        }
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight)
    {
        return true;
    }

  
   
}

