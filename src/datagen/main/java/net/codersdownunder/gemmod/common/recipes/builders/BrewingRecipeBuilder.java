package net.codersdownunder.gemmod.common.recipes.builders;
//package net.codersdownunder.gemmod.common.recipes;
//
//import com.google.common.collect.Lists;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import com.mojang.serialization.DynamicOps;
//import com.mojang.serialization.JsonOps;
//import net.minecraft.advancements.Advancement;
//import net.minecraft.advancements.AdvancementRewards;
//import net.minecraft.data.recipes.FinishedRecipe;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.tags.Tag;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.world.level.ItemLike;
//import net.minecraftforge.items.IItemHandler;
//import net.minecraftforge.items.IItemHandlerModifiable;
//import net.minecraftforge.registries.ForgeRegistries;
//
//import javax.annotation.Nullable;
//import java.util.List;
//import java.util.function.Consumer;
//
//public class BrewingRecipeBuilder {
//	
//    private final ItemStack result;
//    private final List<Ingredient> ingredients = Lists.newArrayList();
//    private final Advancement.Builder advancement = Advancement.Builder.advancement();
//    private String group;
//
//    private BrewingRecipeBuilder(ItemStack result) {
//        this.result = result;
//    }
//
//    /**
//     * Creates a new builder for a shapeless recipe.
//     */
//    public static BrewingRecipeBuilder shapeless(ItemLike provider) {
//        return new BrewingRecipeBuilder(new ItemStack(provider));
//    }
//
//    /**
//     * Creates a new builder for a shapeless recipe.
//     */
//    public static BrewingRecipeBuilder shapeless(ItemLike result, int count) {
//        return new BrewingRecipeBuilder(new ItemStack(result, count));
//    }
//
//    /**
//     * Creates a new builder for a shapeless recipe.
//     */
//    public static BrewingRecipeBuilder shapeless(ItemStack result) {
//        return new BrewingRecipeBuilder(result);
//    }
//
//    /**
//     * Adds an ingredient that can be any item in the given tag.
//     */
//    public BrewingRecipeBuilder requires(Tag<Item> tag) {
//        return this.requires(Ingredient.of(tag));
//    }
//
//    /**
//     * Adds an ingredient of the given item.
//     */
//    public BrewingRecipeBuilder requires(ItemLike item) {
//        return this.requires(item, 1);
//    }
//
//    /**
//     * Adds the given ingredient multiple times.
//     */
//    public BrewingRecipeBuilder requires(ItemLike item, int quantity) {
//        for (int i = 0; i < quantity; ++i) {
//            this.requires(Ingredient.of(item));
//        }
//
//        return this;
//    }
//
//    /**
//     * Adds an ingredient.
//     */
//    public BrewingRecipeBuilder requires(Ingredient ingredient) {
//        return this.requires(ingredient, 1);
//    }
//
//    /**
//     * Adds an ingredient multiple times.
//     */
//    public BrewingRecipeBuilder requires(Ingredient ingredient, int quantity) {
//        for (int i = 0; i < quantity; ++i) {
//            this.ingredients.add(ingredient);
//        }
//
//        return this;
//    }
//
//    public BrewingRecipeBuilder group(String group) {
//        this.group = group;
//        return this;
//    }
//
//    /**
//     * Builds this recipe into an {@link IFinishedRecipe}.
//     */
//    public void save(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
//        this.ensureValid(id);
//        consumerIn.accept(new Result(id, this.result, this.group == null ? "" : this.group, this.ingredients, this.advancement, new ResourceLocation(id.getNamespace(),
//                "recipes/" + this.result.getItem().getItemCategory().getRecipeFolderName() + "/" + id.getPath())));
//    }
//
//    /**
//     * Makes sure that this recipe is valid and obtainable.
//     */
//    private void ensureValid(ResourceLocation id) {
//        if (this.advancement.getCriteria().isEmpty()) {
//            throw new IllegalStateException("No way of obtaining recipe " + id);
//        }
//    }
//
//    public static class Result implements FinishedRecipe {
//        private final ResourceLocation id;
//        private final ItemStack result;
//        private final String group;
//        private final List<Ingredient> ingredients;
//        private final Advancement.Builder advancement;
//        private final ResourceLocation advancementId;
//
//        public Result(ResourceLocation id, ItemStack result, String group, List<Ingredient> ingredients, Advancement.Builder advancementBuilder, ResourceLocation advancementId) {
//            this.id = id;
//            this.result = result;
//            this.group = group;
//            this.ingredients = ingredients;
//            this.advancement = advancementBuilder;
//            this.advancementId = advancementId;
//        }
//
//        public void serializeRecipeData(JsonObject json) {
//            if (!this.group.isEmpty()) {
//                json.addProperty("group", this.group);
//            }
//
//            JsonArray ingredientsJson = new JsonArray();
//
//            for (Ingredient ingredient : this.ingredients) {
//                ingredientsJson.add(ingredient.toJson());
//            }
//
//            json.add("ingredients", ingredientsJson);
//            JsonObject resultJson = new JsonObject();
//            resultJson.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result.getItem()).toString());
//            if (this.result.getCount() > 1) {
//                resultJson.addProperty("count", this.result.getCount());
//            }
//            if (this.result.hasTag()) {
//                resultJson.addProperty("nbt", DynamicOps.INSTANCE.convertTo(JsonOps.INSTANCE, this.result.getTag()).toString());
//            }
//
//            json.add("result", resultJson);
//        }
//
//        public IRecipeSerializer<?> getType() {
//            return IRecipeSerializer.SHAPELESS_RECIPE;
//        }
//
//        /**
//         * Gets the ID for the recipe.
//         */
//        public ResourceLocation getId() {
//            return this.id;
//        }
//
//        /**
//         * Gets the JSON for the advancement that unlocks this recipe. Null if there is no advancement.
//         */
//        @Nullable
//        public JsonObject serializeAdvancement() {
//            return this.advancement.serializeToJson();
//        }
//
//        /**
//         * Gets the ID for the advancement associated with this recipe. Should not be null if {@link #serializeAdvancement()} is non-null.
//         */
//        @Nullable
//        public ResourceLocation getAdvancementId() {
//            return this.advancementId;
//        }
//    }
//}
//
//
////
////	      @SuppressWarnings("deprecation")
////		public void serializeRecipeData(JsonObject pJson) {
////	         if (!this.group.isEmpty()) {
////	            pJson.addProperty("group", this.group);
////	         }
////
////	         JsonArray jsonarray = new JsonArray();
////
////	         if (!(ingredients.isEmpty()) && !(ingredients.size() >= 2)) {
////	         for(Ingredient ingredient : this.ingredients) {
////	            jsonarray.add(ingredient.toJson());
////	         }
////	         
////
////	         pJson.add("ingredients", jsonarray);
////	         JsonObject jsonobject = new JsonObject();
////	         jsonobject.addProperty("item", Registry.ITEM.getKey(this.result).toString());
////	         if (this.count > 1) {
////	            jsonobject.addProperty("count", this.count);
////	         }
////
////	         pJson.add("output", jsonobject);
////	         }
////	      }
//=