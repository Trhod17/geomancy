package net.codersdownunder.gemmod.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MulmusItem extends Item
{

    public MulmusItem(Properties p_i48487_1_)
    {
        super(p_i48487_1_);
    }
    
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity)
    {
        MobEffectInstance effectinstance;
        effectinstance = new MobEffectInstance(MobEffects.LEVITATION, 350, 0);
        entity.addEffect(effectinstance);
        return entity.eat(world, stack);
    }
}