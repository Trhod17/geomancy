package net.codersdownunder.gemmod.init;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.blocks.dipper.DipperBlock;
import net.codersdownunder.gemmod.blocks.dream.DreamCatcherBlock;
import net.codersdownunder.gemmod.blocks.infusion.InfusionBlock;
import net.codersdownunder.gemmod.blocks.sign.CustomStandingSignBlock;
import net.codersdownunder.gemmod.blocks.sign.CustomWallSignBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GemMod.MODID);
    
    public static final RegistryObject<Block> END_LANTERN = BLOCKS.register("end_lantern", () -> new LanternBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((p_235447_0_) -> {
      return 15;
   }).noOcclusion()));
    
    public static final RegistryObject<Block> CHASM_LOG = BLOCKS.register("chasm_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CHASM_LOG_STRIPPED = BLOCKS.register("chasm_log_stripped", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CHASM_LOG_BARK = BLOCKS.register("chasm_log_bark", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CHASM_LOG_STRIPPED_BARK = BLOCKS.register("chasm_log_stripped_bark", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
    
    public static final RegistryObject<Block> CHASM_PLANKS = BLOCKS.register("chasm_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CHASM_STAIRS = BLOCKS.register("chasm_stairs", () -> new StairBlock(() -> CHASM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    
    public static final RegistryObject<Block> CHASM_SLAB = BLOCKS.register("chasm_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    
    public static final RegistryObject<Block> CHASM_DOOR = BLOCKS.register("chasm_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CHASM_TRAPDOOR = BLOCKS.register("chasm_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    
    public static final RegistryObject<Block> CHASM_LEAVES = BLOCKS.register("chasm_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_PURPLE).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()));

    public static final RegistryObject<Block> CHASM_FENCE = BLOCKS.register("chasm_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CHASM_FENCE_GATE = BLOCKS.register("chasm_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    
    public static final RegistryObject<Block> END_LANTERN_BLOCK = BLOCKS.register("end_lantern_block", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().lightLevel((p_235455_0_) -> {
      return 15;
   })));
    
    public static final RegistryObject<Block> CHASM_BUTTON = BLOCKS.register("chasm_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission()));
    public static final RegistryObject<Block> CHASM_PLATE = BLOCKS.register("chasm_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission()));
    
    public static final RegistryObject<Block> CHASM_SIGN = BLOCKS.register("chasm_sign", () -> new CustomStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), GemMod.CHASM));
    public static final RegistryObject<Block> CHASM_SIGN_WALL = BLOCKS.register("chasm_sign_wall", () -> new CustomWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), GemMod.CHASM));
    
    public static final RegistryObject<Block> MULMUS_LANTERN = BLOCKS.register("mulmus_lantern", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS).lightLevel((p_235455_0_) -> {
      return 15;
   })));
   public static final RegistryObject<Block> MULMUS_LANTERN_POLISHED = BLOCKS.register("mulmus_lantern_polished", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS).lightLevel((p_235455_0_) -> {
       return 15;
    })));
   
   public static final RegistryObject<Block> INFUSION_TABLE = BLOCKS.register("infusion_table", () -> new InfusionBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.WOOD)));
   
   public static final RegistryObject<Block> DIPPER = BLOCKS.register("dipper", () -> new DipperBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WATER).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.WOOD)));
   
   public static final RegistryObject<Block> DREAM_CATCHER = BLOCKS.register("dream_catcher", () -> new DreamCatcherBlock(BlockBehaviour.Properties.of(Material.GLASS).requiresCorrectToolForDrops().sound(SoundType.GLASS).dynamicShape().noOcclusion()));
   
   public static final RegistryObject<Block> GEODE_ORE = BLOCKS.register("geode_ore", () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST).requiresCorrectToolForDrops().sound(SoundType.STONE)));
   
   //TODO Finish this later
   //public static final RegistryObject<Block> CHASM_SAPLING = BLOCKS.register("chasm_sapling", () -> new SaplingBlock(new ChasmTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

}
