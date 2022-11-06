package net.codersdownunder.gemmod.blocks.songforge;

import net.codersdownunder.gemmod.init.ItemInit;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.Arrays;

public enum SongForgeUpgrades {

    EMPTY (Items.AIR, new Item[]{}),
    SPEED1 (ItemInit.PLATE_SPEED_UP.get(), new Item[]{}),
    SPEED2 (ItemInit.PLATE_SPEED_OVERDRIVE.get(), new Item[]{ItemInit.PLATE_SPEED_UP.get(), ItemInit.PLATE_FUEL_TIME.get(), ItemInit.PLATE_YIELD_ORE.get()}),
    FAILSAFE (ItemInit.PLATE_FAILSAFE.get(), new Item[]{}),
    FUELCOAL (ItemInit.PLATE_FUEL_COAL.get(), new Item[]{}),
    FUELTIME (ItemInit.PLATE_FUEL_TIME.get(), new Item[]{}),
    YIELDORE (ItemInit.PLATE_YIELD_ORE.get(), new Item[]{}),
    DING (ItemInit.PLATE_DING.get(), new Item[]{});

    private final Item upgrade;
    private final Item[] incompatibles;

    SongForgeUpgrades(Item upgrade, Item[] incompatibles) {
        this.upgrade = upgrade;
        this.incompatibles = incompatibles;
    }

    private Item upgrade() { return upgrade; }
    private Item[] incompatibles() { return incompatibles; }

    public static SongForgeUpgrades getIncompatiblesFromUpgrade(Item identifier) {
        return Arrays.stream(SongForgeUpgrades.values()).filter(item -> item.upgrade().equals(identifier)).findFirst().orElse(EMPTY);
    }

    public static boolean isValidUpgrade(Item identifier) {
        return Arrays.stream(SongForgeUpgrades.values()).anyMatch(item -> item.upgrade().equals(identifier));
    }

//    public static TrellisBlock.Variants getItemFromBlock(Block identifier) {
//        return Arrays.stream(TrellisBlock.Variants.values()).filter(item -> item.trellis().equals(identifier)).findFirst().orElse(EMPTY);
//    }
//
//    public static TrellisBlock.Variants getBlockFromItem(Item identifier) {
//        return Arrays.stream(TrellisBlock.Variants.values()).filter(item -> item.vine().equals(identifier)).findFirst().orElse(EMPTY);
//    }
}
