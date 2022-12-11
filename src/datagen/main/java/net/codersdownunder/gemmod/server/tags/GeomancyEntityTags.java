package net.codersdownunder.gemmod.server.tags;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.init.EntityInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class GeomancyEntityTags extends EntityTypeTagsProvider {

    public GeomancyEntityTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, Geomancy.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
        tag(EntityTypeTags.ARROWS)
                .add(EntityInit.CUPID_ARROW.get());

        tag(EntityTypeTags.IMPACT_PROJECTILES)
                .add(EntityInit.CUPID_ARROW.get());
    }

    @Override
    public String getName() {
        return "Geomancy Entity Tags";
    }
}