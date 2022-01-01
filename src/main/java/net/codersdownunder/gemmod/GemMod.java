package net.codersdownunder.gemmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.serialization.Codec;

import net.codersdownunder.gemmod.crafting.recipe.ModRecipeTypes;
import net.codersdownunder.gemmod.handlers.DreamCatcherEventHandler;
import net.codersdownunder.gemmod.handlers.LogStrippingEvent;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.BlockItemInit;
import net.codersdownunder.gemmod.init.ContainerInit;
import net.codersdownunder.gemmod.init.ItemInit;
import net.codersdownunder.gemmod.init.TileEntityInit;
import net.codersdownunder.gemmod.init.VillagerInit;
import net.codersdownunder.gemmod.network.GemModNetwork;
import net.codersdownunder.gemmod.setup.ClientSetup;
import net.codersdownunder.gemmod.utils.GemModItemGroup;
import net.codersdownunder.gemmod.world.WorldGenerationEvents;
import net.codersdownunder.gemmod.world.decorators.RNGPlacement;
import net.codersdownunder.gemmod.world.features.GeomancyFeatures;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
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
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(GemMod.MODID)
public class GemMod
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
    
    public GemMod() {
        
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        
        bus.addGenericListener(RecipeSerializer.class, ModRecipeTypes::registerRecipes);
        
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        BlockItemInit.BLOCKITEMS.register(bus);
        ContainerInit.CONTAINERS.register(bus);
        TileEntityInit.TILE_ENTITIES.register(bus);
        VillagerInit.POINT_OF_INTEREST_TYPES.register(bus);
        VillagerInit.VILLAGER_PROFESSIONS.register(bus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.serverSpec);
        //ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.clientSpec);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> bus.addListener(ClientSetup::doClientStuff));
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(LogStrippingEvent.class);
        MinecraftForge.EVENT_BUS.register(DreamCatcherEventHandler.class);
        MinecraftForge.EVENT_BUS.register(new WorldGenerationEvents());

 
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	
    	GemModNetwork.init();
    	
        event.enqueueWork(() -> {
        	WoodType.register(CHASM);
        });
        VillagerInit.fillTradeData();
        GeomancyFeatures.initialize();
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
       
    }

    @SubscribeEvent
    public void onServerStarting(FMLDedicatedServerSetupEvent event) {
        
    }
    
    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent event) {
       
        if (event.getItemStack().getItem() == Items.EMERALD) {
            event.getToolTip().add(new TranslatableComponent("tooltip.gem_emerald.text").withStyle(ChatFormatting.LIGHT_PURPLE));
        }
        
        if (event.getItemStack().getItem() == ItemInit.CONCOCTION_ONE.get()) {
        	event.getToolTip().add(new TranslatableComponent("tooltip.concoction.one").withStyle(ChatFormatting.GREEN));
        }
        
        if (event.getItemStack().getItem() == ItemInit.CONCOCTION_TWO.get()) {
        	event.getToolTip().add(new TranslatableComponent("tooltip.concoction.two").withStyle(ChatFormatting.GREEN));
        }
        
        if (event.getItemStack().getItem() == ItemInit.CONCOCTION_THREE.get()) {
        	event.getToolTip().add(new TranslatableComponent("tooltip.concoction.three").withStyle(ChatFormatting.GREEN));
        }
        
        if (event.getItemStack().getItem() == ItemInit.CONCOCTION_FOUR.get()) {
        	event.getToolTip().add(new TranslatableComponent("tooltip.concoction.four").withStyle(ChatFormatting.GREEN));
        }
    }
    
    
    public static final PlacementModifierType<RNGPlacement> RNG_DECORATOR = register("rng_initializer", RNGPlacement.CODEC);
    
    private static <P extends PlacementModifier> PlacementModifierType<P> register(String name, Codec<P> codec) {
		return Registry.register(Registry.PLACEMENT_MODIFIERS, name, () -> {
			return codec;
		});
	}
    
    }