package net.codersdownunder.gemmod.entities;


import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

public class CupidArrowEntity extends AbstractArrow {


    public CupidArrowEntity(EntityType<CupidArrowEntity> entityType, Level world) {
        super(entityType, world);
    }

    public CupidArrowEntity(EntityType<CupidArrowEntity> entityType, double x, double y, double z, Level world) {
        super(entityType, x, y, z, world);
    }

    public CupidArrowEntity(EntityType<CupidArrowEntity> entityType, LivingEntity shooter, Level world) {
        super(entityType, shooter, world);
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (!pResult.getEntity().level.isClientSide()) {
            ServerLevel world = (ServerLevel) this.level;
            BlockPos pos = pResult.getEntity().blockPosition();
            Entity entity = pResult.getEntity();

            if (entity instanceof Animal animal) {

                if (animal.isBaby()) return;

                animal.setAge(0);
                animal.setHealth(10f);
                animal.setLastHurtByMob(null);
            }
        }
    }

//    //this is for helping debug render issues
//    @Override
//    public Packet<ClientGamePacketListener> getAddEntityPacket()
//    {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }
}