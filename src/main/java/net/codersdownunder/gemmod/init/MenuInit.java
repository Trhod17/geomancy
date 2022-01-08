package net.codersdownunder.gemmod.init;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.blocks.dipper.DipperBlockEntity;
import net.codersdownunder.gemmod.blocks.dipper.DipperMenu;
import net.codersdownunder.gemmod.blocks.dream.DreamCatcherMenu;
import net.codersdownunder.gemmod.blocks.infusion.InfusionTableMenu;
import net.codersdownunder.gemmod.blocks.telepad.TelepadMenu;
import net.codersdownunder.gemmod.blocks.terra.TerraFirmaMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuInit
{
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, GemMod.MODID);

    public static final RegistryObject<MenuType<InfusionTableMenu>> INFUSION_TABLE_CONTAINER = CONTAINERS.register("infusion_table", () -> IForgeMenuType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        Level world = inv.player.getCommandSenderWorld();
        return new InfusionTableMenu(windowId, world, pos, inv, inv.player);
    }));
    
    public static final RegistryObject<MenuType<DipperMenu>> DIPPER_CONTAINER = CONTAINERS.register("dipper_container", () -> IForgeMenuType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        Level world = inv.player.getCommandSenderWorld();
        BlockEntity te = inv.player.getCommandSenderWorld().getBlockEntity(pos);
        if(!(te instanceof DipperBlockEntity tile)) {
            return null;
        }
        
        return new DipperMenu(windowId, world, pos, inv, inv.player, tile);
    }));
    
    public static final RegistryObject<MenuType<DreamCatcherMenu>> DREAM_CATCHER_MENU = CONTAINERS.register("dream_catcher_menu", () -> IForgeMenuType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        Level world = inv.player.getCommandSenderWorld();
        return new DreamCatcherMenu(windowId, world, pos, inv, inv.player);
    }));
    
    public static final RegistryObject<MenuType<TelepadMenu>> TELEPAD_MENU = CONTAINERS.register("telepad_menu", () -> IForgeMenuType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        Level world = inv.player.getCommandSenderWorld();
        return new TelepadMenu(windowId, world, pos, inv, inv.player);
    }));
    
    public static final RegistryObject<MenuType<TerraFirmaMenu>> TERRA_FIRMA_MENU = CONTAINERS.register("terra_firma_menu", () -> IForgeMenuType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        Level world = inv.player.getCommandSenderWorld();
        return new TerraFirmaMenu(windowId, world, pos, inv, inv.player);
    }));

}   
