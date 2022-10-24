package net.codersdownunder.gemmod;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import org.apache.commons.lang3.tuple.Pair;

public class Config {

	public static class Client {
		Client(ForgeConfigSpec.Builder builder) {
			builder.comment("Client Configuration Settings").push("client");
			{
				builder.comment("No configs yet");
			}
			builder.pop();
		}
	}
	
	public static class Common {
		public final IntValue dipperTime;
		
		public final IntValue rarity;
		public final IntValue geodeMinY;
		public final IntValue geodeMaxY;
		
//		private List<String> CommonList = Lists.newArrayList("geomancy:agate");
//		private List<String> UncommonList = Lists.newArrayList("minecraft:emerald");
//		private List<String> RareList = Lists.newArrayList("geomancy:chrysocolla");
//		private List<String> EpicList = Lists.newArrayList("geomancy:agate_dreaming");
		
//		public ForgeConfigSpec.ConfigValue<List<? extends String>> Common;
//		public ForgeConfigSpec.ConfigValue<List<? extends String>> Uncommon;
//		public ForgeConfigSpec.ConfigValue<List<? extends String>> Rare;
//		public ForgeConfigSpec.ConfigValue<List<? extends String>> Epic;
//		
		Common(ForgeConfigSpec.Builder builder) {
			builder.comment("Server Configuration Settings").push("server");
			{
				builder.comment("Dipper Configs").push("dipper");
				this.dipperTime = builder.comment("Dipper Processing Time").translation(Geomancy.MODID + ".config.common.dipper.dipper_time").defineInRange("DipperTime", 600, 0, 400000);
				builder.pop();
				
				builder.comment("World Gen Configs").push("worldgen");
				this.rarity = builder.comment("Gem Geode Rarity").translation(Geomancy.MODID + ".config.common.worldgen.gem_geode_rarity").defineInRange("GemGeodeRarity", 40, 0, Integer.MAX_VALUE);
				this.geodeMinY = builder.comment("Gem Geode Min Y Height").translation(Geomancy.MODID + ".config.common.worldgen.gem_geode_min_y").defineInRange("GemGeodeMinY", -50, 0, Integer.MAX_VALUE);
				this.geodeMaxY = builder.comment("Gem Geode Max Y Height").translation(Geomancy.MODID + ".config.common.worldgen.gem_geode_max_y").defineInRange("GemGeodeMaxY", 30, 0, Integer.MAX_VALUE);
				builder.pop();
//				
//				builder.comment("Dream Catcher Configs").push("dream catcher");
//				this.Common = builder.comment("Common gems in the dream catcher").translation(GemMod.MODID + ".config.server.dream_catcher.common").define("common", CommonList);
//				this.Uncommon = builder.comment("UnCommon gems in the dream catcher").translation(GemMod.MODID + ".config.server.dream_catcher.uncommon").define("uncommon", UncommonList);
//				this.Rare = builder.comment("Rare gems in the dream catcher").translation(GemMod.MODID + ".config.server.dream_catcher.rare").define("rare", RareList);
//				this.Epic = builder.comment("Epic gems in the dream catcher").translation(GemMod.MODID + ".config.server.dream_catcher.epic").define("epic", EpicList);
//				builder.pop();
			}
			builder.pop();
		}
	}
	
	  	//static final ForgeConfigSpec clientSpec;
	    //public static final Config.Client CLIENT;

	    static final ForgeConfigSpec commonSpec;
	    public static final Common COMMON;

	    static
	    {
//	        final Pair<Client, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(Config.Client::new);
//	        clientSpec = clientSpecPair.getRight();
//	        CLIENT = clientSpecPair.getLeft();

	        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
	        commonSpec = commonSpecPair.getRight();
	        COMMON = commonSpecPair.getLeft();
	    }
}
