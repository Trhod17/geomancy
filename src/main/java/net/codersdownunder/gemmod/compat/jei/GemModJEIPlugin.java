package net.codersdownunder.gemmod.compat.jei;

import java.util.Collection;
import java.util.stream.Collectors;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.blocks.dipper.DipperMenu;
import net.codersdownunder.gemmod.blocks.infusion.InfusionTableContainer;
import net.codersdownunder.gemmod.crafting.recipe.ModRecipeTypes;
import net.codersdownunder.gemmod.init.BlockInit;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;

@JeiPlugin
public class GemModJEIPlugin implements IModPlugin
{
 

	private static final int PLAYER_INV_SIZE = 4 * 9;
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
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
    	registration.addRecipeCatalyst(new ItemStack(BlockInit.DIPPER.get()), DipperRecipeCategory.ID);
    	registration.addRecipeCatalyst(new ItemStack(BlockInit.INFUSION_TABLE.get()), InfusingRecipeCategory.ID);
    }
    
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper helper = registration.getJeiHelpers().getGuiHelper();
        
        registration.addRecipeCategories(new InfusingRecipeCategory(helper));
        registration.addRecipeCategories(new DipperRecipeCategory(helper));
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {

    	//registration.addRecipeTransferHandler(DipperMenu.class, DipperRecipeCategory.ID, 0, 18, 19, PLAYER_INV_SIZE);
    	registration.addRecipeTransferHandler(InfusionTableContainer.class, InfusingRecipeCategory.ID, 0, 6, 7, PLAYER_INV_SIZE);
    }
    
    private static Collection<?> getRecipes(RecipeManager manager, RecipeType<?> type) {
        return manager.getRecipes().parallelStream().filter(recipe -> recipe.getType() == type).collect(Collectors.toList());
    }

}
