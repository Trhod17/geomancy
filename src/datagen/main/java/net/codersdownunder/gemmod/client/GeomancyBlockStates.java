package net.codersdownunder.gemmod.client;

import net.codersdownunder.gemmod.DataUtils;
import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.blocks.songforge.SongForgeBlock;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.FluidInit;
import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import javax.xml.crypto.Data;

public class GeomancyBlockStates extends BlockStateProvider {
	
    public GeomancyBlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, Geomancy.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
    	
    	// Chasm
    	log((RotatedPillarBlock) BlockInit.CHASM_LOG.get(), "block/chasm_log", "block/chasm_log_top");
    	log((RotatedPillarBlock) BlockInit.CHASM_LOG_BARK.get(), "block/chasm_log", "block/chasm_log");
    	log((RotatedPillarBlock) BlockInit.CHASM_LOG_STRIPPED.get(), "block/stripped_chasm_log", "block/stripped_chasm_log_top");
    	log((RotatedPillarBlock) BlockInit.CHASM_LOG_STRIPPED_BARK.get(), "block/stripped_chasm_log", "block/stripped_chasm_log");
    	simpleBlock(BlockInit.CHASM_PLANKS.get(), models().cubeAll("chasm_planks", modLoc("block/chasm_planks")));
    	stairsBlockWithRenderType((StairBlock) BlockInit.CHASM_STAIRS.get(), "chasm", modLoc("block/chasm_planks"), "minecraft:cutout_mipped");
    	slabBlock((SlabBlock) BlockInit.CHASM_SLAB.get(), ForgeRegistries.BLOCKS.getKey(BlockInit.CHASM_SLAB.get()), modLoc("block/chasm_planks"));
    	doorBlockWithRenderType((DoorBlock) BlockInit.CHASM_DOOR.get(), modLoc("block/chasm_door_bottom"), modLoc("block/chasm_door_top"), "minecraft:cutout_mipped");
    	trapdoorBlockWithRenderType((TrapDoorBlock) BlockInit.CHASM_TRAPDOOR.get(), modLoc("block/chasm_trapdoor"), true, "minecraft:cutout_mipped");
    	fenceBlockWithRenderType((FenceBlock) BlockInit.CHASM_FENCE.get(), "chasm_fence", modLoc("block/chasm_planks"), "minecraft:cutout_mipped");
    	fenceGateBlockWithRenderType((FenceGateBlock) BlockInit.CHASM_FENCE_GATE.get(), "chasm_fence_gate", modLoc("block/chasm_planks"), "minecraft:cutout_mipped");
    	buttonBlock((ButtonBlock) BlockInit.CHASM_BUTTON.get(), modLoc("block/chasm_planks"));
    	pressurePlateBlock((PressurePlateBlock) BlockInit.CHASM_PLATE.get(), modLoc("block/chasm_planks"));
    	signBlock((StandingSignBlock) BlockInit.CHASM_SIGN.get(), (WallSignBlock) BlockInit.CHASM_SIGN_WALL.get(), modLoc("entity/signs/chasm"));
    	simpleBlock(BlockInit.CHASM_LEAVES.get(), models().cubeAll("chasm_leaves", modLoc("block/chasm_leaves")).parent(models().getExistingFile(mcLoc("block/leaves"))).renderType("minecraft:cutout_mipped"));
    	simpleBlock(BlockInit.CHASM_SAPLING.get(), models().cross("chasm_sapling", modLoc("block/chasm_sapling")).renderType("minecraft:cutout_mipped"));

    	simpleBlock(BlockInit.MULMUS_LANTERN.get(), models().cubeAll("mulmus_lantern", modLoc("block/mulmus_lantern")));
    	simpleBlock(BlockInit.MULMUS_LANTERN_POLISHED.get(), models().cubeAll("polished_mulmus_lantern", modLoc("block/polished_mulmus_lantern")));
    	
    	simpleBlock(BlockInit.END_LANTERN_BLOCK.get(), models().cubeAll("end_lantern_block", modLoc("block/end_lantern_block")));
    	
    	simpleBlock(BlockInit.GEODE_ORE.get(), models().cubeAll("geode_ore", modLoc("block/geode_ore")));
    	
