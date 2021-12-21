package net.codersdownunder.gemmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.codersdownunder.gemmod.crafting.recipe.ModRecipeTypes;
import net.codersdownunder.gemmod.handlers.LogStrippingEvent;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.BlockItemInit;
import net.codersdownunder.gemmod.init.ContainerInit;
import net.codersdownunder.gemmod.init.ItemInit;
import net.codersdownunder.gemmod.init.TileEntityInit;
import net.codersdownunder.gemmod.network.GemModNetwork;
import net.codersdownunder.gemmod.setup.ClientSetup;
import net.codersdownunder.gemmod.utils.GemModItemGroup;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
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
       ///ParticlesInit.PARTICLES.register(bus);
        
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the doClientStuff method for modloading
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> bus.addListener(ClientSetup::doClientStuff));
       
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(LogStrippingEvent.class);
        
        
        
    }
    
    

    private void setup(final FMLCommonSetupEvent event)
    {
    	
    	GemModNetwork.init();
    	
        event.enqueueWork(() -> {
        	WoodType.register(CHASM);
        });

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
}