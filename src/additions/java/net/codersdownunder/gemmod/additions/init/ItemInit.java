package net.codersdownunder.gemmod.additions.init;

import net.codersdownunder.gemmod.additions.Additions;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Additions.MODID);
}
