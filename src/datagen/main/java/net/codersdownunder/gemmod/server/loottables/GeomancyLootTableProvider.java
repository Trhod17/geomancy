package net.codersdownunder.gemmod.server.loottables;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class GeomancyLootTableProvider extends LootTableProvider {
    public GeomancyLootTableProvider(final PackOutput output, final List<SubProviderEntry> subProviders) {
        super(output, Set.of(), subProviders);
    }


//    public static GeomancyLootTableProvider create(final PackOutput output) {
//        return new GeomancyLootTableProvider(output, ImmutableList.of(
//                new SubProviderEntry(GeomancyBlockLootProvider::new, LootContextParamSets.BLOCK)
//        ));
//    }

    @Override
    protected void validate(final @NotNull Map<ResourceLocation, LootTable> map, final @NotNull ValidationContext validationContext) {
    }

}
