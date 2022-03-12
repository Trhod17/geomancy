package net.codersdownunder.gemmod.network.messages;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

import net.codersdownunder.gemmod.blocks.infusion.InfusionTableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

public class InfusionCraftingMessage
{

    private final BlockPos pos;


    public InfusionCraftingMessage(BlockPos pos)
    {
        this.pos = pos;
    }
    
    public InfusionCraftingMessage(FriendlyByteBuf buffer) {
    	this(buffer.readBlockPos());
    }

    
    public void encode(FriendlyByteBuf buffer)
    {
        buffer.writeBlockPos(this.pos);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier)
    {
    	final var success = new AtomicBoolean(false);
        supplier.get().enqueueWork(() ->
        {
           ServerPlayer player = supplier.get().getSender();
           if (player != null) {
               //Level world = player.getCommandSenderWorld();
               BlockEntity tile = supplier.get().getSender().level.getBlockEntity(pos);
               if (tile instanceof InfusionTableBlockEntity) {
                   InfusionTableBlockEntity table = (InfusionTableBlockEntity) tile;
                   
                   table.craft();
                   success.set(true);
               }
           }
           //InfusionTableContainer.id = getContainerId();
           
        });
        supplier.get().setPacketHandled(true);
        return success.get();
    }
   
}

