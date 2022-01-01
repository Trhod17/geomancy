package net.codersdownunder.gemmod.network;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.network.messages.InfusionCraftingMessage;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public final class GemModNetwork
{

    public static final String NETWORK_VERSION = "1";

    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(GemMod.MODID, "geomancy"), () -> NETWORK_VERSION,
            NETWORK_VERSION::equals, NETWORK_VERSION::equals);
    
    private GemModNetwork() {
    	
    }
    
    public static void init() {
    	int index = 0;
        CHANNEL.messageBuilder(InfusionCraftingMessage.class, index++, NetworkDirection.PLAY_TO_SERVER)
        .encoder(InfusionCraftingMessage::encode).decoder(InfusionCraftingMessage::new).consumer(InfusionCraftingMessage::handle).add();
  
    }
   

}
