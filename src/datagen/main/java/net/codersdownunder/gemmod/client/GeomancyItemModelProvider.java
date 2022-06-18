package net.codersdownunder.gemmod.client;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GeomancyItemModelProvider extends ItemModelProvider {

    public GeomancyItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, GemMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    	this.singleTexture(ItemInit.DREAM_DUST.get(), "dreamdust");
    	this.singleTexture(ItemInit.CATCHER_RING.get(), "catcherring");
    	this.singleTexture(ItemInit.EMPTY_DISK.get(), "empty_disc");
    	this.singleTexture(ItemInit.CONCOCTION_ONE.get(), "coc1");
    	this.singleTexture(ItemInit.CONCOCTION_TWO.get(), "coc2");
    	this.singleTexture(ItemInit.CONCOCTION_THREE.get(), "coc3");
    	this.singleTexture(ItemInit.CONCOCTION_FOUR.get(), "coc4");
    	this.singleTexture(ItemInit.CONCENTRATION.get(), "concentration");
    	this.singleTexture(ItemInit.NETHERRITE_NUGGET.get(), "netherite_nugget");
    	this.singleTexture(ItemInit.EMPTY_TOTEM.get(), "empty_totem");
    	this.singleTexture(ItemInit.ROSE_QUARTZ.get(), "rose_quartz");
    	this.singleTexture(ItemInit.NETHER_CRUX.get(), "nether_crux");
    	this.singleTexture(ItemInit.PLATE_FAILSAFE.get(), "plate_failsave");
    	this.singleTexture(ItemInit.PLATE_FUEL_COAL.get(), "plate_fuel_coal");
    	this.singleTexture(ItemInit.PLATE_FUEL_TIME.get(), "plate_fuel_time");
    	this.singleTexture(ItemInit.PLATE_SPEED_OVERDRIVE.get(), "plate_speed_overdrive");
    	this.singleTexture(ItemInit.PLATE_SPEED_UP.get(), "plate_speed_up");
    	this.singleTexture(ItemInit.PLATE_YIELD_ORE.get(), "plate_yield_ore");
    	this.singleTexture(ItemInit.RICH_GEODE.get(), "rich_geode_item");
    	this.singleTexture(ItemInit.SPARSE_GEODE.get(), "sparse_geode_item");

    	
    }
    
    private void singleTexture(Item item, String texture) {
    	//Not sure if this works
    	singleTexture(item.toString(),
                mcLoc("item/generated"),
                "layer0", modLoc("items/" + texture));
    }

    
    
    
}