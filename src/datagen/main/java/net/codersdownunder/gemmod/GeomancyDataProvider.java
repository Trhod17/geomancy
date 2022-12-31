package net.codersdownunder.gemmod;

import com.google.common.collect.Sets;
import net.codersdownunder.gemmod.client.GeomancyBlockStates;
import net.codersdownunder.gemmod.client.GeomancyItemModelProvider;
import net.codersdownunder.gemmod.client.GeomancyLanguageProvider;
import net.codersdownunder.gemmod.server.loottables.GeomancyBlockLootProvider;
import net.codersdownunder.gemmod.server.loottables.GeomancyLootTableProvider;
import net.codersdownunder.gemmod.server.recipes.GeomancyCuttingRecipeProvider;
import net.codersdownunder.gemmod.server.recipes.GeomancyDippingRecipeProvider;
import net.codersdownunder.gemmod.server.recipes.GeomancyInfusionRecipeProvider;
import net.codersdownunder.gemmod.server.recipes.GeomancyRecipeProvider;
import net.codersdownunder.gemmod.server.recipes.GeomancyUpgradeRecipeProvider;
import net.codersdownunder.gemmod.server.tags.GeomancyBlockTags;
import net.codersdownunder.gemmod.server.tags.GeomancyEntityTags;
import net.codersdownunder.gemmod.server.tags.GeomancyFluidTags;
import net.codersdownunder.gemmod.server.tags.GeomancyItemTags;
import net.codersdownunder.gemmod.server.world.GeomancyBiomeModifierProvider;
import net.codersdownunder.gemmod.server.world.worldgen.ModConfiguredFeatures;
import net.codersdownunder.gemmod.server.world.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;


@EventBusSubscriber(modid = Geomancy.MODID, bus = Bus.MOD)
public class GeomancyDataProvider {

	private static final Field BUILDER = ObfuscationReflectionHelper.findField(VanillaRegistries.class, /* BUILDER */ "f_254635_");
	private static final Method WRAP_CONTEXT_LOOKUP = ObfuscationReflectionHelper.findMethod(RegistrySetBuilder.class, /* wrapContextLookup */ "m_254882_", HolderLookup.RegistryLookup.class);
    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {
		final var gen = event.getGenerator();
		final var packOutput = gen.getPackOutput();
		final var existingFileHelper = event.getExistingFileHelper();
		final var lookupProvider = event.getLookupProvider().thenApply(GeomancyDataProvider::createLookup);

			gen.addProvider(true, GeomancyPackMetaGenerator.create(packOutput));

			gen.addProvider(event.includeClient(), new GeomancyLanguageProvider(packOutput));
        	gen.addProvider(event.includeClient(), new GeomancyBlockStates(packOutput, existingFileHelper));
        	gen.addProvider(event.includeClient(), new GeomancyItemModelProvider(packOutput, existingFileHelper));

         	gen.addProvider(event.includeServer(), new GeomancyRecipeProvider(packOutput));
         	gen.addProvider(event.includeServer(), new GeomancyCuttingRecipeProvider(packOutput));
         	gen.addProvider(event.includeServer(), new GeomancyDippingRecipeProvider(packOutput));
         	gen.addProvider(event.includeServer(), new GeomancyInfusionRecipeProvider(packOutput));
         	gen.addProvider(event.includeServer(), new GeomancyUpgradeRecipeProvider(packOutput));
        	gen.addProvider(event.includeServer(), new GeomancyLootTableProvider(
					packOutput,
					List.of(new LootTableProvider.SubProviderEntry(GeomancyBlockLootProvider::new, LootContextParamSets.BLOCK))
			));
        	GeomancyBlockTags blockTags = new GeomancyBlockTags(packOutput, lookupProvider, existingFileHelper);
            gen.addProvider(event.includeServer(), blockTags);
            gen.addProvider(event.includeServer(), new GeomancyItemTags(packOutput, lookupProvider, blockTags, existingFileHelper));
            gen.addProvider(event.includeServer(), new GeomancyFluidTags(packOutput, lookupProvider, existingFileHelper));
			gen.addProvider(event.includeServer(), new GeomancyEntityTags(packOutput, lookupProvider, existingFileHelper));
			//gen.addProvider(event.includeServer(), new GeomancyBiomeModifierProvider(gen, existingFileHelper, lookupProvider));

			gen.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(packOutput, lookupProvider, Set.of(Geomancy.MODID)));
    }

	private static HolderLookup.Provider createLookup(final HolderLookup.Provider vanillaLookupProvider) {
		try {
			final var registryAccess = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);

			final var builder = new RegistrySetBuilder()
					.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
					.add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
					.add(ForgeRegistries.Keys.BIOME_MODIFIERS, GeomancyBiomeModifierProvider::bootstrap);

			final var vanillaKeys = Set.copyOf(((RegistrySetBuilder) BUILDER.get(null)).getEntryKeys());
			final var modKeys = Set.copyOf(builder.getEntryKeys());

			final var missingKeys = Sets.difference(vanillaKeys, modKeys);

			missingKeys.forEach(key -> builder.add(
					ResourceKey.create(ResourceKey.createRegistryKey(key.registry()), key.location()),
					context -> {
					}
			));

			return builder.buildPatch(registryAccess, vanillaLookupProvider);
		} catch (final IllegalAccessException e) {
			throw new RuntimeException("Failed to create holder lookup", e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> HolderGetter<T> wrapContextLookup(final HolderLookup.RegistryLookup<T> lookup) {
		try {
			return (HolderGetter<T>) WRAP_CONTEXT_LOOKUP.invoke(null, lookup);
		} catch (final IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException("Failed to wrap context lookup", e);
		}
	}

}
