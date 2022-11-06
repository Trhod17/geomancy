package net.codersdownunder.gemmod.server.tags;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.init.FluidInit;
import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GeomancyFluidTags extends FluidTagsProvider {

    public GeomancyFluidTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, Geomancy.MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(GeomancyTags.Fluids.DIPPING_FLUIDS)
                .add(Fluids.WATER);

        tag(FluidTags.WATER)
                .add(FluidInit.FLOWING_HEALING_WATER.get())
                .add(FluidInit.SOURCE_HEALING_WATER.get());
				
       
    }

    @Override
    public String getName() {
        return "Geomancy Tags";
    }
}