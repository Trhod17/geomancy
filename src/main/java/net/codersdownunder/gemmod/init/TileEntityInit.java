package net.codersdownunder.gemmod.init;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.blocks.dipper.DipperBlockEntity;
import net.codersdownunder.gemmod.blocks.dream.DreamCatcherBlockEntity;
import net.codersdownunder.gemmod.blocks.infusion.InfusionTableBlockEntity;
import net.codersdownunder.gemmod.blocks.sign.CustomSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TileEntityInit
{
    
    public static DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, GemMod.MODID);
    
    public static RegistryObject<BlockEntityType<CustomSignBlockEntity>> CUSTOM_SIGN = TILE_ENTITIES.register("custom_sign", () -> BlockEntityType.Builder.of(CustomSignBlockEntity::new, BlockInit.CHASM_SIGN_WALL.get(), BlockInit.CHASM_SIGN.get()).build(null));
    public static RegistryObject<BlockEntityType<InfusionTableBlockEntity>> INFUSION_TABLE = TILE_ENTITIES.register("infusion_table",() -> BlockEntityType.Builder.of(InfusionTableBlockEntity::new, BlockInit.INFUSION_TABLE.get()).build(null));
    public static RegistryObject<BlockEntityType<DipperBlockEntity>> DIPPER_BE = TILE_ENTITIES.register("dipper_be", () -> BlockEntityType.Builder.of(DipperBlockEntity::new, BlockInit.DIPPER.get()).build(null));
    public static RegistryObject<BlockEntityType<DreamCatcherBlockEntity>> DREAM_CATCHER_BE = TILE_ENTITIES.register("dream_catcher_be", () -> BlockEntityType.Builder.of(DreamCatcherBlockEntity::new, BlockInit.DREAM_CATCHER.get()).build(null));
}
