package net.codersdownunder.gemmod.additions.init;

import net.codersdownunder.gemmod.additions.Additions;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit
{
   public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Additions.MODID);
   
   public static final RegistryObject<Block> PURPUR_WALL = BLOCKS.register("purpur_wall", () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 4.0F).sound(SoundType.STONE)));
   public static final RegistryObject<Block> PURPUR_PILLAR_WALL = BLOCKS.register("purpur_pillar_wall", () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 4.0F).sound(SoundType.STONE)));
   
   public static final RegistryObject<Block> PRISMARINE_BRICKS_WALL = BLOCKS.register("prismarine_bricks_wall", () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 4.0F).sound(SoundType.STONE)));
   public static final RegistryObject<Block> DARK_PRISMARINE_WALL = BLOCKS.register("dark_prismarine_wall", () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 4.0F).sound(SoundType.STONE)));
}
