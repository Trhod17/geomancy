package net.codersdownunder.gemmod.init;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.blocks.dipper.DipperBlockEntity;
import net.codersdownunder.gemmod.blocks.dream.DreamCatcherBlockEntity;
import net.codersdownunder.gemmod.blocks.infusion.InfusionTableBlockEntity;
import net.codersdownunder.gemmod.blocks.infusionstand.InfusionStandBlockEntity;
import net.codersdownunder.gemmod.blocks.sign.CustomSignBlockEntity;
import net.codersdownunder.gemmod.blocks.songforge.SongForgeBlockEntity;
import net.codersdownunder.gemmod.blocks.source.SourceBlockEntity;
import net.codersdownunder.gemmod.blocks.telepad.TelepadBlockEntity;
import net.codersdownunder.gemmod.blocks.terra.TerraFirmaBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Geomancy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockEntityInit
{
    
    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Geomancy.MODID);
    
    public static RegistryObject<BlockEntityType<CustomSignBlockEntity>> CUSTOM_SIGN = BLOCK_ENTITIES.register("custom_sign", () -> BlockEntityType.Builder.of(CustomSignBlockEntity::new, BlockInit.CHASM_SIGN_WALL.get(), BlockInit.CHASM_SIGN.get()).build(null));
    public static RegistryObject<BlockEntityType<InfusionTableBlockEntity>> INFUSION_TABLE = BLOCK_ENTITIES.register("infusion_table",() -> BlockEntityType.Builder.of(InfusionTableBlockEntity::new, BlockInit.INFUSION_TABLE.get()).build(null));
    public static RegistryObject<BlockEntityType<DipperBlockEntity>> DIPPER_BE = BLOCK_ENTITIES.register("dipper_be", () -> BlockEntityType.Builder.of(DipperBlockEntity::new, BlockInit.DIPPER.get()).build(null));
    public static RegistryObject<BlockEntityType<DreamCatcherBlockEntity>> DREAM_CATCHER_BE = BLOCK_ENTITIES.register("dream_catcher_be", () -> BlockEntityType.Builder.of(DreamCatcherBlockEntity::new, BlockInit.DREAM_CATCHER.get()).build(null));
    public static RegistryObject<BlockEntityType<TelepadBlockEntity>> TELEPAD_BE = BLOCK_ENTITIES.register("telepad_be", () -> BlockEntityType.Builder.of(TelepadBlockEntity::new, BlockInit.TELEPAD.get(), BlockInit.TELEPAD_SLAB.get()).build(null));
    
    public static RegistryObject<BlockEntityType<SongForgeBlockEntity>> SONG_FORGE_BE = BLOCK_ENTITIES.register("song_forge_be", () -> BlockEntityType.Builder.of(SongForgeBlockEntity::new, BlockInit.SONG_FORGE.get()).build(null));
    
    //Non-Functional
    public static RegistryObject<BlockEntityType<TerraFirmaBlockEntity>> TERRA_FIRMA_BE = BLOCK_ENTITIES.register("terra_firma_be", () -> BlockEntityType.Builder.of(TerraFirmaBlockEntity::new, BlockInit.TERRA_FIRMA.get()).build(null));
    public static RegistryObject<BlockEntityType<InfusionStandBlockEntity>> INFUSION_STAND_BE = BLOCK_ENTITIES.register("infusion_stand_be",() -> BlockEntityType.Builder.of(InfusionStandBlockEntity::new, BlockInit.INFUSION_STAND.get()).build(null));

    public static RegistryObject<BlockEntityType<SourceBlockEntity>> SOURCE_BE = BLOCK_ENTITIES.register("source_be", () -> BlockEntityType.Builder.of(SourceBlockEntity::new, BlockInit.INFINITE_SOURCE_WATER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
