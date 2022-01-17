package net.codersdownunder.gemmod.compat.jei;

import java.util.ArrayList;
import java.util.Collection;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiFluidStackGroup;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.crafting.recipe.dipping.DippingRecipe;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

public class DipperRecipeCategory implements IRecipeCategory<DippingRecipe>
{
    public static final ResourceLocation ID = new ResourceLocation(GemMod.MODID, ".dipping_recipe_category");
    public static final ResourceLocation GUI = new ResourceLocation(GemMod.MODID, "textures/gui/dipper.png");
    private final IDrawable back;
    private final IDrawable icon;
    
    public DipperRecipeCategory(IGuiHelper helper) {
        this.back = helper.drawableBuilder(GUI, 0, 0, 180, 130).trim(10, 0, 30, 10).build();
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(BlockInit.DIPPER.get()));
        
    }

    @Override
    public ResourceLocation getUid() {
        return ID;
    }

    @Override
    public Class<? extends DippingRecipe> getRecipeClass() {
        return DippingRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TranslatableComponent("category." + GemMod.MODID + ".dipping_recipe");
    }

    @Override
    public IDrawable getBackground() {
        return back;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setIngredients(DippingRecipe recipe, IIngredients ingredients) {
    	
        ingredients.setInputIngredients(recipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
    }
    
    @Override
    public void setRecipe(IRecipeLayout recipeLayout, DippingRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup itemStackGroup = recipeLayout.getItemStacks();
        IGuiFluidStackGroup fluidStackGroup = recipeLayout.getFluidStacks();

        itemStackGroup.init(15, true, 49, 7);
        itemStackGroup.init(16, true, 49, 25);
        itemStackGroup.init(0, true, 49, 43);
        itemStackGroup.init(17, true, 49, 61);
        itemStackGroup.init(13, true, 49, 79);
        itemStackGroup.init(8, true, 49, 97);
        itemStackGroup.init(7, true, 31, 25);
        itemStackGroup.init(6, true, 31, 43);
        itemStackGroup.init(1, true, 31, 61);
        itemStackGroup.init(10, true, 13, 43);
      	itemStackGroup.init(5, true, 13, 61);
      	itemStackGroup.init(2, true, 13, 79);
      	itemStackGroup.init(3, true, 67, 25);
    	itemStackGroup.init(4, true, 67, 43);
    	itemStackGroup.init(9, true, 67, 61);
    	itemStackGroup.init(12, true, 85, 43);
    	itemStackGroup.init(11, true, 85, 61);
    	itemStackGroup.init(14, true, 85, 79);
        itemStackGroup.init(18, false, 121, 43);
        fluidStackGroup.init(19, false, 122, 98);
        
        //itemStackGroup.setBackground(23, bac);
        itemStackGroup.set(15, getString());
        itemStackGroup.set(16, getString());
        itemStackGroup.set(17, getString());
        itemStackGroup.set(ingredients);
        fluidStackGroup.set(19, AcceptedFluids.getAcceptedFluids());
    }

    
    private static ArrayList<ItemStack> getString() {
    	ArrayList<ItemStack> stack = new ArrayList<ItemStack>();
    	
    	for (int i = 0; i < GeomancyTags.Items.STRING.getValues().size(); i++) {
			stack.add(new ItemStack(GeomancyTags.Items.STRING.getValues().get(i)));
		}
    	
    	return stack;
    }

    private static abstract class AcceptedFluids {

        private static final ArrayList<FluidStack> acceptedFluids = new ArrayList<>();

        public static ArrayList < FluidStack > getAcceptedFluids() {

            acceptedFluids.clear();
            Collection<Fluid> fluidList = ForgeRegistries.FLUIDS.getValues();

            for (Fluid fluid : fluidList) {
                if (GeomancyTags.Fluids.DIPPING_FLUIDS.getValues().contains(fluid) && fluid.isSource(fluid.defaultFluidState()))
                    acceptedFluids.add(new FluidStack(fluid, 700));
            }
            return acceptedFluids;
        }
    }
}
