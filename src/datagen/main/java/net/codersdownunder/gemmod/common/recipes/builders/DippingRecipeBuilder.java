package net.codersdownunder.gemmod.common.recipes.builders;

import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.codersdownunder.gemmod.init.RecipeInit;
import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

public class DippingRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final int count;
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final int fluidAmount;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    @Nullable
    private String group;

    public DippingRecipeBuilder(ItemLike pResult, int fluidAmount, int pCount) {
        this.result = pResult.asItem();
        this.fluidAmount = fluidAmount;
        this.count = pCount;
    }

    /**
     * Creates a new builder for a shapeless recipe.
     */
    public static DippingRecipeBuilder dipping(ItemLike pResult, int fluidAmount) {
        return new DippingRecipeBuilder(pResult, fluidAmount, 1);
    }

    /**
     * Creates a new builder for a shapeless recipe.
     */
    public static DippingRecipeBuilder dipping(ItemLike pResult, int pCount, int fluidAmount) {
        return new DippingRecipeBuilder(pResult, pCount, fluidAmount);
    }

    /**
     * Adds an ingredient that can be any item in the given tag.
     */
    public DippingRecipeBuilder dipping(TagKey<Item> pTag, int fluidAmount) {
        return this.requires(Ingredient.of(pTag), fluidAmount);
    }

    /**
     * Adds an ingredient of the given item.
     */
    public DippingRecipeBuilder requires(ItemLike pItem) {
        return this.requires(pItem, 1);
    }

    /**
     * Adds the given ingredient multiple times.
     */
    public DippingRecipeBuilder requires(ItemLike pItem, int pQuantity) {
        for (int i = 0; i < pQuantity; ++i) {
            this.requires(Ingredient.of(pItem));
        }

        return this;
    }

    public DippingRecipeBuilder requires(TagKey<Item> pTag) {
        return this.requires(Ingredient.of(pTag));
    }

    /**
     * Adds an ingredient.
     */
    public DippingRecipeBuilder requires(Ingredient pIngredient) {
        return this.requires(pIngredient, 1);
    }

    /**
     * Adds an ingredient multiple times.
     */
    public DippingRecipeBuilder requires(Ingredient pIngredient, int pQuantity) {
        for (int i = 0; i < pQuantity; ++i) {
            this.ingredients.add(pIngredient);
        }

        return this;
    }

    public DippingRecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    public Item getResult() {
        return this.result;
    }

    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        pFinishedRecipeConsumer.accept(new DippingRecipeBuilder.Result(pRecipeId, this.result, this.count, this.fluidAmount, this.group == null ? "" : this.group, this.ingredients, this.advancement, new ResourceLocation(pRecipeId.getNamespace(), "recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + pRecipeId.getPath())));
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item result;
        private final int count;
        private final int fluidAmount;
        private final String group;
        private final List<Ingredient> ingredients;

        public Result(ResourceLocation pId, Item pResult, int pCount, int fluidAmount, String pGroup, List<Ingredient> pIngredients, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId) {
            this.id = pId;
            this.result = pResult;
            this.count = pCount;
            this.group = pGroup;
            this.ingredients = pIngredients;
            this.fluidAmount = fluidAmount;
        }

        @SuppressWarnings("deprecation")
        public void serializeRecipeData(JsonObject pJson) {
            if (!this.group.isEmpty()) {
                pJson.addProperty("group", this.group);
            }

            JsonArray jsonarray = new JsonArray();

            if (!(ingredients.size() <= 14) && !(ingredients.size() >= 16)) {
                // Ingredients
                for (Ingredient ingredient : this.ingredients) {
                    jsonarray.add(ingredient.toJson());
                }
                pJson.add("ingredients", jsonarray);

                // Fluid input
                JsonObject fluid = new JsonObject();
                fluid.addProperty("tag", GeomancyTags.Fluids.DIPPING_FLUIDS.location().toString());
                fluid.addProperty("amount", this.fluidAmount);
                pJson.add("fluid", fluid);

                // Output
                JsonObject jsonobject = new JsonObject();
                jsonobject.addProperty("item", Registry.ITEM.getKey(this.result).toString());
                if (this.count > 1) {
                    jsonobject.addProperty("count", this.count);
                }

                pJson.add("output", jsonobject);
            } else {
                if (ingredients.size() <= 14) {
                    throw new IndexOutOfBoundsException("not enough items for dipping recipe: " + ingredients.size() + " should be 14");
                } else if (ingredients.size() >= 16) {
                    throw new IndexOutOfBoundsException("to many items for dipping recipe: " + ingredients.size() + " should be 14");
                }
            }
        }

        public RecipeSerializer<?> getType() {
            return RecipeInit.DIPPING.get();
        }

        /**
         * Gets the ID for the recipe.
         */
        public ResourceLocation getId() {
            return this.id;
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            // TODO Auto-generated method stub
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            // TODO Auto-generated method stub
            return null;
        }

    }

    @Deprecated
    @Override
    public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        // TODO Auto-generated method stub
        return this;
    }
}