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
        if (this.asItem() == ItemInit.AGATE.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_agate.text"));
        }
        if (this.asItem() == ItemInit.CHRYSOCOLLA.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_chrysocolla.text"));
        }
        if (this.asItem() == ItemInit.MALACHITE.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_malachite.text"));
        }
        if (this.asItem() == ItemInit.JADE.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_jade.text"));
        }
        if (this.asItem() == ItemInit.PERIDOT.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_peridot.text"));
        }
        if (this.asItem() == ItemInit.TOPAZ.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_topaz.text"));
        }
        if (this.asItem() == ItemInit.CITRINE.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_citrine.text"));
        }
        if (this.asItem() == ItemInit.JASPER.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_jasper.text"));
        }
        if (this.asItem() == ItemInit.RUBY.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_ruby.text"));
        }
        if (this.asItem() == ItemInit.GARNET.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_garnet.text"));
        }
        if (this.asItem() == ItemInit.SPINEL.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_spinel.text"));
        }
        if (this.asItem() == ItemInit.AMETHYST.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_amethyst.text"));
        }
        if (this.asItem() == ItemInit.CHAROITE.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_charoite.text"));
        }
        if (this.asItem() == ItemInit.SAPPHIRE.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_sapphire.text"));
        }
        if (this.asItem() == ItemInit.LILYSTAR.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_lilystar.text"));
        }
        if (this.asItem() == ItemInit.ONYX.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_onyx.text"));
        }
        if (this.asItem() == ItemInit.SPHENE.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_sphene.text"));
        }
        if (this.asItem() == ItemInit.RHODONITE.get())
        {
            list.add(new TranslatableComponent("tooltip.gem_rhodonite.text"));
        }

    }

}
