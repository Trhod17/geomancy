package net.codersdownunder.gemmod;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

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
		public final ForgeConfigSpec.IntValue dipperTime;
		public final IntValue rarity;
		
		Server(ForgeConfigSpec.Builder builder) {
			builder.comment("Server Configuration Settings").push("server");
			{
				builder.comment("Dipper Configs").push("dipper");
				this.dipperTime = builder.comment("Dipper Processing Time").translation(GemMod.MODID + ".config.server.dipper.dipper_time").defineInRange("DipperTime", 12000, 0, 400000);
				builder.pop();
				
				builder.comment("World Gen Configs").push("worldgen");
				this.rarity = builder.comment("BlackStone Geode Rarity").translation(GemMod.MODID + ".config.server.worldgen.blackstone_geode_rarity").defineInRange("BlackStoneGeodeRarity", 40, 0, Integer.MAX_VALUE);
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
