package net.codersdownunder.gemmod.server.tags;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.init.ItemInit;
import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GeomancyItemTags extends ItemTagsProvider {

	public GeomancyItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
		super(generator, blockTags, Geomancy.MODID, helper);
	}

	@Override
	protected void addTags() {
		
		
		tag(GeomancyTags.Items.DREAM_COMMON)
		.add(ItemInit.AGATE.get())
		.add(ItemInit.AMETHYST.get())
		.add(ItemInit.CHAROITE.get())
		.add(ItemInit.CHRYSOCOLLA.get())
		.add(ItemInit.CITRINE.get())
		.add(ItemInit.GARNET.get())
		.add(ItemInit.JADE.get())
		.add(ItemInit.JASPER.get())
		.add(ItemInit.LILYSTAR.get())
		.add(ItemInit.MALACHITE.get())
		.add(ItemInit.ONYX.get())
		.add(ItemInit.PERIDOT.get())
		.add(ItemInit.RHODONITE.get())
		.add(ItemInit.RUBY.get())
		.add(ItemInit.SAPPHIRE.get())
		.add(ItemInit.SPHENE.get())
		.add(ItemInit.SPINEL.get())
		.add(ItemInit.TOPAZ.get());
		
		tag(GeomancyTags.Items.DREAM_RARE)
		.add(ItemInit.AGATE_DREAMING.get())
		.add(ItemInit.AMETHYST_DREAMING.get())
		.add(ItemInit.CHAROITE_DREAMING.get())
		.add(ItemInit.CHRYSOCOLLA_DREAMING.get())
		.add(ItemInit.CITRINE_DREAMING.get())
		.add(ItemInit.GARNET_DREAMING.get())
		.add(ItemInit.JADE_DREAMING.get())
		.add(ItemInit.JASPER_DREAMING.get())
		.add(ItemInit.LILYSTAR_DREAMING.get())
		.add(ItemInit.MALACHITE_DREAMING.get())
		.add(ItemInit.ONYX_DREAMING.get())
		.add(ItemInit.PERIDOT_DREAMING.get())
		.add(ItemInit.RHODONITE_DREAMING.get())
		.add(ItemInit.RUBY_DREAMING.get())
		.add(ItemInit.SAPPHIRE_DREAMING.get())
		.add(ItemInit.SPHENE_DREAMING.get())
		.add(ItemInit.SPINEL_DREAMING.get())
		.add(ItemInit.TOPAZ_DREAMING.get())
		.add(Items.EMERALD)
		.add(ItemInit.EMERALD_DREAMING.get());
		
		tag(GeomancyTags.Items.SEED_CRYSTAL).add(Items.QUARTZ);

		tag(GeomancyTags.Items.CONCOCTIONS_TIER_1).add(ItemInit.CONCOCTION_ONE.get());

		tag(GeomancyTags.Items.CONCOCTIONS_TIER_2).add(ItemInit.CONCOCTION_TWO.get());

		tag(GeomancyTags.Items.CONCOCTIONS_TIER_3).add(ItemInit.CONCOCTION_THREE.get());

		tag(GeomancyTags.Items.CONCOCTIONS_TIER_4).add(ItemInit.CONCOCTION_FOUR.get());
		
		tag(GeomancyTags.Items.DIPPING_FLUIDS)
		.add(Items.WATER_BUCKET);

		tag(ItemTags.LOGS).add(ItemInit.CHASM_LOG.get()).add(ItemInit.CHASM_LOG_BARK.get())
				.add(ItemInit.CHASM_LOG_STRIPPED.get()).add(ItemInit.CHASM_LOG_STRIPPED_BARK.get());

		tag(ItemTags.LOGS_THAT_BURN).add(ItemInit.CHASM_LOG.get()).add(ItemInit.CHASM_LOG_BARK.get())
				.add(ItemInit.CHASM_LOG_STRIPPED.get()).add(ItemInit.CHASM_LOG_STRIPPED_BARK.get());

		tag(ItemTags.PLANKS).add(ItemInit.CHASM_PLANKS.get());

		tag(ItemTags.WOODEN_STAIRS).add(ItemInit.CHASM_STAIRS.get());

		tag(ItemTags.WOODEN_SLABS).add(ItemInit.CHASM_SLAB.get());

		tag(ItemTags.WOODEN_BUTTONS).add(ItemInit.CHASM_BUTTON.get());

		tag(ItemTags.WOODEN_PRESSURE_PLATES).add(ItemInit.CHASM_PLATE.get());

		tag(ItemTags.WOODEN_TRAPDOORS).add(ItemInit.CHASM_TRAPDOOR.get());

		tag(ItemTags.WOODEN_DOORS).add(ItemInit.CHASM_DOOR.get());

		tag(ItemTags.WOODEN_FENCES).add(ItemInit.CHASM_FENCE.get());

		tag(ItemTags.LEAVES).add(ItemInit.CHASM_LEAVES.get());
		
		tag(GeomancyTags.Items.QUARTZ).add(Items.QUARTZ).add(ItemInit.ROSE_QUARTZ.get());
		
		tag(ItemTags.SAPLINGS)
		.add(ItemInit.CHASM_SAPLING.get());

		tag(Tags.Items.SHEARS)
				.add(ItemInit.DIGGING_CLAW_WOOD.get())
				.add(ItemInit.DIGGING_CLAW_STONE.get())
				.add(ItemInit.DIGGING_CLAW_IRON.get())
				.add(ItemInit.DIGGING_CLAW_GOLD.get())
				.add(ItemInit.DIGGING_CLAW_DIAMOND.get())
				.add(ItemInit.DIGGING_CLAW_NETHERITE.get());

		tag(Tags.Items.TOOLS_SHOVELS)
				.add(ItemInit.DIGGING_CLAW_WOOD.get())
				.add(ItemInit.DIGGING_CLAW_STONE.get())
				.add(ItemInit.DIGGING_CLAW_IRON.get())
				.add(ItemInit.DIGGING_CLAW_GOLD.get())
				.add(ItemInit.DIGGING_CLAW_DIAMOND.get())
				.add(ItemInit.DIGGING_CLAW_NETHERITE.get());

		tag(Tags.Items.TOOLS_PICKAXES)
				.add(ItemInit.DIGGING_CLAW_WOOD.get())
				.add(ItemInit.DIGGING_CLAW_STONE.get())
				.add(ItemInit.DIGGING_CLAW_IRON.get())
				.add(ItemInit.DIGGING_CLAW_GOLD.get())
				.add(ItemInit.DIGGING_CLAW_DIAMOND.get())
				.add(ItemInit.DIGGING_CLAW_NETHERITE.get());

	}

	@Override
	public String getName() {
		return "Geomancy Tags";
	}
}