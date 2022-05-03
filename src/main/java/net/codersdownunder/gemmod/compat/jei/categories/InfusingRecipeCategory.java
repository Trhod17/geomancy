package net.codersdownunder.gemmod.compat.jei.categories;

import com.mojang.datafixers.util.Pair;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.crafting.recipe.infusing.InfusingRecipe;
import net.codersdownunder.gemmod.init.BlockInit;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class InfusingRecipeCategory implements IRecipeCategory<InfusingRecipe>
{
    public static final RecipeType<InfusingRecipe> INFUSION = RecipeType.create(GemMod.MODID, "infusion_recipe", InfusingRecipe.class);
    public static final ResourceLocation ID = new ResourceLocation(GemMod.MODID, "infusion_recipe");
    public static final ResourceLocation GUI = new ResourceLocation(GemMod.MODID, "textures/gui/infusion_recipe.png");
    private final IDrawable back;
    private final IDrawable icon;
    
    public InfusingRecipeCategory(IGuiHelper helper) {
        this.back = helper.drawableBuilder(GUI, 0, 0, 200, 120).trim(10, 10, 5, 27).build();
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(BlockInit.INFUSION_TABLE.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return ID;
    }

    @Override
    public Class<? extends InfusingRecipe> getRecipeClass() {
        return InfusingRecipe.class;
    }

    @Override
    public RecipeType<InfusingRecipe> getRecipeType() {
        return INFUSION;
    }

    @Override
    public Component getTitle() {
        return new TranslatableComponent("category." + GemMod.MODID + ".infusing_recipe");
    }

    @Override
    public IDrawable getBackground() {
        return back;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @SuppressWarnings("serial")
	@Override
    public void setRecipe(IRecipeLayoutBuilder builder, InfusingRecipe recipe, IFocusGroup focuses) {
        List<Pair<Integer, Integer>> ingredientPositions = new ArrayList<>() {{
            add(Pair.of(12, 35));
            add(Pair.of(39, 53));
            add(Pair.of(111, 53));
            add(Pair.of(138, 35));
            add(Pair.of(39, 17));
            add(Pair.of(111, 17));
            add(Pair.of(75, 35));
        }};

        NonNullList<Ingredient> ingredients = recipe.getIngredients();
        int ingredientSize = ingredients.size();
        IntStream.range(0, ingredientSize).forEach(value -> {
            builder.addSlot(RecipeIngredientRole.INPUT, ingredientPositions.get(value).getFirst(), ingredientPositions.get(value).getSecond())
                    .addIngredients(ingredients.get(value))
                    .setSlotName("ingredient" + value);
        });

        builder.addSlot(RecipeIngredientRole.INPUT, 80, 40)
                .addIngredient(VanillaTypes.ITEM, recipe.getBaseItem())
                .setSlotName("base");

        builder.addSlot(RecipeIngredientRole.OUTPUT, 75, 80)
                .addIngredient(VanillaTypes.ITEM, recipe.getResultItem())
                .setSlotName("result");
    }
}
