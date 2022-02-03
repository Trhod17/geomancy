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
    	Item current = this.asItem();
    	
    	 if (current == ItemInit.AGATE_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_agate.text"));
         }
    	 else if (current == ItemInit.CHRYSOCOLLA_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_chrysocolla.text"));
         }
    	 else if (current == ItemInit.MALACHITE_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_malachite.text"));
         }
    	 else if (current == ItemInit.JADE_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_jade.text"));
         }
    	 else if (current == ItemInit.PERIDOT_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_peridot.text"));
         }
    	 else if (current == ItemInit.TOPAZ_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_topaz.text"));
         }
    	 else if (current == ItemInit.CITRINE_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_citrine.text"));
         }
    	 else if (current == ItemInit.JASPER_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_jasper.text"));
         }
    	 else if (current == ItemInit.RUBY_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_ruby.text"));
         }
    	 else if (current == ItemInit.GARNET_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_garnet.text"));
         }
    	 else if (current == ItemInit.SPINEL_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_spinel.text"));
         }
    	 else if (current == ItemInit.AMETHYST_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_amethyst.text"));
         }
    	 else if (current == ItemInit.CHAROITE_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_charoite.text"));
         }
    	 else if (current == ItemInit.SAPPHIRE_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_sapphire.text"));
         }
    	 else if (current == ItemInit.LILYSTAR_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_lilystar.text"));
         }
    	 else if (current == ItemInit.ONYX_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_onyx.text"));
         }
    	 else if (current == ItemInit.SPHENE_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_sphene.text"));
         }
    	 else if (current == ItemInit.RHODONITE_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_rhodonite.text"));
         } 
    	 else if (current == ItemInit.EMERALD_DREAMING.get())
         {
             list.add(new TranslatableComponent("tooltip.gem_dreaming_emerald.text"));
         }
    }

}
