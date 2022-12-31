package net.codersdownunder.gemmod.additions.tabs;

import net.codersdownunder.gemmod.additions.Additions;
import net.codersdownunder.gemmod.additions.init.BlockItemInit;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CreativeTabEvents {
    public static CreativeModeTab TAB_GEOMANCY_ADDITIONS;
    @SubscribeEvent
    public static void onCreativeModeTabRegister(CreativeModeTabEvent.Register event) {
        TAB_GEOMANCY_ADDITIONS = event.registerCreativeModeTab(new ResourceLocation(Additions.MODID, "geomancy_additions"),
                builder -> builder
                .icon(() -> new ItemStack(BlockItemInit.PURPUR_PILLAR_WALL.get())).displayItems((features, output, hasPermissions) -> {
                    output.accept(new ItemStack(BlockItemInit.PURPUR_PILLAR_WALL.get()));
                    output.accept(new ItemStack(BlockItemInit.PURPUR_WALL.get()));
                    output.accept(new ItemStack(BlockItemInit.PRISMARINE_BRICKS_WALL.get()));
                    output.accept(new ItemStack(BlockItemInit.DARK_PRISMARINE_WALL.get()));
                })
                .title(Component.translatable("tab_additions_blocks.text"))
                .build());

    }

}