    	simpleBlock(BlockInit.TREADSTONE_1.get(), models().cubeAll("treadstone_1", modLoc("block/treadstone1")));
    	simpleBlock(BlockInit.TREADSTONE_2.get(), models().cubeAll("treadstone_2", modLoc("block/treadstone2")));
    	simpleBlock(BlockInit.TREADSTONE_3.get(), models().cubeAll("treadstone_3", modLoc("block/treadstone3")));
    	simpleBlock(BlockInit.TREADSTONE_4.get(), models().cubeAll("treadstone_4", modLoc("block/treadstone4")));
    	simpleBlock(BlockInit.TREADSTONE_5.get(), models().cubeAll("treadstone_5", modLoc("block/treadstone5")));
    	simpleBlock(BlockInit.TREADSTONE_6.get(), models().cubeAll("treadstone_6", modLoc("block/treadstone6")));
    	simpleBlock(BlockInit.TREADSTONE_7.get(), models().cubeAll("treadstone_7", modLoc("block/treadstone7")));
    	
    	stairsBlock((StairBlock) BlockInit.TREADSTONE_STAIR_1.get(), "treadstone_1", modLoc("block/treadstone1"));
    	stairsBlock((StairBlock) BlockInit.TREADSTONE_STAIR_2.get(), "treadstone_2", modLoc("block/treadstone2"));
    	stairsBlock((StairBlock) BlockInit.TREADSTONE_STAIR_3.get(), "treadstone_3", modLoc("block/treadstone3"));
    	stairsBlock((StairBlock) BlockInit.TREADSTONE_STAIR_4.get(), "treadstone_4", modLoc("block/treadstone4"));
    	stairsBlock((StairBlock) BlockInit.TREADSTONE_STAIR_5.get(), "treadstone_5", modLoc("block/treadstone5"));
    	stairsBlock((StairBlock) BlockInit.TREADSTONE_STAIR_6.get(), "treadstone_6", modLoc("block/treadstone6"));
    	stairsBlock((StairBlock) BlockInit.TREADSTONE_STAIR_7.get(), "treadstone_7", modLoc("block/treadstone7"));
    	
    	slabBlock((SlabBlock)BlockInit.TREADSTONE_SLAB_1.get(), ForgeRegistries.BLOCKS.getKey(BlockInit.TREADSTONE_SLAB_1.get()), modLoc("block/treadstone1"));
    	slabBlock((SlabBlock)BlockInit.TREADSTONE_SLAB_2.get(), ForgeRegistries.BLOCKS.getKey(BlockInit.TREADSTONE_SLAB_2.get()), modLoc("block/treadstone2"));
    	slabBlock((SlabBlock)BlockInit.TREADSTONE_SLAB_3.get(), ForgeRegistries.BLOCKS.getKey(BlockInit.TREADSTONE_SLAB_3.get()), modLoc("block/treadstone3"));
    	slabBlock((SlabBlock)BlockInit.TREADSTONE_SLAB_4.get(), ForgeRegistries.BLOCKS.getKey(BlockInit.TREADSTONE_SLAB_4.get()), modLoc("block/treadstone4"));
    	slabBlock((SlabBlock)BlockInit.TREADSTONE_SLAB_5.get(), ForgeRegistries.BLOCKS.getKey(BlockInit.TREADSTONE_SLAB_5.get()), modLoc("block/treadstone5"));
   		slabBlock((SlabBlock)BlockInit.TREADSTONE_SLAB_6.get(), ForgeRegistries.BLOCKS.getKey(BlockInit.TREADSTONE_SLAB_6.get()), modLoc("block/treadstone6"));
   		slabBlock((SlabBlock)BlockInit.TREADSTONE_SLAB_7.get(), ForgeRegistries.BLOCKS.getKey(BlockInit.TREADSTONE_SLAB_7.get()), modLoc("block/treadstone7"));
   	
   		carpet(BlockInit.TREADSTONE_CARPET_1.get(), "treadstone_carpet_1", "treadstone1");
   		carpet(BlockInit.TREADSTONE_CARPET_2.get(), "treadstone_carpet_2", "treadstone2");
   		carpet(BlockInit.TREADSTONE_CARPET_3.get(), "treadstone_carpet_3", "treadstone3");
   		carpet(BlockInit.TREADSTONE_CARPET_4.get(), "treadstone_carpet_4", "treadstone4");
   		carpet(BlockInit.TREADSTONE_CARPET_5.get(), "treadstone_carpet_5", "treadstone5");
   		carpet(BlockInit.TREADSTONE_CARPET_6.get(), "treadstone_carpet_6", "treadstone6");
   		carpet(BlockInit.TREADSTONE_CARPET_7.get(), "treadstone_carpet_7", "treadstone7");
    	
