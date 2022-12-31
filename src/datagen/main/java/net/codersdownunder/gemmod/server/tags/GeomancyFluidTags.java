package net.codersdownunder.gemmod.server.tags;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.init.FluidInit;
import net.codersdownunder.gemmod.utils.GeomancyTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class GeomancyFluidTags extends FluidTagsProvider {

    public GeomancyFluidTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, Geomancy.MODID, existingFileHelper);
    }


    @Override
    protected void addTags(final HolderLookup.Provider p_256380_) {
        tag(GeomancyTags.Fluids.DIPPING_FLUIDS)
                .add(Fluids.WATER);

        tag(FluidTags.WATER)
                .add(FluidInit.FLOWING_HEALING_WATER.get())
                .add(FluidInit.SOURCE_HEALING_WATER.get());
				
       
    }

    @Override
    @NotNull
    public String getName() {
        return "Geomancy Fluid Tags";
    }
}