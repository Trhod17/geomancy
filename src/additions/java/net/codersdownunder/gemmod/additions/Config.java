package net.codersdownunder.gemmod.additions;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {

	public static class Client {
		public final ForgeConfigSpec.BooleanValue test;
		public final ForgeConfigSpec.IntValue intTest;
		public final ForgeConfigSpec.DoubleValue doubleTest;
		public final ForgeConfigSpec.EnumValue<testEnum> enumTest;
		public enum testEnum {
			
			test1(0, "test1"),
			test2(1, "test2");
			
			private final int id;
			private final String name;
			
			testEnum(int id, String name) {
				this.id = id;
				this.name = name;
			}
			
			public int getId() {
				return id;
			}
			
			public String toString() {
				return name;
			}
		}
		public final ForgeConfigSpec.LongValue longTest;
		
		Client(ForgeConfigSpec.Builder builder) {
			builder.comment("Client Configuration Settings").push("client");
			{
				builder.comment("Test client Configs").push("test");
				this.test = builder.comment("test client boolean config option").translation(Additions.MODID + ".config.client.test.test_boolean").define("test", false);
				this.intTest = builder.comment("test client int config option").defineInRange("intTest", 0, 0, 1000);
				this.doubleTest = builder.comment("test client double config option").defineInRange("testdouble", 0.0D, 0.0D, 100.0D);
				this.enumTest = builder.comment("test client enum config option").defineEnum("enumTest", testEnum.test1);
				this.longTest = builder.comment("test client long config option").defineInRange("longtest", 0L, 0L, 20000L);
				builder.pop();
			}
			builder.pop();
		}
	}
	
	public static class Server {
		public final ForgeConfigSpec.BooleanValue test;
		public final ForgeConfigSpec.IntValue intTest;
		public final ForgeConfigSpec.DoubleValue doubleTest;
		public final ForgeConfigSpec.EnumValue<testEnum> enumTest;
		public enum testEnum {
			
			test1(0, "test1"),
			test2(1, "test2");
			
			private int id;
			private String name;
			
			testEnum(int id, String name) {
				this.id = id;
				this.name = name;
			}
			
			public int getId() {
				return id;
			}
			
			public String toString() {
				return name;
			}
		}
		public final ForgeConfigSpec.LongValue longTest;
		
		Server(ForgeConfigSpec.Builder builder) {
			builder.comment("Server Configuration Settings").push("server");
			{
				builder.comment("Test Server Configs").push("test");
				this.test = builder.comment("test server boolean config option").translation(Additions.MODID + ".config.server.test.test_boolean").define("test", false);
				this.intTest = builder.comment("test server int config option").defineInRange("intTest", 0, 0, 1000);
				this.doubleTest = builder.comment("test server double config option").defineInRange("testdouble", 0.0D, 0.0D, 100.0D);
				this.enumTest = builder.comment("test server enum config option").defineEnum("enumTest", testEnum.test1);
				this.longTest = builder.comment("test server long config option").defineInRange("longtest", 0L, 0L, 20000L);
				builder.pop();
			}
			builder.pop();
		}
	}
	
	  	static final ForgeConfigSpec clientSpec;
	    public static final Config.Client CLIENT;

	    static final ForgeConfigSpec serverSpec;
	    public static final Server SERVER;

	    static
	    {
	        final Pair<Client, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(Config.Client::new);
	        clientSpec = clientSpecPair.getRight();
	        CLIENT = clientSpecPair.getLeft();

	        final Pair<Server, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Server::new);
	        serverSpec = commonSpecPair.getRight();
	        SERVER = commonSpecPair.getLeft();
	    }
}