    	rotatingBlock(BlockInit.TRELLIS.get(), "block/trellis_empty");
    	rotatingBlock(BlockInit.TRELLIS_CAVE_VINES.get(), "block/trellis_cave_vines");
    	rotatingBlock(BlockInit.TRELLIS_CHORUS.get(), "block/trellis_chorus");
    	rotatingBlock(BlockInit.TRELLIS_CRIMSON.get(), "block/trellis_crimson");
    	rotatingBlock(BlockInit.TRELLIS_LICHEN.get(), "block/trellis_lichen");
    	rotatingBlock(BlockInit.TRELLIS_MOSS.get(), "block/trellis_moss");
    	rotatingBlock(BlockInit.TRELLIS_VINE.get(), "block/trellis_vine");
    	rotatingBlock(BlockInit.TRELLIS_WARP.get(), "block/trellis_warp");
    	
    	lanternModel((LanternBlock)BlockInit.END_LANTERN.get(), "end_lantern", "block/end_lantern");
    	
    	songForgeModel();
    	
    	simpleBlock(BlockInit.TELEPAD.get(), models().getExistingFile(modLoc("block/telepad")));
    	simpleBlock(BlockInit.TELEPAD_SLAB.get(), models().getExistingFile(modLoc("block/telepad_slab")));
    	
    	simpleBlock(BlockInit.INFUSION_TABLE.get(), models().getExistingFile(modLoc("block/infusion_table")));
    	
    	simpleBlock(BlockInit.DIPPER.get(), models().getExistingFile(modLoc("block/dipper")));
    	
    	rotatingBlock(BlockInit.DREAM_CATCHER.get(), "block/dream_catcher");

		registerEndTorch();

