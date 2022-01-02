package net.codersdownunder.gemmod.init;

import java.lang.reflect.InvocationTargetException;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.codersdownunder.gemmod.GemMod;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class VillagerInit {
	public static final DeferredRegister<PoiType> POINT_OF_INTEREST_TYPES = DeferredRegister
			.create(ForgeRegistries.POI_TYPES, GemMod.MODID);
	public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister
			.create(ForgeRegistries.PROFESSIONS, GemMod.MODID);

	public static final RegistryObject<PoiType> GEM = POINT_OF_INTEREST_TYPES.register("gem",
			() -> new PoiType("gemer", PoiType.getBlockStates(BlockInit.DIPPER.get()), 1, 1));
	public static final RegistryObject<VillagerProfession> GEMER = VILLAGER_PROFESSIONS.register("gemer",
			() -> new VillagerProfession("gemer", GEM.get(), ImmutableSet.of(), ImmutableSet.of(),
					SoundEvents.VILLAGER_WORK_TOOLSMITH));

	public static void registerGemerPOI() {
		try {
			ObfuscationReflectionHelper.findMethod(PoiType.class, "getBlockStates", PoiType.class).invoke(null,
					GEM.get());
		} catch (InvocationTargetException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public static void fillTradeData() {
		VillagerTrades.ItemListing[] gemerLevel1 = new VillagerTrades.ItemListing[] {
			new VillagerTrades.ItemsForEmeralds(ItemInit.AGATE.get(), 1, 4, 3),
			new VillagerTrades.EmeraldForItems(ItemInit.CHAROITE.get(), 2, 1000, 10)
		};
		VillagerTrades.ItemListing[] gemerLevel2 = new VillagerTrades.ItemListing[] {
				new VillagerTrades.ItemsForEmeralds(ItemInit.AGATE.get(), 1, 4, 3),
				new VillagerTrades.EmeraldForItems(ItemInit.CITRINE.get(), 2, 1000, 10)
		};
		VillagerTrades.ItemListing[] gemerLevel3 = new VillagerTrades.ItemListing[] {
				new VillagerTrades.ItemsForEmeralds(ItemInit.DIPPER.get(), 23, 1, 3),
				new VillagerTrades.EmeraldForItems(ItemInit.CHRYSOCOLLA.get(), 2, 1000, 10)
		};
		VillagerTrades.ItemListing[] gemerLevel4 = new VillagerTrades.ItemListing[] {
				new VillagerTrades.ItemsForEmeralds(ItemInit.SPINEL.get(), 1, 4, 3),
				new VillagerTrades.EmeraldForItems(ItemInit.AGATE_DREAMING.get(), 11, 1000, 10)
		};
		VillagerTrades.ItemListing[] gemerLevel5 = new VillagerTrades.ItemListing[] {
				new VillagerTrades.ItemsForEmeralds(ItemInit.RHODONITE.get(), 1, 4, 3),
				new VillagerTrades.EmeraldForItems(ItemInit.PERIDOT_DREAMING.get(), 12, 1000, 10)
		};
		
		VillagerTrades.TRADES.put(GEMER.get(), toIntMap(ImmutableMap.of(1,gemerLevel1,2,gemerLevel2,3,gemerLevel3,4,gemerLevel4,5,gemerLevel5)));
	}
	
	   @SuppressWarnings({ "rawtypes", "unchecked" })
	private static Int2ObjectMap<ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> p_221238_0_) {
	        return new Int2ObjectOpenHashMap(p_221238_0_);
	    }

}
