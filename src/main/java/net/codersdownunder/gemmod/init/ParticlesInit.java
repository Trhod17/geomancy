//package net.codersdownunder.gemmod.init;
//
//import net.codersdownunder.gemmod.GemMod;
//import net.minecraft.particles.BasicParticleType;
//import net.minecraft.particles.ParticleType;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.fml.RegistryObject;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//
//@Mod.EventBusSubscriber(modid = GemMod.MODID, bus = Bus.MOD, value = Dist.CLIENT)
//public class ParticlesInit
//{
//    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, GemMod.MODID);
//    
//    public static final RegistryObject<BasicParticleType> END_FLAME = PARTICLES.register("end_flame", () -> new BasicParticleType(true));
//    
//    
//    
//}
