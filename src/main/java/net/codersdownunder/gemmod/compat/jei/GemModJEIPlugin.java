package net.codersdownunder.gemmod.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.compat.jei.categories.DippingRecipeCategory;
import net.codersdownunder.gemmod.compat.jei.categories.InfusingRecipeCategory;
import net.codersdownunder.gemmod.compat.jei.categories.SongForgeRecipeCategory;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.RecipeInit;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;

@JeiPlugin
public class GemModJEIPlugin implements IModPlugin {
	//TODO: remove this if not needed
    @SuppressWarnings("unused")
	private static final int PLAYER_INV_SIZE = 4 * 9;
    private static final ResourceLocation PLUGIN_ID = new ResourceLocation(GemMod.MODID, "jei_plugin");

    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_ID;
    }

    @SuppressWarnings({ "resource" })
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager manager = Minecraft.getInstance().level.getRecipeManager();

        registration.addRecipes(InfusingRecipeCategory.INFUSION, manager.getAllRecipesFor(RecipeInit.INFUSING_TYPE.get()).stream().toList());
        registration.addRecipes(DippingRecipeCategory.DIPPING, manager.getAllRecipesFor(RecipeInit.DIPPING_TYPE.get()));
        registration.addRecipes(SongForgeRecipeCategory.SMELTING, manager.getAllRecipesFor(RecipeType.SMELTING));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(BlockInit.DIPPER.get()), DippingRecipeCategory.DIPPING);
        registration.addRecipeCatalyst(new ItemStack(BlockInit.INFUSION_TABLE.get()), InfusingRecipeCategory.INFUSION);
        registration.addRecipeCatalyst(new ItemStack(BlockInit.SONG_FORGE.get()), RecipeTypes.FUELING);
        registration.addRecipeCatalyst(new ItemStack(BlockInit.SONG_FORGE.get()), SongForgeRecipeCategory.SMELTING);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper helper = registration.getJeiHelpers().getGuiHelper();

        registration.addRecipeCategories(new InfusingRecipeCategory(helper));
        registration.addRecipeCategories(new DippingRecipeCategory(helper));
        registration.addRecipeCategories(new SongForgeRecipeCategory(helper));
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {

        //registration.addRecipeTransferHandler(DipperMenu.class, DipperRecipeCategory.ID, 0, 18, 19, PLAYER_INV_SIZE);
    	//registration.addRecipeTransferHandler(InfusionTableMenu.class, InfusingRecipeCategory.INFUSION, 0, 6, 7, PLAYER_INV_SIZE);
    	//registration.addRecipeTransferHandler(InfusionTableMenu.class, InfusingRecipeCategory.INFUSION, 0, 2, 19, PLAYER_INV_SIZE);
    }
}
