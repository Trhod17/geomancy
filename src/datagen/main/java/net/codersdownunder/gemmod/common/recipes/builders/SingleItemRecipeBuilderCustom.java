package net.codersdownunder.gemmod.common.recipes.builders;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

public class SingleItemRecipeBuilderCustom implements RecipeBuilder {
   private final Item result;
   private final Ingredient ingredient;
   private final int count;
   @Nullable
   private String group;
   private final RecipeSerializer<?> type;

   public SingleItemRecipeBuilderCustom(RecipeSerializer<?> pType, Ingredient pIngredient, ItemLike pResult, int pCount) {
      this.type = pType;
      this.result = pResult.asItem();
      this.ingredient = pIngredient;
      this.count = pCount;
   }

   public static SingleItemRecipeBuilderCustom stonecutting(Ingredient pIngredient, ItemLike pResult) {
      return new SingleItemRecipeBuilderCustom(RecipeSerializer.STONECUTTER, pIngredient, pResult, 1);
   }

   public static SingleItemRecipeBuilderCustom stonecutting(Ingredient pIngredient, ItemLike pResult, int pCount) {
      return new SingleItemRecipeBuilderCustom(RecipeSerializer.STONECUTTER, pIngredient, pResult, pCount);
   }
   
   public SingleItemRecipeBuilderCustom group(@Nullable String pGroupName) {
      this.group = pGroupName;
      return this;
   }

   public Item getResult() {
      return this.result;
   }

   public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
      this.ensureValid(pRecipeId);
      pFinishedRecipeConsumer.accept(new SingleItemRecipeBuilderCustom.Result(pRecipeId, this.type, this.group == null ? "" : this.group, this.ingredient, this.result, this.count, new ResourceLocation(pRecipeId.getNamespace(), "recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + pRecipeId.getPath())));
   }

   private void ensureValid(ResourceLocation pId) {
//      if (this.advancement.getCriteria().isEmpty()) {
//         throw new IllegalStateException("No way of obtaining recipe " + pId);
//      }
   }

   public static class Result implements FinishedRecipe {
      private final ResourceLocation id;
      private final String group;
      private final Ingredient ingredient;
      private final Item result;
      private final int count;
      private final RecipeSerializer<?> type;

      public Result(ResourceLocation pId, RecipeSerializer<?> pType, String pGroup, Ingredient pIngredient, Item pResult, int pCount, ResourceLocation pAdvancementId) {
         this.id = pId;
         this.type = pType;
         this.group = pGroup;
         this.ingredient = pIngredient;
         this.result = pResult;
         this.count = pCount;
      
      }

      @SuppressWarnings("deprecation")
	public void serializeRecipeData(JsonObject pJson) {
         if (!this.group.isEmpty()) {
            pJson.addProperty("group", this.group);
         }

         pJson.add("ingredient", this.ingredient.toJson());
         pJson.addProperty("result", Registry.ITEM.getKey(this.result).toString());
         pJson.addProperty("count", this.count);
      }

      /**
       * Gets the ID for the recipe.
       */
      public ResourceLocation getId() {
         return this.id;
      }

      public RecipeSerializer<?> getType() {
         return this.type;
      }

      /**
       * Gets the JSON for the advancement that unlocks this recipe. Null if there is no advancement.
       */
      @Nullable
      public JsonObject serializeAdvancement() {
         return null;
      }

      /**
       * Gets the ID for the advancement associated with this recipe. Should not be null if {@link #getAdvancementJson}
       * is non-null.
       */
      @Nullable
      public ResourceLocation getAdvancementId() {
         return null;
      }
   }

@Override
public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
	return null;
}
}