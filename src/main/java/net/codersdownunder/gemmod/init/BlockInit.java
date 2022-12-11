package net.codersdownunder.gemmod.init;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.blocks.endtorch.EndTorchBlock;
import net.codersdownunder.gemmod.blocks.dipper.DipperBlock;
import net.codersdownunder.gemmod.blocks.dream.DreamCatcherBlock;
import net.codersdownunder.gemmod.blocks.endtorch.EndWallTorchBlock;
import net.codersdownunder.gemmod.blocks.infusion.InfusionTableBlock;
import net.codersdownunder.gemmod.blocks.infusionstand.InfusionStandBlock;
import net.codersdownunder.gemmod.blocks.sign.CustomStandingSignBlock;
import net.codersdownunder.gemmod.blocks.sign.CustomWallSignBlock;
import net.codersdownunder.gemmod.blocks.songforge.SongForgeBlock;
import net.codersdownunder.gemmod.blocks.source.SourceBlock;
import net.codersdownunder.gemmod.blocks.telepad.TelepadBlock;
import net.codersdownunder.gemmod.blocks.telepad.TelepadSlab;
import net.codersdownunder.gemmod.blocks.terra.TerraFirmaBlock;
import net.codersdownunder.gemmod.blocks.trellis.TrellisBlock;
import net.codersdownunder.gemmod.world.feature.tree.ChasmTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Geomancy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Geomancy.MODID);
    
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
    
    public static final RegistryObject<Block> CHASM_DOOR = BLOCKS.register("chasm_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
    public static final RegistryObject<Block> CHASM_TRAPDOOR = BLOCKS.register("chasm_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
    
    public static final RegistryObject<Block> CHASM_LEAVES = BLOCKS.register("chasm_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_PURPLE).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()));

    public static final RegistryObject<Block> CHASM_FENCE = BLOCKS.register("chasm_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CHASM_FENCE_GATE = BLOCKS.register("chasm_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN));
    
    public static final RegistryObject<Block> END_LANTERN_BLOCK = BLOCKS.register("end_lantern_block", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().lightLevel((p_235455_0_) -> {
      return 15;
   })));
    
    public static final RegistryObject<Block> CHASM_BUTTON = BLOCKS.register("chasm_button", () -> new ButtonBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission(), 30, true, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON));
    public static final RegistryObject<Block> CHASM_PLATE = BLOCKS.register("chasm_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noCollission(), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
    
    public static final RegistryObject<Block> CHASM_SIGN = BLOCKS.register("chasm_sign", () -> new CustomStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), Geomancy.CHASM));
    public static final RegistryObject<Block> CHASM_SIGN_WALL = BLOCKS.register("chasm_sign_wall", () -> new CustomWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), Geomancy.CHASM));
    
    public static final RegistryObject<Block> MULMUS_LANTERN = BLOCKS.register("mulmus_lantern", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS).lightLevel((p_235455_0_) -> {
      return 15;
   })));
   public static final RegistryObject<Block> MULMUS_LANTERN_POLISHED = BLOCKS.register("mulmus_lantern_polished", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS).lightLevel((p_235455_0_) -> {
       return 15;
    })));
   
   public static final RegistryObject<Block> INFUSION_TABLE = BLOCKS.register("infusion_table", () -> new InfusionTableBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.WOOD)));
   
   public static final RegistryObject<Block> DIPPER = BLOCKS.register("dipper", () -> new DipperBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WATER).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.WOOD)));
   
   public static final RegistryObject<Block> DREAM_CATCHER = BLOCKS.register("dream_catcher", () -> new DreamCatcherBlock(BlockBehaviour.Properties.of(Material.GLASS).requiresCorrectToolForDrops().sound(SoundType.GLASS).dynamicShape().noOcclusion().noCollission()));
   
   public static final RegistryObject<Block> GEODE_ORE = BLOCKS.register("geode_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.AMETHYST).strength(4.5F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
   
   public static final RegistryObject<Block> TELEPAD = BLOCKS.register("telepad", () -> new TelepadBlock(BlockBehaviour.Properties.of(Material.WOOL).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).noOcclusion().lightLevel((p_235447_0_) -> {return 6;})));
   public static final RegistryObject<Block> TELEPAD_SLAB = BLOCKS.register("telepad_slab", () -> new TelepadSlab(BlockBehaviour.Properties.of(Material.WOOL).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).noOcclusion().lightLevel((p_235447_0_) -> {return 6;})));
   
   public static final RegistryObject<Block> TERRA_FIRMA = BLOCKS.register("terra_firma", () -> new TerraFirmaBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
   
   public static final RegistryObject<Block> INFUSION_STAND = BLOCKS.register("infusion_stand", () -> new InfusionStandBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.WOOD)));
   
   public static final RegistryObject<Block> TREADSTONE_1 = BLOCKS.register("treadstone_1", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_2 = BLOCKS.register("treadstone_2", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_3 = BLOCKS.register("treadstone_3", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_4 = BLOCKS.register("treadstone_4", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_5 = BLOCKS.register("treadstone_5", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_6 = BLOCKS.register("treadstone_6", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_7 = BLOCKS.register("treadstone_7", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   
   public static final RegistryObject<Block> TREADSTONE_SLAB_1 = BLOCKS.register("treadstone_slab_1", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_SLAB_2 = BLOCKS.register("treadstone_slab_2", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_SLAB_3 = BLOCKS.register("treadstone_slab_3", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_SLAB_4 = BLOCKS.register("treadstone_slab_4", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_SLAB_5 = BLOCKS.register("treadstone_slab_5", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_SLAB_6 = BLOCKS.register("treadstone_slab_6", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_SLAB_7 = BLOCKS.register("treadstone_slab_7", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   
   public static final RegistryObject<Block> TREADSTONE_STAIR_1 = BLOCKS.register("treadstone_stair_1", () -> new StairBlock(() -> TREADSTONE_1.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_STAIR_2 = BLOCKS.register("treadstone_stair_2", () -> new StairBlock(() -> TREADSTONE_2.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_STAIR_3 = BLOCKS.register("treadstone_stair_3", () -> new StairBlock(() -> TREADSTONE_3.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_STAIR_4 = BLOCKS.register("treadstone_stair_4", () -> new StairBlock(() -> TREADSTONE_4.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_STAIR_5 = BLOCKS.register("treadstone_stair_5", () -> new StairBlock(() -> TREADSTONE_5.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_STAIR_6 = BLOCKS.register("treadstone_stair_6", () -> new StairBlock(() -> TREADSTONE_6.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_STAIR_7 = BLOCKS.register("treadstone_stair_7", () -> new StairBlock(() -> TREADSTONE_7.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   
   public static final RegistryObject<Block> TREADSTONE_CARPET_1 = BLOCKS.register("treadstone_carpet_1", () -> new CarpetBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_CARPET_2 = BLOCKS.register("treadstone_carpet_2", () -> new CarpetBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_CARPET_3 = BLOCKS.register("treadstone_carpet_3", () -> new CarpetBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_CARPET_4 = BLOCKS.register("treadstone_carpet_4", () -> new CarpetBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_CARPET_5 = BLOCKS.register("treadstone_carpet_5", () -> new CarpetBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_CARPET_6 = BLOCKS.register("treadstone_carpet_6", () -> new CarpetBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   public static final RegistryObject<Block> TREADSTONE_CARPET_7 = BLOCKS.register("treadstone_carpet_7", () -> new CarpetBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).speedFactor(1.2F)));
   
   public static final RegistryObject<Block> SONG_FORGE = BLOCKS.register("song_forge", () -> new SongForgeBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().sound(SoundType.STONE).randomTicks()));
   public static final RegistryObject<Block> TRELLIS = BLOCKS.register("trellis", () -> new TrellisBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion()));
   public static final RegistryObject<Block> TRELLIS_MOSS = BLOCKS.register("trellis_moss", () -> new TrellisBlock(BlockBehaviour.Properties.of(Material.MOSS, MaterialColor.WOOD).strength(2.0F, 3.0F).randomTicks().sound(SoundType.WOOD).requiresCorrectToolForDrops().noOcclusion()));
   public static final RegistryObject<Block> TRELLIS_CAVE_VINES = BLOCKS.register("trellis_cave_vines", () -> new TrellisBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.WOOD).strength(2.0F, 3.0F).randomTicks().requiresCorrectToolForDrops().sound(SoundType.WOOD).noOcclusion()));
   public static final RegistryObject<Block> TRELLIS_LICHEN = BLOCKS.register("trellis_lichen", () -> new TrellisBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.WOOD).strength(2.0F, 3.0F).randomTicks().sound(SoundType.WOOD).noOcclusion().requiresCorrectToolForDrops().lightLevel((p_235447_0_) -> {return 7;})));
   public static final RegistryObject<Block> TRELLIS_VINE = BLOCKS.register("trellis_vine", () -> new TrellisBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.WOOD).strength(2.0F, 3.0F).randomTicks().requiresCorrectToolForDrops().sound(SoundType.WOOD).noOcclusion()));
   public static final RegistryObject<Block> TRELLIS_CHORUS = BLOCKS.register("trellis_chorus", () -> new TrellisBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.WOOD).strength(2.0F, 3.0F).randomTicks().requiresCorrectToolForDrops().sound(SoundType.WOOD).noOcclusion()));
   public static final RegistryObject<Block> TRELLIS_CRIMSON = BLOCKS.register("trellis_crimson", () -> new TrellisBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.WOOD).strength(2.0F, 3.0F).randomTicks().requiresCorrectToolForDrops().sound(SoundType.WOOD).noOcclusion()));
   public static final RegistryObject<Block> TRELLIS_WARP = BLOCKS.register("trellis_warp", () -> new TrellisBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.WOOD).strength(2.0F, 3.0F).randomTicks().requiresCorrectToolForDrops().sound(SoundType.WOOD).noOcclusion()));

   public static final RegistryObject<Block> CHASM_SAPLING = BLOCKS.register("chasm_sapling", () -> new SaplingBlock(new ChasmTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)){
       @Override
       public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
           Block block = state.getBlock();

           if (block == Blocks.END_STONE) return true;
           return false;
       }

       @Override
       protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
           Block block = pState.getBlock();

           if (block == Blocks.END_STONE) return true;
           return false;
       }
   });

   public static final RegistryObject<Block> END_TORCH = BLOCKS.register("end_torch", () -> new EndTorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((p_50886_) -> {
       return 14;
   }).sound(SoundType.WOOD)));
   public static final RegistryObject<Block> WALL_END_TORCH = BLOCKS.register("wall_end_torch", () -> new EndWallTorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((p_50886_) -> {
       return 14;
   }).sound(SoundType.WOOD)));

    public static final RegistryObject<LiquidBlock> HEALING_WATER_BLOCK = BLOCKS.register("healing_water_block",
            () -> new LiquidBlock(FluidInit.SOURCE_HEALING_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)){
                @Override
                public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {

                    if (pEntity instanceof LivingEntity) {
                        if (pState.is(BlockInit.HEALING_WATER_BLOCK.get())) {
                            ((LivingEntity) pEntity).addEffect(new MobEffectInstance(MobEffects.REGENERATION));
                        }
                    }
                }

            });

    public static final RegistryObject<Block> INFINITE_SOURCE_WATER = BLOCKS.register("infinite_source_water", () -> new SourceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(10, 15), Fluids.WATER));


    //TODO Finish this later
//   public static final RegistryObject<Block> SCORCH = BLOCKS.register("scorch", () -> new ScorchBlock(BlockBehaviour.Properties.of(Material.FIRE, MaterialColor.FIRE).noCollission().instabreak().lightLevel((p_152605_) -> {
//       return 15;
//   }).sound(SoundType.WOOL)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
