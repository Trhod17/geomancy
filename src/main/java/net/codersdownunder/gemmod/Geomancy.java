package net.codersdownunder.gemmod;

import net.codersdownunder.gemmod.init.*;
import net.codersdownunder.gemmod.world.feature.ModConfiguredFeatures;
import net.codersdownunder.gemmod.world.feature.ModPlacedFeatures;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.codersdownunder.gemmod.client.ClientSetup;
import net.codersdownunder.gemmod.handlers.DreamCatcherEventHandler;
import net.codersdownunder.gemmod.handlers.LogStrippingEvent;
import net.codersdownunder.gemmod.network.GemModNetwork;
import net.codersdownunder.gemmod.utils.GemModItemGroup;
import net.codersdownunder.gemmod.utils.ModVanillaCompat;
import net.codersdownunder.gemmod.utils.TextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.dispenser.ShearsDispenseItemBehavior;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(Geomancy.MODID)
public class Geomancy
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "geomancy";
    
    public static final CreativeModeTab gemsmoditemtab = new GemModItemGroup("gemsmoditemtab");
    public static final CreativeModeTab gemsmodblocktab = new GemModItemGroup("gemmodblocktab");
    
    public static final WoodType CHASM = WoodType.create(new ResourceLocation(MODID, "chasm").toString());
    
    //public static SimpleChannel simpleChannel; 

    //public static final String MESSAGE_PROTOCOL_VERSION = "1.0";

    //public static final ResourceLocation simpleChannelRL = new ResourceLocation(MODID, "gemmodchannel");
    
    public static String find(String name)
	{
		return MODID + ":" + name;
	}

    
    public Geomancy() {
        
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        
        //bus.addListener(RecipeSerializer.class, ModRecipeTypes::registerRecipes);
        
        ItemInit.register(bus);
        BlockInit.register(bus);
        MenuInit.register(bus);
        BlockEntityInit.register(bus);
        RecipeInit.registerSerializers(bus);
        RecipeInit.registerTypes(bus);
        ModConfiguredFeatures.register(bus);
        ModPlacedFeatures.register(bus);


        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.commonSpec);
        //ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.clientSpec);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> bus.addListener(ClientSetup::doClientStuff));
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(LogStrippingEvent.class);
        MinecraftForge.EVENT_BUS.register(DreamCatcherEventHandler.class);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	
    	GemModNetwork.init();
    	
        event.enqueueWork(() -> {
        	WoodType.register(CHASM);
        	DispenserBlock.registerBehavior(ItemInit.DIGGING_CLAW_WOOD.get(), new ShearsDispenseItemBehavior());
        	DispenserBlock.registerBehavior(ItemInit.DIGGING_CLAW_STONE.get(), new ShearsDispenseItemBehavior());
        	DispenserBlock.registerBehavior(ItemInit.DIGGING_CLAW_IRON.get(), new ShearsDispenseItemBehavior());
        	DispenserBlock.registerBehavior(ItemInit.DIGGING_CLAW_GOLD.get(), new ShearsDispenseItemBehavior());
        	DispenserBlock.registerBehavior(ItemInit.DIGGING_CLAW_DIAMOND.get(), new ShearsDispenseItemBehavior());
        	DispenserBlock.registerBehavior(ItemInit.DIGGING_CLAW_NETHERITE.get(), new ShearsDispenseItemBehavior());
        	
        	ModVanillaCompat.compat();
        });
        //VillagerInit.fillTradeData();
        //GeomancyFeatures.initialize();
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
       
    }

    
//    public void onServerStarting(FMLDedicatedServerSetupEvent event) {
//        
//    }
    
   
    
    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent event) {
       
        if (event.getItemStack().getItem() == Items.EMERALD) {
            event.getToolTip().add(TextUtils.FormattedTooltip("tooltip.gem_emerald.text", ChatFormatting.LIGHT_PURPLE));
        }
        
        if (event.getItemStack().getItem() == ItemInit.CONCOCTION_ONE.get()) {
        	event.getToolTip().add(TextUtils.FormattedTooltip("tooltip.concoction.one", ChatFormatting.GREEN));
        }
        
        if (event.getItemStack().getItem() == ItemInit.CONCOCTION_TWO.get()) {
        	event.getToolTip().add(TextUtils.FormattedTooltip("tooltip.concoction.two", ChatFormatting.GREEN));
        }
        
        if (event.getItemStack().getItem() == ItemInit.CONCOCTION_THREE.get()) {
        	event.getToolTip().add(TextUtils.FormattedTooltip("tooltip.concoction.three", ChatFormatting.GREEN));
        }
        
        if (event.getItemStack().getItem() == ItemInit.CONCOCTION_FOUR.get()) {
        	event.getToolTip().add(TextUtils.FormattedTooltip("tooltip.concoction.four", ChatFormatting.GREEN));
        }
    }
    
    
//    public static final PlacementModifierType<RNGPlacement> RNG_DECORATOR = register("rng_initializer", RNGPlacement.CODEC);
//    
//    private static <P extends PlacementModifier> PlacementModifierType<P> register(String name, Codec<P> codec) {
//		return Registry.register(Registry.PLACEMENT_MODIFIERS, name, () -> {
//			return codec;
//		});
//	}
    
    }