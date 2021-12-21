package net.codersdownunder.gemmod.common.tags;

import net.codersdownunder.gemmod.GemMod;
import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GeomancyFluidTags extends FluidTagsProvider {

    public GeomancyFluidTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, GemMod.MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(GeomancyTags.Fluids.DIPPING_FLUIDS)
                .add(Fluids.WATER);
				
       
    }

    @Override
    public String getName() {
        return "Geomancy Tags";
    }
}