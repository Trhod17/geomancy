package net.codersdownunder.gemmod.client;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.loaders.SeparateTransformsModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GeomancyItemModelProvider extends ItemModelProvider {

    public GeomancyItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, GemMod.MODID, existingFileHelper);
    }
    
    //TODO try to convert 

    @Override
    protected void registerModels() {
    	singleTexture(ItemInit.DREAM_DUST.get(), "dreamdust");
    	singleTexture(ItemInit.CATCHER_RING.get(), "catcherring");
    	singleTexture(ItemInit.EMPTY_DISK.get(), "empty_disc");
    	singleTexture(ItemInit.CONCOCTION_ONE.get(), "coc1");
    	singleTexture(ItemInit.CONCOCTION_TWO.get(), "coc2");
    	singleTexture(ItemInit.CONCOCTION_THREE.get(), "coc3");
    	singleTexture(ItemInit.CONCOCTION_FOUR.get(), "coc4");
    	singleTexture(ItemInit.CONCENTRATION.get(), "concentration");
    	singleTexture(ItemInit.NETHERRITE_NUGGET.get(), "netherite_nugget");
    	singleTexture(ItemInit.EMPTY_TOTEM.get(), "empty_totem");
    	singleTexture(ItemInit.ROSE_QUARTZ.get(), "rose_quartz");
    	singleTexture(ItemInit.NETHER_CRUX.get(), "nether_crux");
    	singleTexture(ItemInit.PLATE_FAILSAFE.get(), "plate_failsave");
    	singleTexture(ItemInit.PLATE_FUEL_COAL.get(), "plate_fuel_coal");
    	singleTexture(ItemInit.PLATE_FUEL_TIME.get(), "plate_fuel_time");
    	singleTexture(ItemInit.PLATE_SPEED_OVERDRIVE.get(), "plate_speed_overdrive");
    	singleTexture(ItemInit.PLATE_SPEED_UP.get(), "plate_speed_up");
    	singleTexture(ItemInit.PLATE_YIELD_ORE.get(), "plate_yield_ore");
    	singleTexture(ItemInit.RICH_GEODE.get(), "rich_geode_item");
    	singleTexture(ItemInit.SPARSE_GEODE.get(), "sparse_geode_item");
    	singleTexture(ItemInit.GEODE.get(), "geode_item");
    	
    	singleTexture(ItemInit.MULMUS_BULB.get(), "mulmus_bulb");
    	
    	singleTexture(ItemInit.TELE_CORE.get(), "tele_core");
    	
    	singleTexture(ItemInit.AGATE.get(), "gem_agate");
    	singleTexture(ItemInit.CHRYSOCOLLA.get(), "gem_chrysocolla");
    	singleTexture(ItemInit.MALACHITE.get(), "gem_malachite");
    	singleTexture(ItemInit.JADE.get(), "gem_jade");
    	singleTexture(ItemInit.PERIDOT.get(), "gem_peridot");
    	singleTexture(ItemInit.TOPAZ.get(), "gem_topaz");
    	singleTexture(ItemInit.CITRINE.get(), "gem_citrine");
    	singleTexture(ItemInit.JASPER.get(), "gem_jasper");
    	singleTexture(ItemInit.RUBY.get(), "gem_ruby");
    	singleTexture(ItemInit.GARNET.get(), "gem_garnet");
    	singleTexture(ItemInit.SPINEL.get(), "gem_spinel");
    	singleTexture(ItemInit.AMETHYST.get(), "gem_amethyst");
    	singleTexture(ItemInit.CHAROITE.get(), "gem_charoite");
    	singleTexture(ItemInit.SAPPHIRE.get(), "gem_sapphire");
    	singleTexture(ItemInit.LILYSTAR.get(), "gem_lilystar");
    	singleTexture(ItemInit.ONYX.get(), "gem_onyx");
    	singleTexture(ItemInit.SPHENE.get(), "gem_sphene");
    	singleTexture(ItemInit.RHODONITE.get(), "gem_rhodonite");
    	
    	singleTexture(ItemInit.AGATE_DREAMING.get(), "gem_lucid_agate");
    	singleTexture(ItemInit.CHRYSOCOLLA_DREAMING.get(), "gem_lucid_chrysocolla");
    	singleTexture(ItemInit.MALACHITE_DREAMING.get(), "gem_lucid_malachite");
    	singleTexture(ItemInit.JADE_DREAMING.get(), "gem_lucid_jade");
    	singleTexture(ItemInit.PERIDOT_DREAMING.get(), "gem_lucid_peridot");
    	singleTexture(ItemInit.TOPAZ_DREAMING.get(), "gem_lucid_topaz");
    	singleTexture(ItemInit.CITRINE_DREAMING.get(), "gem_lucid_citrine");
    	singleTexture(ItemInit.JASPER_DREAMING.get(), "gem_lucid_jasper");
    	singleTexture(ItemInit.RUBY_DREAMING.get(), "gem_lucid_ruby");
    	singleTexture(ItemInit.GARNET_DREAMING.get(), "gem_lucid_garnet");
    	singleTexture(ItemInit.SPINEL_DREAMING.get(), "gem_lucid_spinel");
    	singleTexture(ItemInit.AMETHYST_DREAMING.get(), "gem_lucid_amethyst");
    	singleTexture(ItemInit.CHAROITE_DREAMING.get(), "gem_lucid_charoite");
    	singleTexture(ItemInit.SAPPHIRE_DREAMING.get(), "gem_lucid_sapphire");
    	singleTexture(ItemInit.LILYSTAR_DREAMING.get(), "gem_lucid_lilystar");
    	singleTexture(ItemInit.ONYX_DREAMING.get(), "gem_lucid_onyx");
    	singleTexture(ItemInit.SPHENE_DREAMING.get(), "gem_lucid_sphene");
    	singleTexture(ItemInit.RHODONITE_DREAMING.get(), "gem_lucid_rhodonite");
    	singleTextureMC(ItemInit.EMERALD_DREAMING.get(), "emerald");

    	diggingClaw("wood");
    	diggingClaw("stone");
    	diggingClaw("iron");
    	diggingClaw("gold");
    	diggingClaw("diamond");
    	diggingClaw("netherite");
    	
    	
    }
    
    private ItemModelBuilder diggingClaw(String material) {
    	return getBuilder("digging_claw_" + material)
    	.parent(getExistingFile(new ResourceLocation("forge:item/default")))
    	.customLoader(SeparateTransformsModelBuilder::begin)
    	.base(nested()
    			.parent(getExistingFile(mcLoc("item/generated")))
    			.texture("layer0", modLoc("item/claw_" + material + "_item")))
    	.perspective(TransformType.FIRST_PERSON_RIGHT_HAND, 
    			nested()
    			.parent(getExistingFile(modLoc("item/digging_claw_hand")))
    			.texture("texture", modLoc("item/claw_" + material)))
    	.perspective(TransformType.FIRST_PERSON_LEFT_HAND, 
    			nested()
    			.parent(getExistingFile(modLoc("item/digging_claw_hand_left")))
    			.texture("texture", modLoc("item/claw_" + material)))
    	.perspective(TransformType.THIRD_PERSON_RIGHT_HAND, 
    			nested()
    			.parent(getExistingFile(modLoc("item/digging_claw_hand")))
    			.texture("texture", modLoc("item/claw_" + material)))
    	.perspective(TransformType.THIRD_PERSON_LEFT_HAND, 
    			nested()
    			.parent(getExistingFile(modLoc("item/digging_claw_hand_left")))
    			.texture("texture", modLoc("item/claw_" + material))).
    	end();
    }
    
    private void singleTexture(Item item, String texture) {
    	//Not sure if this works
    	singleTexture(item.toString(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/" + texture));
    }
    
    private void singleTextureMC(Item item, String texture) {
    	//Not sure if this works
    	singleTexture(item.toString(),
                mcLoc("item/generated"),
                "layer0", mcLoc("item/" + texture));
    }
    
    
}