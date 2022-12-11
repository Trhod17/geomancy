package net.codersdownunder.gemmod.init;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.fluids.BaseFluidType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class FluidTypesInit {
        public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("minecraft:block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("minecraft:block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("minecraft:block/water_overlay");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Geomancy.MODID);

    public static final RegistryObject<FluidType> HEALING_WATER = register("healing_water",
            FluidType.Properties.create().lightLevel(7).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK).canExtinguish(true));


    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL,
                0xA135E8F5, new Vector3f(161f / 255f, 53f / 255f, 232f / 255f), properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
