package net.codersdownunder.gemmod.additions.common.loottables;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import net.codersdownunder.gemmod.additions.Additions;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ModLootTables extends LootTableProvider {

    public ModLootTables(final PackOutput output, final List<SubProviderEntry> subProviders) {
        super(output, Set.of(), subProviders);
    }


    public static ModLootTables create(final PackOutput output) {
        return new ModLootTables(output, ImmutableList.of(
                new SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }

    @Override
    protected void validate(final Map<ResourceLocation, LootTable> map, final ValidationContext validationContext) {
        final Set<ResourceLocation> modLootTableIds = BuiltInLootTables
                .all()
                .stream()
                .filter(lootTable -> lootTable.getNamespace().equals(Additions.MODID))
                .collect(Collectors.toSet());

        for (final ResourceLocation id : Sets.difference(modLootTableIds, map.keySet())) {
            validationContext.reportProblem("Missing mod loot table: " + id);
        }

        map.forEach((id, lootTable) -> LootTables.validate(validationContext, id, lootTable));
    }

}