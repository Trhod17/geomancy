package net.codersdownunder.gemmod;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

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
	
	public static class Server {
		public final IntValue dipperTime;
		public final IntValue rarity;
		
//		private List<String> CommonList = Lists.newArrayList("geomancy:agate");
//		private List<String> UncommonList = Lists.newArrayList("minecraft:emerald");
//		private List<String> RareList = Lists.newArrayList("geomancy:chrysocolla");
//		private List<String> EpicList = Lists.newArrayList("geomancy:agate_dreaming");
		
		public ForgeConfigSpec.ConfigValue<List<? extends String>> Common;
		public ForgeConfigSpec.ConfigValue<List<? extends String>> Uncommon;
		public ForgeConfigSpec.ConfigValue<List<? extends String>> Rare;
		public ForgeConfigSpec.ConfigValue<List<? extends String>> Epic;
		
		Server(ForgeConfigSpec.Builder builder) {
			builder.comment("Server Configuration Settings").push("server");
			{
				builder.comment("Dipper Configs").push("dipper");
				this.dipperTime = builder.comment("Dipper Processing Time").translation(GemMod.MODID + ".config.server.dipper.dipper_time").defineInRange("DipperTime", 600, 0, 400000);
				builder.pop();
				
				builder.comment("World Gen Configs").push("worldgen");
				this.rarity = builder.comment("BlackStone Geode Rarity").translation(GemMod.MODID + ".config.server.worldgen.blackstone_geode_rarity").defineInRange("BlackStoneGeodeRarity", 40, 0, Integer.MAX_VALUE);
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

	    static final ForgeConfigSpec serverSpec;
	    public static final Server SERVER;

	    static
	    {
//	        final Pair<Client, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(Config.Client::new);
//	        clientSpec = clientSpecPair.getRight();
//	        CLIENT = clientSpecPair.getLeft();

	        final Pair<Server, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Server::new);
	        serverSpec = commonSpecPair.getRight();
	        SERVER = commonSpecPair.getLeft();
	    }
}
