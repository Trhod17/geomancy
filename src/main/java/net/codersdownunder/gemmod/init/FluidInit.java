package net.codersdownunder.gemmod.init;

import net.codersdownunder.gemmod.Geomancy;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidInit {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Geomancy.MODID);

    public static final RegistryObject<FlowingFluid> SOURCE_HEALING_WATER = FLUIDS.register("healing_water_fluid",
            () -> new ForgeFlowingFluid.Source(FluidInit.HEALING_WATER_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HEALING_WATER = FLUIDS.register("flowing_healing_water",
            () -> new ForgeFlowingFluid.Flowing(FluidInit.HEALING_WATER_PROPERTIES));


    public static final ForgeFlowingFluid.Properties HEALING_WATER_PROPERTIES = new ForgeFlowingFluid.Properties(
            FluidTypesInit.HEALING_WATER, SOURCE_HEALING_WATER, FLOWING_HEALING_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(BlockInit.HEALING_WATER_BLOCK)
            .bucket(ItemInit.HEALING_WATER_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}