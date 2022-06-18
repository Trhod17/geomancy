package net.codersdownunder.gemmod.init;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.crafting.recipe.BrewingRecipe;
import net.codersdownunder.gemmod.crafting.recipe.DippingRecipe;
import net.codersdownunder.gemmod.crafting.recipe.InfusingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = GemMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RecipeInit {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, GemMod.MODID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registry.RECIPE_TYPE_REGISTRY, GemMod.MODID);

    public static final RegistryObject<RecipeSerializer<?>> BREWING = RECIPE_SERIALIZERS.register("brewing", () -> new BrewingRecipe.Serializer<>(BrewingRecipe::new));
    public static final RegistryObject<RecipeSerializer<?>> DIPPING = RECIPE_SERIALIZERS.register("dipping", () -> new DippingRecipe.Serializer<>(DippingRecipe::new));
    public static final RegistryObject<RecipeSerializer<?>> INFUSING = RECIPE_SERIALIZERS.register("infusing", () -> new InfusingRecipe.Serializer<>(InfusingRecipe::new));

    public static RegistryObject<RecipeType<BrewingRecipe>> BREWING_TYPE = registerRecipeType("brewing");
    public static RegistryObject<RecipeType<DippingRecipe>> DIPPING_TYPE = registerRecipeType("dipping");
    public static RegistryObject<RecipeType<InfusingRecipe>> INFUSING_TYPE = registerRecipeType("infusing");

    static <T extends Recipe<SimpleContainer>> RegistryObject<RecipeType<T>> registerRecipeType(final String name) {
        return RECIPE_TYPES.register(name, () -> new RecipeType<T>() {
            public String toString() {
                return GemMod.MODID + ":" + name;
            }
        });
    }
}
