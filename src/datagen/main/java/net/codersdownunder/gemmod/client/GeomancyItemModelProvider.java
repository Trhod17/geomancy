package net.codersdownunder.gemmod.client;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
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
    	
    	
    }
    
    private void singleTexture(Item item, String texture) {
    	singleTexture(item.getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("items/" + texture));
    }
    
}