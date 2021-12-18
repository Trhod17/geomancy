package net.codersdownunder.gemmod.network.messages;

import java.util.function.Supplier;

import net.codersdownunder.gemmod.blocks.infusion.InfusionTableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

public class InfusionCraftingMessage
{

    private static BlockPos pos;

    public InfusionCraftingMessage() {}
    

    public InfusionCraftingMessage(BlockPos pos)
    {
        InfusionCraftingMessage.pos = pos;
    }

    
    public static void encode(InfusionCraftingMessage message, FriendlyByteBuf buffer)
    {
        buffer.writeBlockPos(pos);
    }

    
    public static InfusionCraftingMessage decode(FriendlyByteBuf buffer)
    {
        return new InfusionCraftingMessage(buffer.readBlockPos());
    }
    

    @SuppressWarnings("static-access")
    public static void handle(InfusionCraftingMessage message, Supplier<NetworkEvent.Context> supplier)
    {
        supplier.get().enqueueWork(() ->
        {
           ServerPlayer player = supplier.get().getSender();
           if (player != null) {
               Level world = player.getCommandSenderWorld();
               BlockEntity tile = world.getBlockEntity(message.pos);
               if (tile instanceof InfusionTableBlockEntity) {
                   InfusionTableBlockEntity table = (InfusionTableBlockEntity) tile;
                   
                   table.craft();
               }
           }
           //InfusionTableContainer.id = getContainerId();
           
        });
        supplier.get().setPacketHandled(true);
    }
   
}

