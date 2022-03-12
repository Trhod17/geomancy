package net.codersdownunder.gemmod.utils;

import net.codersdownunder.gemmod.init.BlockInit;
import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class GemModItemGroup extends CreativeModeTab {

    private String name;
    
    public GemModItemGroup(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public ItemStack makeIcon()
    {
        switch(name) {
        case "gemsmoditemtab":
            return new ItemStack(ItemInit.AGATE.get());
        case "gemmodblocktab":
            return new ItemStack(BlockInit.CHASM_LOG.get());
        default:
            return new ItemStack(BlockInit.CHASM_LOG.get());
        }
        
    }
    
    public void fill(NonNullList<ItemStack> items)
    {
        if (name == "gemsmoditemtab") {
        items.add(new ItemStack(Items.EMERALD));
        }
    }

}
