package net.codersdownunder.gemmod.common.tags;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.init.BlockItemInit;
import net.codersdownunder.gemmod.init.ItemInit;
import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GeomancyItemTags extends ItemTagsProvider {

	public GeomancyItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
		super(generator, blockTags, GemMod.MODID, helper);
	}

	@Override
	protected void addTags() {
		tag(GeomancyTags.Items.STRING).add(Items.STRING);

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

	}

	@Override
	public String getName() {
		return "Geomancy Tags";
	}
}