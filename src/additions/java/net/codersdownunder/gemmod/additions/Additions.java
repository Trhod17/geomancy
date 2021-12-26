package net.codersdownunder.gemmod.additions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.codersdownunder.gemmod.additions.init.BlockInit;
import net.codersdownunder.gemmod.additions.init.ItemInit;
import net.codersdownunder.gemmod.additions.utils.AdditionsItemGroup;
import net.codersdownunder.gemmod.additions.init.BlockItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Additions.MODID)
public class Additions
{

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "geomancyadditions";
    
    public static final CreativeModeTab additionsitemtab = new AdditionsItemGroup("additionsitemtab");
    
 public Additions() {
        
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        
        
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        BlockItemInit.BLOCKITEMS.register(bus);
        //ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.serverSpec);
        //ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.clientSpec);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
        
    }
    
    

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
  
    }
}
