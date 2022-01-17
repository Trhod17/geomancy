package net.codersdownunder.gemmod.common.recipes.builders;

import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.codersdownunder.gemmod.crafting.recipe.infusing.InfusingRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

public class InfusionRecipeBuilder implements RecipeBuilder {
	   private final Item result;
	   private final int count;
	   private final List<Ingredient> ingredients = Lists.newArrayList();
	   private final Advancement.Builder advancement = Advancement.Builder.advancement();
	   @Nullable
	   private String group;

	   public InfusionRecipeBuilder(ItemLike pResult, int pCount) {
	      this.result = pResult.asItem();
	      this.count = pCount;
	   }

	   /**
	    * Creates a new builder for a shapeless recipe.
	    */
	   public static InfusionRecipeBuilder infusing(ItemLike pResult) {
	      return new InfusionRecipeBuilder(pResult, 1);
	   }

	   /**
	    * Creates a new builder for a shapeless recipe.
	    */
	   public static InfusionRecipeBuilder infusing(ItemLike pResult, int pCount) {
	      return new InfusionRecipeBuilder(pResult, pCount);
	   }

	   /**
	    * Adds an ingredient that can be any item in the given tag.
	    */
	   public InfusionRecipeBuilder infusing(Tag<Item> pTag) {
	      return this.requires(Ingredient.of(pTag));
	   }

	   /**
	    * Adds an ingredient of the given item.
	    */
	   public InfusionRecipeBuilder requires(ItemLike pItem) {
	      return this.requires(pItem, 1);
	   }

	   /**
	    * Adds the given ingredient multiple times.
	    */
	   public InfusionRecipeBuilder requires(ItemLike pItem, int pQuantity) {
	      for(int i = 0; i < pQuantity; ++i) {
	         this.requires(Ingredient.of(pItem));
	      }

	      return this;
	   }

	   /**
	    * Adds an ingredient.
	    */
	   public InfusionRecipeBuilder requires(Ingredient pIngredient) {
	      return this.requires(pIngredient, 1);
	   }

	   /**
	    * Adds an ingredient multiple times.
	    */
	   public InfusionRecipeBuilder requires(Ingredient pIngredient, int pQuantity) {
	      for(int i = 0; i < pQuantity; ++i) {
	         this.ingredients.add(pIngredient);
	      }

	      return this;
	   }

	   public InfusionRecipeBuilder group(@Nullable String pGroupName) {
	      this.group = pGroupName;
	      return this;
	   }

	   public Item getResult() {
	      return this.result;
	   }

	   public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
	      pFinishedRecipeConsumer.accept(new InfusionRecipeBuilder.Result(pRecipeId, this.result, this.count, this.group == null ? "" : this.group, this.ingredients, this.advancement, new ResourceLocation(pRecipeId.getNamespace(), "recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + pRecipeId.getPath())));
	   }

	   public static class Result implements FinishedRecipe {
	      private final ResourceLocation id;
	      private final Item result;
	      private final int count;
	      private final String group;
	      private final List<Ingredient> ingredients;

	      public Result(ResourceLocation pId, Item pResult, int pCount, String pGroup, List<Ingredient> pIngredients, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId) {
	         this.id = pId;
	         this.result = pResult;
	         this.count = pCount;
	         this.group = pGroup;
	         this.ingredients = pIngredients;

	      }

	      @SuppressWarnings("deprecation")
		public void serializeRecipeData(JsonObject pJson) {
	         if (!this.group.isEmpty()) {
	            pJson.addProperty("group", this.group);
	         }

	         JsonArray jsonarray = new JsonArray();

	         if (!(ingredients.size() < 6) && !(ingredients.size() >= 8)) {
	         for(Ingredient ingredient : this.ingredients) {
	            jsonarray.add(ingredient.toJson());
	         }
	         

	         pJson.add("ingredients", jsonarray);
	         JsonObject jsonobject = new JsonObject();
	         jsonobject.addProperty("item", Registry.ITEM.getKey(this.result).toString());
	         if (this.count > 1) {
	            jsonobject.addProperty("count", this.count);
	         }

	         pJson.add("output", jsonobject);
	         }
	      }

	      public RecipeSerializer<?> getType() {
	         return InfusingRecipe.SERIALIZER;
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