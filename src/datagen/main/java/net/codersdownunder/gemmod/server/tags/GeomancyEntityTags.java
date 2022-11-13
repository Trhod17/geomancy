package net.codersdownunder.gemmod.server.tags;

import net.codersdownunder.gemmod.Geomancy;
import net.codersdownunder.gemmod.init.EntityInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GeomancyEntityTags extends EntityTypeTagsProvider {

    public GeomancyEntityTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, Geomancy.MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(EntityTypeTags.ARROWS)
                .add(EntityInit.CUPID_ARROW.get());

        tag(EntityTypeTags.IMPACT_PROJECTILES)
                .add(EntityInit.CUPID_ARROW.get());
    }

    @Override
    public String getName() {
        return "Geomancy Tags";
    }
}