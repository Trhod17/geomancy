package net.codersdownunder.gemmod.client;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.blocks.songforge.SongForgeBlock;
import net.codersdownunder.gemmod.init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GeomancyBlockStates extends BlockStateProvider {

    public GeomancyBlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, GemMod.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
    	
    	simpleBlock(BlockInit.TREADSTONE_1.get(), models().cubeAll("treadstone_1", new ResourceLocation(GemMod.MODID, "blocks/treadstone1")));
    	simpleBlock(BlockInit.TREADSTONE_2.get(), models().cubeAll("treadstone_2", new ResourceLocation(GemMod.MODID, "blocks/treadstone2")));
    	simpleBlock(BlockInit.TREADSTONE_3.get(), models().cubeAll("treadstone_3", new ResourceLocation(GemMod.MODID, "blocks/treadstone3")));
    	simpleBlock(BlockInit.TREADSTONE_4.get(), models().cubeAll("treadstone_4", new ResourceLocation(GemMod.MODID, "blocks/treadstone4")));
    	simpleBlock(BlockInit.TREADSTONE_5.get(), models().cubeAll("treadstone_5", new ResourceLocation(GemMod.MODID, "blocks/treadstone5")));
    	simpleBlock(BlockInit.TREADSTONE_6.get(), models().cubeAll("treadstone_6", new ResourceLocation(GemMod.MODID, "blocks/treadstone6")));
    	simpleBlock(BlockInit.TREADSTONE_7.get(), models().cubeAll("treadstone_7", new ResourceLocation(GemMod.MODID, "blocks/treadstone7")));
    	
    	stairsBlock((StairBlock) BlockInit.TREADSTONE_STAIR_1.get(), "treadstone_1", new ResourceLocation(GemMod.MODID, "blocks/treadstone1"));
    	stairsBlock((StairBlock) BlockInit.TREADSTONE_STAIR_2.get(), "treadstone_2", new ResourceLocation(GemMod.MODID, "blocks/treadstone2"));
    	stairsBlock((StairBlock) BlockInit.TREADSTONE_STAIR_3.get(), "treadstone_3", new ResourceLocation(GemMod.MODID, "blocks/treadstone3"));
    	stairsBlock((StairBlock) BlockInit.TREADSTONE_STAIR_4.get(), "treadstone_4", new ResourceLocation(GemMod.MODID, "blocks/treadstone4"));
    	stairsBlock((StairBlock) BlockInit.TREADSTONE_STAIR_5.get(), "treadstone_5", new ResourceLocation(GemMod.MODID, "blocks/treadstone5"));
    	stairsBlock((StairBlock) BlockInit.TREADSTONE_STAIR_6.get(), "treadstone_6", new ResourceLocation(GemMod.MODID, "blocks/treadstone6"));
    	stairsBlock((StairBlock) BlockInit.TREADSTONE_STAIR_7.get(), "treadstone_7", new ResourceLocation(GemMod.MODID, "blocks/treadstone7"));
    	
    	//TODO: Fix the slab blockstates
//    	slabBlock((SlabBlock)BlockInit.TREADSTONE_SLAB_1.get(), BlockInit.TREADSTONE_1.get().getName()., modLoc("blocks/treadstone1"));
//    	slabBlock((SlabBlock)BlockInit.TREADSTONE_SLAB_2.get(), BlockInit.TREADSTONE_2.get().getName(), modLoc("blocks/treadstone2"));
//    	slabBlock((SlabBlock)BlockInit.TREADSTONE_SLAB_3.get(), BlockInit.TREADSTONE_3.get().getName(), modLoc("blocks/treadstone3"));
//    	slabBlock((SlabBlock)BlockInit.TREADSTONE_SLAB_4.get(), BlockInit.TREADSTONE_4.get().getName(), modLoc("blocks/treadstone4"));
//    	slabBlock((SlabBlock)BlockInit.TREADSTONE_SLAB_5.get(), BlockInit.TREADSTONE_5.get().getName(), modLoc("blocks/treadstone5"));
//    	slabBlock((SlabBlock)BlockInit.TREADSTONE_SLAB_6.get(), BlockInit.TREADSTONE_6.get().getName(), modLoc("blocks/treadstone6"));
//    	slabBlock((SlabBlock)BlockInit.TREADSTONE_SLAB_7.get(), BlockInit.TREADSTONE_7.get().getName(), modLoc("blocks/treadstone7"));
  
    	
//    	models().carpet("treadstone1", modLoc("blocks/treadstone1"));
//    	models().carpet("treadstone2", modLoc("blocks/treadstone2"));
//    	models().carpet("treadstone3", modLoc("blocks/treadstone3"));
//    	models().carpet("treadstone4", modLoc("blocks/treadstone4"));
//    	models().carpet("treadstone5", modLoc("blocks/treadstone5"));
//    	models().carpet("treadstone6", modLoc("blocks/treadstone6"));
//    	models().carpet("treadstone7", modLoc("blocks/treadstone7"));

    	itemModels().withExistingParent("treadstone_slab_1", modLoc("block/treadstone_slab_1"));
    	itemModels().withExistingParent("treadstone_slab_2", modLoc("block/treadstone_slab_2"));
    	itemModels().withExistingParent("treadstone_slab_3", modLoc("block/treadstone_slab_3"));
    	itemModels().withExistingParent("treadstone_slab_4", modLoc("block/treadstone_slab_4"));
    	itemModels().withExistingParent("treadstone_slab_5", modLoc("block/treadstone_slab_5"));
    	itemModels().withExistingParent("treadstone_slab_6", modLoc("block/treadstone_slab_6"));
    	itemModels().withExistingParent("treadstone_slab_7", modLoc("block/treadstone_slab_7"));
    	
    	itemModels().withExistingParent("treadstone_1", modLoc("block/treadstone_1"));
    	itemModels().withExistingParent("treadstone_2", modLoc("block/treadstone_2"));
    	itemModels().withExistingParent("treadstone_3", modLoc("block/treadstone_3"));
    	itemModels().withExistingParent("treadstone_4", modLoc("block/treadstone_4"));
    	itemModels().withExistingParent("treadstone_5", modLoc("block/treadstone_5"));
     	itemModels().withExistingParent("treadstone_6", modLoc("block/treadstone_6"));
    	itemModels().withExistingParent("treadstone_7", modLoc("block/treadstone_7"));
    	
    	itemModels().withExistingParent("treadstone_stair_1", modLoc("block/treadstone_1_stairs"));
    	itemModels().withExistingParent("treadstone_stair_2", modLoc("block/treadstone_2_stairs"));
    	itemModels().withExistingParent("treadstone_stair_3", modLoc("block/treadstone_3_stairs"));
    	itemModels().withExistingParent("treadstone_stair_4", modLoc("block/treadstone_4_stairs"));
    	itemModels().withExistingParent("treadstone_stair_5", modLoc("block/treadstone_5_stairs"));
    	itemModels().withExistingParent("treadstone_stair_6", modLoc("block/treadstone_6_stairs"));
    	itemModels().withExistingParent("treadstone_stair_7", modLoc("block/treadstone_7_stairs"));
    	
    	
    	
    	 ModelFile furnace = models().orientable("songforge", modLoc("blocks/songforge_side"), modLoc("blocks/songforge_front"), modLoc("blocks/songforge_top"));
         ModelFile furnaceLit = models().orientable("songforge_on", modLoc("blocks/songforge_side"), modLoc("blocks/songforge_front_on"), modLoc("blocks/songforge_top"));
         //ModelFile furnace_forge = models().orientable("songforge_forge", modLoc("blocks/songforge_side"), modLoc("blocks/songforge_front2"), modLoc("blocks/songforge_top"));
         //ModelFile furnace_forgeLit = models().orientable("songforge_forge_on", modLoc("blocks/songforge_side"), modLoc("blocks/songforge_front2_on"), modLoc("blocks/songforge_top"));
         
        getVariantBuilder(BlockInit.SONG_FORGE.get())
                .forAllStates(state -> ConfiguredModel.builder()
                        .modelFile(state.getValue(SongForgeBlock.LIT) ? furnaceLit : furnace)
                        //.modelFile(state.getValue(SongForgeBlock.FORGE) ? furnace_forgeLit : furnace_forge)
                        .rotationY((int) state.getValue(SongForgeBlock.FACING).getOpposite().toYRot())
                        .build()
                );
        
        itemModels().withExistingParent("song_forge", modLoc("block/songforge"));
        
        //directionalBlock(BlockInit.TRELLIS.get(), models().withExistingParent("trellis_empty", modLoc("block/trellis_empty")));

    }

    
}