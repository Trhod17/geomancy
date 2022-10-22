package net.codersdownunder.gemmod.crafting.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Pair;
import net.codersdownunder.gemmod.blocks.dipper.DipperBlockEntity;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.RecipeInit;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.util.RecipeMatcher;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DippingRecipe implements Recipe<SimpleContainer>
{
    private List<FluidStack> acceptedFluids = new ArrayList<>();
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;
    private final Pair<String, Integer> fluid;

    public DippingRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems, Pair<String, Integer> fluid) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.fluid = fluid;
    }
  
    @Override
    public RecipeType<?> getType()
    {
        return RecipeInit.DIPPING_TYPE.get();
    }
    
    @Override
    public boolean matches(SimpleContainer pInv, Level pLevel) {
        List<ItemStack> inputs = new ArrayList<>();

        for (int i = 0; i <= pInv.getContainerSize(); i++) {
            ItemStack stack = pInv.getItem(i);
            if (!stack.isEmpty()) {
                inputs.add(stack);
            }
        }

        return this.recipeItems.size() == inputs.size() && RecipeMatcher.findMatches(inputs, this.recipeItems) != null;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    public int getFluidAmount() {
        return fluid.getSecond();
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
        return new ItemStack(BlockInit.DIPPER.get());
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeInit.DIPPING.get();
    }

    public List<FluidStack> getFluids() {
        if (acceptedFluids.isEmpty()) {
            // Try loading from fluid registry
            List<Fluid> fluids = Collections.singletonList(ForgeRegistries.FLUIDS.getValue(new ResourceLocation(this.fluid.getFirst())));

            if (fluids.get(0).equals(Fluids.EMPTY)) {
                // Try loading fluid from fluid tag
                try {
                    @SuppressWarnings("deprecation")
					HolderSet.Named<Fluid> fluidTag = Registry.FLUID.getOrCreateTag(TagKey.create(Registry.FLUID_REGISTRY, new ResourceLocation(this.fluid.getFirst())));
                    if (fluidTag.size() > 0) {
                        fluids = fluidTag.stream().map(Holder::value).toList();
                    }
                } catch (Exception e) {
                    // Who cares
                }
            }

            acceptedFluids = fluids.stream().map(f -> new FluidStack(f, this.fluid.getSecond())).toList();
        }
        return acceptedFluids;
    }

    public static class Serializer<T extends DippingRecipe> implements RecipeSerializer<DippingRecipe> {
        final DippingRecipe.Serializer.IRecipeFactory<T> factory;

        public Serializer(DippingRecipe.Serializer.IRecipeFactory<T> factory) {
            this.factory = factory;
        }

        @Override
        public DippingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson)
        {
            JsonArray ingredients = GsonHelper.getAsJsonArray(pJson, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(15, Ingredient.EMPTY);
            inputs.set(0, Ingredient.fromJson(ingredients.get(0)));
            inputs.set(1, Ingredient.fromJson(ingredients.get(1)));
            inputs.set(2, Ingredient.fromJson(ingredients.get(2)));
            inputs.set(3, Ingredient.fromJson(ingredients.get(3)));
            inputs.set(4, Ingredient.fromJson(ingredients.get(4)));
            inputs.set(5, Ingredient.fromJson(ingredients.get(5)));
            inputs.set(6, Ingredient.fromJson(ingredients.get(6)));
            inputs.set(7, Ingredient.fromJson(ingredients.get(7)));
            inputs.set(8, Ingredient.fromJson(ingredients.get(8)));
            inputs.set(9, Ingredient.fromJson(ingredients.get(9)));
            inputs.set(10, Ingredient.fromJson(ingredients.get(10)));
            inputs.set(11, Ingredient.fromJson(ingredients.get(11)));
            inputs.set(12, Ingredient.fromJson(ingredients.get(12)));
            inputs.set(13, Ingredient.fromJson(ingredients.get(13)));
            inputs.set(14, Ingredient.fromJson(ingredients.get(14)));

            Pair<String, Integer> fluidInput = null;
            if (pJson.has("fluid")) {
                JsonObject fluid = GsonHelper.getAsJsonObject(pJson, "fluid");
                int amount = Math.min(DipperBlockEntity.capacity, GsonHelper.getAsInt(fluid, "amount", 1000));

                String fluidResourceLocation = "";
                if (fluid.has("tag")) {
                    fluidResourceLocation = GsonHelper.getAsString(fluid, "tag");
                } else if (fluid.has("fluid")) {
                    fluidResourceLocation = GsonHelper.getAsString(fluid, "fluid");
                }

                fluidInput = Pair.of(fluidResourceLocation, amount);
            }

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "output"));

            return this.factory.create(pRecipeId, output, inputs, fluidInput);
        }

        @Nullable
        @Override
        public DippingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer)
        {
            NonNullList<Ingredient> inputs = NonNullList.withSize(15, Ingredient.EMPTY);

            pBuffer.readInt();
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }

            Pair<String, Integer> fluidInput = Pair.of(pBuffer.readUtf(), pBuffer.readInt());
            ItemStack output = pBuffer.readItem();

            return this.factory.create(pRecipeId, output, inputs, fluidInput);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, DippingRecipe pRecipe)
        {
            pBuffer.writeInt(pRecipe.getIngredients().size());
            for (Ingredient ing : pRecipe.getIngredients()) {
                ing.toNetwork(pBuffer);
            }
            pBuffer.writeUtf(pRecipe.fluid.getFirst());
            pBuffer.writeInt(pRecipe.fluid.getSecond());
            pBuffer.writeItemStack(pRecipe.output, false);
        }

        public interface IRecipeFactory<T extends DippingRecipe>
        {
            T create(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems, Pair<String, Integer> fluid);
        }
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight)
    {
        return true;
    }
}

