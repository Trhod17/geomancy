package net.codersdownunder.gemmod.server.tags;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.init.BlockItemInit;
import net.codersdownunder.gemmod.init.ItemInit;
import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class GeomancyItemTags extends ItemTagsProvider {

	public GeomancyItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider provider, @Nullable ExistingFileHelper existingFileHelper)
	{
		super(output, lookupProvider, provider, Geomancy.MODID, existingFileHelper);
	}
	@Override
	protected void addTags(HolderLookup.Provider p_256380_) {
		
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

		tag(ItemTags.LOGS).add(BlockItemInit.CHASM_LOG.get()).add(BlockItemInit.CHASM_LOG_BARK.get())
				.add(BlockItemInit.CHASM_LOG_STRIPPED.get()).add(BlockItemInit.CHASM_LOG_STRIPPED_BARK.get());

		tag(ItemTags.LOGS_THAT_BURN).add(BlockItemInit.CHASM_LOG.get()).add(BlockItemInit.CHASM_LOG_BARK.get())
				.add(BlockItemInit.CHASM_LOG_STRIPPED.get()).add(BlockItemInit.CHASM_LOG_STRIPPED_BARK.get());

		tag(ItemTags.PLANKS).add(BlockItemInit.CHASM_PLANKS.get());

		tag(ItemTags.WOODEN_STAIRS).add(BlockItemInit.CHASM_STAIRS.get());

		tag(ItemTags.WOODEN_SLABS).add(BlockItemInit.CHASM_SLAB.get());

		tag(ItemTags.WOODEN_BUTTONS).add(BlockItemInit.CHASM_BUTTON.get());

		tag(ItemTags.WOODEN_PRESSURE_PLATES).add(BlockItemInit.CHASM_PLATE.get());

		tag(ItemTags.WOODEN_TRAPDOORS).add(BlockItemInit.CHASM_TRAPDOOR.get());

		tag(ItemTags.WOODEN_DOORS).add(BlockItemInit.CHASM_DOOR.get());

		tag(ItemTags.WOODEN_FENCES).add(BlockItemInit.CHASM_FENCE.get());

		tag(ItemTags.LEAVES).add(BlockItemInit.CHASM_LEAVES.get());
		
		tag(GeomancyTags.Items.QUARTZ).add(Items.QUARTZ).add(ItemInit.ROSE_QUARTZ.get());
		
		tag(ItemTags.SAPLINGS)
		.add(BlockItemInit.CHASM_SAPLING.get());

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

		tag(ItemTags.ARROWS)
				.add(ItemInit.CUPID_ARROW.get());
	}

	@Override
	public String getName() {
		return "Geomancy Tags";
	}
}