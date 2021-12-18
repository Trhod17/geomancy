package net.codersdownunder.gemmod.init;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.blocks.dipper.DipperBlockEntity;
import net.codersdownunder.gemmod.blocks.dipper.DipperContainer;
import net.codersdownunder.gemmod.blocks.infusion.InfusionTableContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ContainerInit
{
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, GemMod.MODID);

    public static final RegistryObject<MenuType<InfusionTableContainer>> INFUSION_TABLE_CONTAINER = CONTAINERS.register("infusion_table", () -> IForgeMenuType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        Level world = inv.player.getCommandSenderWorld();
        return new InfusionTableContainer(windowId, world, pos, inv, inv.player);
    }));
    
    public static final RegistryObject<MenuType<DipperContainer>> DIPPER_CONTAINER = CONTAINERS.register("dipper_container", () -> IForgeMenuType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        Level world = inv.player.getCommandSenderWorld();
        BlockEntity te = inv.player.getCommandSenderWorld().getBlockEntity(pos);
        if(!(te instanceof DipperBlockEntity tile)) {
            return null;
        }
        
        return new DipperContainer(windowId, world, pos, inv, inv.player, tile);
    }));

}   