        registerItemModels();

    }


	private void registerEndTorch() {
		simpleBlock(BlockInit.END_TORCH.get(), models().torch(DataUtils.getBlockRegistryName(BlockInit.END_TORCH.get()), modLoc("block/end_torch")).renderType("minecraft:cutout_mipped"));
		horizontalBlock(BlockInit.WALL_END_TORCH.get(), models().torchWall(DataUtils.getBlockRegistryName(BlockInit.WALL_END_TORCH.get()), modLoc("block/end_torch")).renderType("minecraft:cutout_mipped"), 90);
	}

    protected void registerItemModels() {
    	
    	basicModel("end_lantern");
    	
    	basicModel("chasm_log");
    	basicModel("chasm_log_stripped");
    	basicModel("chasm_log_bark");
    	basicModel("chasm_log_stripped_bark");
    	basicModel("chasm_planks");
    	basicModel("chasm_stairs");
    	basicModel("chasm_slab");
    	basicModel("chasm_leaves");
    	singleTexture(BlockInit.CHASM_SAPLING.get().asItem(), "chasm_sapling");
    	singleTexture(BlockInit.CHASM_DOOR.get().asItem(), "chasm_door");
    	singleTexture(BlockInit.CHASM_TRAPDOOR.get().asItem(), "chasm_door");
    	itemModels().fenceInventory("chasm_fence", modLoc("block/chasm_planks"));
    	itemModels().fenceGate("chasm_fence_gate", modLoc("block/chasm_planks"));
    	itemModels().buttonInventory("chasm_button", modLoc("block/chasm_planks"));
    	itemModels().pressurePlate("chasm_plate", modLoc("block/chasm_planks"));
    	singleTextureMC(BlockInit.CHASM_SIGN.get().asItem(), "acacia_sign");
    	
    	basicModel("end_lantern_block");
    	singleTexture(BlockInit.END_LANTERN.get().asItem(), "end_lantern_item");
    	
    	basicModel("mulmus_lantern");
    	basicModel("mulmus_lantern_polished", "polished_mulmus_lantern");
    	
    	basicModel("infusion_table");
    	
    	basicModel("dipper");
    	
    	basicModel("dream_catcher");
    	
    	basicModel("geode_ore");
    	
    	basicModel("telepad");
    	basicModel("telepad_slab");
    	
    	basicModel("song_forge");
    	
    	singleTexture(BlockInit.TRELLIS.get().asItem(), "trellis_item");
    	basicModel("trellis_moss");
    	basicModel("trellis_cave_vines");
    	basicModel("trellis_chorus");
    	basicModel("trellis_crimson");
    	basicModel("trellis_lichen");
    	basicModel("trellis_vine");
    	basicModel("trellis_warp");
    	
    	basicModel("treadstone_slab_1");
    	basicModel("treadstone_slab_2");
    	basicModel("treadstone_slab_3");
    	basicModel("treadstone_slab_4");
    	basicModel("treadstone_slab_5");
    	basicModel("treadstone_slab_6");
    	basicModel("treadstone_slab_7");
    	
    	basicModel("treadstone_1");
    	basicModel("treadstone_2");
    	basicModel("treadstone_3");
    	basicModel("treadstone_4");
    	basicModel("treadstone_5");
     	basicModel("treadstone_6");
    	basicModel("treadstone_7");
    	
    	basicModel("treadstone_stair_1", "treadstone_1_stairs");
    	basicModel("treadstone_stair_2", "treadstone_2_stairs");
    	basicModel("treadstone_stair_3", "treadstone_3_stairs");
    	basicModel("treadstone_stair_4", "treadstone_4_stairs");
    	basicModel("treadstone_stair_5", "treadstone_5_stairs");
    	basicModel("treadstone_stair_6", "treadstone_6_stairs");
    	basicModel("treadstone_stair_7", "treadstone_7_stairs");
    	
    	basicModel("treadstone_carpet_1", "treadstone_carpet_1");
    	basicModel("treadstone_carpet_2", "treadstone_carpet_2");
    	basicModel("treadstone_carpet_3", "treadstone_carpet_3");
    	basicModel("treadstone_carpet_4", "treadstone_carpet_4");
    	basicModel("treadstone_carpet_5", "treadstone_carpet_5");
    	basicModel("treadstone_carpet_6", "treadstone_carpet_6");
    	basicModel("treadstone_carpet_7", "treadstone_carpet_7");
    	
    	basicModel("song_forge");

		singleTexture(ItemInit.END_TORCH.get(), "end_torch", "block");
    	
    }
    
    private void basicModel(String name) {
    	itemModels().withExistingParent(name, modLoc("block/" + name));
    }
    
    private void basicModel(String name, String modelName) {
    	itemModels().withExistingParent(name, modLoc("block/" + modelName));
    }
    
    private void log(RotatedPillarBlock block, String texture_side, String texture_top) {
    	axisBlock(block, modLoc(texture_side), modLoc(texture_top));
    }
    
    private void singleTexture(Item item, String texture) {
    	itemModels().singleTexture(item.toString(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/" + texture));
    }

	private void singleTexture(Item item, String texture, String folder) {
		itemModels().singleTexture(item.toString(),
				mcLoc("item/generated"),
				"layer0", modLoc(folder + "/" + texture));
	}
    
    private void singleTextureMC(Item item, String texture) {
    	itemModels().singleTexture(item.toString(),
                mcLoc("item/generated"),
                "layer0", mcLoc("item/" + texture));
    }
    
    private void carpet(Block block, String name, String texture) {
    	simpleBlock(block, models().getBuilder(name)
   		.parent(models().getExistingFile(mcLoc("block/carpet")))
   		.texture("wool", modLoc("block/" + texture)));	
    }
    
    private void rotatingBlock(Block block, String model) {
    	
    	ModelFile existingModel = models().getExistingFile(modLoc(model));
    	
    	getVariantBuilder(block)
        .forAllStates(state -> ConfiguredModel.builder()
                .modelFile(state.getValue(BlockStateProperties.WATERLOGGED) ? existingModel : existingModel)
                .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite().toYRot())
                .build()
        );
    }
    
    private void lanternModel(LanternBlock block, String name, String texture) {
    	ModelFile lantern = models().withExistingParent(name, mcLoc("block/template_lantern")).texture("lantern", modLoc(texture)).renderType("minecraft:cutout_mipped");
    	ModelFile lantern_hanging = models().withExistingParent(name, mcLoc("block/template_hanging_lantern")).texture("lantern", modLoc(texture)).renderType("minecraft:cutout_mipped");
    	
    	getVariantBuilder(block)
        .forAllStates(state -> ConfiguredModel.builder()
                .modelFile(state.getValue(LanternBlock.HANGING) ? lantern_hanging : lantern)
                .build()
        );
    }
    
    private void songForgeModel() {
    	
    	ModelFile furnace = models().orientable("song_forge", modLoc("block/songforge_side"), modLoc("block/songforge_front"), modLoc("block/songforge_top"));
        ModelFile furnaceLit = models().orientable("song_forge_on", modLoc("block/songforge_side"), modLoc("block/songforge_front_on"), modLoc("block/songforge_top"));
    	
    	getVariantBuilder(BlockInit.SONG_FORGE.get())
        .forAllStates(state -> ConfiguredModel.builder()
                .modelFile(state.getValue(SongForgeBlock.LIT) ? furnaceLit : furnace)
                .rotationY((int) state.getValue(SongForgeBlock.FACING).getOpposite().toYRot())
                .build()
        );
    }

    
}