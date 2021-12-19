package net.codersdownunder.gemmod.client;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class GeomanyLanguageProvider extends LanguageProvider {
    
    public GeomanyLanguageProvider(DataGenerator gen) {
        super(gen, GemMod.MODID, "en_us");
        System.out.println("********* IT HITS THIS **********");
    }
    
    private static String modid = GemMod.MODID;
    
    @Override
    protected void addTranslations() {
    	System.out.println("********* IT HITS THIS **********");
        addBlocks();
        addItems();
        addToolTips();
        addScreenText();
        addJEIText();
        addItemGroupText();
    }
    
    private void addScreenText() {
        add("screen." + modid + ".infusion_table.text", "Infusion Table");
        add("screen." + modid + ".infusion_table.button.text", "Infuse");
        add("screen." + modid + ".liquid_amount", "Stored: %smB / %smB");
        add("screen." + modid + ".liquid_percentage", "Filled: %s");
        add("screen." + modid + ".tank_empty", "Empty");
        
    }
    
    private void addJEIText() {
        add("category." + modid + ".infusing_recipe", "Infusing Recipes");
        add("category." + modid + ".dipping_recipes", "Dipping Recipes");
    }
    
    private void addToolTips() {
        add("tooltip.gem_agate.text", "A Dream of Endless Oceans");
        add("tooltip.gem_chrysocolla.text", "A Dream of Frigid Chills");
        add("tooltip.gem_malachite.text", "A Dream of Pure Chaos");
        add("tooltip.gem_jade.text", "A Dream of Untouched Nature");
        add("tooltip.gem_emerald.text", "A Dream of unargued Integrity");
        add("tooltip.gem_peridot.text", "A Dream of Balance and Order");
        add("tooltip.gem_topaz.text", "A Dream of Intense Rush");
        add("tooltip.gem_citrine.text", "A Dream of Physical Space");
        add("tooltip.gem_jasper.text", "A Dream of Glistening Embers");
        add("tooltip.gem_ruby.text", "A Dream of Sheer Power");
        add("tooltip.gem_garnet.text", "A Dream of Darkest Night");
        add("tooltip.gem_spinel.text", "A Dream of Unbound Life");
        add("tooltip.gem_amethyst.text", "A Dream of True Spirit");
        add("tooltip.gem_charoite.text", "A Dream of Impending Death");
        add("tooltip.gem_sapphire.text", "A Dream of Unparalleled Stability");
        add("tooltip.gem_lilystar.text", "A Dream of a Beautiful Sky");
        add("tooltip.gem_onyx.text", "A Dream of Pristine Ground");
        add("tooltip.gem_sphene.text", "A Dream of Blinding Light");
        add("tooltip.gem_rhodonite.text", "A Dream of Abyssal-Like Infinity");
        
        add("tooltip.gem_dreaming_agate.text", "A Vivid Dream of Endless Oceans");
        add("tooltip.gem_dreaming_chrysocolla.text", "A Vivid Dream of Frigid Chills");
        add("tooltip.gem_dreaming_malachite.text", "A Vivid Dream of Pure Chaos");
        add("tooltip.gem_dreaming_jade.text", "A Vivid Dream of Untouched Nature");
        add("tooltip.gem_dreaming_emerald.text", "A Vivid Dream of unargued Integrity");
        add("tooltip.gem_dreaming_peridot.text", "A Vivid Dream of Balance and Order");
        add("tooltip.gem_dreaming_topaz.text", "A Vivid Dream of Intense Rush");
        add("tooltip.gem_dreaming_citrine.text", "A Vivid Dream of Physical Space");
        add("tooltip.gem_dreaming_jasper.text", "A Vivid Dream of Glistening Embers");
        add("tooltip.gem_dreaming_ruby.text", "A Vivid Dream of Sheer Power");
        add("tooltip.gem_dreaming_garnet.text", "A Vivid Dream of Darkest Night");
        add("tooltip.gem_dreaming_spinel.text", "A Vivid Dream of Unbound Life");
        add("tooltip.gem_dreaming_amethyst.text", "A Vivid Dream of True Spirit");
        add("tooltip.gem_dreaming_charoite.text", "A Vivid Dream of Impending Death");
        add("tooltip.gem_dreaming_sapphire.text", "A Vivid Dream of Unparalleled Stability");
        add("tooltip.gem_dreaming_lilystar.text", "A Vivid Dream of a Beautiful Sky");
        add("tooltip.gem_dreaming_onyx.text", "A Vivid Dream of Pristine Ground");
        add("tooltip.gem_dreaming_sphene.text", "A Vivid Dream of Blinding Light");
        add("tooltip.gem_dreaming_rhodonite.text", "A Vivid Dream of Abyssal-Like Infinity");
        
        add("tooltip.concoction.one", "Used to speed up the dipper");
        add("tooltip.concoction.two", "Used to speed up the dipper (Requires previous tiers)");
        add("tooltip.concoction.three", "Used to speed up the dipper (Requires previous tiers)");
        add("tooltip.concoction.four", "Used to speed up the dipper (Requires previous tiers)");
        
        add(modid + ".dipper.tooltip.add_fluid_unpressed", "Hold control for filling instructions");
        add(modid + ".dipper.tooltip.add_fluid", "Right Click with bucket of valid fluid to add fill Dipper");
        add(modid + ".dipper.tooltip.use_case_unpressed", "Hold shift to more information");
        add(modid + ".dipper.tooltip.use_case", "Used to grow crystals if you ever run out of them (very slow!!)");
        add(modid + ".dipper.tooltip.warning", "Dosent save stored liquids. You have been warned");
    }
    
    private void addItems() {
        add(ItemInit.AGATE.get(), "Agate");
        add(ItemInit.CHRYSOCOLLA.get(), "Chrysocolla");
        add(ItemInit.MALACHITE.get(), "Malachite");
        add(ItemInit.JADE.get(), "Jade");
        add(ItemInit.PERIDOT.get(), "Peridot");
        add(ItemInit.TOPAZ.get(), "Topaz");
        add(ItemInit.CITRINE.get(), "Citrine");
        add(ItemInit.JASPER.get(), "Jasper");
        add(ItemInit.RUBY.get(), "Ruby");
        add(ItemInit.GARNET.get(), "Garnet");
        add(ItemInit.SPINEL.get(), "Spinel");
        add(ItemInit.AMETHYST.get(), "Amethyst");
        add(ItemInit.CHAROITE.get(), "Charoite");
        add(ItemInit.SAPPHIRE.get(), "Sapphire");
        add(ItemInit.LILYSTAR.get(), "Lilystar");
        add(ItemInit.ONYX.get(), "Onyx");
        add(ItemInit.SPHENE.get(), "Sphene");
        add(ItemInit.RHODONITE.get(), "Rhodonite");
        
        add(ItemInit.AGATE_DREAMING.get(), "Dreaming Agate");
        add(ItemInit.CHRYSOCOLLA_DREAMING.get(), "Dreaming Chrysocolla");
        add(ItemInit.MALACHITE_DREAMING.get(), "Dreaming Malachite");
        add(ItemInit.JADE_DREAMING.get(), "Dreaming Jade");
        add(ItemInit.PERIDOT_DREAMING.get(), "Dreaming Peridot");
        add(ItemInit.TOPAZ_DREAMING.get(), "Dreaming Topaz");
        add(ItemInit.CITRINE_DREAMING.get(), "Dreaming Citrine");
        add(ItemInit.JASPER_DREAMING.get(), "Dreaming Jasper");
        add(ItemInit.RUBY_DREAMING.get(), "Dreaming Ruby");
        add(ItemInit.GARNET_DREAMING.get(), "Dreaming Garnet");
        add(ItemInit.SPINEL_DREAMING.get(), "Dreaming Spinel");
        add(ItemInit.AMETHYST_DREAMING.get(), "Dreaming Amethyst");
        add(ItemInit.CHAROITE_DREAMING.get(), "Dreaming Charoite");
        add(ItemInit.SAPPHIRE_DREAMING.get(), "Dreaming Sapphire");
        add(ItemInit.LILYSTAR_DREAMING.get(), "Dreaming Lilystar");
        add(ItemInit.ONYX_DREAMING.get(), "Dreaming Onyx");
        add(ItemInit.SPHENE_DREAMING.get(), "Dreaming Sphene");
        add(ItemInit.RHODONITE_DREAMING.get(), "Dreaming Rhodonite");
        add(ItemInit.EMERALD_DREAMING.get(), "Dreaming Emerald");
        add(ItemInit.MULMUS_BULB.get(), "Mulmus Bulb");
        
        add(ItemInit.CONCOCTION_ONE.get(), "Concoction 1");
        add(ItemInit.CONCOCTION_TWO.get(), "Concoction 2");
        add(ItemInit.CONCOCTION_THREE.get(), "Concoction 3");
        add(ItemInit.CONCOCTION_FOUR.get(), "Concoction 4");
    }

    private void addBlocks() {
        
        add(BlockInit.CHASM_DOOR.get(), "Chasm Door");
        add(BlockInit.CHASM_FENCE.get(), "Chasm Fence");
        add(BlockInit.CHASM_FENCE_GATE.get(), "Chasm Fence Gate");
        add(BlockInit.CHASM_LEAVES.get(), "Chasm Leaves");
        add(BlockInit.CHASM_LOG.get(), "Chasm Log");
        add(BlockInit.CHASM_LOG_BARK.get(), "Chasm Bark");
        add(BlockInit.CHASM_LOG_STRIPPED.get(), "Stripped Chasm Log");
        add(BlockInit.CHASM_LOG_STRIPPED_BARK.get(), "Stripped Chasm Bark");
        add(BlockInit.CHASM_PLANKS.get(), "Chasm Planks");
        add(BlockInit.CHASM_SLAB.get(), "Chasm Slab");
        add(BlockInit.CHASM_STAIRS.get(), "Chasm Stairs");
        add(BlockInit.CHASM_TRAPDOOR.get(), "Chasm Trap Door");
        add(BlockInit.END_LANTERN.get(), "End Lantern");
        add(BlockInit.END_LANTERN_BLOCK.get(), "Mulmus Block");
        add(BlockInit.CHASM_BUTTON.get(), "Chasm Button");
        add(BlockInit.CHASM_PLATE.get(), "Chasm Pressure Plate");
        add(BlockInit.CHASM_SIGN.get(), "Chasm Sign");
        add(BlockInit.MULMUS_LANTERN.get(), "Mulmus Lantern");
        add(BlockInit.MULMUS_LANTERN_POLISHED.get(), "Polished Mulmus Lantern");
        add(BlockInit.INFUSION_TABLE.get(), "Infusion Table");
        add(BlockInit.DIPPER.get(), "Dipper");
    }
    
    private void addItemGroupText() {
    	add("itemGroup.gemsmoditemtab", "Geomancy Items");
    	add("itemGroup.gemsmodblocktab", "Geomancy Blocks");
    }

}