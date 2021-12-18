package net.codersdownunder.gemmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.codersdownunder.gemmod.blocks.dipper.DipperBlockEntityRenderer;
import net.codersdownunder.gemmod.blocks.dipper.DipperScreen;
import net.codersdownunder.gemmod.blocks.infusion.InfusionTableScreen;
import net.codersdownunder.gemmod.crafting.recipe.ModRecipeTypes;
import net.codersdownunder.gemmod.handlers.LogStrippingEvent;
import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.BlockItemInit;
import net.codersdownunder.gemmod.init.ContainerInit;
import net.codersdownunder.gemmod.init.ItemInit;
import net.codersdownunder.gemmod.init.TileEntityInit;
import net.codersdownunder.gemmod.network.GemModNetwork;
import net.codersdownunder.gemmod.utils.GemModItemGroup;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
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
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(LogStrippingEvent.class);
        
    }
    
    

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {   
        WoodType.register(CHASM);
        });
        

        GemModNetwork.init();

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
  
        MenuScreens.register(ContainerInit.INFUSION_TABLE_CONTAINER.get(), InfusionTableScreen::new);
        MenuScreens.register(ContainerInit.DIPPER_CONTAINER.get(), DipperScreen::new);
        
        RenderType GppRender = RenderType.cutoutMipped();
       
        //RenderTypeLookup.setRenderLayer(BlockInit.CHASM_LEAVES.get(), RenderType.cutoutMipped());
        
        event.enqueueWork(() -> {
        ItemBlockRenderTypes.setRenderLayer(BlockInit.END_LANTERN.get(), GppRender);
        ItemBlockRenderTypes.setRenderLayer(BlockInit.INFUSION_TABLE.get(), GppRender);
        ItemBlockRenderTypes.setRenderLayer(BlockInit.CHASM_LEAVES.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.DIPPER.get(), RenderType.cutout());
        
        });
        
        BlockEntityRenderers.register(TileEntityInit.CUSTOM_SIGN.get(), SignRenderer::new);
        event.enqueueWork(() -> {
            Sheets.addWoodType(CHASM);
        });
        
        BlockEntityRenderers.register(TileEntityInit.DIPPER_BE.get(), DipperBlockEntityRenderer::new);
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
    
   
    
    @Mod.EventBusSubscriber(modid = MODID, bus = Bus.MOD)
    public static class ModEventBusSubscriber {
        
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            //final IForgeRegistry<Item> registry = event.getRegistry();
            /*BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)
                    .forEach(block -> {
                        final Item.Properties properties = new Item.Properties().tab(gemsmodblocktab);
                        final BlockItem blockItem = new BlockItem(block, properties);
                        blockItem.setRegistryName(block.getRegistryName());
                        registry.register(blockItem);
                    });*/
        }   
    }
}