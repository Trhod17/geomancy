package net.codersdownunder.gemmod.items;

import java.util.List;

import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;


public class DreamingGemItem extends Item
{

    public DreamingGemItem(Properties p_i48487_1_)
    {
        super(p_i48487_1_);

    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag)
    {
    	 if (this.asItem() == ItemInit.AGATE_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_agate.text"));
         }
         if (this.asItem() == ItemInit.CHRYSOCOLLA_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_chrysocolla.text"));
         }
         if (this.asItem() == ItemInit.MALACHITE_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_malachite.text"));
         }
         if (this.asItem() == ItemInit.JADE_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_jade.text"));
         }
         if (this.asItem() == ItemInit.PERIDOT_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_peridot.text"));
         }
         if (this.asItem() == ItemInit.TOPAZ_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_topaz.text"));
         }
         if (this.asItem() == ItemInit.CITRINE_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_citrine.text"));
         }
         if (this.asItem() == ItemInit.JASPER_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_jasper.text"));
         }
         if (this.asItem() == ItemInit.RUBY_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_ruby.text"));
         }
         if (this.asItem() == ItemInit.GARNET_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_garnet.text"));
         }
         if (this.asItem() == ItemInit.SPINEL_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_spinel.text"));
         }
         if (this.asItem() == ItemInit.AMETHYST_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_amethyst.text"));
         }
         if (this.asItem() == ItemInit.CHAROITE_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_charoite.text"));
         }
         if (this.asItem() == ItemInit.SAPPHIRE_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_sapphire.text"));
         }
         if (this.asItem() == ItemInit.LILYSTAR_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_lilystar.text"));
         }
         if (this.asItem() == ItemInit.ONYX_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_onyx.text"));
         }
         if (this.asItem() == ItemInit.SPHENE_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_sphene.text"));
         }
         if (this.asItem() == ItemInit.RHODONITE_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_rhodonite.text"));
         } 
         if (this.asItem() == ItemInit.EMERALD_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_emerald.text"));
         }
    }

}
