package net.codersdownunder.gemmod.additions.utils;

import net.codersdownunder.gemmod.additions.init.BlockInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class AdditionsItemGroup extends CreativeModeTab {

    public AdditionsItemGroup(String name) {
        super(name);
    }

    @Override
    public ItemStack makeIcon()
    {
            return new ItemStack(BlockInit.PURPUR_WALL.get());
 
    }


}
