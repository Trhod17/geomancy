package net.codersdownunder.gemmod.items;

import java.util.List;

import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;

public class GemItem extends Item
{

    public GemItem(Properties p_i48487_1_)
    {
        super(p_i48487_1_);

    }


    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag)
    {
    	Item current = this.asItem();
    	
        if (current == ItemInit.AGATE.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_agate.text"));
        }
        else if (current == ItemInit.CHRYSOCOLLA.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_chrysocolla.text"));
        }
        else if (current == ItemInit.MALACHITE.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_malachite.text"));
        }
        else if (current == ItemInit.JADE.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_jade.text"));
        }
        else if (current == ItemInit.PERIDOT.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_peridot.text"));
        }
        else if (current == ItemInit.TOPAZ.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_topaz.text"));
        }
        else if (current == ItemInit.CITRINE.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_citrine.text"));
        }
        else if (current == ItemInit.JASPER.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_jasper.text"));
        }
        else if (current == ItemInit.RUBY.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_ruby.text"));
        }
        else if (current == ItemInit.GARNET.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_garnet.text"));
        }
        else if (this.asItem() == ItemInit.SPINEL.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_spinel.text"));
        }
        else if (current == ItemInit.AMETHYST.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_amethyst.text"));
        }
        else if (current == ItemInit.CHAROITE.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_charoite.text"));
        }
        else if (current == ItemInit.SAPPHIRE.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_sapphire.text"));
        }
        else if (current == ItemInit.LILYSTAR.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_lilystar.text"));
        }
        else if (current == ItemInit.ONYX.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_onyx.text"));
        }
        else if (current == ItemInit.SPHENE.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_sphene.text"));
        }
        else if (current == ItemInit.RHODONITE.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_rhodonite.text"));
        }

    }

}
