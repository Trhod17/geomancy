package net.codersdownunder.gemmod.items;

import net.codersdownunder.gemmod.entities.CupidArrowEntity;
import net.codersdownunder.gemmod.init.EntityInit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CupidArrowItem extends ArrowItem
{

    public CupidArrowItem(Properties p_40512_) {
        super(p_40512_);
    }

    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        return new CupidArrowEntity(EntityInit.CUPID_ARROW.get(), pShooter, pLevel);
    }

}