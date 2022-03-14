package net.codersdownunder.gemmod.network.messages;

import net.codersdownunder.gemmod.blocks.infusionstand.InfusionStandBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

public class InfusionStandCraftingMessage
{

    private final BlockPos pos;


    public InfusionStandCraftingMessage(BlockPos pos)
    {
        this.pos = pos;
    }
    
    public InfusionStandCraftingMessage(FriendlyByteBuf buffer) {
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
               if (tile instanceof InfusionStandBlockEntity) {
                   InfusionStandBlockEntity table = (InfusionStandBlockEntity) tile;
                   
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

