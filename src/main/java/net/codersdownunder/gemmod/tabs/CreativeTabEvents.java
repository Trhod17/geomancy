package net.codersdownunder.gemmod.tabs;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.BlockItemInit;
import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CreativeTabEvents {
    public static CreativeModeTab TAB_GEOMANCY_BLOCKS;
    public static CreativeModeTab TAB_GEOMANCY_ITEMS;

    @SubscribeEvent
    public static void onCreativeModeTabRegister(CreativeModeTabEvent.Register event) {
        TAB_GEOMANCY_BLOCKS = event.registerCreativeModeTab(new ResourceLocation(Geomancy.MODID, "geomancy_blocks"), builder -> {
            builder
                    .icon(() -> new ItemStack(BlockItemInit.SONG_FORGE.get())).displayItems((features, output, hasPermissions) -> {
                        output.accept(new ItemStack(BlockItemInit.CHASM_BUTTON.get()));
                        output.accept(new ItemStack(BlockItemInit.CHASM_DOOR.get()));
                        output.accept(new ItemStack(BlockItemInit.CHASM_FENCE.get()));
                        output.accept(new ItemStack(BlockItemInit.CHASM_FENCE_GATE.get()));
                        output.accept(new ItemStack(BlockItemInit.CHASM_LOG.get()));
                        output.accept(new ItemStack(BlockItemInit.CHASM_LEAVES.get()));
                        output.accept(new ItemStack(BlockItemInit.CHASM_LOG_BARK.get()));
                        output.accept(new ItemStack(BlockItemInit.CHASM_LOG_STRIPPED.get()));
                        output.accept(new ItemStack(BlockItemInit.CHASM_LOG_STRIPPED_BARK.get()));
                        output.accept(new ItemStack(BlockItemInit.CHASM_PLANKS.get()));
                        output.accept(new ItemStack(BlockItemInit.CHASM_PLATE.get()));
                        output.accept(new ItemStack(BlockItemInit.CHASM_SAPLING.get()));
                        output.accept(new ItemStack(BlockItemInit.CHASM_SIGN.get()));
                        output.accept(new ItemStack(BlockItemInit.CHASM_SLAB.get()));
                        output.accept(new ItemStack(BlockItemInit.CHASM_STAIRS.get()));
                        output.accept(new ItemStack(BlockItemInit.CHASM_TRAPDOOR.get()));
                        output.accept(new ItemStack(BlockItemInit.DIPPER.get()));
                        output.accept(new ItemStack(BlockItemInit.DREAM_CATCHER.get()));
                        output.accept(new ItemStack(BlockItemInit.END_LANTERN.get()));
                        output.accept(new ItemStack(BlockItemInit.END_LANTERN_BLOCK.get()));
                        output.accept(new ItemStack(BlockItemInit.END_TORCH.get()));
                        output.accept(new ItemStack(BlockItemInit.GEODE_ORE.get()));
                        output.accept(new ItemStack(BlockItemInit.INFINITE_SOURCE_WATER.get()));
                        output.accept(new ItemStack(BlockItemInit.INFUSION_STAND.get()));
                        output.accept(new ItemStack(BlockItemInit.INFUSION_TABLE.get()));
                        output.accept(new ItemStack(BlockItemInit.MULMUS_LANTERN.get()));
                        output.accept(new ItemStack(BlockItemInit.MULMUS_LANTERN_POLISHED.get()));
                        output.accept(new ItemStack(BlockItemInit.SONG_FORGE.get()));
                        output.accept(new ItemStack(BlockItemInit.TELEPAD.get()));
                        output.accept(new ItemStack(BlockItemInit.TELEPAD_SLAB.get()));
                        output.accept(new ItemStack(BlockItemInit.TERRA_FIRMA.get()));

                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_1.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_2.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_3.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_4.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_5.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_6.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_7.get()));

                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_CARPET_1.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_CARPET_2.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_CARPET_3.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_CARPET_4.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_CARPET_5.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_CARPET_6.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_CARPET_7.get()));

                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_STAIR_1.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_STAIR_2.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_STAIR_3.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_STAIR_4.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_STAIR_5.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_STAIR_6.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_STAIR_7.get()));

                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_SLAB_1.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_SLAB_2.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_SLAB_3.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_SLAB_4.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_SLAB_5.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_SLAB_6.get()));
                        output.accept(new ItemStack(BlockItemInit.TREADSTONE_SLAB_7.get()));

                        output.accept(new ItemStack(BlockItemInit.TRELLIS.get()));

                    })
                    .title(Component.translatable("tab_geomancy_blocks.text"))
                    .build();
        });

        TAB_GEOMANCY_ITEMS = event.registerCreativeModeTab(new ResourceLocation(Geomancy.MODID, "geomancy_items"), builder -> {
            builder
                    .icon(() -> new ItemStack(ItemInit.DIGGING_CLAW_DIAMOND.get())).displayItems((features, output, hasPermissions) -> {
                        output.accept(new ItemStack(ItemInit.DIGGING_CLAW_NETHERITE.get()));
                        output.accept(new ItemStack(ItemInit.DIGGING_CLAW_DIAMOND.get()));
                        output.accept(new ItemStack(ItemInit.DIGGING_CLAW_GOLD.get()));
                        output.accept(new ItemStack(ItemInit.DIGGING_CLAW_IRON.get()));
                        output.accept(new ItemStack(ItemInit.DIGGING_CLAW_STONE.get()));
                        output.accept(new ItemStack(ItemInit.DIGGING_CLAW_WOOD.get()));

                        output.accept(new ItemStack(ItemInit.AGATE.get()));
                        output.accept(new ItemStack(ItemInit.CHRYSOCOLLA.get()));
                        output.accept(new ItemStack(ItemInit.CHAROITE.get()));
                        output.accept(new ItemStack(ItemInit.CITRINE.get()));
                        output.accept(new ItemStack(ItemInit.MALACHITE.get()));
                        output.accept(new ItemStack(ItemInit.JADE.get()));
                        output.accept(new ItemStack(ItemInit.PERIDOT.get()));
                        output.accept(new ItemStack(ItemInit.TOPAZ.get()));
                        output.accept(new ItemStack(ItemInit.CITRINE.get()));
                        output.accept(new ItemStack(ItemInit.JASPER.get()));
                        output.accept(new ItemStack(ItemInit.RUBY.get()));
                        output.accept(new ItemStack(ItemInit.GARNET.get()));
                        output.accept(new ItemStack(ItemInit.AMETHYST.get()));
                        output.accept(new ItemStack(ItemInit.SPINEL.get()));
                        output.accept(new ItemStack(ItemInit.SAPPHIRE.get()));
                        output.accept(new ItemStack(ItemInit.LILYSTAR.get()));
                        output.accept(new ItemStack(ItemInit.ONYX.get()));
                        output.accept(new ItemStack(ItemInit.SPHENE.get()));
                        output.accept(new ItemStack(ItemInit.RHODONITE.get()));

                        output.accept(new ItemStack(ItemInit.AGATE_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.CHRYSOCOLLA_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.CHAROITE_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.CITRINE_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.MALACHITE_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.JADE_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.PERIDOT_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.TOPAZ_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.CITRINE_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.JASPER_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.RUBY_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.GARNET_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.AMETHYST_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.SPINEL_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.SAPPHIRE_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.LILYSTAR_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.ONYX_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.SPHENE_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.RHODONITE_DREAMING.get()));
                        output.accept(new ItemStack(ItemInit.EMERALD_DREAMING.get()));

                        output.accept(new ItemStack(ItemInit.MULMUS_BULB.get()));
                        output.accept(new ItemStack(ItemInit.CONCOCTION_ONE.get()));
                        output.accept(new ItemStack(ItemInit.CONCOCTION_TWO.get()));
                        output.accept(new ItemStack(ItemInit.CONCOCTION_THREE.get()));
                        output.accept(new ItemStack(ItemInit.CONCOCTION_FOUR.get()));
                        output.accept(new ItemStack(ItemInit.GEODE.get()));
                        output.accept(new ItemStack(ItemInit.RICH_GEODE.get()));
                        output.accept(new ItemStack(ItemInit.SPARSE_GEODE.get()));
                        output.accept(new ItemStack(ItemInit.TELE_CORE.get()));
                        output.accept(new ItemStack(ItemInit.CATCHER_RING.get()));
                        output.accept(new ItemStack(ItemInit.DREAM_DUST.get()));
                        output.accept(new ItemStack(ItemInit.EMPTY_DISK.get()));
                        output.accept(new ItemStack(ItemInit.CONCENTRATION.get()));
                        output.accept(new ItemStack(ItemInit.NETHERRITE_NUGGET.get()));
                        output.accept(new ItemStack(ItemInit.EMPTY_TOTEM.get()));
                        output.accept(new ItemStack(ItemInit.NETHER_CRUX.get()));
                        output.accept(new ItemStack(ItemInit.ROSE_QUARTZ.get()));
                        output.accept(new ItemStack(ItemInit.PLATE_DING.get()));
                        output.accept(new ItemStack(ItemInit.PLATE_FAILSAFE.get()));
                        output.accept(new ItemStack(ItemInit.PLATE_FUEL_COAL.get()));
                        output.accept(new ItemStack(ItemInit.PLATE_FUEL_TIME.get()));
                        output.accept(new ItemStack(ItemInit.PLATE_SPEED_UP.get()));
                        output.accept(new ItemStack(ItemInit.ROSE_QUARTZ.get()));
                        output.accept(new ItemStack(ItemInit.PLATE_SPEED_OVERDRIVE.get()));
                        output.accept(new ItemStack(ItemInit.PLATE_YIELD_ORE.get()));
                        output.accept(new ItemStack(ItemInit.HEALING_WATER_BUCKET.get()));
                        output.accept(new ItemStack(ItemInit.CUPID_ARROW.get()));





                    })
                    .title(Component.translatable("tab_geomancy_items.text"))
                    .build();
        });
    }

}