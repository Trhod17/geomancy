package net.codersdownunder.gemmod.additions.client;

import net.codersdownunder.gemmod.additions.Additions;
import net.codersdownunder.gemmod.additions.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class AdditionsLanguageProvider extends LanguageProvider {

	public AdditionsLanguageProvider(PackOutput packOutput) {
		super(packOutput, Additions.MODID, "en_us");
	}

	// private static String modid = Additions.MODID;

	@Override
	protected void addTranslations() {

		addBlocks();
		addCreativeTabs();
	}

	private void addBlocks() {

		add(BlockInit.PURPUR_WALL.get(), "Purpur Wall");
		add(BlockInit.PURPUR_PILLAR_WALL.get(), "Purpur Pillar Wall");
		add(BlockInit.DARK_PRISMARINE_WALL.get(), "Dark Prismarine Wall");
		add(BlockInit.PRISMARINE_BRICKS_WALL.get(), "Prismarine Brick Wall");
	}

	private void addCreativeTabs() {

		add("tabs_additions_blocks.text", "Geomancy Additions");
    }
}
