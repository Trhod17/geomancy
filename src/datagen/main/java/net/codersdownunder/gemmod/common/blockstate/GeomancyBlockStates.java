package net.codersdownunder.gemmod.common.blockstate;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GeomancyBlockStates extends BlockStateProvider {

    public GeomancyBlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, GemMod.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
    	
    	simpleBlock(BlockInit.TREADSTONE_1.get(), models().singleTexture(getName(), null, null));
    	simpleBlock(BlockInit.TREADSTONE_2.get());
    	simpleBlock(BlockInit.TREADSTONE_3.get());
    	simpleBlock(BlockInit.TREADSTONE_4.get());
    	simpleBlock(BlockInit.TREADSTONE_5.get());
    	simpleBlock(BlockInit.TREADSTONE_6.get());
    	simpleBlock(BlockInit.TREADSTONE_7.get());
    	
    	
    	
    	stairsBlock(null, null);
    	stairsBlock(null, null);
    	stairsBlock(null, null);
    	stairsBlock(null, null);
    	stairsBlock(null, null);
    }

    
}