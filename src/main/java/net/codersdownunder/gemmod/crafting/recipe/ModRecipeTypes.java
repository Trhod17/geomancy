package net.codersdownunder.gemmod.crafting.recipe;

import net.codersdownunder.gemmod.crafting.recipe.brewing.BrewingRecipe;
import net.codersdownunder.gemmod.crafting.recipe.brewing.BrewingRecipeType;
import net.codersdownunder.gemmod.crafting.recipe.dipping.DippingRecipe;
import net.codersdownunder.gemmod.crafting.recipe.dipping.DippingRecipeType;
import net.codersdownunder.gemmod.crafting.recipe.infusing.InfusingRecipe;
import net.codersdownunder.gemmod.crafting.recipe.infusing.InfusingRecipeType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;

import java.util.Map;

public class ModRecipeTypes {

    public static final RecipeType<InfusingRecipe> INFUSING_RECIPE = new InfusingRecipeType();
    public static final RecipeType<DippingRecipe> DIPPING_RECIPE = new DippingRecipeType();
    public static final RecipeType<BrewingRecipe> BREWING_RECIPE = new BrewingRecipeType();

    public static void registerRecipes(DeferredRegister<RecipeSerializer<?>> event) {
        registerRecipe(event, INFUSING_RECIPE, InfusingRecipe.SERIALIZER);
        registerRecipe(event, DIPPING_RECIPE, DippingRecipe.SERIALIZER);
        registerRecipe(event, BREWING_RECIPE, BrewingRecipe.SERIALIZER);
    }

    private static void registerRecipe(DeferredRegister<RecipeSerializer<?>> event, RecipeType<?> type,
            RecipeSerializer<?> serializer) {
        Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(type.toString()), type);
        event.register((IEventBus) serializer);
    }

    public static Map<ResourceLocation, Recipe<?>> getRecipes(RecipeType<?> type, RecipeManager manager) {
        final Map<RecipeType<?>, Map<ResourceLocation, Recipe<?>>> recipes = ObfuscationReflectionHelper
                .getPrivateValue(RecipeManager.class, manager, "field_199522_d");
        return recipes.get(type);
    }
}