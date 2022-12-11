//package net.codersdownunder.gemmod.compat.jei.categories;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.IntStream;
//
//import com.mojang.datafixers.util.Pair;
//
//import mezz.jei.api.constants.VanillaTypes;
//import mezz.jei.api.forge.ForgeTypes;
//import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
//import mezz.jei.api.gui.drawable.IDrawable;
//import mezz.jei.api.helpers.IGuiHelper;
//import mezz.jei.api.recipe.IFocusGroup;
//import mezz.jei.api.recipe.RecipeIngredientRole;
//import mezz.jei.api.recipe.RecipeType;
//import mezz.jei.api.recipe.category.IRecipeCategory;
//import net.codersdownunder.gemmod.Geomancy;
//import net.codersdownunder.gemmod.blocks.dipper.DipperBlockEntity;
//import net.codersdownunder.gemmod.crafting.recipe.DippingRecipe;
//import net.codersdownunder.gemmod.init.BlockInit;
//import net.codersdownunder.gemmod.utils.GeomancyTags;
//import net.codersdownunder.gemmod.utils.TagUtils;
//import net.minecraft.core.NonNullList;
//import net.minecraft.network.chat.Component;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.Ingredient;
//
//public class DippingRecipeCategory implements IRecipeCategory<DippingRecipe> {
//    public static final RecipeType<DippingRecipe> DIPPING = RecipeType.create(Geomancy.MODID, "dipping_recipe", DippingRecipe.class);
//    public static final ResourceLocation ID = new ResourceLocation(Geomancy.MODID, "dipping_recipe");
//    public static final ResourceLocation GUI = new ResourceLocation(Geomancy.MODID, "textures/gui/dipper.png");
//    private final IDrawable back;
//    private final IDrawable icon;
//
//    public DippingRecipeCategory(IGuiHelper helper) {
//        this.back = helper.drawableBuilder(GUI, 0, 0, 180, 130).trim(10, 0, 30, 10).build();
//        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockInit.DIPPER.get()));
//    }
//
//    @Override
//    public RecipeType<DippingRecipe> getRecipeType() {
//        return DIPPING;
//    }
//
//    @Override
//    public Component getTitle() {
//        return Component.translatable("category." + Geomancy.MODID + ".dipping_recipe");
//    }
//
//    @Override
//    public IDrawable getBackground() {
//        return back;
//    }
//
//    @Override
//    public IDrawable getIcon() {
//        return icon;
//    }
//
//    @SuppressWarnings("serial")
//	@Override
//    public void setRecipe(IRecipeLayoutBuilder builder, DippingRecipe recipe, IFocusGroup focuses) {
//        List<Pair<Integer, Integer>> ingredientPositions = new ArrayList<>() {{
//            add(Pair.of(50, 44));
//            add(Pair.of(32, 62));
//            add(Pair.of(14, 80));
//            add(Pair.of(68, 26));
//            add(Pair.of(68, 44));
//            add(Pair.of(14, 62));
//            add(Pair.of(32, 44));
//            add(Pair.of(32, 26));
//            add(Pair.of(50, 98));
//            add(Pair.of(68, 62));
//            add(Pair.of(14, 44));
//            add(Pair.of(86, 62));
//            add(Pair.of(86, 44));
//            add(Pair.of(50, 80));
//            add(Pair.of(86, 80));
//            add(Pair.of(50, 8));
//            add(Pair.of(50, 26));
//            add(Pair.of(50, 62));
//        }};
//
//        NonNullList<Ingredient> ingredients = recipe.getIngredients();
//        int ingredientSize = ingredients.size();
//        IntStream.range(0, 15).forEach(value -> {
//            if (ingredientSize >= value) {
//                builder.addSlot(RecipeIngredientRole.INPUT, ingredientPositions.get(value).getFirst(), ingredientPositions.get(value).getSecond())
//                        .addIngredients(ingredients.get(value))
//                        .setSlotName("ingredient" + value);
//            }
//        });
//
//        ArrayList<ItemStack> strings = getStringStacks();
//        builder.addSlot(RecipeIngredientRole.INPUT, ingredientPositions.get(15).getFirst(), ingredientPositions.get(15).getSecond())
//                .addIngredients(VanillaTypes.ITEM_STACK, strings)
//                .setSlotName("string1");
//        builder.addSlot(RecipeIngredientRole.INPUT, ingredientPositions.get(16).getFirst(), ingredientPositions.get(16).getSecond())
//                .addIngredients(VanillaTypes.ITEM_STACK, strings)
//                .setSlotName("string2");
//        builder.addSlot(RecipeIngredientRole.INPUT, ingredientPositions.get(17).getFirst(), ingredientPositions.get(17).getSecond())
//                .addIngredients(VanillaTypes.ITEM_STACK, strings)
//                .setSlotName("string3");
//
//        builder.addSlot(RecipeIngredientRole.INPUT, 122, 71)
//                .addIngredients(ForgeTypes.FLUID_STACK, recipe.getFluids())
//                .setFluidRenderer(DipperBlockEntity.capacity, true, 16, 43)
//                .setSlotName("fluid");
//
//        builder.addSlot(RecipeIngredientRole.OUTPUT, 122, 44)
//                .addIngredient(VanillaTypes.ITEM_STACK, recipe.getResultItem())
//                .setSlotName("result");
//    }
//
//    private static ArrayList<ItemStack> getStringStacks() {
//        ArrayList<ItemStack> stack = new ArrayList<>();
//
//        TagUtils.getValues(GeomancyTags.Items.STRING).forEach(item -> {
//            stack.add(new ItemStack(item));
//        });
//
//        return stack;
//    }
//
////    private static abstract class AcceptedFluids {
////
////        private static final ArrayList<FluidStack> acceptedFluids = new ArrayList<>();
////
////        public static ArrayList<FluidStack> getAcceptedFluids(DippingRecipe recipe) {
////            acceptedFluids.clear();
////            Collection<Fluid> fluidList = ForgeRegistries.FLUIDS.getValues();
////
////            List<Fluid> drippingFluids = TagUtils.getValuesFluid(GeomancyTags.Fluids.DIPPING_FLUIDS);
////            for (Fluid fluid : fluidList) {
////                if (drippingFluids.contains(fluid) && fluid.isSource(fluid.defaultFluidState())) {
////                    acceptedFluids.add(new FluidStack(fluid, recipe.getFluidAmount()));
////                }
////            }
////            return acceptedFluids;
////        }
////    }
//}
