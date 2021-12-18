package net.codersdownunder.gemmod.network;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.network.messages.InfusionCraftingMessage;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class GemModNetwork
{

    public static final String NETWORK_VERSION = "1";

    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(GemMod.MODID, "network"), () -> NETWORK_VERSION,
            version -> version.equals(NETWORK_VERSION), version -> version.equals(NETWORK_VERSION));
    
    public static void init() {
        CHANNEL.registerMessage(34, InfusionCraftingMessage.class, InfusionCraftingMessage::encode, InfusionCraftingMessage::decode, InfusionCraftingMessage::handle);
  
    }

}
