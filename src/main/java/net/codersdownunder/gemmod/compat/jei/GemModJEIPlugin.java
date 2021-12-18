package net.codersdownunder.gemmod.compat.jei;

import java.util.Collection;
import java.util.stream.Collectors;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.crafting.recipe.ModRecipeTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;

@JeiPlugin
public class GemModJEIPlugin implements IModPlugin
{
    
    private static final ResourceLocation PLUGIN_ID = new ResourceLocation(GemMod.MODID, "jei_plugin");

    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_ID;
    }
    
    @SuppressWarnings("resource")
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager manager = Minecraft.getInstance().level.getRecipeManager();
        
        registration.addRecipes(getRecipes(manager, ModRecipeTypes.INFUSING_RECIPE), InfusingRecipeCategory.ID);
        registration.addRecipes(getRecipes(manager, ModRecipeTypes.DIPPING_RECIPE), DipperRecipeCategory.ID);
    }
    
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper helper = registration.getJeiHelpers().getGuiHelper();
        
        registration.addRecipeCategories(new InfusingRecipeCategory(helper));
        registration.addRecipeCategories(new DipperRecipeCategory(helper));
    }
    
    private static Collection<?> getRecipes(RecipeManager manager, RecipeType<?> type) {
        return manager.getRecipes().parallelStream().filter(recipe -> recipe.getType() == type).collect(Collectors.toList());
    }

}
